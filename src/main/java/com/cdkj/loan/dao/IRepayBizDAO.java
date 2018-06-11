package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepayBiz;

public interface IRepayBizDAO extends IBaseDAO<RepayBiz> {
    String NAMESPACE = IRepayBizDAO.class.getName().concat(".");

    public int updateBankcard(RepayBiz data);

    public int updateRepayAllAdvance(RepayBiz data);

    public int updateRepayAll(RepayBiz data);

    public int updateEnterBlackList(RepayBiz data);

    public int updateConfirmSettledProduct(RepayBiz data);

    public int updateRepayBizRestAmount(RepayBiz data);

    // 清欠催收部审核
    public void approveByQkcsDepart(RepayBiz data);

    // 驻行人员审核
    public void approveByBankCheck(RepayBiz data);

    // 总经理审核
    public void approveByManager(RepayBiz data);

    // 财务审核
    public void approveByFinance(RepayBiz data);

    // 业务团队解除抵押
    public void releaseMortgage(RepayBiz data);

    // 申请拖车
    public void applyTrailer(RepayBiz repayBiz);

    // 财务打款
    public void financialMoney(RepayBiz repayBiz);

    // 清款催收部拖车录入
    public void trailerEntry(RepayBiz repayBiz);

    // 司法诉讼结果录入
    public void judicialLitigationEntry(RepayBiz repayBiz);

    // 拖车管理
    public void trailerManage(RepayBiz repayBiz);

    // 清款催收部申请赎回
    public void qkcsbRedeemApply(RepayBiz repayBiz);

    // 风控主管审核
    public void riskManagerCheck(RepayBiz repayBiz);

    // 财务主管审核
    public void financeApprove(RepayBiz repayBiz);

    // 根据角色查条数
    public long selectTotalCountByRoleCode(RepayBiz condition);

    // 根据角色查集合
    public List<RepayBiz> selectRepayBizByRoleCode(RepayBiz condition,
            int start, int pageSize);

    // 缴纳代偿金额
    public void repayAmount(RepayBiz repayBiz);

}
