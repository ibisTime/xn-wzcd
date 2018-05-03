package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ILoanOrderDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.LoanOrder;

@Repository("loanOrderDAOImpl")
public class LoanOrderDAOImpl extends AMybatisTemplate
        implements ILoanOrderDAO {

    @Override
    public int insert(LoanOrder data) {
        return super.insert(NAMESPACE.concat("insert_loanOrder"), data);
    }

    @Override
    public int delete(LoanOrder data) {
        return super.delete(NAMESPACE.concat("delete_loanOrder"), data);
    }

    @Override
    public LoanOrder select(LoanOrder condition) {
        return super.select(NAMESPACE.concat("select_loanOrder"), condition,
            LoanOrder.class);
    }

    @Override
    public long selectTotalCount(LoanOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_loanOrder_count"), condition);
    }

    @Override
    public List<LoanOrder> selectList(LoanOrder condition) {
        return super.selectList(NAMESPACE.concat("select_loanOrder"), condition,
            LoanOrder.class);
    }

    @Override
    public List<LoanOrder> selectList(LoanOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_loanOrder"), start,
            count, condition, LoanOrder.class);
    }

    @Override
    public int update(LoanOrder data) {
        return super.update(NAMESPACE.concat("update_loanOrder"), data);
    }

    @Override
    public int updateApproveSuccess(LoanOrder data) {
        return super.update(NAMESPACE.concat("update_approveSuccess"), data);
    }

    @Override
    public int updateApproveFailed(LoanOrder data) {
        return super.update(NAMESPACE.concat("update_approveFailed"), data);
    }

}
