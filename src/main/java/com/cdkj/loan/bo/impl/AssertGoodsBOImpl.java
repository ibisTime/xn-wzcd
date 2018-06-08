package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAssertGoodsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAssertGoodsDAO;
import com.cdkj.loan.domain.AssertGoods;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:54:38 
 * @history:
 */
@Component
public class AssertGoodsBOImpl extends PaginableBOImpl<AssertGoods>
        implements IAssertGoodsBO {

    @Autowired
    private IAssertGoodsDAO assertGoodsDAO;

    @Override
    public boolean isAssertGoodsExist(String code) {
        AssertGoods condition = new AssertGoods();
        condition.setCode(code);
        if (assertGoodsDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveAssertGoods(AssertGoods data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.ASSERT_GOODS.getCode());
            data.setCode(code);
            assertGoodsDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeAssertGoods(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            AssertGoods data = new AssertGoods();
            data.setCode(code);
            count = assertGoodsDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshAssertGoods(AssertGoods data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = assertGoodsDAO.update(data);
        }
        return count;
    }

    @Override
    public List<AssertGoods> queryAssertGoodsList(AssertGoods condition) {
        return assertGoodsDAO.selectList(condition);
    }

    @Override
    public AssertGoods getAssertGoods(String code) {
        AssertGoods data = null;
        if (StringUtils.isNotBlank(code)) {
            AssertGoods condition = new AssertGoods();
            condition.setCode(code);
            data = assertGoodsDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "办公物品列表不存在");
            }
        }
        return data;
    }
}
