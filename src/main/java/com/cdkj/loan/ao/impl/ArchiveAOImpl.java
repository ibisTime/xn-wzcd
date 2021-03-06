package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.ao.ISYSUserAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISocialRelationBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.SocialRelation;
import com.cdkj.loan.dto.req.XN632800Req;
import com.cdkj.loan.dto.req.XN632800ReqChild;
import com.cdkj.loan.dto.req.XN632802Req;
import com.cdkj.loan.dto.req.XN632802ReqChild;
import com.cdkj.loan.dto.req.XN632804Req;
import com.cdkj.loan.dto.req.XN632808Req;
import com.cdkj.loan.dto.req.XN632809Req;
import com.cdkj.loan.dto.res.XN632803Res;
import com.cdkj.loan.enums.EArchiveNode;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
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
    private ISYSUserBO sysUserBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    @Transactional
    public String addArchive(XN632800Req req) {
        Archive data = new Archive();
        data.setRealName(req.getRealName());
        data.setIdNo(req.getIdNo());
        data.setMobile(req.getMobile());
        data.setJobNo(req.getJobNo());
        data.setEntryDatetime(DateUtil.strToDate(req.getEntryDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setPostCode(req.getPostCode());
        Department department = departmentBO.getDepartment(req.getPostCode());// 通过岗位获取部门
        data.setDepartmentCode(department.getParentCode());

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
        data.setTrafficAward(StringValidater.toLong(req.getTrafficAward()));
        data.setMobileAward(StringValidater.toLong(req.getMobileAward()));
        data.setTaxiWard(StringValidater.toLong(req.getTaxiWard()));
        data.setMealAward(StringValidater.toLong(req.getMealAward()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        if (StringUtils.isNotBlank(req.getLeaveDatetime())
                && StringUtils.isNotBlank(req.getEntryDatetime())) {
            int num = DateUtil.daysBetween(req.getEntryDatetime(),
                req.getLeaveDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING);
            String workingYears = String.valueOf(((int) (num / 365)));
            data.setWorkingYears(workingYears);
        }
        data.setCurNodeCode(EArchiveNode.BRANCH_CEO_APPROVE.getCode());
        data.setStatus(EBoolean.YES.getCode());
        String archiveCode = archiveBO.saveArchive(data);

        sysBizLogBO.saveSYSBizLog(archiveCode, EBizLogType.ARCHIVE,
            archiveCode, EArchiveNode.BRANCH_CEO_APPROVE.getCode());

        List<XN632800ReqChild> socialRelationList = req.getSocialRelationList();
        if (CollectionUtils.isEmpty(socialRelationList)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "社会关系为空！");
        }
        for (XN632800ReqChild xn632800ReqChild : socialRelationList) {
            SocialRelation data1 = new SocialRelation();
            data1.setArchiveCode(archiveCode);
            data1.setRealName(xn632800ReqChild.getRealName());
            data1.setRelation(xn632800ReqChild.getRelation());
            data1.setCompanyName(xn632800ReqChild.getCompanyName());
            data1.setPost(xn632800ReqChild.getPost());
            data1.setContact(xn632800ReqChild.getContact());
            data1.setStatus(EBoolean.YES.getCode());
            socialRelationBO.saveSocialRelation(data1);
        }
        return archiveCode;
    }

    @Override
    @Transactional
    public void editArchive(XN632802Req req) {
        Archive data = archiveBO.getArchive(req.getCode());
        if (!EArchiveNode.REAPPLY.getCode().equals(data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "人事档案不是重新申请节点，不能操作！");
        }
        data.setRealName(req.getRealName());
        data.setIdNo(req.getIdNo());
        data.setMobile(req.getMobile());
        data.setJobNo(req.getJobNo());
        data.setEntryDatetime(DateUtil.strToDate(req.getEntryDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setPostCode(req.getPostCode());
        Department department = departmentBO.getDepartment(req.getPostCode());// 通过岗位获取部门
        data.setDepartmentCode(department.getParentCode());
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
        data.setTrafficAward(StringValidater.toLong(req.getTrafficAward()));
        data.setMobileAward(StringValidater.toLong(req.getMobileAward()));
        data.setTaxiWard(StringValidater.toLong(req.getTaxiWard()));
        data.setMealAward(StringValidater.toLong(req.getMealAward()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setWorkingYears(req.getWorkingYears());
        data.setCurNodeCode(EArchiveNode.BRANCH_CEO_APPROVE.getCode());
        // 删除原有的社会关系
        SocialRelation condition = new SocialRelation();
        condition.setArchiveCode(req.getCode());
        List<SocialRelation> socialRelationList = socialRelationBO
            .querySocialRelationList(condition);
        for (SocialRelation socialRelation : socialRelationList) {
            socialRelationBO.removeSocialRelationTrue(socialRelation.getCode());
        }
        List<XN632802ReqChild> list = req.getSocialRelationList();
        for (XN632802ReqChild child : list) {
            SocialRelation data1 = new SocialRelation();
            data1.setCode(child.getCode());
            data1.setArchiveCode(data.getCode());
            data1.setCompanyName(child.getCompanyName());
            data1.setRealName(child.getRealName());
            data1.setRelation(child.getRelation());
            data1.setContact(child.getContact());
            data1.setPost(child.getPost());
            socialRelationBO.saveSocialRelation(data1);
        }
        archiveBO.refreshArchive(data);
    }

    @Override
    public void dropArchive(String code) {
        if (!archiveBO.isArchiveExist(code)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "人事档案不存在");
        }
        archiveBO.removeArchive(code);
        socialRelationBO.removeSocialRelation(code);
    }

    @Override
    @Transactional
    public void branchCeoApprove(XN632804Req req) {
        Archive data = archiveBO.getArchive(req.getCode());
        String curNodeCode = data.getCurNodeCode();
        if (!EArchiveNode.BRANCH_CEO_APPROVE.getCode().equals(curNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "人事档案不是分公司总经理审批节点，不能操作！");
        }
        String nextNodeCode = getNextNodeCode(curNodeCode,
            req.getApproveResult());

        archiveBO.branchCeoApprove(req.getCode(), nextNodeCode,
            req.getApproveNote(), req.getOperator());

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
            EBizLogType.ARCHIVE, data.getCode(), curNodeCode, nextNodeCode,
            req.getApproveNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void administrationApprove(XN632808Req req) {
        Archive data = archiveBO.getArchive(req.getCode());
        String curNodeCode = data.getCurNodeCode();
        if (!EArchiveNode.ADMINISTRATION_APPROVE.getCode().equals(curNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "人事档案不是行政部审批节点，不能操作！");
        }
        String nextNodeCode = getNextNodeCode(curNodeCode,
            req.getApproveResult());

        archiveBO.administrationApprove(req.getCode(), nextNodeCode,
            req.getApproveNote(), req.getOperator());

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
            EBizLogType.ARCHIVE, data.getCode(), curNodeCode, nextNodeCode,
            req.getApproveNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void networkSkillApprove(XN632809Req req) {
        Archive data = archiveBO.getArchive(req.getCode());
        String curNodeCode = data.getCurNodeCode();
        if (!EArchiveNode.NETWORK_SKILL_APPROVE.getCode().equals(curNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "人事档案不是网络技术部审批节点，不能操作！");
        }
        String nextNodeCode = getNextNodeCode(curNodeCode,
            req.getApproveResult());

        archiveBO.networkSkillApprove(req.getCode(), nextNodeCode,
            req.getApproveNote(), req.getOperator());

        if (EBoolean.YES.getCode().equals(req.getApproveResult())) {

            // 生成角色
            SYSUser sysUserLoginName = sysUserBO.getUserByLoginName(data
                .getMobile());
            SYSUser sysUserMobile = sysUserBO.getUserByMobile(data.getMobile());

            String userId = null;
            if (sysUserLoginName == null && sysUserMobile == null) {
                userId = sysUserAO.doAddUser(ESysUserType.Plat.getCode(),
                    data.getMobile(), "888888", data.getMobile(),
                    data.getRealName(), SysConstants.COMMON_ROLE,
                    data.getPostCode(), null);
            } else {
                if (sysUserLoginName != null) {
                    userId = sysUserLoginName.getUserId();
                } else if (sysUserMobile != null) {
                    userId = sysUserMobile.getUserId();
                }
            }
            data.setUserId(userId);
            archiveBO.refreshArchiveUserId(data);
        }

        // 日志记录
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.ARCHIVE, data.getCode(),
            curNodeCode, req.getApproveNote(), req.getOperator());
    }

    private String getNextNodeCode(String curNodeCode, String approveResult) {
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        String nextNodeCode = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            nextNodeCode = nodeFlow.getNextNode();
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            nextNodeCode = nodeFlow.getBackNode();
        }
        return nextNodeCode;
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
        Archive archive = archiveBO.getArchive(code);
        SocialRelation condition = new SocialRelation();
        condition.setArchiveCode(code);
        List<SocialRelation> list = socialRelationBO
            .querySocialRelationList(condition);
        archive.setSocialRelationList(list);
        archive.setDepartmentName(departmentBO.getDepartment(
            archive.getDepartmentCode()).getName());
        archive.setPostName(departmentBO.getDepartment(archive.getPostCode())
            .getName());
        return archive;
    }

    @Override
    @Transactional
    public void editLeaveArchive(Archive data) {
        if (!archiveBO.isArchiveExist(data.getCode())) {
            throw new BizException("xn0000", "人事档案不存在");
        }
        archiveBO.refreshLeaveArchive(data);
    }

    @Override
    @Transactional
    public void statisticsAge(Archive condition) {
        int age1to20 = 0;
        int age20to30 = 0;
        int age30to40 = 0;
        int age40to50 = 0;
        int age50to100 = 0;
        List<Archive> archiveList = archiveBO.queryArchiveList(condition);
        for (Archive archive : archiveList) {
            // 当前年
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int year = calendar.get(Calendar.YEAR);
            // 出生年
            calendar.setTime(archive.getBirthday());
            int birthday = calendar.get(Calendar.YEAR);
            // 年龄
            int age = year - birthday;
            if (age > 0 && age < 20) {
                age1to20 = age1to20 + 1;
            } else if (age >= 20 && age < 30) {
                age20to30 = age20to30 + 1;
            } else if (age >= 30 && age < 40) {
                age30to40 = age30to40 + 1;
            } else if (age >= 40 && age < 50) {
                age40to50 = age40to50 + 1;
            } else if (age >= 50 && age < 100) {
                age50to100 = age50to100 + 1;
            }
        }
    }

    @Override
    public List<XN632803Res> getTotal() {
        List<XN632803Res> list = new ArrayList<XN632803Res>();

        XN632803Res res1 = new XN632803Res();
        res1.setAge(0 + "至" + 20);
        int count1 = archiveBO.getTotalCount(0, 20);
        res1.setCount(count1);
        list.add(res1);

        XN632803Res res2 = new XN632803Res();
        res2.setAge(20 + "至" + 30);
        int count2 = archiveBO.getTotalCount(20, 30);
        res2.setCount(count2);
        list.add(res2);

        XN632803Res res3 = new XN632803Res();
        res3.setAge(30 + "至" + 40);
        int count3 = archiveBO.getTotalCount(30, 40);
        res3.setCount(count3);
        list.add(res3);

        XN632803Res res4 = new XN632803Res();
        res4.setAge(40 + "至" + 50);
        int count4 = archiveBO.getTotalCount(40, 50);
        res4.setCount(count4);
        list.add(res4);

        XN632803Res res5 = new XN632803Res();
        res5.setAge(50 + "至" + 100);
        int count5 = archiveBO.getTotalCount(50, 100);
        res5.setCount(count5);
        list.add(res5);
        return list;
    }

}
