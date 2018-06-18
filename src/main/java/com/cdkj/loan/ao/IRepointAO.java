package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.dto.req.XN632240Req;
import com.cdkj.loan.dto.req.XN632241Req;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月18日 下午2:21:15 
 * @history:
 */
@Component
public interface IRepointAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRepoint(XN632240Req req);

    public Paginable<Repoint> queryRepointPage(int start, int limit,
            Repoint condition);

    public List<Repoint> queryRepointList(Repoint condition);

    public Repoint getRepoint(String code);

    // 确认放款
    public void confirmLoan(XN632241Req req);

}
