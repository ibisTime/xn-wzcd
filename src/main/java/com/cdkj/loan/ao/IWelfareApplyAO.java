package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.WelfareApply;
import com.cdkj.loan.dto.req.XN632660Req;
import com.cdkj.loan.dto.req.XN632661Req;

/**
 * 福利发放
 * @author: silver 
 * @since: 2018年6月6日 下午7:18:24 
 * @history:
 */
@Component
public interface IWelfareApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addWelfareApply(XN632660Req req);

    public void approveWelfareApply(XN632661Req req);

    public Paginable<WelfareApply> queryWelfareApplyPage(int start, int limit,
            WelfareApply condition);

    public List<WelfareApply> queryWelfareApplyList(WelfareApply condition);

    public WelfareApply getWelfareApply(String code);

}
