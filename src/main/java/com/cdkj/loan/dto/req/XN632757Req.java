package com.cdkj.loan.dto.req;

/**
 * 列表查询品名
 * @author: silver 
 * @since: 2018年6月4日 下午11:18:41 
 * @history:
 */
public class XN632757Req extends AListReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -6705759451896067458L;

    // 类型
    private String categoryCode;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

}
