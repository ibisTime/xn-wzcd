package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RepointDetail;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月16日 下午2:45:08 
 * @history:
 */
public interface IRepointDetailBO extends IPaginableBO<RepointDetail> {

    public boolean isRepointDetailExist(String code);

    public String saveRepointDetail(RepointDetail data);

    public int removeRepointDetail(String code);

    public int refreshRepointDetail(RepointDetail data);

    public List<RepointDetail> queryRepointDetailList(RepointDetail condition);

    public RepointDetail getRepointDetail(String code);

}
