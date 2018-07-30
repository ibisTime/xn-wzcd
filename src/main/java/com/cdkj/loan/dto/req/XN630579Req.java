package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 理件岗理件
 * @author: CYL 
 * @since: 2018年7月30日 下午5:34:10 
 * @history:
 */
public class XN630579Req {
    // 还款业务编号
    @NotEmpty
    private List<String> codeList;

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
