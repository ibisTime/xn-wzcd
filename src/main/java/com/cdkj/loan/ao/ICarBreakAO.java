package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarBreak;
import com.cdkj.loan.dto.req.XN632630Req;
import com.cdkj.loan.dto.req.XN632631Req;

/**
 * 违章处理
 * @author: silver 
 * @since: 2018年6月6日 下午4:39:22 
 * @history:
 */
@Component
public interface ICarBreakAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCarBreak(XN632630Req req);

    public void approveCarBreak(XN632631Req req);

    public Paginable<CarBreak> queryCarBreakPage(int start, int limit,
            CarBreak condition);

    public List<CarBreak> queryCarBreakList(CarBreak condition);

    public CarBreak getCarBreak(String code);

}
