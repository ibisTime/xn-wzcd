package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Repoint;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午10:09:00 
 * @history:
 */
@Component
public interface IRepointAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRepoint(Repoint data);

    public int dropRepoint(String code);

    public int editRepoint(Repoint data);

    public Paginable<Repoint> queryRepointPage(int start, int limit,
            Repoint condition);

    public List<Repoint> queryRepointList(Repoint condition);

    public Repoint getRepoint(String code);

}
