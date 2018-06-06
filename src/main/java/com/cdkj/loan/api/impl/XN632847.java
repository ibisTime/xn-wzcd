package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRecruitApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.RecruitApply;
import com.cdkj.loan.dto.req.XN632847Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查用人申请
 * @author: CYL 
 * @since: 2018年6月5日 上午12:27:48 
 * @history:
 */
public class XN632847 extends AProcessor {
    private IRecruitApplyAO recruitApplyAO = SpringContextHolder
        .getBean(IRecruitApplyAO.class);

    private XN632847Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RecruitApply condition = new RecruitApply();
        condition.setDepartmentCode(req.getDepartmentCode());
        condition.setPosition(req.getPosition());
        condition.setApplyDatetime(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetime(DateUtil.strToDate(req.getApplyDatetimeEnd(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        return recruitApplyAO.queryRecruitApplyList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632847Req.class);
        ObjValidater.validateReq(req);
    }

}
