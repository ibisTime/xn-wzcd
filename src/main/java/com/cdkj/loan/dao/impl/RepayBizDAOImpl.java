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
        return super.update(NAMESPACE.concat("update_repayComplete"), data);
    }

    @Override
    public int updateEnterBlackList(RepayBiz data) {
        return super.update(NAMESPACE.concat("enter_black_list"), data);
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

    // update_repayAllAdvance
    @Override
    public int updateRepayAllAdvance(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repayEarlySuccess"), data);
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

}
