package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.GpsApply;

/**
 * GPS申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:12:13 
 * @history:
 */
public interface IGpsApplyBO extends IPaginableBO<GpsApply> {

    public boolean isGpsApplyExist(String code);

    public String saveGpsApply(GpsApply data);

    public void approveGpsApply(GpsApply data);

    public List<GpsApply> queryGpsApplyList(GpsApply condition);

    public GpsApply getGpsApply(String code);

}
