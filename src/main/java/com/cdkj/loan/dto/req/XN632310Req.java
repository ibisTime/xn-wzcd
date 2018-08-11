package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 录入结算费率
 * @author: jiafr 
 * @since: 2018年8月10日 下午2:48:18 
 * @history:
 */
public class XN632310Req {

    // 银行返佣编号列表
    @NotEmpty
    List<String> codeList;

    // 结算费率
    @NotBlank
    String settleRate;

    // 操作人
    @NotBlank
    String operator;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getSettleRate() {
        return settleRate;
    }

    public void setSettleRate(String settleRate) {
        this.settleRate = settleRate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
