package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Judge;

public interface IJudgeDAO extends IBaseDAO<Judge> {
    String NAMESPACE = IJudgeDAO.class.getName().concat(".");

    // 诉讼跟进
    public void updateJudgeFollow(Judge data);

    // 执行结果录入
    public void updateJudgeResultInput(Judge data);

    // 财务确认收货
    public void updateFinanceSureReceipt(Judge data);

}
