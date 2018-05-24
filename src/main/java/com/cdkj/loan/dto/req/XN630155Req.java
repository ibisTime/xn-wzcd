package com.cdkj.loan.dto.req;

public class XN630155Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5780013307270124748L;

    private String name;// 节点名称

    private String type;// 流程类型

    private String nextNode;// 下一个节点

    private String backNode;// 返回节点

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNextNode() {
        return nextNode;
    }

    public void setNextNode(String nextNode) {
        this.nextNode = nextNode;
    }

    public String getBackNode() {
        return backNode;
    }

    public void setBackNode(String backNode) {
        this.backNode = backNode;
    }

}
