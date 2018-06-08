package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBizTeamAO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午1:00:55 
 * @history:
 */
@Service
public class BizTeamAOImpl implements IBizTeamAO {

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addBizTeam(BizTeam data) {
        SYSUser user = sysUserBO.getUser(data.getCaptain());
        data.setCompanyCode(user.getCompanyCode());
        return bizTeamBO.saveBizTeam(data);
    }

    @Override
    public int editBizTeam(BizTeam data) {
        if (!bizTeamBO.isBizTeamExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        SYSUser user = sysUserBO.getUser(data.getCaptain());
        data.setCompanyCode(user.getCompanyCode());
        return bizTeamBO.refreshBizTeam(data);
    }

    @Override
    public int dropBizTeam(String code) {
        if (!bizTeamBO.isBizTeamExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return bizTeamBO.removeBizTeam(code);
    }

    @Override
    public Paginable<BizTeam> queryBizTeamPage(int start, int limit,
            BizTeam condition) {
        return bizTeamBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BizTeam> queryBizTeamList(BizTeam condition) {
        return bizTeamBO.queryBizTeamList(condition);
    }

    @Override
    public BizTeam getBizTeam(String code) {
        return bizTeamBO.getBizTeam(code);
    }
}
