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
            "002_05", "重新填写预算单"),

    BANK_LOAN_COMMIT("007_01", "确认提交银行"), SEND_LOGISTICS("007_02",
            "分公司内勤寄送银行材料"), COMPANY_COLLECTION_CHECK("007_03", "总公司内勤收件并核查"), SEND_BANK_MATERIALS(
            "007_04", "总公司内勤寄送银行材料"), BANK_COLLECTION_CHECK("007_05",
            "银行驻点收件并核查"), CONFIRM_RECEIVABLES("007_06", "确认收款"), BRANCH_PENDING_PARTS(
            "007_07", "分公司内勤寄送银行材料待补件"), HEADQUARTERS_PENDING_PARTS("007_08",
            "总公司内勤寄送银行材料待补件"),

    CAR_BANK_LOAN_COMMIT("008_01", "确认提交银行"), CAR_SEND_LOGISTICS("008_02",
            "分公司内勤寄送银行材料"), CAR_COMPANY_COLLECTION_CHECK("008_03", "总公司内勤收件并核查"), CAR_SEND_BANK_MATERIALS(
            "008_04", "总公司内勤寄送银行材料"), CAR_BANK_COLLECTION_CHECK("008_05",
            "银行驻点收件并核查"), CAR_PLEDGE_CONFIRM("008_06", "抵押完成"), CAR_BRANCH_PENDING_PARTS(
            "008_07", "分公司内勤寄送银行材料待补件"), CAR_HEADQUARTERS_PENDING_PARTS(
            "008_08", "总公司内勤寄送银行材料待补件"),

    CAR_FEN_BANK_LOAN_COMMIT("009_01", "确认提交银行"), SENDING_CONTRACT("009_02",
            "总公司准备并寄送合同"), FEN_COMPANY_COLLECTION_CHECK("009_03", "分公司内勤收件并核查"), FEN_CAR_SEND_LOGISTICS(
            "009_04", "分公司准备并寄送抵押材料"), HEADQUARTERS_CAR_COMPANY_COLLECTION_CHECK(
            "009_05", "总公司内勤收件并核查"), HEADQUARTERS_CAR_SEND_BANK_MATERIALS(
            "009_06", "总公司内勤寄送银行材料"), CAR_FEN_BANK_COLLECTION_CHECK("009_07",
            "银行驻点收件并核查"),CAR_FEN_PLEDGE_CONFIRM("009_08", "抵押完成"), HEADQUARTERS_SEND_CONTRACT("009_09", "总公司寄送合同待补件"), FEN_CAR_BRANCH_PENDING_PARTS(
            "009_10", "分公司内勤寄送银行材料待补件"), HEADQUARTERS_CAR_PENDING_PARTS(
            "009_11", "总公司内勤寄送银行材料待补件"),

    PENDING_FILE("010_01", "待入档"), ALREADY_FILE("010_02", "已入档");

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
