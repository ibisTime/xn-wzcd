package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 请款预算单节点
 * @author: CYL 
 * @since: 2018年5月23日 上午10:57:01 
 * @history:
 */
public enum EReqBudgetNode {

    APPLY("005_01", "提交请款预算单"), LOAN("005_02", "确认放款"), ALREADY_CREDIT(
            "005_03", "已放款"),BACK_RECORD("005_04","打款回录"), COLLECTION(
            "005_05", "财务确认收回预算款"), HAS_COLLECTION("005_06", "已收回预算款");

    public static Map<String, EReqBudgetNode> getMap() {
        Map<String, EReqBudgetNode> map = new HashMap<String, EReqBudgetNode>();
        for (EReqBudgetNode node : EReqBudgetNode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    EReqBudgetNode(String code, String value) {
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
