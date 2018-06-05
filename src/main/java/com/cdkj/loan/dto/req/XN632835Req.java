package com.cdkj.loan.dto.req;

/**
 * 分页查询合同
 * @author: jiafr 
 * @since: 2018年6月5日 下午9:05:11 
 * @history:
 */
public class XN632835Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String archiveCode;

    private String contractNo;

    private String type;

    public String getArchiveCode() {
        return archiveCode;
    }

    public void setArchiveCode(String archiveCode) {
        this.archiveCode = archiveCode;
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
