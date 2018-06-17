package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.dto.req.XN630560Req;
import com.cdkj.loan.dto.req.XN630561Req;
import com.cdkj.loan.dto.req.XN630562Req;

@Component
public interface IJudgeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 司法诉讼录入
    public String judgeApply(XN630560Req req);

    // 诉讼跟进
    public void judgeFollow(XN630561Req req);

    // 执行结果录入
    public void judgeResultInput(XN630562Req req);

    public Paginable<Judge> queryJudgePage(int start, int limit, Judge condition);

    public List<Judge> queryJudgeList(Judge condition);

    public Judge getJudge(String code);

}
