package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Repoint;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月9日 下午2:20:11 
 * @history:
 */
public interface IRepointBO extends IPaginableBO<Repoint> {

    public String saveRepoint(Repoint data);

    public int refreshRepoint(Repoint data);

    public List<Repoint> queryRepointList(Repoint condition);

    public Repoint getRepoint(String code);

}
