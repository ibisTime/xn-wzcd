package com.cdkj.loan.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.dto.req.XN804080Req;
import com.cdkj.loan.dto.req.XN804081Req;
import com.cdkj.loan.dto.req.XN804082Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.enums.ESystemCode;
import com.cdkj.loan.http.BizConnecter;
import com.cdkj.loan.http.JsonUtils;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:15:46 
 * @history:
 */
@Component
public class SmsOutBOImpl implements ISmsOutBO {
    static Logger logger = Logger.getLogger(SmsOutBOImpl.class);

    @Override
    public void sendSmsCaptcha(String mobile, String bizType) {
        try {
            XN804081Req req = new XN804081Req();
            req.setMobile(mobile);
            req.setBizType(bizType);
            req.setSystemCode(ESystemCode.HTWT.getCode());
            req.setCompanyCode(ESystemCode.HTWT.getCode());
            BizConnecter.getBizData("804081", JsonUtils.object2Json(req),
                PKCodeRes.class);
        } catch (Exception e) {
            logger.error("调用短信发送服务异常");
        }
    }

    @Override
    public void checkCaptcha(String mobile, String captcha, String bizType) {
        XN804082Req req = new XN804082Req();
        req.setMobile(mobile);
        req.setCaptcha(captcha);
        req.setBizType(bizType);
        req.setSystemCode(ESystemCode.HTWT.getCode());
        req.setCompanyCode(ESystemCode.HTWT.getCode());
        BizConnecter.getBizData("804082", JsonUtils.object2Json(req),
            BooleanRes.class);
    }

    @Override
    public void sendSmsOut(String mobile, String content) {
        try {
            XN804080Req req = new XN804080Req();
            req.setMobile(mobile);
            req.setContent(content);
            req.setType("M");
            req.setSystemCode(ESystemCode.HTWT.getCode());
            req.setCompanyCode(ESystemCode.HTWT.getCode());
            BizConnecter.getBizData("804080", JsonUtils.object2Json(req),
                PKCodeRes.class);
        } catch (Exception e) {
            logger.error("调用短信发送服务异常");
        }
    }
}
