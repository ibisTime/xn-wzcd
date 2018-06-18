package com.cdkj.loan.dto.req;

/**
 * 分页查询gps申领列表
 * @author: silver 
 * @since: 2018年5月31日 上午2:30:26 
 * @history:
 */
public class XN632715Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 4507998360119484825L;

    // 申领人
    private String applyUser;

    // 所属公司
    private String companyCode;

    // 状态
    private String status;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
