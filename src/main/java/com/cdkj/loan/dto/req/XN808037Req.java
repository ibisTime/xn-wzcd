package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN808037Req {

    // 产品名称(必填)
    @NotBlank
    private String productCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

}
