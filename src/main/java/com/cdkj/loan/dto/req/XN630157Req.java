package com.cdkj.loan.dto.req;

public class XN630157Req {

    private String type;// 流程类型

    private String currentNode;// 当前节点

    private String nextNode;// 下一个节点

    private String backNode;// 返回节点

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
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
