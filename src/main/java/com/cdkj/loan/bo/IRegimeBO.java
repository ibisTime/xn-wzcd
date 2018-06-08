package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Regime;

/**
 * 公司制度
 * @author: silver 
 * @since: 2018年6月4日 下午8:34:26 
 * @history:
 */
public interface IRegimeBO extends IPaginableBO<Regime> {

    public boolean isRegimeExist(String code);

    public String saveRegime(Regime data);

    public List<Regime> queryRegimeList(Regime condition);

    public Regime getRegime(String code);

    public void editRegime(Regime data);

    public void publishRegime(String code, String updater, String remark);

    public void removeRegime(String code, String updater, String remark);
}
