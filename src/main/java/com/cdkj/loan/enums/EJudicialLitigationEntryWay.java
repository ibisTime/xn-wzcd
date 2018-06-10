package com.cdkj.loan.enums;

/**
 * 司法诉讼方式
 * @author: CYL 
 * @since: 2018年6月10日 下午7:31:28 
 * @history:
 */
public enum EJudicialLitigationEntryWay {

    BAD_DEBT("0", "坏账"), TEAN_BUY_OUT("1", "业务团队买断"), TEAM_RENT("2", "业务团队租赁");

    EJudicialLitigationEntryWay(String code, String value) {
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
