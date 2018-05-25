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
    public void addCredit(Credit data);

}
