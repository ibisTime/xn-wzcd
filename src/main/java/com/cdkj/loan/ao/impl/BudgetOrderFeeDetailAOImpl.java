package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBudgetOrderFeeDetailAO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.IBudgetOrderFeeDetailBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;
import com.cdkj.loan.dto.req.XN632160Req;
import com.cdkj.loan.enums.EBoolean;

/**
 * 手续费明细
 * @author: jiafr 
 * @since: 2018年5月30日 下午9:07:49 
 * @history:
 */
@Service
public class BudgetOrderFeeDetailAOImpl implements IBudgetOrderFeeDetailAO {

    @Autowired
    private IBudgetOrderFeeDetailBO budgetOrderFeeDetailBO;

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Override
    @Transactional
    public String addBudgetOrderFeeDetail(XN632160Req req) {
        BudgetOrderFee budgetOrderFee = budgetOrderFeeBO.getBudgetOrderFee(req
            .getFeeCode());
        BudgetOrderFeeDetail data = new BudgetOrderFeeDetail();
        data.setRemitType(req.getRemitType());
        data.setRemitProject(req.getRemitProject());
        data.setAmount(StringValidater.toLong(req.getAmount()));
        data.setPlatBankcard(req.getPlatBankcard());
        data.setRemitUser(req.getRemitUser());
        data.setReachDatetime(DateUtil.strToDate(req.getReachDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setRemark(req.getRemark());
        data.setFeeCode(req.getFeeCode());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setFeeCode(req.getFeeCode());
        data.setIsSettled(req.getIsSettled());

        budgetOrderFee.setRealAmount(budgetOrderFee.getRealAmount()
                + data.getAmount());
        if (budgetOrderFee.getRealAmount().longValue() >= budgetOrderFee
            .getShouldAmount().longValue()) {
            budgetOrderFee.setIsSettled(EBoolean.YES.getCode());
        } else {
            budgetOrderFee.setIsSettled(EBoolean.NO.getCode());
        }
        budgetOrderFeeBO.refreshBudgetOrderFee(budgetOrderFee);
        return budgetOrderFeeDetailBO.saveBudgetOrderFeeDetail(data);
    }

    @Override
    public Paginable<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailPage(
            int start, int limit, BudgetOrderFeeDetail condition) {
        return budgetOrderFeeDetailBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailList(
            BudgetOrderFeeDetail condition) {
        return budgetOrderFeeDetailBO.queryBudgetOrderFeeDetailList(condition);
    }

    @Override
    public BudgetOrderFeeDetail getBudgetOrderFeeDetail(String code) {
        return budgetOrderFeeDetailBO.getBudgetOrderFeeDetail(code);
    }
}
