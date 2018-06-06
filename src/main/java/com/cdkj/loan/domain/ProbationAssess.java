package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 试用期评估
* @author: CYunlai 
* @since: 2018-06-05 23:00:30
* @history:
*/
public class ProbationAssess extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private int id;

    // 转正申请编号
    private String convertCode;

    // 评估项目
    private String evalItem;

    // 评估分数
    private Integer grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConvertCode(String convertCode) {
        this.convertCode = convertCode;
    }

    public String getConvertCode() {
        return convertCode;
    }

    public void setEvalItem(String evalItem) {
        this.evalItem = evalItem;
    }

    public String getEvalItem() {
        return evalItem;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

}
