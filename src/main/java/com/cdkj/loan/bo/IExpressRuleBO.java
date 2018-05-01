package com.cdkj.loan.bo;

import com.cdkj.loan.dto.res.XN003020Res;

public interface IExpressRuleBO {

    public XN003020Res getPrice(String startPoint, String endPoint,
            Double weight, String companyCode, String systemCode);
}
