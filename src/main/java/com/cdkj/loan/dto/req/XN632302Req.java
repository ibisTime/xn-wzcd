package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class XN632302Req {

    @NotEmpty
    private List<String> codeList;// 逾期名单编号

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

}
