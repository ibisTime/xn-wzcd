package com.cdkj.loan.dto.req;

/**
 * 列表查询库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午10:15:29 
 * @history:
 */
public class XN632747Req extends AListReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -6705759451896067458L;

    // 名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
