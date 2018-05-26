package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CreditUser;

public interface ICreditUserBO extends IPaginableBO<CreditUser> {

    // 新增征信人员
    public void addCreditUser(CreditUser creditUser);

    // 录入银行征信结果
    public void inputBankCreditResult(CreditUser creditUser);

    // 修改征信人员信息
    public void updateCreditUser(CreditUser creditUser);

    // 批量查询征信人员 根据征信单编号
    public List<CreditUser> queryCreditUserListByCreditCode(String creditCode);

    // 查看征信报告详情
    public CreditUser queryCreditReportDetail(String code);

}
