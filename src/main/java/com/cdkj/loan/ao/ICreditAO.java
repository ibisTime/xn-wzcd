package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月24日 下午11:05:31 
 * @history:
 */
public interface ICreditAO {

    // 新增征信 和 征信人员列表
    public String addCredit(Credit data, List<CreditUser> dataList);

}
