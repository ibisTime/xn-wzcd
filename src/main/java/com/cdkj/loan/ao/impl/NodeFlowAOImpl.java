package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.INodeFlowAO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.NodeFlow;

@Service
public class NodeFlowAOImpl implements INodeFlowAO {

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    public Paginable<NodeFlow> queryNodeFlowPage(int start, int limit,
            NodeFlow condition) {
        Paginable<NodeFlow> page = nodeFlowBO.getPaginable(start, limit,
            condition);
        for (NodeFlow nodeFlow : page.getList()) {
            initFile(nodeFlow);
        }
        return page;
    }

    @Override
    public List<NodeFlow> queryNodeFlowList(NodeFlow condition) {
        List<NodeFlow> list = nodeFlowBO.queryNodeFlowList(condition);
        for (NodeFlow nodeFlow : list) {
            initFile(nodeFlow);
        }
        return list;
    }

    @Override
    public NodeFlow getNodeFlow(String id) {
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlow(id);
        initFile(nodeFlow);
        return nodeFlow;
    }

    private void initFile(NodeFlow nodeFlow) {
        if (StringUtils.isNotBlank(nodeFlow.getFileList())) {
            String fileList = nodeFlow.getFileList();
            String[] fileArr = fileList.split(",");
            List<String> fileStrs = new ArrayList<String>();
            if (fileArr != null) {
                for (int i = 0; i < fileArr.length; i++) {
                    fileStrs.add(fileArr[i]);
                }
            }
            nodeFlow.setFileStrs(fileStrs);
        }
    }

    @Override
    public void doModifyFileList(String id, List<String> fileStrs) {
        String fileList = "";
        if (CollectionUtils.isNotEmpty(fileStrs)) {
            for (String file : fileStrs) {
                fileList += file + ",";
            }
            if (StringUtils.isNotBlank(fileList)) {
                fileList = fileList.substring(0, fileList.length() - 1);
            }
        }
        nodeFlowBO.refreshNodeFlow(id, fileList);
    }
}
