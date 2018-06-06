package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRecruitApplyAO;
import com.cdkj.loan.bo.IRecruitApplyBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.RecruitApply;
import com.cdkj.loan.dto.req.XN632840Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.ERecruitApplyStatus;

@Service
public class RecruitApplyAOImpl implements IRecruitApplyAO {

    @Autowired
    private IRecruitApplyBO recruitApplyBO;

    @Override
    public String addRecruitApply(XN632840Req req) {
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
        data.setReplacePosition(req.getReplacePosition());
        data.setReplaceRealName(req.getReplaceRealName());
        data.setNewApplyReason(req.getNewApplyReason());
        data.setPositionNowQuantity(
            StringValidater.toInteger(req.getPositionNowQuantity()));
        data.setPositionAddReason(req.getPositionAddReason());
        data.setTempStartDatetime(DateUtil.strToDate(req.getTempStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setTempEndDatetime(DateUtil.strToDate(req.getTempEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setGender(req.getGender());
        data.setAge(req.getAge());
        data.setMarryState(req.getMarryState());
        data.setEducation(req.getEducation());
        data.setMajor(req.getMajor());
        data.setMajorRequire(req.getMajorRequire());
        data.setAbilityRequire(req.getAbilityRequire());
        data.setExperience(req.getExperience());
        data.setStatus(ERecruitApplyStatus.STAY_AUDIT.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return recruitApplyBO.saveRecruitApply(data);
    }

    @Override
    public void auditRecruitApply(String code, String approveResult,
            String updater, String remark) {
        RecruitApply condition = recruitApplyBO.getRecruitApply(code);
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            condition.setStatus(ERecruitApplyStatus.AUDIT_PASS.getCode());
        } else {
            condition.setStatus(ERecruitApplyStatus.AUDIT_NOT_PASS.getCode());
        }
        condition.setUpdater(updater);
        condition.setUpdateDatetime(new Date());
        condition.setRemark(remark);
        recruitApplyBO.auditRecruitApply(condition);
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
