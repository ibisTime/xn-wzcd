/**
 * @Title TencentBOImpl.java 
 * @Package com.cdkj.coin.bo.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月16日 下午5:05:31 
 * @version V1.0   
 */
package com.cdkj.coin.bo.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.ITencentBO;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.dto.res.XN625000Res;
import com.cdkj.coin.enums.EConfigType;
import com.cdkj.coin.enums.ESystemCode;
import com.cdkj.coin.enums.EUserPwd;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tls.sigcheck.tls_sigcheck;

/** 
 * @author: haiqingzheng 
 * @since: 2017年11月16日 下午5:05:31 
 * @history:
 */
@Component
public class TencentBOImpl implements ITencentBO {

    private static final Logger logger = LoggerFactory
        .getLogger(TencentBOImpl.class);

    public static final String TENXUN_CHAT_TUOGUAN_URL = "https://console.tim.qq.com/v4/registration_service/register_account_v1";

    public static final String TENXUN_CHAT_DULI_URL = "https://console.tim.qq.com/v4/im_open_login_svc/account_import";

    public static final String TENXUN_CREATE_GROUP = "https://console.tim.qq.com/v4/group_open_http_svc/create_group";

    public static final String TENXUN_SEND_GROUP_SYSTEM_NOTIFICATION = "https://console.tim.qq.com/v4/group_open_http_svc/send_group_system_notification";

    public static final String TENXUN_SEND_GROUP_MSG = "https://console.tim.qq.com/v4/group_open_http_svc/send_group_msg";

    @Autowired
    private ISYSConfigBO sysConfigBO;

