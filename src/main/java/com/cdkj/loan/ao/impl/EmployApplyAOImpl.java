package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IEmployApplyAO;
import com.cdkj.loan.bo.IEmployApplyBO;
import com.cdkj.loan.bo.ISocialRelationBO;
import com.cdkj.loan.bo.IWorkExperienceBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.EmployApply;
import com.cdkj.loan.domain.WorkExperience;
import com.cdkj.loan.dto.req.XN632850Req;
import com.cdkj.loan.dto.req.XN632850ReqExp;
import com.cdkj.loan.enums.EEmployApplyStatus;

@Service
public class EmployApplyAOImpl implements IEmployApplyAO {

    @Autowired
    private IEmployApplyBO employApplyBO;

    @Autowired
    private IWorkExperienceBO workExperienceBO;

    @Autowired
    private ISocialRelationBO socialRelationBO;

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
    public void interviewEmployApply(EmployApply data) {
    }

    @Override
    public Paginable<EmployApply> queryEmployApplyPage(int start, int limit,
            EmployApply condition) {
        return employApplyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<EmployApply> queryEmployApplyList(EmployApply condition) {
        return employApplyBO.queryEmployApplyList(condition);
    }

    @Override
    public EmployApply getEmployApply(String code) {
        return employApplyBO.getEmployApply(code);
    }
}
