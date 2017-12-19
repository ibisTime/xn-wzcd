package com.cdkj.coin.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.ISmsOutAO;
import com.cdkj.coin.bo.ISmsOutBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.common.PhoneUtil;
import com.cdkj.coin.domain.User;
import com.cdkj.coin.enums.ECaptchaType;
import com.cdkj.coin.enums.EUserKind;
import com.cdkj.coin.exception.BizException;

@Service
public class SmsOutAOImpl implements ISmsOutAO {

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    IUserBO userBO;

    @Override
    public void sendSmsCaptcha(String mobile, String bizType,
            String companyCode, String systemCode) {
        if (ECaptchaType.C_REG.getCode().equals(bizType)) {
            userBO.isMobileExist(mobile, EUserKind.Customer.getCode(),
                companyCode, systemCode);
        }
        smsOutBO.sendSmsCaptcha(mobile, bizType, companyCode, systemCode);
    }

    @Override
    public void sendEmailCaptcha(String email, String bizType,
            String companyCode, String systemCode) {
        smsOutBO.sendEmailCaptcha(email, bizType, companyCode, systemCode);
    }

    @Override
    public void sendContent(String tokenId, String userId, String content) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn0000", "该用户编号不存在");
        }
        smsOutBO.sendSmsOut(user.getMobile(), content, "001200",
            user.getCompanyCode(), user.getSystemCode());
    }

    @Override
    public void sendContent(String tokenId, String mobile, String content,
            String companyCode, String systemCode) {
        PhoneUtil.checkMobile(mobile);
        smsOutBO.sendSmsOut(mobile, content, "001201", companyCode, systemCode);
    }
}
