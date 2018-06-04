package com.cdkj.loan.dto.req;

/**
 * 分页查询库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午10:12:33 
 * @history:
 */
public class XN632745Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5933298866541905618L;

    // 名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
