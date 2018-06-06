package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.WelfareApply;

/**
 * 福利发放
 * @author: silver 
 * @since: 2018年6月6日 下午6:57:55 
 * @history:
 */
public interface IWelfareApplyBO extends IPaginableBO<WelfareApply> {

    public boolean isWelfareApplyExist(String code);

    public String saveWelfareApply(WelfareApply data);

    public void refreshWelfareApply(WelfareApply data);

    public List<WelfareApply> queryWelfareApplyList(WelfareApply condition);

    public WelfareApply getWelfareApply(String code);

}
