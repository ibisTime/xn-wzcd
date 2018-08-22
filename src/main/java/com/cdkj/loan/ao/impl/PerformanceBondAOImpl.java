package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IPerformanceBondAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.IPerformanceBondBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.PerformanceBond;
import com.cdkj.loan.domain.SYSUser;

@Service
public class PerformanceBondAOImpl implements IPerformanceBondAO {

    @Autowired
    private IPerformanceBondBO performanceBondBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ICarDealerBO carDealerBO;

    @Override
    public void addPerformanceBond(PerformanceBond data) {
        performanceBondBO.savePerformanceBond(data);
    }

    @Override
    @Transactional
    public void editPerformanceBond(String budgetCode) {
        PerformanceBond performanceBond = performanceBondBO
            .getPerformanceBondByBudget(budgetCode);
        performanceBond.setPrintDatetime(new Date());
        performanceBondBO.refreshPerformanceBond(performanceBond);
    }

    @Override
    public Paginable<PerformanceBond> queryPerformanceBondPage(int start,
            int limit, PerformanceBond condition) {
        Paginable<PerformanceBond> paginable = performanceBondBO
            .getPaginable(start, limit, condition);
        for (PerformanceBond performanceBond : paginable.getList()) {
            initPerformanceBond(performanceBond);
        }
        return paginable;
    }

    @Override
    public List<PerformanceBond> queryPerformanceBondList(
            PerformanceBond condition) {
        return performanceBondBO.queryPerformanceBondList(condition);
    }

    @Override
    public PerformanceBond getPerformanceBond(int id) {
        PerformanceBond performanceBond = performanceBondBO
            .getPerformanceBond(id);
        initPerformanceBond(performanceBond);
        return performanceBond;
    }

    private void initPerformanceBond(PerformanceBond performanceBond) {
        if (StringUtils.isNotBlank(performanceBond.getLoanBankCode())) {
            Bank bank = bankBO
                .getBankBySubbranch(performanceBond.getLoanBankCode());
            performanceBond.setLoanBankName(bank.getBankName());
        }
        if (StringUtils.isNotBlank(performanceBond.getSaleUser())) {
            SYSUser user = sysUserBO.getUser(performanceBond.getSaleUser());
            performanceBond.setSaleUserName(user.getRealName());
        }
        if (StringUtils.isNotBlank(performanceBond.getCarDealerCode())) {
            CarDealer carDealer = carDealerBO
                .getCarDealer(performanceBond.getCarDealerCode());
            performanceBond.setCarDealerName(carDealer.getFullName());
        }
    }
}
