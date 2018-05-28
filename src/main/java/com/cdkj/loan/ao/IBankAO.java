package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.dto.req.XN632030Req;
import com.cdkj.loan.dto.req.XN632032Req;

/**
 * 银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午4:43:42 
 * @history:
 */
public interface IBankAO {
    String DEFAULT_ORDER_COLUMN = "update_datetime";

    public String addBank(XN632030Req req);

    public void dropBank(String code);

    public int editBank(XN632032Req req);

    public Bank getBank(String code);

    public Paginable<Bank> queryBankPage(int start, int limit, Bank condition);

    public List<Bank> queryBankList(Bank condition);
}
