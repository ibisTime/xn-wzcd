package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CompCategory;
import com.cdkj.loan.dto.req.XN632740Req;
import com.cdkj.loan.dto.req.XN632741Req;

/**
 * 库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午9:54:56 
 * @history:
 */
@Component
public interface ICompCategoryAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCompCategory(XN632740Req req);

    public void editCompCategory(XN632741Req req);

    public Paginable<CompCategory> queryCompCategoryPage(int start, int limit,
            CompCategory condition);

    public List<CompCategory> queryCompCategoryList(CompCategory condition);

    public CompCategory getCompCategory(String code);

}
