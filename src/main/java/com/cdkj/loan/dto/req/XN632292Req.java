package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 银行返点（批量）
 * @author: jiafr 
 * @since: 2018年7月23日 上午10:59:08 
 * @history:
 */
public class XN632292Req {

    // 预算单编号列表(必填)
    @NotEmpty(message = "编号列表不能为空")
    private List<String> codeList;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

}
