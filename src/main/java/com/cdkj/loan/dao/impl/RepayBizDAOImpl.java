package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRepayBizDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.RepayBiz;

@Repository("repayBizDAOImpl")
public class RepayBizDAOImpl extends AMybatisTemplate implements IRepayBizDAO {

    @Override
    public int insert(RepayBiz data) {
        return super.insert(NAMESPACE.concat("insert_repayBiz"), data);
    }

    @Override
    public int delete(RepayBiz data) {
        return 0;
    }

    @Override
    public RepayBiz select(RepayBiz condition) {
        return super.select(NAMESPACE.concat("select_repayBiz"), condition,
            RepayBiz.class);
    }

    @Override
    public long selectTotalCount(RepayBiz condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_repayBiz_count"), condition);
    }

    @Override
    public List<RepayBiz> selectList(RepayBiz condition) {
        return super.selectList(NAMESPACE.concat("select_repayBiz"), condition,
            RepayBiz.class);
    }

    @Override
    public List<RepayBiz> selectList(RepayBiz condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_repayBiz"), start,
            count, condition, RepayBiz.class);
    }

    @Override
    public int updateBankcard(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repayBiz_bankcard"), data);
    }

    @Override
    public int updateRepayAll(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repayAll"), data);
    }

    @Override
    public int updateEnterBlackList(RepayBiz data) {
        return super.update(NAMESPACE.concat("enter_black_list_prd"), data);
    }

    @Override
    public int updateConfirmSettledProduct(RepayBiz data) {
        return super.update(NAMESPACE.concat("confirm_settle"), data);
    }

    @Override
    public int updateRepayBizRestAmount(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repayBiz_restAmount"),
            data);
    }

    @Override
    public int updateRepayAllAdvance(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repayAllAdvance"), data);
    }

    @Override
    public void approveByQkcsDepart(RepayBiz data) {
        super.update(NAMESPACE.concat("update_approveByQkcsDepart"), data);
    }

    @Override
    public void approveByBankCheck(RepayBiz data) {
        super.update(NAMESPACE.concat("update_approveByBankCheck"), data);
    }

    @Override
    public void approveByManager(RepayBiz data) {
        super.update(NAMESPACE.concat("update_approveByManager"), data);
    }

    @Override
    public void approveByFinance(RepayBiz data) {
        super.update(NAMESPACE.concat("update_approveByFinance"), data);
    }

    @Override
    public void releaseMortgage(RepayBiz data) {
        super.update(NAMESPACE.concat("update_releaseMortgage"), data);
    }

    @Override
    public void applyTrailer(RepayBiz data) {
        super.update(NAMESPACE.concat("update_applyTrailer"), data);
    }

    @Override
    public void financialMoney(RepayBiz data) {
        super.update(NAMESPACE.concat("update_financialMoney"), data);
    }

    @Override
    public void trailerEntry(RepayBiz data) {
        super.update(NAMESPACE.concat("update_trailerEntry"), data);

    }

    @Override
    public void judicialLitigationEntry(RepayBiz data) {
        super.update(NAMESPACE.concat("update_judicialLitigationEntry"), data);
    }

    @Override
    public void trailerManage(RepayBiz data) {
        super.update(NAMESPACE.concat("update_trailerManage"), data);
    }

    @Override
    public void qkcsbRedeemApply(RepayBiz data) {
        super.update(NAMESPACE.concat("update_qkcsbRedeemApply"), data);
    }

    @Override
    public void riskManagerCheck(RepayBiz data) {
        super.update(NAMESPACE.concat("update_riskManagerCheck"), data);
    }

    @Override
    public void financeApprove(RepayBiz data) {
        super.update(NAMESPACE.concat("update_financeApprove"), data);
    }

    @Override
    public long selectTotalCountByRoleCode(RepayBiz condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_repayBiz_count_byRoleCode"), condition);
    }

    @Override
    public List<RepayBiz> selectRepayBizByRoleCode(RepayBiz condition,
            int start, int pageSize) {
        return super.selectList(NAMESPACE.concat("select_repayBiz_byRoleCode"),
            condition, RepayBiz.class);
    }

}
