package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAssertUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAssertUserDAO;
import com.cdkj.loan.domain.AssertUser;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:56:54 
 * @history:
 */
@Component
public class AssertUserBOImpl extends PaginableBOImpl<AssertUser>
        implements IAssertUserBO {

    @Autowired
    private IAssertUserDAO assertUserDAO;

    @Override
    public boolean isAssertUserExist(String code) {
        AssertUser condition = new AssertUser();
        condition.setCode(code);
        if (assertUserDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveAssertUser(AssertUser data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.ASSERT_USER.getCode());
            data.setCode(code);
            assertUserDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeAssertUser(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            AssertUser data = new AssertUser();
            data.setCode(code);
            count = assertUserDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshAssertUser(AssertUser data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = assertUserDAO.update(data);
        }
        return count;
    }

    @Override
    public List<AssertUser> queryAssertUserList(AssertUser condition) {
        return assertUserDAO.selectList(condition);
    }

    @Override
    public AssertUser getAssertUser(String code) {
        AssertUser data = null;
        if (StringUtils.isNotBlank(code)) {
            AssertUser condition = new AssertUser();
            condition.setCode(code);
            data = assertUserDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "办公用户列表不存在");
            }
        }
        return data;
    }
}
