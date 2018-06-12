package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632310Req;
import com.cdkj.loan.enums.ERepointStatus;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月9日 下午2:19:32 
 * @history:
 */
@Service
public class RepointAOImpl implements IRepointAO {

    @Autowired
    private IRepointBO repointBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public void confirmRepoint(XN632310Req req) {
        Repoint data = repointBO.getRepoint(req.getCode());
        data.setActualAmount(StringValidater.toLong(req.getActualAmount()));
        data.setWaterBill(req.getWaterBill());
        data.setStatus(ERepointStatus.HANDLED.getCode());
        data.setUpdater(req.getUpdater());

        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        repointBO.refreshRepoint(data);
    }

    @Override
    public Paginable<Repoint> queryRepointPage(int start, int limit,
            Repoint condition) {
        Paginable<Repoint> paginable = repointBO.getPaginable(start, limit,
            condition);
        for (Repoint repoint : paginable.getList()) {
            SYSUser user = sysUserBO.getUser(repoint.getCaptain());
            repoint.setUser(user);
        }
        return paginable;
    }

    @Override
    public List<Repoint> queryRepointList(Repoint condition) {
        List<Repoint> repointList = repointBO.queryRepointList(condition);
        for (Repoint repoint : repointList) {
            SYSUser user = sysUserBO.getUser(repoint.getCaptain());
            repoint.setUser(user);
        }
        return repointList;
    }

    @Override
    public Repoint getRepoint(String code) {
        Repoint repoint = repointBO.getRepoint(code);
        SYSUser user = sysUserBO.getUser(repoint.getCaptain());
        repoint.setUser(user);
        return repoint;
    }
}
