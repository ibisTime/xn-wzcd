package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IReplaceRepayPlanDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.ReplaceRepayPlan;

/**
 * 代偿审核
 * @author: silver 
 * @since: 2018年6月15日 下午5:53:04 
 * @history:
 */
@Repository("replaceRepayPlanDAOImpl")
public class ReplaceRepayPlanDAOImpl extends AMybatisTemplate
        implements IReplaceRepayPlanDAO {

    @Override
    public int insert(ReplaceRepayPlan data) {
        return super.insert(NAMESPACE.concat("insert_replaceRepayPlan"), data);
    }

    @Override
    public int delete(ReplaceRepayPlan data) {
        return super.delete(NAMESPACE.concat("delete_replaceRepayPlan"), data);
    }

    @Override
    public ReplaceRepayPlan select(ReplaceRepayPlan condition) {
        return super.select(NAMESPACE.concat("select_replaceRepayPlan"),
            condition, ReplaceRepayPlan.class);
    }

    @Override
    public long selectTotalCount(ReplaceRepayPlan condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_replaceRepayPlan_count"), condition);
    }

    @Override
    public List<ReplaceRepayPlan> selectList(ReplaceRepayPlan condition) {
        return super.selectList(NAMESPACE.concat("select_replaceRepayPlan"),
            condition, ReplaceRepayPlan.class);
    }

    @Override
    public List<ReplaceRepayPlan> selectList(ReplaceRepayPlan condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_replaceRepayPlan"),
            start, count, condition, ReplaceRepayPlan.class);
    }

    @Override
    public void updateRiskManageApprove(ReplaceRepayPlan data) {
        super.update(NAMESPACE.concat("update_riskManageApprove"), data);
    }

    @Override
    public void updateSubcompApprove(ReplaceRepayPlan data) {
        super.update(NAMESPACE.concat("update_subcompApprove"), data);
    }

    @Override
    public void updateRiskChiefApprove(ReplaceRepayPlan data) {
        super.update(NAMESPACE.concat("update_riskChiefApprove"), data);
    }

    @Override
    public void updateFianaceApprove(ReplaceRepayPlan data) {
        super.update(NAMESPACE.concat("update_financeApprove"), data);
    }

    @Override
    public void updateConfirmLoan(ReplaceRepayPlan data) {
        super.update(NAMESPACE.concat("update_confirmLoan"), data);
    }

}
