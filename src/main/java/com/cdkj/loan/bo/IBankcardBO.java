package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.dto.req.XN630510Req;

public interface IBankcardBO extends IPaginableBO<Bankcard> {

    public String saveBankcard(Bankcard data);

    public String saveBankcardBiz(XN630510Req req);

    public int removeBankcard(String code);

    public int refreshBankcard(Bankcard data);

    public List<Bankcard> queryBankcardList(Bankcard condition);

    public Bankcard getBankcard(String code);

    public Bankcard getBankcardInfo(String code);

    public Bankcard getBankcardByBankcardNumber(String bankcardNumber);

    public List<Bankcard> queryBankcardList(String userId);

    public String bind(String userId, String realName, String bankcardNumber,
            String bankCode, String bankName);

    public void refreshBankcardNumber(Bankcard bankcard);

}
