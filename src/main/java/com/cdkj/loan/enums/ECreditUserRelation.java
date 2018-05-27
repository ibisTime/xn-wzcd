package com.cdkj.loan.enums;

public enum ECreditUserRelation {

    SELF("1", "贷款人本人"), HUSBAND("2", "共还人"), WIFE("3", "担保人"), FATHER("4", "父亲"), MOTHER(
            "5", "母亲"), FATHERINLAW("6", "岳父"), MOTHERINLAW("7", "岳母"), FRIEND(
            "8", "朋友");

    ECreditUserRelation(String code, String value) {
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
