package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 新增公司制度
 * @author: silver 
 * @since: 2018年6月4日 下午8:37:14 
 * @history:
 */
public class XN632730Req {
    // 制度编号
    private String regimeCode;

    // 名称
    private String name;

    // 类型(1行政事务类 2 人力资源管理类 3 财务管理类 4 营销管理类 5 生产管理类)
    @NotBlank
    private String type;

    // 内容
    private String content;

    // 更新人
    private String updater;

    // 备注
    private String remark;

    // 范围
    @NotEmpty
    private List<XN632720ReqScope> scopePeopleList;

    public String getUpdater() {
        return updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRegimeCode() {
        return regimeCode;
    }

    public void setRegimeCode(String regimeCode) {
        this.regimeCode = regimeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<XN632720ReqScope> getScopePeopleList() {
        return scopePeopleList;
    }

    public void setScopePeopleList(List<XN632720ReqScope> scopePeopleList) {
        this.scopePeopleList = scopePeopleList;
    }

}
