package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.dto.req.XN632710Req;
import com.cdkj.loan.dto.req.XN632711Req;
import com.cdkj.loan.dto.req.XN632712Req;
import com.cdkj.loan.dto.req.XN632713Req;

/**
 * GPS申领
 * @author: xieyj 
 * @since: 2018年6月18日 下午1:54:22 
 * @history:
 */
public interface IGpsApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String applyCompanyGps(XN632710Req req);

    public void approveCompanyGps(XN632712Req req);

    public String applyUserGps(XN632711Req req);

    public void approveUserGps(XN632713Req req);

    public Paginable<GpsApply> queryGpsApplyPage(int start, int limit,
            GpsApply condition);

    public List<GpsApply> queryGpsApplyList(GpsApply condition);

    public GpsApply getGpsApply(String code);
}
