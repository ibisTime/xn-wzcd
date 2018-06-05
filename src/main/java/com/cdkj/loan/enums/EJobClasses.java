package com.cdkj.loan.enums;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月5日 下午3:50:09 
 * @history:
 */
public enum EJobClasses {

    BG_CLASSES("BGC", "办公班次"), SJ_CLASSES("SJC", "设计班次"), BF_CLASSES("BFC",
            "版房班次"), ZT_CLASSES("ZTC", "展厅班次"), BA_CLASSES("BAC", "保安班次"), KF_CLASSES(
            "KFC", "客服班次"), SPBSJ_CLASSES("SPC", "商品部司机"), CGBSJ_CLASSES("CGC",
            "采购部司机"), XZSJ_CLASSES("XZC", "行政司机"), SJBWY_CLASSES("SJC", "设计部文员"), QJG_CLASSES(
            "QJC", "清洁工班次"), DD_CLASSES("DDC", "督导班次");

    EJobClasses(String code, String value) {
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
