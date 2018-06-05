package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Contract;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月5日 下午8:42:07 
 * @history:
 */

@Component
public interface IContractAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addContract(Contract data);

    public int dropContract(String code);

    public int editContract(Contract data);

    public Paginable<Contract> queryContractPage(int start, int limit,
            Contract condition);

    public List<Contract> queryContractList(Contract condition);

    public Contract getContract(String code);

}
