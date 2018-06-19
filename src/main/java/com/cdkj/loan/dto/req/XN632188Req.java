package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 分页查询垫资
 * @author: jiafr 
 * @since: 2018年6月18日 上午1:56:04 
 * @history:
 */
public class XN632188Req {

    // 业务公司编号
    @NotBlank
    private String companyCode;

    // 1分公司制单2确认打款分公司
    @NotBlank
    private String curNodeCode;

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
