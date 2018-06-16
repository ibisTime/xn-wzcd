package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IJudgeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IJudgeDAO;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class JudgeBOImpl extends PaginableBOImpl<Judge> implements IJudgeBO {

    @Autowired
    private IJudgeDAO judgeDAO;

    @Override
    public boolean isJudgeExist(String code) {
        Judge condition = new Judge();
        condition.setCode(code);
        if (judgeDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveJudge(Judge data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.JUDGE.getCode());
            data.setCode(code);
            judgeDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshJudgeFollow(Judge data) {
        judgeDAO.updateJudgeFollow(data);
    }

    @Override
    public void refreshJudgeResultEntry(Judge data) {
        judgeDAO.updateJudgeResultEntry(data);
    }

    @Override
    public List<Judge> queryJudgeList(Judge condition) {
        return judgeDAO.selectList(condition);
    }

    @Override
    public Judge getJudge(String code) {
        Judge data = null;
        if (StringUtils.isNotBlank(code)) {
            Judge condition = new Judge();
            condition.setCode(code);
            data = judgeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在！");
            }
        }
        return data;
    }

}
