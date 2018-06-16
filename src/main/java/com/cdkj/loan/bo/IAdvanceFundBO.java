package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.AdvanceFund;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:54:10 
 * @history:
 */
public interface IAdvanceFundBO extends IPaginableBO<AdvanceFund> {

    public boolean isAdvanceFundExist(String code);

    public String saveAdvanceFund(AdvanceFund data);

    public int removeAdvanceFund(String code);

    public int refreshAdvanceFund(AdvanceFund data);

    public List<AdvanceFund> queryAdvanceFundList(AdvanceFund condition);

    public AdvanceFund getAdvanceFund(String code);

    // 确认用款单 更新节点
    public void refreshConfirmAdvanceFund(AdvanceFund data);

    // 区域总经理审核 更新节点
    public void refreshAreaAudit(AdvanceFund data);

    // 省分公司总经理审核 更新节点
    public void refreshProvinceAudit(AdvanceFund data);

}
