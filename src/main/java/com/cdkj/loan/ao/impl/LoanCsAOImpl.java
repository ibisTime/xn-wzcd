package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ILoanCsAO;
import com.cdkj.loan.bo.ILoanCsBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.LoanCs;
import com.cdkj.loan.dto.req.XN632080Req;

/**
 * 贷款成数
 * @author: silver 
 * @since: 2018年6月14日 下午7:31:44 
 * @history:
 */
@Service
public class LoanCsAOImpl implements ILoanCsAO {

    @Autowired
    private ILoanCsBO loanCsBO;

    @Override
    public void editLoanCs(XN632080Req req) {
        LoanCs data = new LoanCs();
        data.setCode(req.getCode());
        data.setType(req.getType());
        data.setMinCs(StringValidater.toDouble(req.getMinCs()));
        data.setMaxCs(StringValidater.toDouble(req.getMaxCs()));
        data.setRemark(req.getRemark());
        loanCsBO.refreshLoanCs(data);
    }

    @Override
    public Paginable<LoanCs> queryLoanCsPage(int start, int limit,
            LoanCs condition) {
        return loanCsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<LoanCs> queryLoanCsList(LoanCs condition) {
        return loanCsBO.queryLoanCsList(condition);
    }

    @Override
    public LoanCs getLoanCs(String code) {
        return loanCsBO.getLoanCs(code);
    }
}
