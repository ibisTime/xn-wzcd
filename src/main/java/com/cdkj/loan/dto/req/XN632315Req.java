package com.cdkj.loan.dto.req;

/**
 * 分页查询银行返佣
 * @author: jiafr 
 * @since: 2018年6月9日 下午2:22:25 
 * @history:
 */
public class XN632315Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 贷款银行编号
    private String loanBankCode;

    // 汽车经销商编号
    private String carDealerCode;

    // 节点
    private String curNodeCode;

    // 客户姓名
    private String customerName;

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
