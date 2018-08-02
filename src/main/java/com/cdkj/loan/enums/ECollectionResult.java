package com.cdkj.loan.enums;

/**
 * 催收结果
 * @author: CYL 
 * @since: 2018年8月2日 下午5:42:07 
 * @history:
 */
public enum ECollectionResult {
    ALL_REPAY("all_repay", "全额还款"), PART_REPAY("part_repay","部分还款"), 
        REJUST_REPAY("rejust_repay","拒绝还款"), TAKE_CAR("take_car", "收车处理"),
        JUDGE("judge","诉讼"), REPLACE_REPAY("replace_repay", "代偿");

    ECollectionResult(String code, String value) {
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
