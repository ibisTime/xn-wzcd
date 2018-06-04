package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRecruitApplyAO;
import com.cdkj.loan.bo.IRecruitApplyBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.RecruitApply;
import com.cdkj.loan.dto.req.XN632480Req;
import com.cdkj.loan.exception.BizException;

@Service
public class RecruitApplyAOImpl implements IRecruitApplyAO {

    @Autowired
    private IRecruitApplyBO recruitApplyBO;

    @Override
    public String addRecruitApply(XN632480Req req) {
        RecruitApply data = new RecruitApply();
        data.setDepartmentCode(req.getDepartmentCode());
        data.setPosition(req.getPosition());
        data.setEstablishQuantity(
            StringValidater.toInteger(req.getEstablishQuantity()));
        data.setNowQuantity(StringValidater.toInteger(req.getNowQuantity()));
        data.setApplyQuantity(
            StringValidater.toInteger(req.getApplyQuantity()));
        data.setApplyDatetime(DateUtil.strToDate(req.getApplyDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setRequireDatetime(DateUtil.strToDate(req.getRequireDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setReplaceRealName(req.getReplaceRealName());
        data.setNewApplyReason(req.getNewApplyReason());
        data.setPositionNowQuantity(
            StringValidater.toInteger(req.getPositionNowQuantity()));
        data.setPositionAddReason(req.getPositionAddReason());
        return recruitApplyBO.saveRecruitApply(data);
    }

    @Override
    public int editRecruitApply(RecruitApply data) {
        if (!recruitApplyBO.isRecruitApplyExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return recruitApplyBO.refreshRecruitApply(data);
    }

    @Override
    public int dropRecruitApply(String code) {
        if (!recruitApplyBO.isRecruitApplyExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return recruitApplyBO.removeRecruitApply(code);
    }

    @Override
    public Paginable<RecruitApply> queryRecruitApplyPage(int start, int limit,
            RecruitApply condition) {
        return recruitApplyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<RecruitApply> queryRecruitApplyList(RecruitApply condition) {
        return recruitApplyBO.queryRecruitApplyList(condition);
    }

    @Override
    public RecruitApply getRecruitApply(String code) {
        return recruitApplyBO.getRecruitApply(code);
    }
}
