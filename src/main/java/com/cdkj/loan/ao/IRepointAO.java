package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.dto.req.XN632310Req;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午10:09:00 
 * @history:
 */
@Component
public interface IRepointAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 确认返点支付
    public void confirmRepoint(XN632310Req req);

    public Paginable<Repoint> queryRepointPage(int start, int limit,
            Repoint condition);

    public List<Repoint> queryRepointList(Repoint condition);

    public Repoint getRepoint(String code);

}
