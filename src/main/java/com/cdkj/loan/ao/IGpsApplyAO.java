package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.dto.req.XN632710Req;
import com.cdkj.loan.dto.req.XN632711Req;

/**
 * GPS申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:18:54 
 * @history:
 */
public interface IGpsApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addGpsApply(XN632710Req req);

    public void approveYesGpsApply(XN632711Req req);

    public void approveNoGpsApply(String code, String remark);

    public Paginable<GpsApply> queryGpsApplyPage(int start, int limit,
            GpsApply condition);

    public List<GpsApply> queryGpsApplyList(GpsApply condition);

    public GpsApply getGpsApply(String code);
}
