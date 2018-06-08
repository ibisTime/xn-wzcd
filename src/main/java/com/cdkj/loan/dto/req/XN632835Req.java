package com.cdkj.loan.dto.req;

/**
 * 分页查询合同
 * @author: jiafr 
 * @since: 2018年6月5日 下午9:05:11 
 * @history:
 */
public class XN632835Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String contractNo;

    private String type;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
