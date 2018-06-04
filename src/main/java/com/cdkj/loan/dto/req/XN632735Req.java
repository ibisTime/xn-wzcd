package com.cdkj.loan.dto.req;

/**
 * 分页查询公司制度
 * @author: silver 
 * @since: 2018年6月4日 下午8:52:24 
 * @history:
 */
public class XN632735Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -7716238068563414086L;

    // 类型(1行政事务类 2 人力资源管理类 3 财务管理类 4 营销管理类 5 生产管理类)
    private String type;

    // 制度编号
    private String regimeCode;

    // 名称
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegimeCode() {
        return regimeCode;
    }

    public void setRegimeCode(String regimeCode) {
        this.regimeCode = regimeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
