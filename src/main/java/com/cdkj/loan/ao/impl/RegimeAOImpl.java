package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IRegimeAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IRegimeBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IScopePeopleBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Regime;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.ScopePeople;
import com.cdkj.loan.dto.req.XN632730Req;
import com.cdkj.loan.dto.req.XN632731Req;
import com.cdkj.loan.enums.ENoticeRegime;
import com.cdkj.loan.enums.ERegimeStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 公司制度
 * @author: silver 
 * @since: 2018年6月4日 下午8:41:44 
 * @history:
 */
@Service
public class RegimeAOImpl implements IRegimeAO {
    @Autowired
    private IRegimeBO regimeBO;

    @Autowired
    private IScopePeopleBO scopePeopleBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    @Transactional
    public String addRegime(XN632730Req req) {
        Regime condition = new Regime();
        condition.setRegimeCode(req.getRegimeCode());
        if (regimeBO.getTotalCount(condition) != 0) {
            throw new BizException("xn0000", "制度编号已存在，请重新输入！");
        }

        Regime data = new Regime();
        data.setName(req.getName());
        data.setRegimeCode(req.getRegimeCode());
        data.setType(req.getType());
        data.setContent(req.getContent());
        data.setStatus(ERegimeStatus.TO_PUBLISH.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        String regimeCode = regimeBO.saveRegime(data);

        // 添加制度范围
        scopePeopleBO.saveScopePeople(regimeCode,
            ENoticeRegime.REMIGE.getCode(), req.getScopePeopleList());
        return regimeCode;
    }

    @Override
    public Paginable<Regime> queryRegimePage(int start, int limit,
            Regime condition) {
        Paginable<Regime> paginable = regimeBO.getPaginable(start, limit,
            condition);
        for (Regime regime : paginable.getList()) {
            SYSUser user = sysUserBO.getUser(regime.getUpdater());
            regime.setUpdaterName(user.getRealName());
        }
        return paginable;
    }

    @Override
    public List<Regime> queryRegimeList(Regime condition) {
        List<Regime> queryRegimeList = regimeBO.queryRegimeList(condition);
        for (Regime regime : queryRegimeList) {
            SYSUser user = sysUserBO.getUser(regime.getUpdater());
            regime.setUpdaterName(user.getRealName());
        }
        return queryRegimeList;
    }

    @Override
    public Regime getRegime(String code) {
        Regime regime = regimeBO.getRegime(code);
        ScopePeople scopePeople = new ScopePeople();
        scopePeople.setRefCode(code);
        regime.setScopePeopleList(
            scopePeopleBO.queryScopePeopleList(scopePeople));
        SYSUser user = sysUserBO.getUser(regime.getUpdater());
        regime.setUpdaterName(user.getRealName());
        return regime;
    }

    @Override
    @Transactional
    public void editRegime(XN632731Req req) {
        Regime data = new Regime();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setRegimeCode(req.getRegimeCode());
        data.setType(req.getType());
        data.setContent(req.getContent());

        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        regimeBO.editRegime(data);

        // 添加制度范围
        scopePeopleBO.dropScopePeopleByRef(req.getCode());
        scopePeopleBO.saveScopePeople(req.getCode(),
            ENoticeRegime.REMIGE.getCode(), req.getScopePeopleList());
    }

    @Override
    public void publishRegime(String code, String updater, String remark) {
        Regime regime = regimeBO.getRegime(code);
        if (!ERegimeStatus.TO_PUBLISH.getCode().equals(regime.getStatus())) {
            throw new BizException("xn0000", "制度不在待发布状态！");
        }
        regimeBO.publishRegime(code, updater, remark);
    }

    @Override
    public void removeRegime(String code, String updater, String remark) {
        Regime regime = regimeBO.getRegime(code);
        if (!ERegimeStatus.PUBLISHED.getCode().equals(regime.getStatus())) {
            throw new BizException("xn0000", "制度不在待发布状态！");
        }
        regimeBO.removeRegime(code, updater, remark);
    }
}
