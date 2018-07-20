package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 资料传递收件
 * @author: silver 
 * @since: 2018年5月29日 下午11:02:18 
 * @history:
 */
public class XN632151Req {
    // 编号
    @NotBlank
    private String code;

    // 备注
    private String remark;

    // 编号List
    private List<String> codeList;

    // 操作人
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
