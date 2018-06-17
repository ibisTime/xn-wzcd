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

    // 车贷正常流程
    TO_REPAY("020_01", "还款中"), COMMIT_SETTLE("020_02", "提交结算单"), FINANCE_CHECK(
            "020_03", "财务审核"), FINANCE_CHECK_NO("020_04", "财务审核不通过"), CASH_REMIT(
            "020_05", "出纳打款"), RELEASE_MORTGAGE_APPLY("020_06", "解除抵押申请"), RISK_INDOOR_CHECK(
            "020_07", "风控内勤审核"), RISK_INDOOR_CHECK_NO("020_08", "风控内勤审核不通过"), RISK_MANAGER_CHECK(
            "020_09", "风控经理审核"), RISK_MANAGER_CHECK_NO("020_10", "风控经理审核不通过"), BANK_REC_LOGIC(
            "020_11", "驻行人员收件"), MORTGAGE_INPUT("020_12", "驻行人员回录抵押"), MORTGAGE_OVER(
            "020_13", "抵押完成"),

    // 拖车流程
    TC_APPLY("021_01", "申请拖车"), TC_RISK_MANAGE_CHECK("021_02", "拖车风控经理审核"), TC_RISK_MANAGE_CHECK_NO(
            "021_03", "风控经理审核不通过"), TC_COMPANY_MANAGE_CHECK("021_04",
            "分公司总经理审核"), TC_COMPANY_MANAGE_CHECK_NO("021_05", "分公司总经理审核不通过"), TC_RISK_LEADER_CHECK(
            "021_06", "风控总监审核"), TC_RISK_LEADER_CHECK_NO("021_07", "风控总监审核不通过"), TC_FINANCE_CHECK(
            "021_08", "财务经理审核"), TC_FINANCE_CHECK_NO("021_09", "财务经理审核不通过"), TC_SURE_FK(
            "021_10", "确认放款"), TC_RESULT_INPUT("021_11", "录入拖车结果"), TC_TO_HANDLE(
            "021_12", "已录入待处理"), REDEEM("021_13", "已赎回"), SELLED("021_14", "出售"), JUDGE(
            "021_15", "司法诉讼"), JUDGE_FOLLOW("021_16", "诉讼跟进"), JUDGE_RESULT_INPUT(
            "021_17", "诉讼结果录入"), FINANCE_SURE_RECEIPT("021_18", "财务确认收款"),

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
