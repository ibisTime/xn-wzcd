package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SuppleSignApply;

/**
 * 补签
 * @author: silver 
 * @since: 2018年6月5日 下午10:55:43 
 * @history:
 */
public interface ISuppleSignApplyBO extends IPaginableBO<SuppleSignApply> {

    public boolean isSuppleSignApplyExist(String code);

    public String saveSuppleSignApply(SuppleSignApply data);

    public void refreshSuppleSignApply(SuppleSignApply data);

    public List<SuppleSignApply> querySuppleSignApplyList(
            SuppleSignApply condition);

    public SuppleSignApply getSuppleSignApply(String code);

}
