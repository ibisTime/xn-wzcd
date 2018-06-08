package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAssertApplyBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAssertApplyDAO;
import com.cdkj.loan.domain.AssertApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:49:31 
 * @history:
 */
@Component
public class AssertApplyBOImpl extends PaginableBOImpl<AssertApply>
        implements IAssertApplyBO {

    @Autowired
    private IAssertApplyDAO assertApplyDAO;

    @Override
    public boolean isAssertApplyExist(String code) {
        AssertApply condition = new AssertApply();
        condition.setCode(code);
        if (assertApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveAssertApply(AssertApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.ASSERT_APPLY.getCode());
            data.setCode(code);
            assertApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeAssertApply(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            AssertApply data = new AssertApply();
            data.setCode(code);
            count = assertApplyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshAssertApply(AssertApply data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = assertApplyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<AssertApply> queryAssertApplyList(AssertApply condition) {
        return assertApplyDAO.selectList(condition);
    }

    @Override
    public AssertApply getAssertApply(String code) {
        AssertApply data = null;
        if (StringUtils.isNotBlank(code)) {
            AssertApply condition = new AssertApply();
            condition.setCode(code);
            data = assertApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "办公用品不存在");
            }
        }
        return data;
    }

    @Override
    public Paginable<AssertApply> getPaginableByDepartmentCode(int start,
            int pageSize, AssertApply condition) {

        long totalCount = assertApplyDAO
            .selectTotalCountByDepartmentCode(condition);

        Paginable<AssertApply> page = new Page<AssertApply>(start, pageSize,
            totalCount);

        List<AssertApply> dataList = assertApplyDAO.selectListByDepartmentCode(
            condition, page.getStart(), page.getPageSize());

        page.setList(dataList);
        return page;
    }
}
