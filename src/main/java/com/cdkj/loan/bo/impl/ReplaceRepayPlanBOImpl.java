package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IReplaceRepayPlanBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IReplaceRepayPlanDAO;
import com.cdkj.loan.domain.ReplaceRepayPlan;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 代偿审核
 * @author: silver 
 * @since: 2018年6月15日 下午7:12:46 
 * @history:
 */
@Component
public class ReplaceRepayPlanBOImpl extends PaginableBOImpl<ReplaceRepayPlan>
        implements IReplaceRepayPlanBO {

    @Autowired
    private IReplaceRepayPlanDAO replaceRepayPlanDAO;

    @Override
    public boolean isReplaceRepayPlanExist(String code) {
        ReplaceRepayPlan condition = new ReplaceRepayPlan();
        condition.setCode(code);
        if (replaceRepayPlanDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveReplaceRepayPlan(ReplaceRepayPlan data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.REPLACE_REPAY_PLAN.getCode());
            data.setCode(code);
            replaceRepayPlanDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<ReplaceRepayPlan> queryReplaceRepayPlanList(
            ReplaceRepayPlan condition) {
        return replaceRepayPlanDAO.selectList(condition);
    }

    @Override
    public ReplaceRepayPlan getReplaceRepayPlan(String code) {
        ReplaceRepayPlan data = null;
        if (StringUtils.isNotBlank(code)) {
            ReplaceRepayPlan condition = new ReplaceRepayPlan();
            condition.setCode(code);
            data = replaceRepayPlanDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在！");
            }
        }
        return data;
    }

    @Override
    public void updateRiskManageApprove(String code, String curNodeCode,
            String riskNote, String remark, String operator) {
        ReplaceRepayPlan data = new ReplaceRepayPlan();
        data.setCode(code);
        data.setCurNodeCode(curNodeCode);
        data.setRiskNote(riskNote);
        data.setRemark(remark);
        data.setUpdater(operator);
        data.setUpdateDatetime(new Date());
        replaceRepayPlanDAO.updateRiskManageApprove(data);
    }

    @Override
    public void updateSubcompApprove(String code, String curNodeCode,
            String remark, String operator) {
        ReplaceRepayPlan data = new ReplaceRepayPlan();
        data.setCode(code);
        data.setCurNodeCode(curNodeCode);
        data.setRemark(remark);
        data.setUpdater(operator);
        data.setUpdateDatetime(new Date());
        replaceRepayPlanDAO.updateSubcompApprove(data);
    }

    @Override
    public void updateRiskChiefApprove(String code, String curNodeCode,
            String remark, String operator) {
        ReplaceRepayPlan data = new ReplaceRepayPlan();
        data.setCode(code);
        data.setCurNodeCode(curNodeCode);
        data.setRemark(remark);
        data.setUpdater(operator);
        data.setUpdateDatetime(new Date());
        replaceRepayPlanDAO.updateRiskChiefApprove(data);
    }

    @Override
    public void updateFianaceApprove(String code, String curNodeCode,
            String remark, String operator) {
        ReplaceRepayPlan data = new ReplaceRepayPlan();
        data.setCode(code);
        data.setCurNodeCode(curNodeCode);
        data.setRemark(remark);
        data.setUpdater(operator);
        data.setUpdateDatetime(new Date());
        replaceRepayPlanDAO.updateFianaceApprove(data);
    }

    @Override
    public void updateConfirmLoan(ReplaceRepayPlan data) {
        replaceRepayPlanDAO.updateConfirmLoan(data);
    }

    @Override
    public Paginable<ReplaceRepayPlan> getPaginableByRoleCode(int start,
            int limit, ReplaceRepayPlan condition) {
        prepare(condition);

        long totalCount = replaceRepayPlanDAO
            .selectTotalCountByRoleCode(condition);

        Paginable<ReplaceRepayPlan> page = new Page<ReplaceRepayPlan>(start,
            limit, totalCount);

        List<ReplaceRepayPlan> dataList = replaceRepayPlanDAO
            .selectReplaceRepayPlanByRoleCodeList(condition, page.getStart(),
                page.getPageSize());

        page.setList(dataList);
        return page;
    }
}
