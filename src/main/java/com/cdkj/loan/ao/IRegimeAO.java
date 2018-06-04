package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Regime;
import com.cdkj.loan.dto.req.XN632730Req;

/**
 * 公司制度
 * @author: silver 
 * @since: 2018年6月4日 下午8:40:34 
 * @history:
 */
public interface IRegimeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRegime(XN632730Req req);

    public Paginable<Regime> queryRegimePage(int start, int limit,
            Regime condition);

    public List<Regime> queryRegimeList(Regime condition);

    public Regime getRegime(String code);

}
