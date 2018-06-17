package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IAdvanceFundDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.AdvanceFund;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:56:29 
 * @history:
 */
@Repository("advanceFundDAOImpl")
public class AdvanceFundDAOImpl extends AMybatisTemplate implements
        IAdvanceFundDAO {

    @Override
    public int insert(AdvanceFund data) {
        return super.insert(NAMESPACE.concat("insert_advanceFund"), data);
    }

    @Override
    public int delete(AdvanceFund data) {
        return super.delete(NAMESPACE.concat("delete_advanceFund"), data);
    }

    @Override
    public AdvanceFund select(AdvanceFund condition) {
        return super.select(NAMESPACE.concat("select_advanceFund"), condition,
            AdvanceFund.class);
    }

    @Override
    public long selectTotalCount(AdvanceFund condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_advanceFund_count"), condition);
    }

    @Override
    public List<AdvanceFund> selectList(AdvanceFund condition) {
        return super.selectList(NAMESPACE.concat("select_advanceFund"),
            condition, AdvanceFund.class);
    }

    @Override
    public List<AdvanceFund> selectList(AdvanceFund condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_advanceFund"), start,
            count, condition, AdvanceFund.class);
    }

    @Override
    public int update(AdvanceFund data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void updateConfirmAdvanceFund(AdvanceFund data) {
        super.update(NAMESPACE.concat("update_confirm_advance_fund"), data);
    }

    @Override
    public void updateAreaAudit(AdvanceFund data) {
        super.update(NAMESPACE.concat("update_area_audit"), data);
    }

    @Override
    public void updateProvinceAudit(AdvanceFund data) {
        super.update(NAMESPACE.concat("update_province_audit"), data);

    }

    @Override
    public void updateParentMakeBill(AdvanceFund data) {
        super.update(NAMESPACE.concat("update_parent_make_bill"), data);

    }

    @Override
    public void updateBranchMakeBill(AdvanceFund data) {
        super.update(NAMESPACE.concat("update_branch_make_bill"), data);

    }

    @Override
    public void confirmPayCarDealer(AdvanceFund data) {
        super.update(NAMESPACE.concat("update_confirm_pay_car_dealer"), data);

    }

    @Override
    public void updateConfirmPayBranchCompany(AdvanceFund data) {
        super.update(NAMESPACE.concat("update_confirm_pay_branch_company"),
            data);

    }

    @Override
    public void updateApplyCancelAdvanceFund(AdvanceFund data) {
        super
            .update(NAMESPACE.concat("update_apply_cancel_advance_fund"), data);

    }

}
