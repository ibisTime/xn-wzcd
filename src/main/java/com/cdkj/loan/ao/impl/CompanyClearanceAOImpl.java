package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICompanyClearanceAO;
import com.cdkj.loan.bo.ICompanyClearanceBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CompanyClearance;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632350Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.exception.BizException;

@Service
public class CompanyClearanceAOImpl implements ICompanyClearanceAO {

    @Autowired
    private ICompanyClearanceBO companyClearanceBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Override
    @Transactional
    public void addCompanyClearance(XN632350Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepaybizCode());
        if (ERepayBizNode.CLEARANCE_CASHIER.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是公司结清后待打款节点，不能操作！");
        }
        CompanyClearance data = new CompanyClearance();
        data.setRepaybizCode(req.getRepaybizCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        companyClearanceBO.saveCompanyClearance(data);
    }

    @Override
    public Paginable<CompanyClearance> queryCompanyClearancePage(int start,
            int limit, CompanyClearance condition) {
        Paginable<CompanyClearance> paginable = companyClearanceBO
            .getPaginable(start, limit, condition);
        for (CompanyClearance companyClearance : paginable.getList()) {
            initCompanyClearance(companyClearance);
        }
        return paginable;
    }

    private void initCompanyClearance(CompanyClearance companyClearance) {
        if (StringUtils.isNotBlank(companyClearance.getUpdater())) {
            SYSUser user = sysUserBO.getUser(companyClearance.getUpdater());
            companyClearance.setUpdaterName(user.getRealName());
        }
    }

    @Override
    public List<CompanyClearance> queryCompanyClearanceList(
            CompanyClearance condition) {
        return companyClearanceBO.queryCompanyClearanceList(condition);
    }

    @Override
    public CompanyClearance getCompanyClearance(int id) {
        CompanyClearance companyClearance = companyClearanceBO
            .getCompanyClearance(id);
        initCompanyClearance(companyClearance);
        return companyClearance;
    }
}
