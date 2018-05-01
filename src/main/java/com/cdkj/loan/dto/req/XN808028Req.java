package com.cdkj.loan.dto.req;

public class XN808028Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 7405232977567267123L;

    // 产品大类(选填)
    private String category;

    // 产品小类(选填)
    private String type;

    // 产品名称(选填)
    private String name;

    // 状态(选填)
    private String status;

    // 位置(选填)
    private String location;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
