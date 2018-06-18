package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.dto.req.XN632060ReqCollectBankcard;

public interface ICollectBankcardBO extends IPaginableBO<CollectBankcard> {

    public String saveCollectBankcard(CollectBankcard data);

    public int removeCollectBankcard(String code);

    public int refreshCollectBankcard(CollectBankcard data);

    public List<CollectBankcard> queryCollectBankcardList(
            CollectBankcard condition);

    public List<CollectBankcard> queryCollectBankcardList(
            XN632060ReqCollectBankcard condition);

    public CollectBankcard getCollectBankcard(String code);

    public void saveCollectBankcardList(
            List<XN632060ReqCollectBankcard> CollectBankcardList, String type,
            String code);

    public void saveCollectBankcardList(
            List<XN632060ReqCollectBankcard> gsCollectBankcardList, String type,
            String belongBank, String code);

    public void removeCollectBankcardByList(
            List<XN632060ReqCollectBankcard> CollectBankcardList);

    public List<CollectBankcard> queryCollectBankcardByCompanyCodeAndType(
            CollectBankcard condition);

}
