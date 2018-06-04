package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CompProduct;

/**
 * 品名管理
 * @author: silver 
 * @since: 2018年6月4日 下午10:54:04 
 * @history:
 */

public interface ICompProductBO extends IPaginableBO<CompProduct> {

    public boolean isCompProductExist(String code);

    public String saveCompProduct(CompProduct data);

    public void refreshCompProduct(CompProduct data);

    public List<CompProduct> queryCompProductList(CompProduct condition);

    public CompProduct getCompProduct(String code);

}
