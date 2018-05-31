package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.dto.req.XN632150Req;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午10:58:25 
 * @history:
 */
public interface ILogisticsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void sendLogistics(XN632150Req req);

    public void receiveLogistics(String code, String operator, String remark);

    public void sendAgainLogistics(String code, String operator, String remark);

    public Paginable<Logistics> queryLogisticsPage(int start, int limit,
            Logistics condition);

    public List<Logistics> queryLogisticsList(Logistics condition);

    public Logistics getLogistics(String code);
}
