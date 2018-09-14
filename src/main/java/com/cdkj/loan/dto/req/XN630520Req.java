package com.cdkj.loan.dto.req;

import java.util.List;

public class XN630520Req extends APageReq {

    private static final long serialVersionUID = 5066181160930283667L;

    private String code;// 还款业务编号

    private String userId;// 用户编号

    private String refType;// 关联类型

    // 业务公司编号
    private String companyCode;

    // 汽车经销商编号
    private String carDealerCode;

    // 入档状态（0待入档1待补录2已入档）
    private String enterFileStatus;

    private String keyWord;// 关键字

    private List<String> curNodeCodeList;// 节点

    private String curNodeCode;// 节点
    // 购车途径

    private String shopWay;

    // 是否恢复执行
    private String isImplementAgain;

    public String getShopWay() {
        return shopWay;
    }

    public void setShopWay(String shopWay) {
        this.shopWay = shopWay;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getEnterFileStatus() {
        return enterFileStatus;
    }

    public void setEnterFileStatus(String enterFileStatus) {
        this.enterFileStatus = enterFileStatus;
    }

    public String getIsImplementAgain() {
        return isImplementAgain;
    }

    public void setIsImplementAgain(String isImplementAgain) {
        this.isImplementAgain = isImplementAgain;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

}
