package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarBreak;

/**
 * 违章处理
 * @author: silver 
 * @since: 2018年6月6日 下午4:36:53 
 * @history:
 */
public interface ICarBreakBO extends IPaginableBO<CarBreak> {

    public boolean isCarBreakExist(String code);

    public String saveCarBreak(CarBreak data);

    public void approveCarBreak(CarBreak data);

    public List<CarBreak> queryCarBreakList(CarBreak condition);

    public CarBreak getCarBreak(String code);

}
