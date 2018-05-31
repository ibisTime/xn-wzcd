package com.cdkj.loan.bo;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.enums.EGpsApplyStatus;

/**
 * GPS申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:12:13 
 * @history:
 */
public interface IGpsApplyBO extends IPaginableBO<GpsApply> {

    public boolean isGpsApplyExist(String code);

    public String saveGpsApply(GpsApply data);

    public void approveGpsApply(String code, EGpsApplyStatus eGpsApplyStatus,
            String remark);

    public List<GpsApply> queryGpsApplyList(GpsApply condition);

    public GpsApply getGpsApply(String code);

    public void sendGps(String code, Date sendDatetime);

    public void receiveGps(String code);

}
