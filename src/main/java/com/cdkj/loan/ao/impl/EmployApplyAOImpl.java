package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IEmployApplyAO;
import com.cdkj.loan.bo.ICheckProjectBO;
import com.cdkj.loan.bo.IEmployApplyBO;
import com.cdkj.loan.bo.ISocialRelationBO;
import com.cdkj.loan.bo.IWorkExperienceBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CheckProject;
import com.cdkj.loan.domain.EmployApply;
import com.cdkj.loan.domain.WorkExperience;
import com.cdkj.loan.dto.req.XN632850Req;
import com.cdkj.loan.dto.req.XN632850ReqExp;
import com.cdkj.loan.dto.req.XN632851Req;
import com.cdkj.loan.dto.req.XN632851ReqCheckPro;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EEmployApplyStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class EmployApplyAOImpl implements IEmployApplyAO {

    @Autowired
    private IEmployApplyBO employApplyBO;

    @Autowired
    private IWorkExperienceBO workExperienceBO;

    @Autowired
    private ISocialRelationBO socialRelationBO;

    @Autowired
    private ICheckProjectBO checkProjectBO;

    @Override
    public String addEmployApply(XN632850Req req) {
        // 保存申请职位信息
        EmployApply data = new EmployApply();
        data.setRealName(req.getRealName());
        data.setGender(req.getGender());
        data.setBirthday(req.getBirthday());
        data.setNativePlace(req.getNativePlace());

        data.setNation(req.getNation());
        data.setPosition(req.getPosition());
        data.setEducation(req.getEducation());
        data.setIdNo(req.getIdNo());
        data.setContactMobile(req.getContactMobile());

        data.setResidenceAddress(req.getResidenceAddress());
        data.setSpeciality(req.getSpeciality());
        data.setExpectSalary(StringValidater.toLong(req.getExpectSalary()));
        data.setNowAddress(req.getNowAddress());
        data.setEmergencyContact(req.getEmergencyContact());

        data.setEmergencyContactMobile(req.getEmergencyContactMobile());
        data.setPostcode(req.getPostcode());
        data.setAward(req.getAward());
        data.setIsOut(req.getIsOut());
        data.setIsOverTime(req.getIsOverTime());
        data.setIsAdjustWork(req.getIsAdjustWork());

        data.setIsOnceRecruited(req.getIsOnceRecruited());
        data.setIsFriendWork(req.getIsFriendWork());
        data.setStatus(EEmployApplyStatus.TO_INTERVIEW.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        data.setRemark(req.getRemark());
        String code = employApplyBO.saveEmployApply(data);
        // 保存工作经历列表
        for (XN632850ReqExp exp : req.getWorkExperienceList()) {
            WorkExperience experience = new WorkExperience();
            experience.setParentCode(code);
            experience.setStartDatetime(DateUtil.strToDate(
                exp.getStartDatetime(), DateUtil.DATA_TIME_PATTERN_1));
            experience.setEndDatetime(DateUtil.strToDate(exp.getEndDatetime(),
                DateUtil.DATA_TIME_PATTERN_1));
            experience.setCompanyName(exp.getCompanyName());
            experience.setPosition(exp.getPosition());
            experience.setLeaveReason(exp.getLeaveReason());
            experience.setProver(exp.getProver());
            experience.setProverMobile(exp.getProverMobile());
            workExperienceBO.saveWorkExperience(experience);
        }

        // 保存家庭成员列表
        // for (XN632850ReqSocial social : req.getSocialRelationList()) {
        // SocialRelation socialRelation = new SocialRelation();
        // socialRelation.setArchiveCode(code);
        // socialRelation.setRealName(social.getRealName());
        // socialRelation.setRelation(social.getRelation());
        // socialRelation.setCompanyName(social.getCompanyName());
        // socialRelation.setPost(social.getPost());
        // socialRelation.setContact(social.getContact());
        // socialRelationBO.saveSocialRelation(socialRelation);
        // }
        return code;
    }

    @Override
    @Transactional
    public void interviewEmployApply(XN632851Req req) {
        EmployApply data = employApplyBO.getEmployApply(req.getCode());
        if (!EEmployApplyStatus.TO_INTERVIEW.getCode()
            .equals(data.getStatus())) {
            throw new BizException("xn0000", "当前应聘记录不是待面试状态");
        }
        // 保存面试信息
        data.setComposite(req.getComposite());
        data.setQuality(req.getQuality());
        data.setInterviewRecord(req.getInterviewRecord());
        data.setEmployResult(req.getEmployResult());
        data.setProbation(req.getProbation());
        data.setEmploySalary(StringValidater.toLong(req.getEmploySalary()));
        data.setEmployDepartmentCode(req.getEmployDepartmentCode());
        data.setEmployPositionCode(req.getEmployPositionCode());
        data.setEmployApproveUser(req.getEmployApproveUser());
        data.setEmployApproveDatetime(new Date());
        data.setEmployApproveNote(req.getEmployApproveNote());

        data.setStatus(EEmployApplyStatus.INTERVIEW_NO.getCode());
        if (EBoolean.YES.getCode().equals(req.getEmployApproveResult())) {
            data.setStatus(EEmployApplyStatus.INTERVIEW_YES.getCode());
        }
        employApplyBO.interview(data);
        for (XN632851ReqCheckPro checkProjectReq : req.getCheckProjectList()) {
            CheckProject checkProject = new CheckProject();
            checkProject.setName(checkProjectReq.getName());
            checkProject.setCheckResult(checkProjectReq.getCheckResult());
            checkProject.setCheckUser(checkProjectReq.getCheckUser());
            checkProject.setRemark(checkProjectReq.getRemark());
            checkProject.setEmployApplyCode(req.getCode());
            checkProjectBO.saveCheckProject(checkProject);
        }
    }

    @Override
    public Paginable<EmployApply> queryEmployApplyPage(int start, int limit,
            EmployApply condition) {
        Paginable<EmployApply> page = employApplyBO.getPaginable(start, limit,
            condition);
        if (page != null) {
            for (EmployApply employApply : page.getList()) {
                initEmployApply(employApply);
            }
        }
        return page;
    }

    @Override
    public List<EmployApply> queryEmployApplyList(EmployApply condition) {
        List<EmployApply> list = employApplyBO.queryEmployApplyList(condition);
        for (EmployApply employApply : list) {
            initEmployApply(employApply);
        }
        return list;
    }

    @Override
    public EmployApply getEmployApply(String code) {
        EmployApply data = employApplyBO.getEmployApply(code);
        initEmployApply(data);
        return data;
    }

    private void initEmployApply(EmployApply data) {
        WorkExperience wECondition = new WorkExperience();
        wECondition.setParentCode(data.getCode());
        data.setWorkExperienceList(
            workExperienceBO.queryWorkExperienceList(wECondition));

        // SocialRelation sRCondition = new SocialRelation();
        // sRCondition.setArchiveCode(data.getCode());
        // data.setSocialRelationList(
        // socialRelationBO.querySocialRelationList(sRCondition));

        CheckProject cpCondition = new CheckProject();
        cpCondition.setEmployApplyCode(data.getCode());
        data.setCheckProjectList(
            checkProjectBO.queryCheckProjectList(cpCondition));
    }
}
