package com.cdkj.loan.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISmsOutAO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.enums.ECaptchaType;
import com.cdkj.loan.enums.EUserKind;

@Service
public class SmsOutAOImpl implements ISmsOutAO {

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    IUserBO userBO;

    @Override
    public void sendSmsCaptcha(String mobile, String bizType) {
        if (ECaptchaType.C_REG.getCode().equals(bizType)) {
            userBO.isMobileExist(mobile, EUserKind.Customer.getCode());
        }
        smsOutBO.sendSmsCaptcha(mobile, bizType);

    }

    @Override
    public void sendContent(String tokenId, String mobile, String content) {
        PhoneUtil.checkMobile(mobile);
        smsOutBO.sendSmsOut(mobile, content);
    }
}
