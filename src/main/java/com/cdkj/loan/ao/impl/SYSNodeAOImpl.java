package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISYSNodeAO;
import com.cdkj.loan.bo.ISYSNodeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSNode;

@Service
public class SYSNodeAOImpl implements ISYSNodeAO {

    @Autowired
    private ISYSNodeBO SYSNodeBO;

    @Override
    public String addSYSNode(SYSNode data) {
        return SYSNodeBO.saveSYSNode(data);
    }

    @Override
    public int editSYSNode(SYSNode data) {
        return SYSNodeBO.refreshSYSNode(data);
    }

    @Override
    public int dropSYSNode(String code) {
        return SYSNodeBO.removeSYSNode(code);
    }

    @Override
    public Paginable<SYSNode> querySYSNodePage(int start, int limit,
            SYSNode condition) {
        return SYSNodeBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SYSNode> querySYSNodeList(SYSNode condition) {
        return SYSNodeBO.querySYSNodeList(condition);
    }

    @Override
    public SYSNode getSYSNode(String code) {
        return SYSNodeBO.getSYSNode(code);
    }
}
