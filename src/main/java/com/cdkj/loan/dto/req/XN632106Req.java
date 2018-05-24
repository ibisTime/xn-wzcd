package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author: CYL 
 * @since: 2018年5月23日 下午1:53:17 
 * @history:
 */
public class XN632106Req {

    @NotBlank
    private String code;// 预算单编号

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
