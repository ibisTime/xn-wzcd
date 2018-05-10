package com.cdkj.loan.ao;

import com.cdkj.loan.spring.ServiceModule;

@ServiceModule
public interface IBaofooAO {

    // 宝付代扣
    public boolean withhold(String bankCode, String accountNo, String idNo,
            String realName, String mobile, Long transAmount, String refNo,
            String companyCode, String systemCode);

}
