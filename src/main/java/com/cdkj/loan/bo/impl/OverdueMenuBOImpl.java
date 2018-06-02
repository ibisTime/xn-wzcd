package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IOverdueMenuBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IOverdueMenuDAO;
import com.cdkj.loan.domain.OverdueMenu;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class OverdueMenuBOImpl extends PaginableBOImpl<OverdueMenu>
        implements IOverdueMenuBO {

    @Autowired
    private IOverdueMenuDAO overdueMenuDAO;

    public String saveOverdueMenu(OverdueMenu data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.OVERDUEMENU.getCode());
            data.setCode(code);
            overdueMenuDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeOverdueMenu(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            OverdueMenu data = new OverdueMenu();
            data.setCode(code);
            count = overdueMenuDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshOverdueMenu(OverdueMenu data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = overdueMenuDAO.update(data);
        }
        return count;
    }

    @Override
    public List<OverdueMenu> queryOverdueMenuList(OverdueMenu condition) {
        return overdueMenuDAO.selectList(condition);
    }

    @Override
    public OverdueMenu getOverdueMenu(String code) {
        OverdueMenu data = null;
        if (StringUtils.isNotBlank(code)) {
            OverdueMenu condition = new OverdueMenu();
            condition.setCode(code);
            data = overdueMenuDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
