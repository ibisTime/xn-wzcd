package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Judge;

public interface IJudgeDAO extends IBaseDAO<Judge> {
    String NAMESPACE = IJudgeDAO.class.getName().concat(".");

    // 诉讼跟进
    public void updateJudgeFollow(Judge data);

    // 执行结果录入
    public void updateJudgeResultInput(Judge data);

    // 出纳打款
    public void cashier(Judge judge);

    // 受理
    public void acceptance(Judge judge);

    // 开庭
    public void toHoldCourt(Judge judge);

    // 判决
    public void sentence(Judge judge);

    // 生效
    public void takeEffect(Judge judge);

    // 申请执行
    public void applyImplement(Judge judge);

    // 执行案件：申请执行
    public void implementAdmissibility(Judge judge);

    // 执行案件：拍卖
    public void auction(Judge judge);

    // 执行案件：公告
    public void notice(Judge judge);
}
