package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBizTeamAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630190Req;
import com.cdkj.loan.dto.req.XN630192Req;
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

    @Autowired
    private IAccountBO accountBO;

    @Override
    public String addBizTeam(XN630190Req req) {

        BizTeam data = new BizTeam();
        data.setName(req.getName());
        data.setCaptain(req.getCaptain());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setStatus("1");
        data.setAccountNo(req.getAccountNo());
        data.setBank(req.getBank());
        data.setSubbranch(req.getSubbranch());
        data.setWaterBill(req.getWaterBill());

        SYSUser user = sysUserBO.getUser(data.getCaptain());
        data.setCompanyCode(user.getCompanyCode());
        String bizTeamCode = bizTeamBO.saveBizTeam(data);
        return bizTeamCode;
    }

    @Override
    public void editBizTeam(XN630192Req req) {
        if (!bizTeamBO.isBizTeamExist(req.getCode())) {
            throw new BizException("xn0000", "业务团队不存在");
        }
        BizTeam data = bizTeamBO.getBizTeam(req.getCode());
        data.setName(req.getName());
        data.setCaptain(req.getCaptain());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setAccountNo(req.getAccountNo());
        data.setBank(req.getBank());
        data.setSubbranch(req.getSubbranch());
        data.setWaterBill(req.getWaterBill());
        SYSUser user = sysUserBO.getUser(req.getCaptain());
        data.setCompanyCode(user.getCompanyCode());
        bizTeamBO.refreshBizTeam(data);
    }

    @Override
    public int dropBizTeam(String code) {
        if (!bizTeamBO.isBizTeamExist(code)) {
            throw new BizException("xn0000", "业务团队不存在");
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

        BizTeam bizTeam = bizTeamBO.getBizTeam(code);
        SYSUser condition = new SYSUser();
        condition.setTeamCode(bizTeam.getCode());
        List<SYSUser> userList = sysUserBO.queryUserList(condition);
        bizTeam.setUserList(userList);

        return bizTeam;
    }
}
