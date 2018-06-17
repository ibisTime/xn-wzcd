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

    // 总公司制单
    public void parentMakeBill(AdvanceFund data);

    // 分公司制单
    public void branchMakeBill(AdvanceFund data);

    // 确认打款给车行
    public void confirmPayCarDealer(AdvanceFund data);

    // 确认打款给分公司
    public void confirmPayBranchCompany(AdvanceFund data);

    // 申请撤销垫资
    public void applyCancelAdvanceFund(AdvanceFund data);

    // 分页查询垫资单根据角色编号
    public Object queryAdvanceFundPageByRoleCode(int start, int limit,
            AdvanceFund condition);

}
