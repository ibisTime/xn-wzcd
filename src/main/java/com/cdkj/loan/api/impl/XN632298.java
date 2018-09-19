package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepointDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.dto.req.XN632298Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 根据经销商编号查返点（去重）
 * @author: CYL 
 * @since: 2018年9月19日 下午9:32:39 
 * @history:
 */
public class XN632298 extends AProcessor {
    private IRepointDetailAO repointDetailAO = SpringContextHolder
        .getBean(IRepointDetailAO.class);

    private XN632298Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        RepointDetail condition = new RepointDetail();
        condition.setCarDealerCode(req.getCarDealerCode());
        return repointDetailAO.queryRepointDetailListByCarDealer(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632298Req.class);
        ObjValidater.validateReq(req);
    }
}
