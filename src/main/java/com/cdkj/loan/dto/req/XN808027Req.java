/**
 * @Title XN601001Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月17日 上午9:08:54 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月17日 上午9:08:54 
 * @history:
 */
public class XN808027Req {

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
