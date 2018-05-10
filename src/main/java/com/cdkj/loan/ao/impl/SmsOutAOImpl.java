package com.cdkj.loan.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISmsOutAO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.common.PhoneUtil;

@Service
public class SmsOutAOImpl implements ISmsOutAO {

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    IUserBO userBO;

    @Override
    public void sendSmsCaptcha(String mobile, String bizType) {
        userBO.isMobileExist(mobile);
        smsOutBO.sendSmsCaptcha(mobile, bizType);

    }

    @Override
    public void sendContent(String tokenId, String mobile, String content) {
        PhoneUtil.checkMobile(mobile);
        smsOutBO.sendSmsOut(mobile, content);
    }
}
