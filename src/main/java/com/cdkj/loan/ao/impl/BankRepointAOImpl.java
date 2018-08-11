package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankRepointAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankRepointBO;
import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BankRepoint;
import com.cdkj.loan.domain.BankSubbranch;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月11日 下午1:52:50 
 * @history:
 */
@Service
public class BankRepointAOImpl implements IBankRepointAO {

    @Autowired
    private IBankRepointBO bankRepointBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private ICarDealerBO carDealerBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IBankSubbranchBO bankSubbranchBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IBankBO bankBO;

    @Override
    public String addBankRepoint(BankRepoint data) {
        return bankRepointBO.saveBankRepoint(data);
    }

    @Override
    public int editBankRepoint(BankRepoint data) {
        if (!bankRepointBO.isBankRepointExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return bankRepointBO.refreshBankRepoint(data);
    }

    @Override
    public int dropBankRepoint(String code) {
        if (!bankRepointBO.isBankRepointExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return bankRepointBO.removeBankRepoint(code);
    }

    @Override
    public Paginable<BankRepoint> queryBankRepointPage(int start, int limit,
            BankRepoint condition) {
        Paginable<BankRepoint> paginable = bankRepointBO.getPaginable(start,
            limit, condition);
        List<BankRepoint> list = paginable.getList();
        for (BankRepoint data : list) {
            init(data);
        }
        return paginable;
    }

    private void init(BankRepoint data) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(data
            .getBizCode());
        data.setBankFkDatetime(budgetOrder.getBankFkDatetime());
        CarDealer carDealer = carDealerBO.getCarDealer(data.getCarDealerCode());
        data.setCarDealerName(carDealer.getFullName());
        User user = userBO.getUser(budgetOrder.getSaleUserId());
        data.setSaleUserName(user.getRealName());
        data.setShopWay(budgetOrder.getShopWay());
        data.setLoanAmount(budgetOrder.getLoanAmount());
        data.setFee(budgetOrder.getFee());
        BankSubbranch bankSubbranch = bankSubbranchBO
            .getBankSubbranch(budgetOrder.getLoanBankCode());
        data.setLoanBankName(bankSubbranch.getFullName());
        data.setRateType(budgetOrder.getRateType());
        data.setBankRate(budgetOrder.getBankRate());
        data.setLoanPeriods(budgetOrder.getLoanPeriods());
        Department company = departmentBO.getDepartment(budgetOrder
            .getCompanyCode());
        data.setCompanyName(company.getName());
        Bank bank = bankBO.getBankBySubbranch(budgetOrder.getLoanBankCode());
        Double bankBenchmarkRate = 0d;
        switch (budgetOrder.getLoanPeriods()) {
            case 12:
                bankBenchmarkRate = bank.getRate12();
                break;
            case 24:
                bankBenchmarkRate = bank.getRate24();
                break;
            case 36:
                bankBenchmarkRate = bank.getRate36();
                break;
        }
        data.setBankBenchmarkRate(bankBenchmarkRate);
    }

    @Override
    public List<BankRepoint> queryBankRepointList(BankRepoint condition) {
        return bankRepointBO.queryBankRepointList(condition);
    }

    @Override
    public BankRepoint getBankRepoint(String code) {
        return bankRepointBO.getBankRepoint(code);
    }

    @Override
    public void entrySettleRate(List<String> codeList, String settleRate,
            String operator) {
        for (String code : codeList) {
            BankRepoint data = bankRepointBO.getBankRepoint(code);
            data.setSettleRate(StringValidater.toDouble(settleRate));
            data.setUpdater(operator);
            data.setUpdateDatetime(new Date());
            bankRepointBO.refreshBankRepoint(data);
            // 日志待定 流程暂不确定
        }
    }

    @Override
    public void sendBackBankRepoint(String code, String sendBackAmount,
            String billPdf, String operator) {
        BankRepoint data = bankRepointBO.getBankRepoint(code);
        data.setSendBackAmount(StringValidater.toLong(sendBackAmount));
        data.setBillPdf(billPdf);
        data.setUpdater(operator);
        data.setUpdateDatetime(new Date());
        bankRepointBO.refreshBankRepoint(data);
        // 日志待定
    }
}
