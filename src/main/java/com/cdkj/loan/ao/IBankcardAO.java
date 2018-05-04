package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.dto.req.XN630220Req;

//CHECK ��鲢��ע�� 
@Component
public interface IBankcardAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBankcard(XN630220Req req);

    public int dropBankcard(String code);

    public int editBankcard(Bankcard data);

    public Paginable<Bankcard> queryBankcardPage(int start, int limit,
            Bankcard condition);

    public List<Bankcard> queryBankcardList(Bankcard condition);

    public Bankcard getBankcard(String code);

    // 绑定银行卡
    public String bind(String userId, String bankcardNumber, String bankCode,
            String bankName, String subbranch);

}
