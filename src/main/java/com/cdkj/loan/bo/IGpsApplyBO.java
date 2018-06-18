package com.cdkj.loan.bo;

import java.util.Date;
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

    // 申请gps
    public String saveGpsApply(GpsApply data);

    // 审核gps
    public void approveCompanyGpsApply(GpsApply gpsApply, String approveResult,
            String approveUser, String approveNote);

    // 审核gps
    public void approveUserGpsApply(GpsApply gpsApply, String approveResult,
            String approveUser, String approveNote);

    public List<GpsApply> queryGpsApplyList(GpsApply condition);

    public GpsApply getGpsApply(String code);

    public void sendGps(String code, Date sendDatetime);

    public void receiveGps(String code);

}
