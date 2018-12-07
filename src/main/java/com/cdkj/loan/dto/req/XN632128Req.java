package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 银行征信详情查
 * @author: CYL 
 * @since: 2018年11月30日 下午4:32:37 
 * @history:
 */
public class XN632128Req {
    @NotBlank
    private String code;// 征信人员编号

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
