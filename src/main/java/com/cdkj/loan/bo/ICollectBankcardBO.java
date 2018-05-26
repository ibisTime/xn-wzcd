package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CollectBankcard;




public interface ICollectBankcardBO extends IPaginableBO<CollectBankcard> {


	public String saveCollectBankcard(CollectBankcard data);


	public int removeCollectBankcard(String code);


	public int refreshCollectBankcard(CollectBankcard data);


	public List<CollectBankcard> queryCollectBankcardList(CollectBankcard condition);


	public CollectBankcard getCollectBankcard(String code);


}