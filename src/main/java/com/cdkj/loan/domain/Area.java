package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 身份证区域
 * @author: silver 
 * @since: 2018年5月26日 下午5:14:25 
 * @history:
 */
public class Area extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 9110728402324159141L;

    // 序号
    private int id;

    // 身份证区域号
    private String areaNo;

    // 身份证区域名称
    private String areaName;

    /*-----------辅助字段-------------*/

    // 身份证区域号模糊查
    private String areaNoForQuery;

    // 身份证区域名称模糊查
    private String areaNameForQuery;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaNoForQuery() {
        return areaNoForQuery;
    }

    public void setAreaNoForQuery(String areaNoForQuery) {
        this.areaNoForQuery = areaNoForQuery;
    }

    public String getAreaNameForQuery() {
        return areaNameForQuery;
    }

    public void setAreaNameForQuery(String areaNameForQuery) {
        this.areaNameForQuery = areaNameForQuery;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

}
