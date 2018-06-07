package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IEntryApplyAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IEntryApplyBO;
import com.cdkj.loan.bo.IWorkExperienceBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.EntryApply;
import com.cdkj.loan.domain.WorkExperience;
import com.cdkj.loan.dto.req.XN632850ReqExp;
import com.cdkj.loan.dto.req.XN632860Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EEntryApplyStatus;

@Service
public class EntryApplyAOImpl implements IEntryApplyAO {

    @Autowired
    private IEntryApplyBO entryApplyBO;

    @Autowired
    private IWorkExperienceBO workExperienceBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addEntryApply(XN632860Req req) {
        EntryApply data = new EntryApply();
        data.setPosition(req.getPosition());
        Department department = departmentBO.getDepartment(req.getPosition());
        data.setDepartmentCode(department.getParentCode());
        data.setEntryDatetime(DateUtil.strToDate(req.getEntryDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setApplyDatetime(new Date());
        data.setRealName(req.getRealName());
        data.setGender(req.getGender());
        data.setBirthday(DateUtil.strToDate(req.getBirthday(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setEducation(req.getEducation());
        data.setNation(req.getNation());
        data.setNativePlace(req.getNativePlace());
        data.setHealth(req.getHealth());
        data.setMarryStatus(req.getMarryStatus());
        data.setIdNo(req.getIdNo());
        data.setMobile(req.getMobile());
        data.setEmergencyContact(req.getEmergencyContact());
        data.setEmergencyContactMobile(req.getEmergencyContactMobile());
        data.setResidenceProperty(req.getResidenceProperty());
        data.setPhoto(req.getPhoto());
        data.setResidenceAddress(req.getResidenceAddress());
        data.setNowAddress(req.getNowAddress());
        data.setIsOtherCompanyRelation(req.getIsOtherCompanyRelation());
        data.setRelativeName(req.getRelativeName());
        data.setRelativePosition(req.getRelativePosition());
        data.setMainPerform(req.getMainPerform());
        data.setProbationStartDatetime(
            DateUtil.strToDate(req.getProbationStartDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setProbationEndDatetime(DateUtil.strToDate(
            req.getProbationEndDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setProbationSalary(
            StringValidater.toLong(req.getProbationSalary()));
        data.setBaseSalary(StringValidater.toLong(req.getBaseSalary()));
        data.setPerformSalary(StringValidater.toLong(req.getPerformSalary()));
        data.setPerformSalaryStandard(req.getPerformSalaryStandard());
        data.setQuarterlyAwardStandard(req.getQuarterlyAwardStandard());
        data.setCommunicatePayStandard(req.getCommunicatePayStandard());
        data.setProvincialBedStandard(req.getProvincialBedStandard());
        data.setNonProvincialBedStandard(req.getNonProvincialBedStandard());
        data.setTrafficStandard(
            StringValidater.toLong(req.getTrafficStandard()));
        data.setMobileStandard(StringValidater.toLong(req.getMobileStandard()));
        data.setTaxiStandard(StringValidater.toLong(req.getTaxiStandard()));
        data.setMealStandard(StringValidater.toLong(req.getMealStandard()));
        data.setSalaryCardNo(req.getSalaryCardNo());
        data.setBank(req.getBank());
        data.setBankCode(req.getBankCode());
        data.setStatus(EEntryApplyStatus.STAY_AUDIT.getCode());

        String code = entryApplyBO.saveEntryApply(data);

        // 保存工作经历列表
        for (XN632850ReqExp exp : req.getWorkExperienceList()) {
            WorkExperience experience = new WorkExperience();
            experience.setParentCode(code);
            experience.setStartDatetime(DateUtil.strToDate(
                exp.getStartDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
            experience.setEndDatetime(DateUtil.strToDate(exp.getEndDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            experience.setCompanyName(exp.getCompanyName());
            experience.setPosition(req.getPosition());
            experience.setLeaveReason(exp.getLeaveReason());
            experience.setProver(exp.getProver());
            experience.setProverMobile(exp.getProverMobile());
            workExperienceBO.saveWorkExperience(experience);
        }
        return code;
    }

    @Override
    public void approveEntryApply(String code, String approveResult,
            String updater, String remark) {
        EntryApply entryApply = entryApplyBO.getEntryApply(code);
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            entryApply.setStatus(EEntryApplyStatus.AUDIT_PASS.getCode());
        } else {
            entryApply.setStatus(EEntryApplyStatus.AUDIT_NOT_PASS.getCode());
        }
        entryApply.setUpdater(updater);
        entryApply.setUpdateDatetime(new Date());
        entryApply.setRemark(remark);
        entryApplyBO.updateEntryApplyStatus(entryApply);
    }

    @Override
    public Paginable<EntryApply> queryEntryApplyPage(int start, int limit,
            EntryApply condition) {
        Paginable<EntryApply> paginable = entryApplyBO.getPaginable(start,
            limit, condition);
        if (paginable != null) {
            for (EntryApply entryApply : paginable.getList()) {
                WorkExperience wECondition = new WorkExperience();
                wECondition.setParentCode(entryApply.getCode());
                entryApply.setWorkExperienceList(
                    workExperienceBO.queryWorkExperienceList(wECondition));
            }
        }
        return paginable;
    }

    @Override
    public List<EntryApply> queryEntryApplyList(EntryApply condition) {
        return entryApplyBO.queryEntryApplyList(condition);
    }

    @Override
    public EntryApply getEntryApply(String code) {
        EntryApply entryApply = entryApplyBO.getEntryApply(code);
        WorkExperience wECondition = new WorkExperience();
        wECondition.setParentCode(entryApply.getCode());
        entryApply.setWorkExperienceList(
            workExperienceBO.queryWorkExperienceList(wECondition));
        return entryApply;
    }

}
