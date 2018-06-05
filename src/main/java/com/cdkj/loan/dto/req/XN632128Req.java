package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-车辆落户
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632128Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    // 车辆落户日期
    private String carSettleDatetime;

    // 发票
    private String carInvoice;

    // 合格证
    private String carHgz;

    // 交强险
    private String carJqx;

    // 商业险
    private String carSyx;

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

    public String getCarSettleDatetime() {
        return carSettleDatetime;
    }

    public void setCarSettleDatetime(String carSettleDatetime) {
        this.carSettleDatetime = carSettleDatetime;
    }

    public String getCarInvoice() {
        return carInvoice;
    }

    public void setCarInvoice(String carInvoice) {
        this.carInvoice = carInvoice;
    }

    public String getCarHgz() {
        return carHgz;
    }

    public void setCarHgz(String carHgz) {
        this.carHgz = carHgz;
    }

    public String getCarJqx() {
        return carJqx;
    }

    public void setCarJqx(String carJqx) {
        this.carJqx = carJqx;
    }

    public String getCarSyx() {
        return carSyx;
    }

    public void setCarSyx(String carSyx) {
        this.carSyx = carSyx;
    }

}
