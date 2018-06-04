package com.cdkj.loan.dto.req;

/**
 * 分页查询品名
 * @author: silver 
 * @since: 2018年6月4日 下午11:12:37 
 * @history:
 */
public class XN632755Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5933298866541905618L;

    // 名称
    private String name;

    // 类别
    private String categoryCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

}
