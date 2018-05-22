package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 角色节点
 * @author: hp 
 * @since: 2018年5月22日 下午11:43:35 
 * @history:
 */
public class SYSRoleNode extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 7757508097444907536L;

    // 序号
    private Long id;

    // 节点编号
    private String nodeCode;

    // 角色编号
    private String roleCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

}
