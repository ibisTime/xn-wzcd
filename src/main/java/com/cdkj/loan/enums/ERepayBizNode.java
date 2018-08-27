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
    TO_REPAY("020_01", "还款中"), COMMIT_SETTLE("020_02", "提交结算单"), RISK_MANAGE_AUDIT(
            "020_03", "风控总监理审核"), FINANCE_CHECK("020_04", "财务审核"), CASH_REMIT(
            "020_05", "确认付款"), RELEASE_MORTGAGE_APPLY("020_06", "解除抵押申请"), RISK_INDOOR_CHECK(
            "020_07", "风控内勤审核"), RISK_MANAGER_CHECK("020_08", "风控经理审核"), MORTGAGE_PRINT(
            "020_09", "打印岗打印"), PHYSICAL_PARTS("020_10", "理件岗理件"), BANK_REC_LOGIC(
            "020_11", "寄送银行材料"), MORTGAGE_COMMIT_FILE("020_12", "驻行人员提交材料"), MORTGAGE_OVER(
            "020_13", "解除抵押完成"),

    // 收车流程To hold court
    TC_APPLY("021_01", "申请收车"), TC_COMPANY_MANAGE_CHECK("021_02", "分公司总经理审核"), TC_RISK_MANAGE_CHECK(
            "021_03", "风控经理审核"), TC_RISK_LEADER_CHECK("021_04", "风控总监审核"), TC_FINANCE_CHECK(
            "021_05", "财务经理审核"), TC_SURE_FK("021_06", "确认放款"), TC_RESULT_INPUT(
            "021_07", "录入收车结果"), TC_TO_HANDLE("021_08", "已录入待处理"), JUDGE(
            "021_09", "司法诉讼"),CASE_ADMISSIBILITY("021_10", "案件受理"), JUDGE_FINANCE_CHECK(
            "021_11", "财务审核"), CASHIER("021_12", "出纳打款"), SERVICE("021_13", "送达"),  SENTENCE(
            "021_14", "判决"),TAKE_EFFECT("021_15", "生效"),APPLY_IMPLEMENT("021_16","申请执行"),IMPLEMENT_ADMISSIBILITY(
            "021_17","案件受理"),AUCTION("021_18","拍卖"),NOTICE("021_19","公告"), JUDGE_RESULT_INPUT(
            "021_20", "诉讼结果录入"), RESULT_INPUT_AGAIN("021_21", "恢复执行"), FINANCE_SURE_RECEIPT(
            "021_22", "财务收款"),ADJUDICATION_DEADLINE("021_23","录入查封裁定到期时间"), LAWSUIT_FINISH(
            "021_24", "司法诉讼完成"), JUDGE_BAD("021_25", "坏账"), REDEEM_FINANCIAL_AUDIT(
            "021_26", "赎回财务审核"), SELLED_FINANCIAL_AUDIT("021_27", "转卖财务审核"),CLEARANCE_CASHIER(
            "021_28", "公司结清出纳打款"),COMPANY_CLEARANCE("021_29", "公司已结清");

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
