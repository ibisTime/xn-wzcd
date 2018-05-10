package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBaofooWithholdBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IBaofooWithholdDAO;
import com.cdkj.loan.domain.BaofooWithhold;
import com.cdkj.loan.exception.BizException;

@Component
public class BaofooWithholdBOImpl extends PaginableBOImpl<BaofooWithhold>
        implements IBaofooWithholdBO {

    @Autowired
    private IBaofooWithholdDAO baofooWithholdDAO;

    @Override
    public String saveBaofooWithhold(BaofooWithhold data) {
        String code = null;
        if (data != null) {
            baofooWithholdDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<BaofooWithhold> queryBaofooWithholdList(
            BaofooWithhold condition) {
        return baofooWithholdDAO.selectList(condition);
    }

    @Override
    public BaofooWithhold getBaofooWithhold(String code) {
        BaofooWithhold data = null;
        if (StringUtils.isNotBlank(code)) {
            BaofooWithhold condition = new BaofooWithhold();
            condition.setTransId(code);
            data = baofooWithholdDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "代扣记录不存在");
            }
        }
        return data;
    }
}
