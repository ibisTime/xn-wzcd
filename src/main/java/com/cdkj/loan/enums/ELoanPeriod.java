package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum ELoanPeriod {

    ONE_YEAER("12", "一年"), TWO_YEAR("24", "两年"), THREE_YEAR("36", "三年");

    ELoanPeriod(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static Map<String, ELoanPeriod> getLoanPeriodMap() {
        Map<String, ELoanPeriod> map = new HashMap<String, ELoanPeriod>();
        for (ELoanPeriod loanPeriod : ELoanPeriod.values()) {
            map.put(loanPeriod.getCode(), loanPeriod);
        }
        return map;
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
