package com.cdkj.loan.dto.req;

/**
 * 列表查询公告
 * @author: silver 
 * @since: 2018年6月4日 下午7:45:50 
 * @history:
 */
public class XN632727Req extends AListReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 464900751873626340L;

    // 标题
    private String title;

    // 类型
    private String type;

    // 状态
    private String status;

    // 紧急程度
    private String urgentStatus;

    // 发布部门
    private String publishDepartmentCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrgentStatus() {
        return urgentStatus;
    }

    public void setUrgentStatus(String urgentStatus) {
        this.urgentStatus = urgentStatus;
    }

    public String getPublishDepartmentCode() {
        return publishDepartmentCode;
    }

    public void setPublishDepartmentCode(String publishDepartmentCode) {
        this.publishDepartmentCode = publishDepartmentCode;
    }

}
