package com.cdkj.loan.bo.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IExpressRuleBO;
import com.cdkj.loan.dto.req.XN003020Req;
import com.cdkj.loan.dto.res.XN003020Res;
import com.cdkj.loan.http.BizConnecter;
import com.cdkj.loan.http.JsonUtils;

@Component
public class ExpressRuleBOImpl implements IExpressRuleBO {
    static Logger logger = Logger.getLogger(ExpressRuleBOImpl.class);

    @Override
    public XN003020Res getPrice(String startPoint, String endPoint,
            Double weight, String companyCode, String systemCode) {
        XN003020Res res = null;
        try {
            if (StringUtils.isBlank(startPoint)
                    || StringUtils.isBlank(endPoint)) {
                res = new XN003020Res(0L);
            }
            XN003020Req req = new XN003020Req();
            req.setStartPoint(startPoint);
            req.setEndPoint(endPoint);
            req.setWeight(weight.toString());
            req.setCompanyCode(companyCode);
            req.setSystemCode(systemCode);
            res = BizConnecter.getBizData("003020", JsonUtils.object2Json(req),
                XN003020Res.class);
        } catch (Exception e) {
            logger.error("商品统计运费金额系统错误, 原因：" + e.getMessage());
            res = new XN003020Res();
            res.setExpressFee(0L);
        }
        return res;
    }
}
