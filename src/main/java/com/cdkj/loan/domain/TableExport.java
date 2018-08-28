package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 表格导出
* @author: CYunlai 
* @since: 2018-08-04 20:38:22
* @history:
*/
public class TableExport extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private int id;

    // URL
    private String url;

    // 操作人
    private String operator;

    // 操作时间
    private Date updateDatetime;

    /***********辅助字段************/

    private String realName;// 真实姓名

    private String menuName;// 菜单名称

    private Date updateDatetimeStart;// 操作时间起始

    private Date updateDatetimeEnd;// 操作时间结束

    public Date getUpdateDatetimeStart() {
        return updateDatetimeStart;
    }

    public void setUpdateDatetimeStart(Date updateDatetimeStart) {
        this.updateDatetimeStart = updateDatetimeStart;
    }

    public Date getUpdateDatetimeEnd() {
        return updateDatetimeEnd;
    }

    public void setUpdateDatetimeEnd(Date updateDatetimeEnd) {
        this.updateDatetimeEnd = updateDatetimeEnd;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

}
