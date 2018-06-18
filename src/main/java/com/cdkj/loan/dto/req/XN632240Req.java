package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 返点财务经理制单（新增）
 * @author: jiafr 
 * @since: 2018年6月18日 下午2:14:31 
 * @history:
 */
public class XN632240Req {

    // 汽车经销商编号
    private String carDealerCode;

    // 收款账号编号
    private String bankcardCode;

    // 总金额
    private String totalAmount;

    // 缘由
    private String reason;

    // 申请人编号
    private String operator;

    private List<String> repointDetailCodeList;

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getBankcardCode() {
        return bankcardCode;
    }

    public void setBankcardCode(String bankcardCode) {
        this.bankcardCode = bankcardCode;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<String> getRepointDetailCodeList() {
        return repointDetailCodeList;
    }

    public void setRepointDetailCodeList(List<String> repointDetailCodeList) {
        this.repointDetailCodeList = repointDetailCodeList;
    }

}
