package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 试用期评估
 * @author: CYL 
 * @since: 2018年6月5日 下午10:11:01 
 * @history:
 */
public class XN632870ReqProbationAssess {

    // 评估项目
    @NotBlank
    private String evalItem;

    // 评估分数
    @NotBlank
    private String grade;

    public String getEvalItem() {
        return evalItem;
    }

    public void setEvalItem(String evalItem) {
        this.evalItem = evalItem;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
