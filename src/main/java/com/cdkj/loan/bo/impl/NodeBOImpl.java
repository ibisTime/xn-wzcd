package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.INodeDAO;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class NodeBOImpl extends PaginableBOImpl<Node> implements INodeBO {

    @Autowired
    INodeDAO nodeDAO;

    @Override
    public List<Node> queryNodeList(Node condition) {
        return nodeDAO.selectList(condition);
    }

    @Override
    public Node getNode(String code) {
        Node data = null;
        if (StringUtils.isNotBlank(code)) {
            Node condition = new Node();
            condition.setCode(code);
            data = nodeDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "节点不存在！");
            }
        }
        return data;
    }

    @Override
    public List<Node> queryNodeListIncludeCurRole(Node node) {

        return nodeDAO.selectNodeListIncludeCurRole(node);
    }

}
