package com.cdkj.loan.dto.req;

/**
 * 分页查询资料传递
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:21:09 
 * @history:
 */
public class XN632155Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 业务编号
    private String bizCode;

    // 节点编号
    private String bizNodeCode;

    // 状态
    private String status;

    // 用户编号
    private String userId;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizNodeCode() {
        return bizNodeCode;
    }

    public void setBizNodeCode(String bizNodeCode) {
        this.bizNodeCode = bizNodeCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
