package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSNode;

@Component
public interface ISYSNodeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addSYSNode(SYSNode data);

    public int dropSYSNode(String code);

    public int editSYSNode(SYSNode data);

    public Paginable<SYSNode> querySYSNodePage(int start, int limit,
            SYSNode condition);

    public List<SYSNode> querySYSNodeList(SYSNode condition);

    public SYSNode getSYSNode(String code);

}
