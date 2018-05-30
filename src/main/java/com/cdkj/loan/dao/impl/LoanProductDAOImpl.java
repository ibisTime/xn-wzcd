package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ILoanProductDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.LoanProduct;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:23:56 
 * @history:
 */
@Repository("loanProductDAOImpl")
public class LoanProductDAOImpl extends AMybatisTemplate
        implements ILoanProductDAO {

    @Override
    public int insert(LoanProduct data) {
        return super.insert(NAMESPACE.concat("insert_loanProduct"), data);
    }

    @Override
    public int delete(LoanProduct data) {
        return super.delete(NAMESPACE.concat("delete_loanProduct"), data);
    }

    @Override
    public LoanProduct select(LoanProduct condition) {
        return super.select(NAMESPACE.concat("select_loanProduct"), condition,
            LoanProduct.class);
    }

    @Override
    public long selectTotalCount(LoanProduct condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_loanProduct_count"), condition);
    }

    @Override
    public List<LoanProduct> selectList(LoanProduct condition) {
        return super.selectList(NAMESPACE.concat("select_loanProduct"),
            condition, LoanProduct.class);
    }

    @Override
    public List<LoanProduct> selectList(LoanProduct condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_loanProduct"), start,
            count, condition, LoanProduct.class);
    }

    @Override
    public void updateLoanProduct(LoanProduct data) {
        super.update(NAMESPACE.concat("update_loanProduct"), data);
    }

    @Override
    public void updateLoanProductPublish(LoanProduct data) {
        super.update(NAMESPACE.concat("update_loanProduct_publish"), data);
    }
}
