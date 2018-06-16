package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BankSubbranch;
import com.cdkj.loan.dto.req.XN632050Req;
import com.cdkj.loan.dto.req.XN632052Req;

/**
 * 支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午10:21:15 
 * @history:
 */
public interface IBankSubbranchAO {
    String DEFAULT_ORDER_COLUMN = "id";

    public long addBankSubbranch(XN632050Req req);

    public int dropBankSubbranch(String code);

    public int editBankSubbranch(XN632052Req req);

    public BankSubbranch getBankSubbranch(String code);

    public Paginable<BankSubbranch> queryBankSubbranchPage(int start, int limit,
            BankSubbranch condition);

    public List<BankSubbranch> queryBankSubbranchList(BankSubbranch condition);
}
