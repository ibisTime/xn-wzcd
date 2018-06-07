package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.ao.ISYSUserAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISocialRelationBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SocialRelation;
import com.cdkj.loan.dto.req.XN632800Req;
import com.cdkj.loan.dto.req.XN632800ReqChild;
import com.cdkj.loan.dto.req.XN632802Req;
import com.cdkj.loan.dto.req.XN632802ReqChild;
import com.cdkj.loan.enums.ESysUserType;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月4日 下午7:41:28 
 * @history:
 */
@Service
public class ArchiveAOImpl implements IArchiveAO {

    @Autowired
    private IArchiveBO archiveBO;

    @Autowired
    private ISocialRelationBO socialRelationBO;

    @Autowired
    private ISYSUserAO sysUserAO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addArchive(XN632800Req req) {
        Archive data = new Archive();
        data.setRealName(req.getRealName());
        data.setIdNo(req.getIdNo());
        data.setMobile(req.getMobile());
        data.setJobNo(req.getJobNo());
        data.setEntryDatetime(DateUtil.strToDate(req.getEntryDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDepartmentCode(req.getDepartmentCode());
        data.setPostCode(req.getPostCode());
        data.setJobClasses(req.getJobClasses());
        data.setBirthday(DateUtil.strToDate(req.getBirthday(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setGender(req.getGender());
        data.setNation(req.getNation());
        data.setNativePlace(req.getNativePlace());
        data.setMarryStatus(req.getMarryStatus());
        data.setPolitics(req.getPolitics());
        data.setMajor(req.getMajor());
        data.setEducation(req.getEducation());
        data.setWorkStatus(req.getWorkStatus());
        data.setHealth(req.getHealth());
        data.setSalaryCard(req.getSalaryCard());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setFiveInsuranceInfo(req.getFiveInsuranceInfo());
        data.setResidenceAddress(req.getResidenceAddress());
        data.setResidenceProperty(req.getResidenceProperty());
        data.setSocialSecurityRegDatetime(DateUtil.strToDate(
            req.getSocialSecurityRegDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setCurrentAddress(req.getCurrentAddress());
        data.setEmergencyContact(req.getEmergencyContact());
        data.setEmergencyContactMobile(req.getEmergencyContactMobile());
        data.setContractDeadline(req.getContractDeadline());
        data.setContractType(req.getContractType());
        data.setProbationTime(req.getProbationTime());
        data.setConvertDatetime(DateUtil.strToDate(req.getConvertDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setLeaveDatetime(DateUtil.strToDate(req.getLeaveDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setEntranceNo(req.getEntranceNo());
        data.setCheckNo(req.getCheckNo());
        data.setCarNo(req.getCarNo());
        data.setIdNoPdf(req.getIdNoPdf());
        data.setPhoto(req.getPhoto());
        data.setWechat(req.getWechat());
        data.setQq(req.getQq());
        data.setPerformSalaryStandard(req.getPerformSalaryStandard());
        data.setQuarterlyAwardStandard(req.getQuarterlyAwardStandard());
        data.setCommumicationFeeStandard(req.getCommumicationFeeStandard());
        data.setProvincialBedStandard(req.getProvincialBedStandard());
        data.setNoProvincialBedStandard(req.getNoProvincialBedStandard());
        data.setTrafficAward(StringValidater.toDouble(req.getTrafficAward()));
        data.setMobileAward(StringValidater.toDouble(req.getMobileAward()));
        data.setTaxiWard(StringValidater.toDouble(req.getTaxiWard()));
        data.setMealAward(StringValidater.toDouble(req.getMealAward()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        if (null != req.getLeaveDatetime()
                && !"".equals(req.getLeaveDatetime())
                && null != req.getEntryDatetime()
                && !"".equals(req.getEntryDatetime())) {
            int num = DateUtil.daysBetween(req.getEntryDatetime(),
                req.getLeaveDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING);
            String workingYears = String.valueOf(((int) (num / 365)));
            data.setWorkingYears(workingYears);
        }
        Department department = departmentBO.getDepartment(req
            .getDepartmentCode());
        String userId = sysUserAO.doAddUser(ESysUserType.Plat.getCode(),
            req.getMobile(), "888888", req.getMobile(), req.getRealName(),
            SysConstants.COMMON_ROLE, department.getParentCode(),
            department.getCode(), req.getPostCode());
        data.setUserId(userId);
        String archiveCode = archiveBO.saveArchive(data);

        List<XN632800ReqChild> socialRelationList = req.getSocialRelationList();
        for (XN632800ReqChild xn632800ReqChild : socialRelationList) {
            SocialRelation data1 = new SocialRelation();
            data1.setArchiveCode(archiveCode);
            data1.setRealName(xn632800ReqChild.getRealName());
            data1.setRelation(xn632800ReqChild.getRelation());
            data1.setCompanyName(xn632800ReqChild.getCompanyName());
            data1.setPost(xn632800ReqChild.getPost());
            data1.setContact(xn632800ReqChild.getContact());
            socialRelationBO.saveSocialRelation(data1);
        }

        return archiveCode;
    }

    @Override
    public void editArchive(XN632802Req req) {
        if (!archiveBO.isArchiveExist(req.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        Archive data = new Archive();
        data.setRealName(req.getRealName());
        data.setIdNo(req.getIdNo());
        data.setMobile(req.getMobile());
        data.setJobNo(req.getJobNo());
        data.setEntryDatetime(DateUtil.strToDate(req.getEntryDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDepartmentCode(req.getDepartmentCode());
        data.setPostCode(req.getPostCode());
        data.setJobClasses(req.getJobClasses());
        data.setBirthday(DateUtil.strToDate(req.getBirthday(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setGender(req.getGender());
        data.setNation(req.getNation());
        data.setNativePlace(req.getNativePlace());
        data.setMarryStatus(req.getMarryStatus());
        data.setPolitics(req.getPolitics());
        data.setMajor(req.getMajor());
        data.setEducation(req.getEducation());
        data.setWorkStatus(req.getWorkStatus());
        data.setHealth(req.getHealth());
        data.setSalaryCard(req.getSalaryCard());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setFiveInsuranceInfo(req.getFiveInsuranceInfo());
        data.setResidenceAddress(req.getResidenceAddress());
        data.setResidenceProperty(req.getResidenceProperty());
        data.setSocialSecurityRegDatetime(DateUtil.strToDate(
            req.getSocialSecurityRegDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setCurrentAddress(req.getCurrentAddress());
        data.setEmergencyContact(req.getEmergencyContact());
        data.setEmergencyContactMobile(req.getEmergencyContactMobile());
        data.setContractDeadline(req.getContractDeadline());
        data.setContractType(req.getContractType());
        data.setProbationTime(req.getProbationTime());
        data.setConvertDatetime(DateUtil.strToDate(req.getConvertDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setLeaveDatetime(DateUtil.strToDate(req.getLeaveDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setEntranceNo(req.getEntranceNo());
        data.setCheckNo(req.getCheckNo());
        data.setCarNo(req.getCarNo());
        data.setIdNoPdf(req.getIdNoPdf());
        data.setPhoto(req.getPhoto());
        data.setWechat(req.getWechat());
        data.setQq(req.getQq());
        data.setPerformSalaryStandard(req.getPerformSalaryStandard());
        data.setQuarterlyAwardStandard(req.getQuarterlyAwardStandard());
        data.setCommumicationFeeStandard(req.getCommumicationFeeStandard());
        data.setProvincialBedStandard(req.getProvincialBedStandard());
        data.setNoProvincialBedStandard(req.getNoProvincialBedStandard());
        data.setTrafficAward(StringValidater.toDouble(req.getTrafficAward()));
        data.setMobileAward(StringValidater.toDouble(req.getMobileAward()));
        data.setTaxiWard(StringValidater.toDouble(req.getTaxiWard()));
        data.setMealAward(StringValidater.toDouble(req.getMealAward()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setWorkingYears(req.getWorkingYears());

        List<XN632802ReqChild> list = req.getSocialRelationList();
        for (XN632802ReqChild child : list) {

            if (!"".equals(child.getIsDelete()) && null != child.getIsDelete()
                    && "0".equals(child.getIsDelete())) {
                socialRelationBO.removeSocialRelation(child.getCode());
                continue;
            }
            SocialRelation data1 = new SocialRelation();
            data1.setCode(child.getCode());
            data1.setCompanyName(child.getCompanyName());
            data1.setRealName(child.getRealName());
            data1.setRelation(child.getRelation());
            data1.setContact(child.getContact());
            data1.setPost(child.getPost());
            socialRelationBO.refreshSocialRelation(data1);

        }

        archiveBO.refreshArchive(data);
    }

    @Override
    public void dropArchive(String code) {
        if (!archiveBO.isArchiveExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        archiveBO.removeArchive(code);
        socialRelationBO.removeSocialRelation(code);
    }

    @Override
    public Paginable<Archive> queryArchivePage(int start, int limit,
            Archive condition) {
        return archiveBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Archive> queryArchiveList(Archive condition) {
        return archiveBO.queryArchiveList(condition);
    }

    @Override
    public Archive getArchive(String code) {

        SocialRelation condition = new SocialRelation();
        condition.setArchiveCode(code);
        List<SocialRelation> list = socialRelationBO
            .querySocialRelationList(condition);
        Archive archive = archiveBO.getArchive(code);
        archive.setSocialRelationList(list);
        return archive;
    }

    @Override
    public void editLeaveArchive(Archive data) {
        if (!archiveBO.isArchiveExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }

        archiveBO.refreshLeaveArchive(data);
    }

}
