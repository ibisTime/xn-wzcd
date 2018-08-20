package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.IGpsSupplierBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.domain.GpsSupplier;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632701Req;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EGpsSendBackReason;
import com.cdkj.loan.enums.EGpsUseStatus;
import com.cdkj.loan.enums.EGpsUserApplyStatus;

@Service
public class GpsAOImpl implements IGpsAO {

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IGpsSupplierBO gpsSupplierBO;

    @Override
    public String addGps(String gpsDevNo, String gpsType, String supplierCode) {
        // 验证gps设备号是否唯一
        gpsBO.checkGpsDevNo(gpsDevNo);

        Gps data = new Gps();
        String code = OrderNoGenerater.generate(EGeneratePrefix.GPS.getCode());
        data.setCode(code);
        data.setGpsDevNo(gpsDevNo);
        data.setGpsType(gpsType);
        data.setSupplierCode(supplierCode);
        data.setCompanyApplyStatus(EBoolean.NO.getCode());// 公司申领状态 (0待申领 1已申领)
        data.setApplyStatus(EGpsUserApplyStatus.TO_APPLY.getCode());// 个人申领状态
        data.setUseStatus(EGpsUseStatus.UN_USE.getCode());// 使用状态
        gpsBO.saveGps(data);
        return code;
    }

    @Override
    public Paginable<Gps> queryGpsPage(int start, int limit, Gps condition) {
        Paginable<Gps> page = gpsBO.getPaginable(start, limit, condition);
        List<Gps> list = page.getList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (Gps gps : list) {
                initGps(gps);
            }
        }
        return page;
    }

    @Override
    public List<Gps> queryGpsList(Gps condition) {
        List<Gps> list = gpsBO.queryGpsList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Gps gps : list) {
                initGps(gps);
            }
        }
        return list;
    }

    @Override
    public Gps getGps(String code) {
        Gps gps = gpsBO.getGps(code);
        if (null != gps) {
            initGps(gps);
        }
        return gps;
    }

    // 初始化gps数据，包含公司名称 和 业务员姓名
    private void initGps(Gps gps) {
        // 业务公司名称
        if (StringUtils.isNotBlank(gps.getCompanyCode())) {
            Department department = departmentBO
                .getDepartment(gps.getCompanyCode());
            gps.setCompanyName(department.getName());
        }

        // 申请人姓名
        if (StringUtils.isNotBlank(gps.getApplyUser())) {
            SYSUser sysUser = sysUserBO.getUser(gps.getApplyUser());
            gps.setApplyUserName(sysUser.getRealName());
        }

        // 供应商名称
        if (StringUtils.isNotBlank(gps.getSupplierCode())) {
            GpsSupplier gpsSupplier = gpsSupplierBO
                .getGpsSupplier(gps.getSupplierCode());
            gps.setSupplierName(gpsSupplier.getName());
        }
    }

    @Override
    public void gpsSendBackApply(XN632701Req req) {
        Gps gps = gpsBO.getGps(req.getCode());
        if (EGpsSendBackReason.DAMAGE.getCode().equals(req.getReason())) {// gps损坏
            gps.setUseStatus(EGpsUseStatus.DAMAGE.getCode());
        }
        if (EGpsSendBackReason.EMPLOYEE_LEAVE.getCode()
            .equals(req.getReason())) {// 员工离职
            gps.setApplyStatus(EGpsUserApplyStatus.TO_APPLY.getCode());
        }
        gpsBO.refresh(gps);
        // 资料传递待发件 TODO
        // logisticsBO.saveLogistics(ELogisticsType.GPS.getCode(),
        // gps.getCode(),
        // gps.getApplyUser(), null, null);
    }
}
