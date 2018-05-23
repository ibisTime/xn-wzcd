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
    private ISYSNodeBO sysNodeBO;

    @Override
    public String addSYSNode(SYSNode data) {
        return sysNodeBO.saveSYSNode(data);
    }

    @Override
    public int editSYSNode(SYSNode data) {
        return sysNodeBO.refreshSYSNode(data);
    }

    @Override
    public int dropSYSNode(String code) {
        return sysNodeBO.removeSYSNode(code);
    }

    @Override
    public Paginable<SYSNode> querySYSNodePage(int start, int limit,
            SYSNode condition) {
        return sysNodeBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SYSNode> querySYSNodeList(SYSNode condition) {
        return sysNodeBO.querySYSNodeList(condition);
    }

    @Override
    public SYSNode getSYSNode(String code) {
        return sysNodeBO.getSYSNode(code);
    }
}
