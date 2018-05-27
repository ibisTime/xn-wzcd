package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CollectBankcard;

public interface ICollectBankcardBO extends IPaginableBO<CollectBankcard> {

    public String saveCollectBankcard(CollectBankcard data);

    public int removeCollectBankcard(String code);

    public int refreshCollectBankcard(CollectBankcard data);

    public List<CollectBankcard> queryCollectBankcardList(
            CollectBankcard condition);

    public CollectBankcard getCollectBankcard(String code);

    public void saveCollectBankcardList(
            List<CollectBankcard> CollectBankcardList, String type,
            String code);

    public void saveCollectBankcardList(
            List<CollectBankcard> gsCollectBankcardList, String type,
            String bankCode, String code);

    public void removeCollectBankcardByList(
            List<CollectBankcard> CollectBankcardList);

}
