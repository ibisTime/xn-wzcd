package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.INodeDAO;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.exception.BizException;

@Component
public class NodeBOImpl extends PaginableBOImpl<Node> implements INodeBO {

    @Autowired
    INodeDAO nodeDAO;

    @Override
    public long getTotalCount(Node condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Paginable<Node> getPaginable(int start, Node condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String saveNode(Node data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int removeNode(String code) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int refreshNode(Node data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Node> queryNodeList(Node condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Node getNode(String code) {
        Node data = null;
        if (StringUtils.isNotBlank(code)) {
            Node condition = new Node();
            condition.setCode(code);
            data = nodeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }

}
