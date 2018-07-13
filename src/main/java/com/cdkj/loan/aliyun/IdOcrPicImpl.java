package com.cdkj.loan.aliyun;

import static org.apache.commons.codec.binary.Base64.encodeBase64;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.aliyun.domain.IdOcr;
import com.cdkj.loan.aliyun.domain.IdOcrRes;
import com.cdkj.loan.aliyun.util.HttpUtils;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EConfigType;
import com.cdkj.loan.enums.EIdSide;
import com.cdkj.loan.exception.BizException;

@Service
public class IdOcrPicImpl {

    @Autowired
    protected ISYSConfigBO sysConfigBO;

    private static Logger logger = Logger.getLogger(IdOcrPicImpl.class);

    public IdOcrRes getIdInfo(String picUrl, String side) {
        IdOcrRes idOcrRes = null;
        Map<String, String> resultMap = sysConfigBO
            .getConfigsMap(EConfigType.ALIYUN.getCode());
        String host = resultMap.get(SysConstants.ALIYUN_HOST);
        if (StringUtils.isBlank(host)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "阿里云访问域名未配置");
        }
        String path = resultMap.get(SysConstants.ALIYUN_HOST_REST_PATH);
        if (StringUtils.isBlank(path)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "阿里云访问请求地址未配置");
        }

        String appcode = resultMap.get(SysConstants.ALIYUN_APPCODE);
        if (StringUtils.isBlank(appcode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "阿里云鉴别图片appcode未配置");
        }
        Boolean is_old_format = false;// 如果文档的输入中含有inputs字段，设置为True， 否则设置为False
        // 请根据线上文档修改configure字段
        JSONObject configObj = new JSONObject();

        EIdSide eIdSide = EIdSide.getIdSideMap().get(side);
        if (eIdSide == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "side参数请传[face 正面/back 反面]");
        }
        configObj.put("side", side);// 身份证正反面类型:face/back
        String config_str = configObj.toString();
        // configObj.put("min_size", 5);
        // String config_str = "";

        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
        // 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);

        Map<String, String> querys = new HashMap<String, String>();
        // 对图像进行base64编码
        String imgBase64 = "";
        try {
            imgBase64 = new String(encodeBase64(readFileByUrl(picUrl)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "图片base64转换错误");
        }
        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        try {
            if (is_old_format) {
                JSONObject obj = new JSONObject();
                obj.put("image", getParam(50, imgBase64));
                if (config_str.length() > 0) {
                    obj.put("configure", getParam(50, config_str));
                }
                JSONArray inputArray = new JSONArray();
                inputArray.add(obj);
                requestObj.put("inputs", inputArray);
            } else {
                requestObj.put("image", imgBase64);
                if (config_str.length() > 0) {
                    requestObj.put("configure", config_str);
                }
            }
        } catch (JSONException e) {
            logger.error("拼装请求body的json字符串异常:" + e.getMessage());
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "拼装请求body的json字符串异常");
        }
        String bodys = requestObj.toString();

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method,
                headers, querys, bodys);
            int stat = response.getStatusLine().getStatusCode();
            if (stat != 200) {
                logger.error("Http code: " + stat);
                logger.error("http header error msg: "
                        + response.getFirstHeader("X-Ca-Error-Message"));
                logger.error("Http body error msg:"
                        + EntityUtils.toString(response.getEntity()));
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    response.getEntity());
            }

            String res = EntityUtils.toString(response.getEntity());
            JSONObject resObject = JSON.parseObject(res);
            if (is_old_format) {
                JSONArray outputArray = resObject.getJSONArray("outputs");
                String output = outputArray.getJSONObject(0)
                    .getJSONObject("outputValue").getString("dataValue");
                JSONObject out = JSON.parseObject(output);
                System.out.println(out.toJSONString());
            } else {
                IdOcr idOcr = JsonUtil.json2Bean(resObject.toJSONString(),
                    IdOcr.class);
                idOcrRes = new IdOcrRes(idOcr);
            }
        } catch (Exception e) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "识别身份证照片失败！");
        }

        return idOcrRes;
    }

    /*
     * 获取参数的json对象
     */
    private static JSONObject getParam(int type, String dataValue) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("dataType", type);
            obj.put("dataValue", dataValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private static byte[] readFileByUrl(String urlStr) {
        byte[] result = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            // 得到输入流
            InputStream inputStream = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            result = bos.toByteArray();
        } catch (Exception e) {
            logger.error("通过url地址获取文本内容失败 Exception：" + e);
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                e.getMessage());
        }
        return result;
    }
}
