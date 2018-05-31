package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EGpsUseStatus;

@Service
public class GpsAOImpl implements IGpsAO {

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addGps(String gpsDevNo, String gpsType) {
        Gps data = new Gps();
        String code = OrderNoGenerater.generate(EGeneratePrefix.GPS.getCode());
        data.setCode(code);
        data.setGpsDevNo(gpsDevNo);
        data.setGpsType(gpsType);
        data.setApplyStatus(EBoolean.NO.getCode());
        data.setUseStatus(EGpsUseStatus.UN_USE.getCode());
        gpsBO.saveGps(data);
        return code;
    }

    @Override
    public Paginable<Gps> queryGpsPage(int start, int limit, Gps condition) {

        Paginable<Gps> paginable = gpsBO.getPaginable(start, limit, condition);
        List<Gps> list = paginable.getList();

        if (paginable != null
                && CollectionUtils.isNotEmpty(paginable.getList())) {
            for (Gps gps : list) {
                initGps(gps);
            }
        }
        return paginable;
    }

    @Override
    public List<Gps> queryGpsList(Gps condition) {

        List<Gps> list = gpsBO.queryGpsList(condition);
        if (null != list && CollectionUtils.isNotEmpty(list)) {
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
            Department department = departmentBO.getDepartment(gps
                .getCompanyCode());
            if (null != department) {
                gps.setCompanyName(department.getName());
            }

        }

        // 业务员姓名
        if (StringUtils.isNotBlank(gps.getApplyUser())) {
            SYSUser sysUser = sysUserBO.getUser(gps.getApplyUser());
            if (null != sysUser) {
                gps.setApplyUserName(sysUser.getRealName());
            }

        }

    }

}
