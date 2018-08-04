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
