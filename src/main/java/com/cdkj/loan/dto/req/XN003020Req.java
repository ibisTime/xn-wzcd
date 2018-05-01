package com.cdkj.loan.dto.req;

public class XN003020Req {

    // 起点(必填)
    private String startPoint;

    // 终点(必填)
    private String endPoint;

    // 重量(必填)
    private String weight;

    // 所属公司编号(必填)
    private String companyCode;

    // 系统编号(必填)
    private String systemCode;

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
