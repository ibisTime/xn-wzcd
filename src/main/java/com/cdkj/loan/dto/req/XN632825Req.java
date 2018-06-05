package com.cdkj.loan.dto.req;

/**
 * 分页查询档案存放位置
 * @author: jiafr 
 * @since: 2018年6月5日 下午6:56:58 
 * @history:
 */
public class XN632825Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 位置名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
