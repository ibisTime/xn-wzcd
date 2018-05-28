package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 预算单节点
 * @author: CYL 
 * @since: 2018年5月28日 下午8:31:51 
 * @history:
 */
public enum EBudgetOrderNode {
    START_NODE("002_01", "填写预算单"), AREA_AUDIT("002_02",
            "区域总经理准入审核"), COMPANY_AUDIT("002_03", "省分公司总经理审核"), TWO_AUDIT(
                    "002_04", "准入审核二审"), LOAN("002_05", "确认用款单");

    public static Map<String, EBudgetOrderNode> getMap() {
        Map<String, EBudgetOrderNode> map = new HashMap<String, EBudgetOrderNode>();
        for (EBudgetOrderNode node : EBudgetOrderNode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    EBudgetOrderNode(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
