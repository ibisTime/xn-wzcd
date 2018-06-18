package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAdvanceFundBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAdvanceFundDAO;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:55:29 
 * @history:
 */
@Component
public class AdvanceFundBOImpl extends PaginableBOImpl<AdvanceFund> implements
        IAdvanceFundBO {

    @Autowired
    private IAdvanceFundDAO advanceFundDAO;

    @Override
    public boolean isAdvanceFundExist(String code) {
        AdvanceFund condition = new AdvanceFund();
        condition.setCode(code);
        if (advanceFundDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveAdvanceFund(AdvanceFund data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.ADVANCE_FUND
                .getCode());
            data.setCode(code);
            advanceFundDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeAdvanceFund(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            AdvanceFund data = new AdvanceFund();
            data.setCode(code);
            count = advanceFundDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshAdvanceFund(AdvanceFund data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = advanceFundDAO.update(data);
        }
        return count;
    }

    @Override
    public List<AdvanceFund> queryAdvanceFundList(AdvanceFund condition) {
        return advanceFundDAO.selectList(condition);
    }

    @Override
    public AdvanceFund getAdvanceFund(String code) {
        AdvanceFund data = null;
        if (StringUtils.isNotBlank(code)) {
            AdvanceFund condition = new AdvanceFund();
            condition.setCode(code);
            data = advanceFundDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "垫资单不存在");
            }
        }
        return data;
    }

    @Override
    public void refreshConfirmAdvanceFund(AdvanceFund data) {
        if (null != data) {
            advanceFundDAO.updateConfirmAdvanceFund(data);
        }
    }

    @Override
    public void refreshAreaAudit(AdvanceFund data) {
        if (null != data) {
            advanceFundDAO.updateAreaAudit(data);
        }
    }

    @Override
    public void refreshProvinceAudit(AdvanceFund data) {
        if (null != data) {
            advanceFundDAO.updateProvinceAudit(data);
        }
    }

    @Override
    public void parentMakeBill(AdvanceFund data) {
        if (null != data) {
            advanceFundDAO.updateParentMakeBill(data);
        }

    }

    @Override
    public void branchMakeBill(AdvanceFund data) {
        if (null != data) {
            advanceFundDAO.updateBranchMakeBill(data);
        }
    }

    @Override
    public void confirmPayCarDealer(AdvanceFund data) {
        if (null != data) {
            advanceFundDAO.confirmPayCarDealer(data);
        }

    }

    @Override
    public void confirmPayBranchCompany(AdvanceFund data) {
        if (null != data) {
            advanceFundDAO.updateConfirmPayBranchCompany(data);
        }

    }

    @Override
    public void applyCancelAdvanceFund(AdvanceFund data) {
        if (null != data) {
            advanceFundDAO.updateApplyCancelAdvanceFund(data);
        }
    }

    @Override
    public Paginable<AdvanceFund> queryAdvanceFundPageByRoleCode(int start,
            int limit, AdvanceFund condition) {
        prepare(condition);

        long totalCount = advanceFundDAO.selectTotalCountByRoleCode(condition);

        Paginable<AdvanceFund> page = new Page<AdvanceFund>(start, limit,
            totalCount);

        List<AdvanceFund> dataList = advanceFundDAO
            .selectAdvenceFundByRoleCodeList(condition, page.getStart(),
                page.getPageSize());

        page.setList(dataList);
        return page;
    }
}
