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
            "002_03", "省分公司总经理审核"), SECOND_AUDIT("002_04", "准入审核二审"), FILL_AGAIN(
            "002_05", "重新填写预算单"), ADVANCE_FUND_AUDIT("002_06", "垫资审核中"),

    SALESMAN_SEND_LOGISTICS("007_01A", "业务员准备并寄送银行材料给总公司"), BRANCH_SEND_LOGISTICS(
            "007_01B", "分公司内勤寄送银行材料给总公司"), HEADQUARTERS_SEND_PRINT("007_02",
            "总公司寄送银行材料"), LOAN_PRINT("007_03", "打印岗打印"), BANK_LOAN_COLLATEPOST_COLLATE(
            "007_04", "理件岗理件"), SEND_BANK_MATERIALS("007_05", "寄件岗寄件"), BANK_LOAN_COMMIT(
            "007_06", "确认提交银行"), BANK_POINT_PUSH_LOAN_LIST("007_07",
            "银行驻点推送已放款名单"), CONFIRM_RECEIVABLES("007_08", "财务确认收款"), BANK_LOAN_ACHIEVE(
            "007_09", "还款中"),

    LOCAL_PRINTPOST_PRINT("008_01", "打印岗打印"), LOCAL_COLLATEPOST_COLLATE(
            "008_02", "理件岗理件"), LOCAL_SENDPOST_SEND_BANK("008_03",
            "寄件岗寄送材料给银行驻点"), LOCAL_SUBMIT_BANK("008_04", "提交银行"), TODO_LOCAL_PLEDGE_ACHIEVE(
            "008_05", "待提交抵押完成"), LOCAL_PLEDGE_ACHIEVE("008_06", "车辆抵押完成"),

    OUT_BANKPOINT_SEND_PARENT("009_01", "银行驻点发送抵押合同给总公司"), OUT_PARENT_SEND_BRANCH(
            "009_02", "总公司寄送合同给分公司"), OUT_PLEDGE_BEGIN("009_03", "抵押开始"), TODO_OUT_PLEDGE_ACHIEVE(
            "009_04", "待提交抵押完成"), OUT_BRANCH_SEND_PARENT("009_05",
            "分公司寄送抵押材料给总公司"), OUT_COLLATEPOST_COLLATE("009_06", "理件岗理件"), OUT_SENDPOST_SEND_BANK(
            "009_07", "寄件岗寄送材料给银行驻点"), OUT_SUBMIT_BANK("009_08", "提交银行"), OUT_PLEDGE_ACHIEVE(
            "009_09", "车辆抵押完成"),

    INVOICE_MISMATCH_APPLY("011_01", "发票不匹配申请"), APPROVE_APPLY("011_02",
            "发票不匹配审核"), TWO_APPROVE_APPLY("011_03", "发票不匹配二审"), FINANCE_CONFIRM(
            "011_04", "财务确认"),

    TO_APPLY_CANCEL("012_00", "待作废"), APPLY_CANCEL("012_01", "申请作废"), APPROVE_CANCEL(
            "012_02", "审核"), FINANCE_CONFIRM_RECEIVABLES("012_03", "财务确认收款"), CANCEL_APPLY_END(
            "012_04", "已作废");

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
