package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IGpsApplyAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsApplyBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632710Req;
import com.cdkj.loan.dto.req.XN632711Req;
import com.cdkj.loan.dto.req.XN632712Req;
import com.cdkj.loan.dto.req.XN632712ReqGps;
import com.cdkj.loan.dto.req.XN632713Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGpsApplyStatus;
import com.cdkj.loan.enums.EGpsApplyType;
import com.cdkj.loan.enums.EGpsUseStatus;
import com.cdkj.loan.enums.EGpsUserApplyStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.exception.BizException;

/**
 * GPS申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:19:42 
 * @history:
 */
@Service
public class GpsApplyAOImpl implements IGpsApplyAO {

    @Autowired
    private IGpsApplyBO gpsApplyBO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Override
    public String applyCompanyGps(XN632710Req req) {
        Gps condition = new Gps();
        condition.setCompanyApplyStatus(EBoolean.NO.getCode());
        List<Gps> list = gpsBO.queryGpsList(condition);
        if (StringValidater.toInteger(req.getApplyCount()) > list.size()) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "申请数量大于库存！");
        }
        // 保存数据
        GpsApply data = new GpsApply();
        data.setType(EGpsApplyType.COMPANY.getCode());
        SYSUser sysUser = sysUserBO.getUser(req.getApplyUser());
        if (StringUtils.isBlank(sysUser.getPostCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "申请用户还未设置职位");
        }
        data.setCompanyCode(sysUser.getCompanyCode());
        data.setApplyUser(req.getApplyUser());
        data.setApplyReason(req.getApplyReason());
        data.setApplyCount(StringValidater.toInteger(req.getApplyCount()));
        data.setApplyDatetime(new Date());
        data.setStatus(EGpsApplyStatus.TO_APPROVE.getCode());// 节点
        return gpsApplyBO.saveGpsApply(data);
    }

    @Override
    @Transactional
    public void approveCompanyGps(XN632712Req req) {
        GpsApply data = gpsApplyBO.getGpsApply(req.getCode());
        if (!EGpsApplyStatus.TO_APPROVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "GPS申领单不是待审核状态，不能操作");
        }
        // 审核通过gps
        if (EBoolean.YES.getCode().equals(req.getApproveResult())) {
            // gps 分配
            for (XN632712ReqGps childReq : req.getGpsList()) {
                Gps gps = gpsBO.getGps(childReq.getCode());
                if (!EGpsUseStatus.UN_USE.getCode()
                    .equals(gps.getUseStatus())) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "编号为" + gps.getCode() + "的gps不是待使用状态,不能申领");
                }
                gpsBO.approveCompanyGps(childReq.getCode(),
                    data.getCompanyCode(), data.getApplyDatetime(),
                    data.getCode());
            }
            // 产生物流单
            logisticsBO.saveLogistics(ELogisticsType.GPS.getCode(),
                data.getCode(), data.getApplyUser(), null, null);
        }
        // 修改订单状态
        gpsApplyBO.approveCompanyGpsApply(data, req.getApproveResult(),
            req.getApproveUser(), req.getApproveNote());
    }

    @Override
    @Transactional
    public String applyUserGps(XN632711Req req) {
        SYSUser user = sysUserBO.getUser(req.getApplyUser());
        Gps condition = new Gps();
        condition.setCompanyCode(user.getCompanyCode());
        condition.setCompanyApplyStatus(EBoolean.YES.getCode());// 公司已申领
        condition.setApplyStatus(EGpsUserApplyStatus.TO_APPLY.getCode());// 个人未申领
        List<Gps> list = gpsBO.queryGpsList(condition);
        if (StringValidater.toInteger(req.getApplyCount()) > list.size()) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "申请数量大于公司库存！");
        }
        // 1、申请记录落地
        GpsApply data = new GpsApply();
        data.setType(EGpsApplyType.PERSON.getCode());
        SYSUser sysUser = sysUserBO.getUser(req.getApplyUser());
        if (StringUtils.isBlank(sysUser.getPostCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "申请用户还未设置职位");
        }
        data.setCompanyCode(sysUser.getCompanyCode());
        data.setApplyUser(req.getApplyUser());
        data.setApplyCount(StringValidater.toInteger(req.getApplyCount()));
        data.setApplyReason(req.getApplyReason());
        data.setApplyDatetime(new Date());
        data.setStatus(EGpsApplyStatus.TO_APPROVE.getCode());
        return gpsApplyBO.saveGpsApply(data);
    }

    @Override
    public void approveUserGps(XN632713Req req) {
        GpsApply data = gpsApplyBO.getGpsApply(req.getCode());
        if (!EGpsApplyStatus.TO_APPROVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "GPS申领单不在待审核状态");
        }
        // 审核通过gps
        if (EBoolean.YES.getCode().equals(req.getApproveResult())) {
            // 2、gps个人申请状态变更
            for (XN632712ReqGps gpsReq : req.getGpsList()) {
                Gps gps = gpsBO.getGps(gpsReq.getCode());
                if (!EGpsUserApplyStatus.TO_APPLY.getCode()
                    .equals(gps.getApplyStatus())) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "编号为" + gps.getCode() + "的gps不处于待申领状态,不能申领");
                }
                gpsBO.applyUserGps(gpsReq.getCode(), data.getCode(),
                    data.getApplyUser());
                gpsBO.approveUserGps(gpsReq.getCode(), req.getApproveResult());
            }
        }
        // 修改订单状态
        gpsApplyBO.approveUserGpsApply(data, req.getApproveResult(),
            req.getApproveUser(), req.getApproveNote());
    }

    @Override
    public Paginable<GpsApply> queryGpsApplyPage(int start, int limit,
            GpsApply condition) {
        Paginable<GpsApply> page = gpsApplyBO.getPaginable(start, limit,
            condition);
        List<GpsApply> gpsApplyList = page.getList();
        for (GpsApply gpsApply : gpsApplyList) {
            initGpsApply(gpsApply);
        }
        return page;
    }

    @Override
    public List<GpsApply> queryGpsApplyList(GpsApply condition) {
        List<GpsApply> gpsApplyList = gpsApplyBO.queryGpsApplyList(condition);
        for (GpsApply gpsApply : gpsApplyList) {
            initGpsApply(gpsApply);
        }
        return gpsApplyList;
    }

    @Override
    public GpsApply getGpsApply(String code) {
        GpsApply gpsApply = gpsApplyBO.getGpsApply(code);
        initGpsApply(gpsApply);
        return gpsApply;
    }

    private void initGpsApply(GpsApply gpsApply) {
        SYSUser sysUser = sysUserBO.getUser(gpsApply.getApplyUser());
        gpsApply.setApplyUserName(sysUser.getRealName());
        Department department = departmentBO
            .getDepartment(gpsApply.getCompanyCode());
        if (department != null) {
            gpsApply.setCompanyName(department.getName());
        }
        List<Gps> gpsList = new ArrayList<Gps>();
        if (EGpsApplyType.COMPANY.getCode().equals(gpsApply.getType())) {
            gpsList = gpsBO.queryGpsListByCompanyApplyCode(gpsApply.getCode());
        } else if (EGpsApplyType.PERSON.getCode().equals(gpsApply.getType())) {
            gpsList = gpsBO.queryGpsListByUserApplyCode(gpsApply.getCode());
        }
        gpsApply.setGpsList(gpsList);
    }
}
