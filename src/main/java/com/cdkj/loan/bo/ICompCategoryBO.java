package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CompCategory;

/**
 * 库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午9:49:30 
 * @history:
 */
public interface ICompCategoryBO extends IPaginableBO<CompCategory> {

    public boolean isCompCategoryExist(String code);

    public String saveCompCategory(CompCategory data);

    public void refreshCompCategory(CompCategory data);

    public List<CompCategory> queryCompCategoryList(CompCategory condition);

    public CompCategory getCompCategory(String code);

}
