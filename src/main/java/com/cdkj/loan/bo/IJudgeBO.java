package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Judge;

public interface IJudgeBO extends IPaginableBO<Judge> {

    public boolean isJudgeExist(String code);

    public String saveJudge(Judge data);

    // 诉讼跟进
    public void refreshJudgeFollow(Judge data);

    // 执行结果录入
    public void refreshJudgeResultEntry(Judge data);

    public List<Judge> queryJudgeList(Judge condition);

    public Judge getJudge(String code);

}
