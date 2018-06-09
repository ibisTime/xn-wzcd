package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月9日 下午2:19:32 
 * @history:
 */
@Service
public class RepointAOImpl implements IRepointAO {

    @Autowired
    private IRepointBO repointBO;

    @Override
    public String addRepoint(Repoint data) {
        return repointBO.saveRepoint(data);
    }

    @Override
    public int editRepoint(Repoint data) {
        if (!repointBO.isRepointExist(data.getCode())) {
            throw new BizException("xn0000", "返点数据不存在");
        }
        return repointBO.refreshRepoint(data);
    }

    @Override
    public int dropRepoint(String code) {
        if (!repointBO.isRepointExist(code)) {
            throw new BizException("xn0000", "返点数据不存在");
        }
        return repointBO.removeRepoint(code);
    }

    @Override
    public Paginable<Repoint> queryRepointPage(int start, int limit,
            Repoint condition) {
        return repointBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Repoint> queryRepointList(Repoint condition) {
        return repointBO.queryRepointList(condition);
    }

    @Override
    public Repoint getRepoint(String code) {
        return repointBO.getRepoint(code);
    }
}
