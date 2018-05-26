package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarDealerAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.dto.req.XN632067Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询经销商管理
 * @author: CYL 
 * @since: 2018年5月24日 下午2:23:15 
 * @history:
 */
public class XN632067 extends AProcessor {
    private ICarDealerAO carDealerAO = SpringContextHolder
        .getBean(ICarDealerAO.class);

    private XN632067Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        CarDealer condition = new CarDealer();
        condition.setAbbrName(req.getAbbrName());
        condition.setIsSelfDevelop(req.getIsSelfDevelop());
        condition.setCurNodeCode(req.getCurNodeCode());

        return carDealerAO.queryCarDealerList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632067Req.class);
        ObjValidater.validateReq(req);
    }

}
