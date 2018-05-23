package com.cdkj.loan.enums;

/**
 * 请款预算单节点
 * @author: CYL 
 * @since: 2018年5月23日 上午10:57:01 
 * @history:
 */
public enum EReqBudgetNode {

    STARTNODE("005_00", "开始节点"), APPLY("005_01", "提交请款预算单"), AUDIT("005_02",
            "财务经理审核"), CREDIT("005_03", "确认放款"), REFILL("005_04",
                    "重新填写请款预算单"), ALREADY_CREDIT("005_05",
                            "已放款"), COLLECTION("005_06", "财务确认收回预算款");

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
