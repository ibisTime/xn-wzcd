package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IGpsApplyAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsApplyBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632710Req;
import com.cdkj.loan.dto.req.XN632711Req;
import com.cdkj.loan.dto.req.XN632711ReqChild;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EGpsApplyStatus;
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

    @Override
    public String addGpsApply(XN632710Req req) {
        GpsApply data = new GpsApply();
        SYSUser sysUser = sysUserBO.getUser(req.getApplyUser());
        if (null != sysUser) {
            data.setCompanyCode(sysUser.getCompanyCode());
        }
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.GPS_APPLY.getCode());
        data.setCode(code);

        data.setApplyUser(req.getApplyUser());
        data.setApplyReason(req.getApplyReason());
        data.setType(req.getType());
        data.setApplyCount(StringValidater.toInteger(req.getApplyCount()));
        data.setApplyDatetime(new Date());

        data.setStatus(EGpsApplyStatus.TO_APPROVE.getCode());
        return gpsApplyBO.saveGpsApply(data);
    }

    @Override
    @Transactional
    public void approveYesGpsApply(XN632711Req req) {
        GpsApply data = new GpsApply();
        data = gpsApplyBO.getGpsApply(req.getCode());
        if (null == data) {
            throw new BizException("xn0000", "记录编号不存在");
        }

        if (!EGpsApplyStatus.TO_APPROVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "申领单不在待审核状态");
        }

        if (null == req.getGpsList()) {
            throw new BizException("xn0000", "GPS列表不能为空");
        }

        GpsApply gpsApply = new GpsApply();
        gpsApply.setCode(req.getCode());
        gpsApply.setStatus(EGpsApplyStatus.APPROVE_YES.getCode());
        gpsApply.setRemark(req.getRemark());

        for (XN632711ReqChild childReq : req.getGpsList()) {
            Gps gps = new Gps();
            gps.setCode(childReq.getCode());
            gps.setApplyCode(gpsApply.getCode());
            gps.setCompanyCode(data.getCompanyCode());
            gps.setApplyUser(data.getApplyUser());
            gps.setApplyStatus(EBoolean.YES.getCode());
            gps.setApplyDatetime(data.getApplyDatetime());
            gpsBO.applyGps(gps);
        }
        gpsApplyBO.approveGpsApply(gpsApply);
    }

    @Override
    public void approveNoGpsApply(String code, String remark) {
        GpsApply data = new GpsApply();
        data = gpsApplyBO.getGpsApply(code);
        if (null == data) {
            throw new BizException("xn0000", "记录编号不存在");
        }

        if (!EGpsApplyStatus.TO_APPROVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "申领单不在待审核状态");
        }

        data.setCode(code);
        data.setStatus(EGpsApplyStatus.APPROVE_NO.getCode());
        data.setRemark(remark);
        gpsApplyBO.approveGpsApply(data);
    }

    @Override
    public Paginable<GpsApply> queryGpsApplyPage(int start, int limit,
            GpsApply condition) {
        Paginable<GpsApply> page = gpsApplyBO.getPaginable(start, limit,
            condition);
        List<GpsApply> gpsApplyList = page.getList();
        for (GpsApply gpsApply : gpsApplyList) {
            SYSUser sysUser = sysUserBO.getUser(gpsApply.getApplyUser());
            if (null != sysUser) {
                gpsApply.setUserName(sysUser.getRealName());
            }

            Department department = departmentBO
                .getDepartment(gpsApply.getCompanyCode());
            if (null != department) {
                gpsApply.setCompanyName(department.getName());
            }
        }
        return page;
    }

    @Override
    public List<GpsApply> queryGpsApplyList(GpsApply condition) {
        List<GpsApply> gpsApplyList = gpsApplyBO.queryGpsApplyList(condition);
        for (GpsApply gpsApply : gpsApplyList) {
            SYSUser sysUser = sysUserBO.getUser(gpsApply.getApplyUser());
            if (null != sysUser) {
                gpsApply.setUserName(sysUser.getRealName());
            }

            Department department = departmentBO
                .getDepartment(gpsApply.getCompanyCode());
            if (null != department) {
                gpsApply.setCompanyName(department.getName());
            }
        }
        return gpsApplyList;
    }

    @Override
    public GpsApply getGpsApply(String code) {
        GpsApply data = gpsApplyBO.getGpsApply(code);
        SYSUser sysUser = sysUserBO.getUser(data.getApplyUser());
        if (null != sysUser) {
            data.setUserName(sysUser.getRealName());
        }

        Department department = departmentBO
            .getDepartment(data.getCompanyCode());
        if (null != department) {
            data.setCompanyName(department.getName());
        }
        return data;
    }
}
