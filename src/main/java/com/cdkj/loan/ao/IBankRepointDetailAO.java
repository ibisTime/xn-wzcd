package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BankRepointDetail;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月10日 下午2:30:36 
 * @history:
 */
@Component
public interface IBankRepointDetailAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBankRepointDetail(BankRepointDetail data);

    public int dropBankRepointDetail(String code);

    public int editBankRepointDetail(BankRepointDetail data);

    public Paginable<BankRepointDetail> queryBankRepointDetailPage(int start,
            int limit, BankRepointDetail condition);

    public List<BankRepointDetail> queryBankRepointDetailList(
            BankRepointDetail condition);

    public BankRepointDetail getBankRepointDetail(String code);

    // 录入返佣金额
    public void entryRepointAmount(String code, String amount, String billPdf,
            String operator);

}
