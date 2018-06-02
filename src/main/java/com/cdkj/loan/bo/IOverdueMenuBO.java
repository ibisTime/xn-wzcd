package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.OverdueMenu;




public interface IOverdueMenuBO extends IPaginableBO<OverdueMenu> {


	public String saveOverdueMenu(OverdueMenu data);


	public int removeOverdueMenu(String code);


	public int refreshOverdueMenu(OverdueMenu data);


	public List<OverdueMenu> queryOverdueMenuList(OverdueMenu condition);


	public OverdueMenu getOverdueMenu(String code);


}