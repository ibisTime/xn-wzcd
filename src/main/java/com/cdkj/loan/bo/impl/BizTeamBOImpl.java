package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBizTeamDAO;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午1:03:05 
 * @history:
 */
@Component
public class BizTeamBOImpl extends PaginableBOImpl<BizTeam> implements
        IBizTeamBO {

    @Autowired
    private IBizTeamDAO bizTeamDAO;

    @Override
    public boolean isBizTeamExist(String code) {
        BizTeam condition = new BizTeam();
        condition.setCode(code);
        if (bizTeamDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBizTeam(BizTeam data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BIZ_TEAM.getCode());
            data.setCode(code);
            bizTeamDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBizTeam(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BizTeam data = new BizTeam();
            data.setCode(code);
            data.setStatus("0");
            count = bizTeamDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBizTeam(BizTeam data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bizTeamDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BizTeam> queryBizTeamList(BizTeam condition) {
        return bizTeamDAO.selectList(condition);
    }

    @Override
    public BizTeam getBizTeam(String code) {
        BizTeam data = null;
        if (StringUtils.isNotBlank(code)) {
            BizTeam condition = new BizTeam();
            condition.setCode(code);
            condition.setStatus(EBoolean.YES.getCode());
            data = bizTeamDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "业务团队不存在");
            }
        }
        return data;
    }
}
