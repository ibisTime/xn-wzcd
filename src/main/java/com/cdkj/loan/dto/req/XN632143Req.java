package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 银行放款理件完成
 * @author: jiafr 
 * @since: 2018年7月14日 下午9:01:57 
 * @history:
 */
public class XN632143Req {

    // 预算单编号
    @NotEmpty
    private List<String> list;

    // 操作人
    @NotBlank
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

}
