package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.dto.req.XN630560Req;
import com.cdkj.loan.dto.req.XN630561Req;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.enums.EBoolean;

public interface IJudgeBO extends IPaginableBO<Judge> {

    public boolean isJudgeExist(String code);

    public String saveJudge(XN630560Req req);

    // 诉讼跟进
    public void refreshJudgeFollow(XN630561Req req);

    // 执行结果录入
    public void refreshJudgeResultInput(XN630562Req req);

    // 财务确认收货
    public void refreshFinanceSureReceipt(String code, String updater);

    public List<Judge> queryJudgeList(Judge condition);

    public Judge getJudge(String code);

    public Judge queryJudgeByRepayBizCode(String repayBizCode, EBoolean status);

}
