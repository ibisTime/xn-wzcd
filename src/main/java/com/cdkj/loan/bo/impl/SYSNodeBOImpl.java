package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISYSNodeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ISYSNodeDAO;
import com.cdkj.loan.domain.SYSNode;
import com.cdkj.loan.exception.BizException;

@Component
public class SYSNodeBOImpl extends PaginableBOImpl<SYSNode>
        implements ISYSNodeBO {

    @Autowired
    ISYSNodeDAO sysNodeDAO;

    @Override
    public long getTotalCount(SYSNode condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Paginable<SYSNode> getPaginable(int start, SYSNode condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paginable<SYSNode> getPaginable(int start, int pageSize,
            SYSNode condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String saveSYSNode(SYSNode data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int removeSYSNode(String code) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int refreshSYSNode(SYSNode data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<SYSNode> querySYSNodeList(SYSNode condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SYSNode getSYSNode(String code) {
        SYSNode data = null;
        if (StringUtils.isNotBlank(code)) {
            SYSNode condition = new SYSNode();
            condition.setCode(code);
            data = sysNodeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }

}
