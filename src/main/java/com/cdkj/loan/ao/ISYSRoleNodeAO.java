package com.cdkj.loan.ao;

import java.util.List;

public interface ISYSRoleNodeAO {

    static final String DEFAULT_ORDER_COLUMN = "id";

    // 给角色分配节点
    public void assignNodeForRole(String roleCode, List<String> nodeList);

}
