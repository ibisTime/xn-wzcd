package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.domain.Node;

/**
 * 节点角色
 * @author: jiafr 
 * @since: 2018年5月24日 下午12:22:04 
 * @history:
 */
public interface IRoleNodeAO {

    static final String DEFAULT_ORDER_COLUMN = "id";

    // 给角色分配节点
    public void assignNodeForRole(String roleCode, List<String> nodeList);

    // 根据角色编号查询节点列表
    public List<Node> queryNodeListByRoleCode(String roleCode);

    // 查询所有节点列表（包括当前角色）
    public List<Node> queryNodeListIncludeCurRoleCode(String roleCode);

}
