/**
 * @Title BaofooPayImpl.java 
 * @Package com.std.account.bo.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年9月13日 下午4:49:31 
 * @version V1.0   
 */
package com.cdkj.loan.bo.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.cdkj.loan.baofoo.BaofooResult;
import com.cdkj.loan.baofoo.CompanyChannel;
import com.cdkj.loan.baofoo.HttpUtil;
import com.cdkj.loan.baofoo.RsaCodingUtil;
import com.cdkj.loan.baofoo.SecurityUtil;
import com.cdkj.loan.bo.IBaofooBO;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;

/** 
 * @author: haiqingzheng 
 * @since: 2017年9月13日 下午4:49:31 
 * @history:
 */
@Component
public class BaofooBOImpl implements IBaofooBO {

    static Logger logger = Logger.getLogger(BaofooBOImpl.class);

    @Override
    public BaofooResult withhold(String transId, String bankCode,
            String accountNo, String idNo, String realName, String mobile,
            Long transAmount, CompanyChannel companyChannel) {
        BaofooResult baofooResult = null;

        Map<String, String> HeadPostParam = new HashMap<String, String>();

        HeadPostParam.put("version", "4.0.0.0");
        HeadPostParam.put("member_id", companyChannel.getChannelCompany());
        HeadPostParam.put("terminal_id", companyChannel.getPrivateKey3());
        HeadPostParam.put("txn_type", "0431");
        HeadPostParam.put("txn_sub_type", "13");
        HeadPostParam.put("data_type", "json");
        String biz_type = "0000";

        String request_url = companyChannel.getPageUrl();// 测试地址

        String pfxpath = this.getClass().getResource("/").getPath()
                + companyChannel.getPrivateKey1();
        String keyStorePassword = companyChannel.getPrivateKey4();
        String cerpath = this.getClass().getResource("/").getPath()
                + companyChannel.getPrivateKey2();

        /**
         * 报文体
         * =============================================
         * 
         */
        String trade_date = new SimpleDateFormat(DateUtil.DATA_TIME_PATTERN_5)
            .format(new Date());// 交易日期
        Map<String, String> XMLArray = new HashMap<String, String>();

        XMLArray.put("txn_sub_type", HeadPostParam.get("txn_sub_type"));
        XMLArray.put("biz_type", biz_type);
        XMLArray.put("terminal_id", HeadPostParam.get("terminal_id"));
        XMLArray.put("member_id", HeadPostParam.get("member_id"));
        XMLArray.put("trans_serial_no", "TISN" + System.currentTimeMillis());
        XMLArray.put("trade_date", trade_date);
        XMLArray.put("additional_info", "附加信息");
        XMLArray.put("req_reserved", "保留");

        String txn_amt = String.valueOf(transAmount / 10.0);// 支付金额转换成分
        XMLArray.put("pay_code", bankCode);
        XMLArray.put("pay_cm", "2");
        XMLArray.put("id_card_type", "01");
        XMLArray.put("acc_no", accountNo);
        XMLArray.put("id_card", idNo);
        XMLArray.put("id_holder", realName);
        XMLArray.put("mobile", mobile);
        XMLArray.put("trans_id", transId);
        XMLArray.put("txn_amt", txn_amt);

        String XmlOrJson = JsonUtil.Object2Json(XMLArray);
        logger.info("请求参数：" + XmlOrJson);

        String base64str;
        try {
            base64str = SecurityUtil.Base64Encode(XmlOrJson);
            String data_content = RsaCodingUtil.encryptByPriPfxFile(base64str,
                pfxpath, keyStorePassword);

            HeadPostParam.put("data_content", data_content);

            String PostString = HttpUtil.RequestForm(request_url,
                HeadPostParam);
            logger.info("请求返回：" + PostString);

            PostString = RsaCodingUtil.decryptByPubCerFile(PostString, cerpath);

            if (PostString.isEmpty()) {// 判断解密是否正确。如果为空则宝付公钥不正确
                logger.error("=====检查解密公钥是否正确！");
            }

            PostString = SecurityUtil.Base64Decode(PostString);
            logger.info("=====返回查询数据解密结果:" + PostString);

            baofooResult = JsonUtil.json2Bean(PostString, BaofooResult.class);
            String ReturnStr = "返回码:" + baofooResult.getResp_code() + ", 返回消息:"
                    + baofooResult.getResp_msg();
            logger.info("代扣结果：" + ReturnStr);

        } catch (IOException e) {
            logger.error("代扣异常：" + e.getMessage());
        }
        return baofooResult;
    }

}
