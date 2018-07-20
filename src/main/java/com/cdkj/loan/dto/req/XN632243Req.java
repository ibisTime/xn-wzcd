package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 返点支付财务确认
 * @author: jiafr 
 * @since: 2018年7月20日 下午8:19:50 
 * @history:
 */
public class XN632243Req {

    // 返点编号
    @NotBlank
    private List<String> codeList;

    // 操作人
    @NotBlank
    private String operator;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
