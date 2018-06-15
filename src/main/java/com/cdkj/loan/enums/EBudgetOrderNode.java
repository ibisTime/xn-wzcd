package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 预算单节点
 * @author: jiafr 
 * @since: 2018年6月13日 下午1:25:57 
 * @history:
 */
public enum EBudgetOrderNode {
    START_NODE("002_01", "填写预算单"), AREA_AUDIT("002_02", "区域总经理准入审核"), COMPANY_AUDIT(
            "002_03", "省分公司总经理审核"), SECOND_AUDIT("002_04", "准入审核二审"),
    
    BANK_LOAN_COMMIT("007_01","确认提交银行"),SEND_LOGISTICS("007_02","分公司内勤寄送银行材料"),COMPANY_COLLECTION_CHECK("007_03","总公司内勤收件并核查"),
    SEND_BANK_MATERIALS("007_04","总公司内勤寄送银行材料"),BANK_COLLECTION_CHECK("007_05","银行驻点收件并核查"),CONFIRM_RECEIVABLES("007_06","确认收款"),
    BRANCH_PENDING_PARTS("007_07","分公司内勤寄送银行材料待补件"),HEADQUARTERS_PENDING_PARTS("007_08","总公司内勤寄送银行材料待补件"),
    
    CAR_BANK_LOAN_COMMIT("008_01","确认提交银行"),CAR_SEND_LOGISTICS("008_02","分公司内勤寄送银行材料"),CAR_COMPANY_COLLECTION_CHECK("008_03","总公司内勤收件并核查"),
    CAR_SEND_BANK_MATERIALS("008_04","总公司内勤寄送银行材料"),CAR_BANK_COLLECTION_CHECK("008_05","银行驻点收件并核查"),CAR_PLEDGE_CONFIRM("008_06","抵押完成"),
    CAR_BRANCH_PENDING_PARTS("008_07","分公司内勤寄送银行材料待补件"),CAR_HEADQUARTERS_PENDING_PARTS("008_08","总公司内勤寄送银行材料待补件");

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
