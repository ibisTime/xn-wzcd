package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * GPS申领审核
 * @author: silver 
 * @since: 2018年5月31日 上午12:33:49 
 * @history:
 */
public class XN632711Req {
    // 编号
    @NotBlank
    private String code;

    // 备注
    private String remark;

    // GPS列表
    @NotEmpty
    private List<XN632711ReqChild> gpsList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<XN632711ReqChild> getGpsList() {
        return gpsList;
    }

    public void setGpsList(List<XN632711ReqChild> gpsList) {
        this.gpsList = gpsList;
    }

}
