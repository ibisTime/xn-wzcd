package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SuppleSignApply;
import com.cdkj.loan.dto.req.XN632600Req;
import com.cdkj.loan.dto.req.XN632601Req;

/**
 * 补签
 * @author: silver 
 * @since: 2018年6月5日 下午10:58:06 
 * @history:
 */
@Component
public interface ISuppleSignApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addSuppleSignApply(XN632600Req req);

    public void approveSuppleSignApply(XN632601Req req);

    public Paginable<SuppleSignApply> querySuppleSignApplyPage(int start,
            int limit, SuppleSignApply condition);

    public List<SuppleSignApply> querySuppleSignApplyList(
            SuppleSignApply condition);

    public SuppleSignApply getSuppleSignApply(String code);

}
