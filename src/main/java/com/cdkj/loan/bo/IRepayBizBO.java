package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RepayBiz;



public interface IRepayBizBO extends IPaginableBO<RepayBiz> {


	public boolean isRepayBizExist(String code);


	public String saveRepayBiz(RepayBiz data);


	public int removeRepayBiz(String code);


	public int refreshRepayBiz(RepayBiz data);


	public List<RepayBiz> queryRepayBizList(RepayBiz condition);


	public RepayBiz getRepayBiz(String code);


}