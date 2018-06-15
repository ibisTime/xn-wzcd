package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.LoanCs;
import com.cdkj.loan.dto.req.XN632080Req;

/**
 * 贷款成数
 * @author: silver 
 * @since: 2018年6月14日 下午7:31:08 
 * @history:
 */
@Component
public interface ILoanCsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void editLoanCs(XN632080Req req);

    public Paginable<LoanCs> queryLoanCsPage(int start, int limit,
            LoanCs condition);

    public List<LoanCs> queryLoanCsList(LoanCs condition);

    public LoanCs getLoanCs(String code);

}
