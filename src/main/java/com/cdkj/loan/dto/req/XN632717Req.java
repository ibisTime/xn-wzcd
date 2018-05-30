package com.cdkj.loan.dto.req;

/**
 * 列表查询gps申领列表
 * @author: silver 
 * @since: 2018年5月31日 上午2:30:26 
 * @history:
 */
public class XN632717Req extends AListReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -7449078922996839069L;

    // 申领人
    private String applyUser;

    // 所属公司
    private String company;

    // 状态
    private String status;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
