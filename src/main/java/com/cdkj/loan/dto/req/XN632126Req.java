package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 预算单-安装GPS
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632126Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    @NotEmpty
    private List<XN632126ReqGps> gpsAzList; // 安装gps列表

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<XN632126ReqGps> getGpsAzList() {
        return gpsAzList;
    }

    public void setGpsAzList(List<XN632126ReqGps> gpsAzList) {
        this.gpsAzList = gpsAzList;
    }
}