    private String getUrl(String baseUrl) {
        String urlString = null;
        Map<String, String> sysConfigMap = sysConfigBO.getConfigsMap(
            EConfigType.TENCENT_IM.getCode(), ESystemCode.COIN.getCode(),
            ESystemCode.COIN.getCode());
        String txAppCode = sysConfigMap.get(SysConstants.TX_APP_CODE);
        String txAppAdmin = sysConfigMap.get(SysConstants.TX_APP_ADMIN);
        String accessKey = sysConfigMap.get(SysConstants.TX_ACCESS_KEY);
        String secretKey = sysConfigMap.get(SysConstants.TX_SECRET_KEY);
        String accountType = sysConfigMap.get(SysConstants.TX_ACCOUNT_TYPE);

        if (StringUtils.isBlank(txAppCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "应用编号不能为空");
        }
        if (StringUtils.isBlank(txAppAdmin)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "管理员不能为空");
        }
        if (StringUtils.isBlank(accessKey)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "公钥不能为空");
        }
        if (StringUtils.isBlank(secretKey)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "私钥不能为空");
        }
        if (StringUtils.isBlank(accountType)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "账号类型不能为空");
        }
        try {
            tls_sigcheck demo = new tls_sigcheck();
            demo.loadJniLib(Thread.currentThread().getContextClassLoader()
                .getResource("jnisigcheck.so").getPath());

            int ret = demo.tls_gen_signature_ex2(txAppCode, txAppAdmin,
                secretKey);
            ret = demo.tls_check_signature_ex2(demo.getSig(), accessKey,
                txAppCode, txAppAdmin);
            if (0 != ret) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "腾讯云IM签名失败");
            }
            urlString = baseUrl + "?usersig=" + demo.getSig()
                    + "&apn=1&identifier=" + txAppAdmin + "&sdkappid="
                    + txAppCode + "&contenttype=json";
        } catch (Exception e) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "腾讯云IM签名异常，原因" + e.getMessage());
        }
        return urlString;
    }

    /** 
     * @see com.cdkj.coin.bo.ITencentBO#register(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void register(String userId, String companyCode, String systemCode) {
        try {
            String urlString = getUrl(TENXUN_CHAT_TUOGUAN_URL);
            String result = sendChildSms(urlString, userId);
            String errorCode = JSONObject.parseObject(result).getString(
                "ErrorCode");
            String errorInfo = JSONObject.parseObject(result).getString(
                "ErrorInfo");
            if (!errorCode.equals("0")) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "腾讯云注册异常,错误编号：" + errorCode + "，原因：" + errorInfo);
            }
        } catch (Exception e) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "腾讯云IM注册异常，原因" + e.getMessage());
        }
    }

    /** 
     * @see com.cdkj.coin.bo.ITencentBO#getSign(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public XN625000Res getSign(String userId, String companyCode,
            String systemCode) {
        Map<String, String> sysConfigMap = sysConfigBO.getConfigsMap(
            EConfigType.TENCENT_IM.getCode(), companyCode, systemCode);
        String txAppCode = sysConfigMap.get(SysConstants.TX_APP_CODE);
        String txAppAdmin = sysConfigMap.get(SysConstants.TX_APP_ADMIN);
        String accessKey = sysConfigMap.get(SysConstants.TX_ACCESS_KEY);
        String secretKey = sysConfigMap.get(SysConstants.TX_SECRET_KEY);
        String accountType = sysConfigMap.get(SysConstants.TX_ACCOUNT_TYPE);

        if (StringUtils.isBlank(txAppCode)) {
            throw new BizException("xn0000", "应用编号不能为空");
        }
        if (StringUtils.isBlank(txAppAdmin)) {
            throw new BizException("xn0000", "管理员不能为空");
        }
        if (StringUtils.isBlank(accessKey)) {
            throw new BizException("xn0000", "公钥不能为空");
        }
        if (StringUtils.isBlank(secretKey)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "私钥不能为空");
        }
        if (StringUtils.isBlank(accountType)) {
            throw new BizException("xn0000", "账号类型不能为空");
        }
        tls_sigcheck demo = new tls_sigcheck();
        demo.loadJniLib(Thread.currentThread().getContextClassLoader()
            .getResource("jnisigcheck.so").getPath());
        int ret = demo.tls_gen_signature_ex2(txAppCode, userId, secretKey);
        if (0 != ret) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "腾讯云IM签名失败");
        }
        XN625000Res res = new XN625000Res();
        res.setTxAppCode(txAppCode);
        res.setTxAppAdmin(txAppAdmin);
        res.setAccountType(accountType);
        res.setAccessKey(accessKey);
        res.setSecretKey(secretKey);
        res.setSign(demo.getSig());
        return res;
    }

    private static String sendChildSms(String url, String account) {
        String codingType = "UTF-8";
        String backEncodType = "UTF-8";
        try {
            JsonObject smsParams = new JsonObject();
            smsParams.addProperty("Identifier",
                URLEncoder.encode(account, codingType));
            smsParams.addProperty("Password",
                URLEncoder.encode(EUserPwd.Beicoin.getCode(), codingType));
            smsParams.addProperty("IdentifierType", 3);
            String sendSms = smsParams.toString();
            return doAccessHTTPPostJson(url, sendSms, backEncodType);
        } catch (Exception e) {
            e.printStackTrace();
            return "未发送，编码异常";
        }
    }

    @Override
    public void createGroup(String groupId, String buyUser, String sellUser) {
        try {
            String urlString = getUrl(TENXUN_CREATE_GROUP);
            String codingType = "UTF-8";
            String backEncodType = "UTF-8";
            JsonObject smsParams = new JsonObject();
            smsParams.addProperty("Type",
                URLEncoder.encode("ChatRoom", codingType));
            smsParams.addProperty("Name",
                URLEncoder.encode(groupId + "-Group", codingType));
            smsParams.addProperty("GroupId",
                URLEncoder.encode(groupId, codingType));

            JsonArray members = new JsonArray();

            JsonObject aaa = new JsonObject();
            aaa.addProperty("Member_Account",
                URLEncoder.encode(buyUser, codingType));

            JsonObject bbb = new JsonObject();
            bbb.addProperty("Member_Account",
                URLEncoder.encode(sellUser, codingType));

            members.add(aaa);
            members.add(bbb);

            smsParams.add("MemberList", members);

            String sendSms = smsParams.toString();

            logger.info("*&*&* URL=" + sendSms);

            String result = doAccessHTTPPostJson(urlString, sendSms,
                backEncodType);
            String errorCode = JSONObject.parseObject(result).getString(
                "ErrorCode");
            String errorInfo = JSONObject.parseObject(result).getString(
                "ErrorInfo");
            if (!errorCode.equals("0")) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "腾讯云创建群组异常,错误编号：" + errorCode + "，原因：" + errorInfo);
            }

        } catch (Exception e) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "腾讯云创建群组异常，原因" + e.getMessage());
        }
    }

    /**
     * POSTJson访问方法
     * @param sendUrl ：访问URL        
     * @param paramStr ：参数串  
     * @param backEncodType  ：返回的编码         
     * @return
     */
    public static String doAccessHTTPPostJson(String sendUrl, String sendParam,
            String backEncodType) {
        StringBuffer receive = new StringBuffer();
        BufferedWriter wr = null;
        try {
            if (backEncodType == null || backEncodType.equals("")) {
                backEncodType = "UTF-8";
            }

            URL url = new URL(sendUrl);
            HttpURLConnection URLConn = (HttpURLConnection) url
                .openConnection();

            URLConn.setDoOutput(true);
            URLConn.setDoInput(true);
            ((HttpURLConnection) URLConn).setRequestMethod("POST");
            URLConn.setUseCaches(false);
            URLConn.setAllowUserInteraction(true);
            HttpURLConnection.setFollowRedirects(true);
            URLConn.setInstanceFollowRedirects(true);

            URLConn.setRequestProperty("Content-Type",
                "application/json;charset=UTF-8");
            URLConn.setRequestProperty("Content-Length",
                String.valueOf(sendParam.getBytes().length));

            DataOutputStream dos = new DataOutputStream(
                URLConn.getOutputStream());
            dos.writeBytes(sendParam);

            BufferedReader rd = new BufferedReader(new InputStreamReader(
                URLConn.getInputStream(), backEncodType));
            String line;
            while ((line = rd.readLine()) != null) {
                receive.append(line).append("\r\n");
            }
            rd.close();
        } catch (java.io.IOException e) {
            receive.append("访问产生了异常-->").append(e.getMessage());
            e.printStackTrace();
        } finally {
            if (wr != null) {
                try {
                    wr.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                wr = null;
            }
        }
        System.out.println(receive);
        return receive.toString();
    }

    @Override
    public void sendMessage(String groupId, String content) {
        try {
            String urlString = getUrl(TENXUN_SEND_GROUP_SYSTEM_NOTIFICATION);
            String codingType = "UTF-8";
            String backEncodType = "UTF-8";
            JsonObject params = new JsonObject();
            params.addProperty("GroupId",
                URLEncoder.encode(groupId, codingType));
            params.addProperty("Content",
                URLEncoder.encode(content, codingType));

            String paramsString = params.toString();

            String result = doAccessHTTPPostJson(urlString, paramsString,
                backEncodType);
            String errorCode = JSONObject.parseObject(result).getString(
                "ErrorCode");
            String errorInfo = JSONObject.parseObject(result).getString(
                "ErrorInfo");
            if (!errorCode.equals("0")) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "腾讯云发送系统消息异常,错误编号：" + errorCode + "，原因：" + errorInfo);
            }

        } catch (Exception e) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "腾讯云发送系统消息异常，原因" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void sendNormalMessage(String groupId, String content) {
        try {
            String urlString = getUrl(TENXUN_SEND_GROUP_MSG);
            String codingType = "UTF-8";
            String backEncodType = "UTF-8";
            int random = (int) (Math.random() * (9999 - 1000 + 1)) + 10000000;
            JsonObject params = new JsonObject();
            params.addProperty("GroupId",
                URLEncoder.encode(groupId, codingType));
            params.addProperty("Random", random);

            JsonObject text = new JsonObject();
            text.addProperty("Text", URLEncoder.encode(content, codingType));

            JsonObject MsgBody = new JsonObject();
            MsgBody.addProperty("MsgType", "TIMTextElem");
            MsgBody.add("MsgContent", text);

            JsonArray msgBodyArray = new JsonArray();
            msgBodyArray.add(MsgBody);

            params.add("MsgBody", msgBodyArray);

            String paramsString = params.toString();

            String result = doAccessHTTPPostJson(urlString, paramsString,
                backEncodType);
            String errorCode = JSONObject.parseObject(result).getString(
                "ErrorCode");
            String errorInfo = JSONObject.parseObject(result).getString(
                "ErrorInfo");
            if (!errorCode.equals("0")) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "腾讯云发送普通消息异常,错误编号：" + errorCode + "，原因：" + errorInfo);
            }

        } catch (Exception e) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "腾讯云发送普通消息异常，原因" + e.getMessage());
        }
    }

}
