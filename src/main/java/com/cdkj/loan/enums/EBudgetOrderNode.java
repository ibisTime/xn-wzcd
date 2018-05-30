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
    WRITE_BUDGET_ORDER("002_01", "填写准入申请单"), RISK_APPROVE("002_02",
            "风控专员审核"), RISK_CHARGE_APPROVE("002_03", "风控主管审核"), AGAIN_WRITE(
                    "002_04",
                    "重新填写准入申请单"), INTERVIEW("002_05", "面签"), BIZ_CHARGE_APPROVE(
                            "002_06", "业务总监审核"), ADVANCEFUND("002_07",
                                    "财务垫资"), AGAIN_INTERVIEW("002_08", "重新面签"),

    GPSAZ("002_09", "业务团队安装GPS"), GPSMANAGERAPPROVE("002_10",
            "GPS管理员审核"), AGAINGPSAZ("002_12", "业务团队重新安装GPS"), CARSETTLE(
                    "002_11", "业务团队车辆落户"), DHAPPROVEDATA("002_13",
                            "业务贷后审核材料"), AGAINGPSA1Z("002_14", "业务团队重新安装GPS");

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
