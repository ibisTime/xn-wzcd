package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 还款业务节点
 * @author: xieyj 
 * @since: 2018年6月8日 下午3:47:31 
 * @history:
 */
public enum ERepayBizNode {
    // 车贷
    TO_REPAY("003_01", "还款中"), QKCS_DEPART_CHECK("003_02", "清欠催收部审核"), BANK_CHECK(
            "003_03", "驻行人员审核"), MANAGER_CHECK("003_04", "总经理审核"), FINANCE_CHECK(
            "003_05", "财务审核"), RELEASE_MORTGAGE("003_06", "解除抵押"), SETTLED(
            "003_07", "已结清"), QKCSB_APPLY_TC("003_08", "清欠催收部申请拖车"), FINANCE_REMIT(
            "003_09", "财务打款"), QKCSB_TOTC("003_10", "清欠催收部拖车结果待录入"), QKCSB_TC_INPUT(
            "003_11", "清欠催收部拖车结果已录入"), JUDICIAL_LAWSUIT("003_13", "司法诉讼"), BAD_DEBT(
            "003_14", "坏账"), TEAN_BUY_OUT("003_15", "业务团队买断"), TEAM_RENT(
            "003_16", "业务团队租赁"), QKCSB_REDEEM_APPLY("003_17", "清欠催收部申请赎回"), RISK_MANAGER_CHECK(
            "003_18", "风控主管审核"), FINANCE_MANAGER_CHECK("003_19", "财务经理审核"), RISK_MANAGER_CHECK_NO(
            "003_20", "风控主管审核不通过"), FINANCE_MANAGER_CHECK_NO("003_21",
            "财务经理审核不通过"), REDEEM_SETTLED("003_22", "结清剩余还款"),

    // 商品分期的节点
    PRO_TO_REPAY("005_01", "还款中"), PRO_SETTLED("005_02", "已结清"), PRO_CONFIRM_SETTLE(
            "005_03", "确认结清"), PRO_BAD_DEBT("005_04", "确认不还");

    public static Map<String, ERepayBizNode> getMap() {
        Map<String, ERepayBizNode> map = new HashMap<String, ERepayBizNode>();
        for (ERepayBizNode node : ERepayBizNode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    private ERepayBizNode(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
