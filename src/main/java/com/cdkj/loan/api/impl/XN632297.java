package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepointDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.dto.req.XN632297Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询返点明细 按汽车经销商编号和返点账号编号
 * @author: jiafr 
 * @since: 2018年6月18日 下午5:35:50 
 * @history:
 */
public class XN632297 extends AProcessor {
    private IRepointDetailAO repointDetailAO = SpringContextHolder
        .getBean(IRepointDetailAO.class);

    private XN632297Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        RepointDetail condition = new RepointDetail();
        condition.setCarDealerCode(req.getCarDealerCode());
        condition.setAccountCode(req.getAccountCode());

        return repointDetailAO.queryRepointDetailListByCarDealerCode(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632297Req.class);
        ObjValidater.validateReq(req);
    }
}
