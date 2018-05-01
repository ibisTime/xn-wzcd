package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepayPlanDAO;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.exception.BizException;

@Component
public class RepayPlanBOImpl extends PaginableBOImpl<RepayPlan>
        implements IRepayPlanBO {

    @Autowired
    private IRepayPlanDAO repayPlanDAO;

    @Override
    public boolean isRepayPlanExist(String code) {
        RepayPlan condition = new RepayPlan();
        condition.setCode(code);
        if (repayPlanDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRepayPlan(RepayPlan data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate("RP");
            data.setCode(code);
            repayPlanDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRepayPlan(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            RepayPlan data = new RepayPlan();
            data.setCode(code);
            count = repayPlanDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshRepayPlan(RepayPlan data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = repayPlanDAO.update(data);
        }
        return count;
    }

    @Override
    public List<RepayPlan> queryRepayPlanList(RepayPlan condition) {
        return repayPlanDAO.selectList(condition);
    }

    @Override
    public RepayPlan getRepayPlan(String code) {
        RepayPlan data = null;
        if (StringUtils.isNotBlank(code)) {
            RepayPlan condition = new RepayPlan();
            condition.setCode(code);
            data = repayPlanDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }
}
