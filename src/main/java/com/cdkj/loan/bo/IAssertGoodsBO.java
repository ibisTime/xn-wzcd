package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.AssertGoods;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:54:19 
 * @history:
 */
public interface IAssertGoodsBO extends IPaginableBO<AssertGoods> {

    public boolean isAssertGoodsExist(String code);

    public String saveAssertGoods(AssertGoods data);

    public int removeAssertGoods(String code);

    public int refreshAssertGoods(AssertGoods data);

    public List<AssertGoods> queryAssertGoodsList(AssertGoods condition);

    public AssertGoods getAssertGoods(String code);

}
