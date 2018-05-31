package com.cdkj.loan.domain;

import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 节点流程
 * @author: xieyj 
 * @since: 2018年5月28日 下午8:13:01 
 * @history:
 */
public class NodeFlow extends ABaseDO {
    private static final long serialVersionUID = 4733016091171187458L;

    private String id;// 序号

    private String currentNode;// 当前节点

    private String type;// 类型

    private String nextNode;// 下一个节点

    private String backNode;// 返回节点

    private String fileList;// 材料清单

    private String remark;// 备注

    // ****************db properties****************
    private List<FileList> fileStrs;// 材料清单

    public List<FileList> getFileStrs() {
        return fileStrs;
    }

    public void setFileStrs(List<FileList> fileStrs) {
        this.fileStrs = fileStrs;
    }

    public String getFileList() {
        return fileList;
    }

    public void setFileList(String fileList) {
        this.fileList = fileList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
