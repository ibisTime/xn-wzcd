package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ILoanCsDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.LoanCs;

/**
 * 贷款成数
 * @author: silver 
 * @since: 2018年6月14日 下午7:27:32 
 * @history:
 */
@Repository("loanCsDAOImpl")
public class LoanCsDAOImpl extends AMybatisTemplate implements ILoanCsDAO {

    @Override
    public int insert(LoanCs data) {
        return super.insert(NAMESPACE.concat("insert_loanCs"), data);
    }

    @Override
    public int delete(LoanCs data) {
        return super.delete(NAMESPACE.concat("delete_loanCs"), data);
    }

    @Override
    public LoanCs select(LoanCs condition) {
        return super.select(NAMESPACE.concat("select_loanCs"), condition,
            LoanCs.class);
    }

    @Override
    public long selectTotalCount(LoanCs condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_loanCs_count"),
            condition);
    }

    @Override
    public List<LoanCs> selectList(LoanCs condition) {
        return super.selectList(NAMESPACE.concat("select_loanCs"), condition,
            LoanCs.class);
    }

    @Override
    public List<LoanCs> selectList(LoanCs condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_loanCs"), start, count,
            condition, LoanCs.class);
    }

    @Override
    public void update(LoanCs data) {
        super.update(NAMESPACE.concat("update_loanCs"), data);
    }
}
