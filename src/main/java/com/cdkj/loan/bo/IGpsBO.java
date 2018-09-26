package com.cdkj.loan.bo;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Gps;

public interface IGpsBO extends IPaginableBO<Gps> {

    public void checkGpsDevNo(String gpsDevNo);

    // 新增gps
    public void saveGps(Gps data);

    // 公司申领审核通过后gps状态变更
    public void approveCompanyGps(String code, String companyCode,
            Date applyDatetime, String companyApplyCode);

    // 公司物流收货或gps状态更改为已申领
    public void receiveCompanyGps(String code);

    // 个人申请gps状态变更为申请处理中
    public void applyUserGps(String code, String applyCode, String applyUser);

    // 个人审核通过后状态变更，不通过后设置为待申领状态
    public void approveUserGps(String code, String approveResult);

    // 更新gps使用状态
    public void refreshUseGps(String code, String budgetOrder);

    public void refreshUseGpsToDamage(Gps gps);

    // 更新gps使用为未使用
    public void refreshUnUse(String code);

    public List<Gps> queryGpsList(Gps condition);

    public List<Gps> queryGpsListByUserApplyCode(String userApplyCode);

    public List<Gps> queryGpsListByCompanyApplyCode(String companyApplyCode);

    public Gps getGps(String code);

    public Gps getGpsByDevNo(String gpsDevNo);

    public void refresh(Gps data);

}
