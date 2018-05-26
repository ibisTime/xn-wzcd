package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Credit;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:40:13 
 * @history:
 */
public interface ICreditBO extends IPaginableBO<Credit> {

    // 新增征信单
    public String addCredit(Credit data);

    // 修改征信单
    public void updateCredit(Credit credit);

    // 查询征信单详情
    public Credit getCredit(String code);

    // 查询更多征信单详情，包含征信人员信息
    public Credit getMoreCredit(String code);

    // 更新征信单节点
    public void refreshCreditNode(Credit credit);

}
