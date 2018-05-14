package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查询银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午8:09:33 
 * @history:
 */
public class XN802017Req {

    // 编号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
