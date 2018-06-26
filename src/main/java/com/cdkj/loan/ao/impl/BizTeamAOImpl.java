package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBizTeamAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630190Req;
import com.cdkj.loan.dto.req.XN630192Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
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

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addBizTeam(XN630190Req req) {
        doCheckCaptainOnlyOne(req.getCaptain());
        SYSUser captain = sysUserBO.getUser(req.getCaptain());
        if (StringUtils.isBlank(captain.getPostCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请先设置队长职位");
        }

        BizTeam data = new BizTeam();
        data.setName(req.getName());
        data.setCaptain(req.getCaptain());
        data.setCompanyCode(captain.getCompanyCode());
        data.setStatus(EBoolean.YES.getCode());
        data.setUpdater(req.getUpdater());

        data.setUpdateDatetime(new Date());
        data.setAccountNo(req.getAccountNo());
        data.setBank(req.getBank());
        data.setSubbranch(req.getSubbranch());
        data.setWaterBill(req.getWaterBill());
        return bizTeamBO.saveBizTeam(data);
    }

    private void doCheckCaptainOnlyOne(String captain) {
        SYSUser sysUser = sysUserBO.getUser(captain);
        if (StringUtils.isNotBlank(sysUser.getTeamCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该用户已入选其他团队");
        }
    }

    @Override
    public void editBizTeam(XN630192Req req) {
        BizTeam data = bizTeamBO.getBizTeam(req.getCode());
        if (!req.getCaptain().equals(data.getCaptain())) {
            doCheckCaptainOnlyOne(req.getCaptain());
        }
        SYSUser captain = sysUserBO.getUser(req.getCaptain());
        if (StringUtils.isBlank(captain.getPostCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请先设置队长职位");
        }

        data.setName(req.getName());
        data.setCaptain(req.getCaptain());
        data.setCompanyCode(captain.getCompanyCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        data.setAccountNo(req.getAccountNo());
        data.setBank(req.getBank());
        data.setSubbranch(req.getSubbranch());
        data.setWaterBill(req.getWaterBill());
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
        Paginable<BizTeam> paginable = bizTeamBO.getPaginable(start, limit,
            condition);
        List<BizTeam> list = paginable.getList();
        for (BizTeam bizTeam : list) {
            initBizTeam(bizTeam);
        }

        return paginable;
    }

    @Override
    public List<BizTeam> queryBizTeamList(BizTeam condition) {
        List<BizTeam> list = bizTeamBO.queryBizTeamList(condition);
        for (BizTeam bizTeam : list) {
            initBizTeam(bizTeam);
        }

        return list;
    }

    @Override
    public BizTeam getBizTeam(String code) {

        BizTeam bizTeam = bizTeamBO.getBizTeam(code);
        initBizTeam(bizTeam);
        SYSUser condition = new SYSUser();
        condition.setTeamCode(bizTeam.getCode());
        List<SYSUser> userList = sysUserBO.queryUserList(condition);
        for (SYSUser sysUser : userList) {
            Department department = departmentBO.getDepartment(sysUser
                .getCompanyCode());
            sysUser.setCompanyName(department.getName());
        }
        bizTeam.setUserList(userList);

        return bizTeam;
    }

    private void initBizTeam(BizTeam bizTeam) {

        String captain = bizTeam.getCaptain();
        SYSUser user = sysUserBO.getUser(captain);
        bizTeam.setCaptainName(user.getRealName());

        String companyCode = bizTeam.getCompanyCode();
        Department department = departmentBO.getDepartment(companyCode);
        bizTeam.setCompanyName(department.getName());

        String updater = bizTeam.getUpdater();
        SYSUser updateUser = sysUserBO.getUser(updater);
        bizTeam.setUpdaterName(updateUser.getRealName());

    }
}
