package com.cdkj.loan.dto.req;

/**
 * 列表查询资料传递
 * @author: silver 
 * @since: 2018年5月30日 下午1:48:18 
 * @history:
 */
public class XN632157Req extends AListReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 4758846135600445797L;

    // 业务编号
    private String bizCode;

    // 用户编号
    private String userId;

    // 业务节点
    private String bizNodeCode;

    // 状态
    private String status;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
