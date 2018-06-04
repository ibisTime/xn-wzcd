package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CompProduct;
import com.cdkj.loan.dto.req.XN632750Req;
import com.cdkj.loan.dto.req.XN632751Req;

/**
 * 品名管理
 * @author: silver 
 * @since: 2018年6月4日 下午10:56:52 
 * @history:
 */
@Component
public interface ICompProductAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCompProduct(XN632750Req req);

    public void editCompProduct(XN632751Req req);

    public Paginable<CompProduct> queryCompProductPage(int start, int limit,
            CompProduct condition);

    public List<CompProduct> queryCompProductList(CompProduct condition);

    public CompProduct getCompProduct(String code);

}
