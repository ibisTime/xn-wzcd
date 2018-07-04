package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632114ReqCNR {

    // 征信人员编号
    @NotBlank
    private String code;

    // 法院网查询结果
    @NotBlank
    private String courtNetworkResults;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourtNetworkResults() {
        return courtNetworkResults;
    }

    public void setCourtNetworkResults(String courtNetworkResults) {
        this.courtNetworkResults = courtNetworkResults;
    }

}
