package com.cdkj.loan.dto.req;

/**
 * 列表查询返点明细 
 * @author: jiafr 
 * @since: 2018年6月18日 下午5:32:52 
 * @history:
 */
public class XN632297Req {

    // 经销商返点账号编号
    private String accountCode;

    // 汽车经销商编号
    private String carDealerCode;

    // 收款账号(协议外返点手填)
    private String accountNo;

    // 节点
    private String curNodeCode;

    // 结算方式
    private String settleWay;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getSettleWay() {
        return settleWay;
    }

    public void setSettleWay(String settleWay) {
        this.settleWay = settleWay;
    }

}
