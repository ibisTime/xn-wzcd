package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 代偿还款计划单节点
 * @author: silver 
 * @since: 2018年6月15日 下午4:25:47 
 * @history:
 */
public enum EReplaceRepayPlanNode {

    TO_RISK_MANAGE_APPROVE("013_01", "代偿申请，待风控经理审核"), RISK_MANAGE_APPROVE_YES("013_02","风控经理审核通过，待分公司总经理审核"), 
    RISK_MANAGE_APPROVE_NO("013_03", "风控经理审核不通过"), SUBCOMP_APPROVE_YES("013_04", "分公司总经理审核通过，待风控总监审核"), 
    SUBCOMP_APPROVE_NO("013_05", "分公司总经理审核不通过"), RISK_CHIEF_APPROVE_YES("013_06", "风控总监审核通过，待财务经理审核"), 
    RISK_CHIEF_APPROVE_NO("013_07", "风控总监审核不通过"), FINANCE_APPROVE_YES("013_08", "财务经理审核通过，待确认放款"), 
    FINANCE_APPROVE_NO("013_09", "财务经理审核不通过"), DONE("013_010", "确认放款完成");

    public static Map<String, EReplaceRepayPlanNode> getBizTypeMap() {
        Map<String, EReplaceRepayPlanNode> map = new HashMap<String, EReplaceRepayPlanNode>();
        for (EReplaceRepayPlanNode bizType : EReplaceRepayPlanNode.values()) {
            map.put(bizType.getCode(), bizType);
        }
        return map;
    }

    EReplaceRepayPlanNode(String code, String value) {
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
