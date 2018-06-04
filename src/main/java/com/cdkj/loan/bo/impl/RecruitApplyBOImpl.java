package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRecruitApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IRecruitApplyDAO;
import com.cdkj.loan.domain.RecruitApply;
import com.cdkj.loan.exception.BizException;

@Component
public class RecruitApplyBOImpl extends PaginableBOImpl<RecruitApply> implements
        IRecruitApplyBO {

    @Autowired
    private IRecruitApplyDAO recruitApplyDAO;

    @Override
    public boolean isRecruitApplyExist(String code) {
        RecruitApply condition = new RecruitApply();
        condition.setCode(code);
        if (recruitApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRecruitApply(RecruitApply data) {
        String code = null;
        if (data != null) {
            // code = OrderNoGenerater.generateM(EGeneratePrefix.CT.getCode());
            data.setCode(code);
            recruitApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRecruitApply(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            RecruitApply data = new RecruitApply();
            data.setCode(code);
            count = recruitApplyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshRecruitApply(RecruitApply data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            // count = recruitApplyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<RecruitApply> queryRecruitApplyList(RecruitApply condition) {
        return recruitApplyDAO.selectList(condition);
    }

    @Override
    public RecruitApply getRecruitApply(String code) {
        RecruitApply data = null;
        if (StringUtils.isNotBlank(code)) {
            RecruitApply condition = new RecruitApply();
            condition.setCode(code);
            data = recruitApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
