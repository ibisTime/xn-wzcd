package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:29:02 
 * @history:
 */
public enum EGeneratePrefix {

    ADVERTISE("AD", "广告"), DH("DH", "导航"), TRADE_ORDER("JY", "交易订单"), ARBITRATE(
            "ZC", "仲裁工单")

    , Account("A", "账户"), AJour("AJ", "账户流水"), EXCHANGE_CURRENCY("EC", "币种兑换"), HLORDER(
            "HL", "红蓝订单"), Charge("CZ", "充值订单"), Withdraw("QX", "取现订单"), BAOFOO_PAY_ORDER(
            "BFDF", "宝付代付订单"),

    Brand("B", "品牌"), Series("S", "车系"), Car("C", "车型"), Car_Order("COD",
            "购买意向"),

    CATEGORY("FL", "分类"), PRODUCT("CP", "产品"), PRODUCT_SPECS("PS", "产品"), ORDER(
            "DD", "订单"), PRODUCT_ORDER("CD", "产品订单"), PAY_GROUP("PG", "支付组号"), BANKCARD(
            "CD", "银行卡"),

    DEPARTMENT("DP", "部门"), REQBUDGET("RB", "请款预算单表"), CREDIT("C", "征信单"), CREDITUSER(
            "CU", "征信列表"), INSURANCECOMPANY("IC", "保险公司信息"), COLLECTBANKCARD(
            "CB", "收款账号"), CARDEALER("CD", "经销商信息表"), CARDEALERPROTOCOL("CDT",
            "经销商协议表"),

    BUDGET("BG", "预订单"), GPS("G", "GPS"), BANK("BA", "银行"), LOGISTICS("L",

    "资料传递"), BUDGETORDER("BO", "预算单"), LOAN_PRODUCT("LP", "贷款产品"), GPSAZ(
            "GPSAZ", "gps安装"), GPS_APPLY("GA", "GPS申领"), BUDGET_ORDER_FEE(
            "BOF", "准入单手续费"), BUDGET_ORDER_FEE_DETAIL("BOFD", "准入单手续费明细"),

    OVERDUEMENU("OM", "导入逾期名单"), NOTICE("N", "通知公告"), REGIME("R", "公司制度"), CompCategory(
            "CC", "库存类别"), CompProduct("COP", "品名"), RECRUITAPPLY("RA", "用人申请"), ARCHIVE(
            "AR", "人事档案"), SOCIAL_RELATION("SR", "社会关系"), ARCHIVE_LOCATION(
            "AL", "档案存放位置"),

    SOCIALRELATION("SR", "社会关系"), EmployApply("EA", "应聘登记"), WORK_EXPERIENCE(

    "WE", "工作经历"), CHECK_PROJECT("CP", "考核项目"), STORAGE_IN("SI", "入库"), STORAGE_OUT(
            "SO", "出库"), CONTRACT("HT", "合同管理"), ENTRYAPPLY("EA", "入职申请");

    public static Map<String, EGeneratePrefix> getMap() {
        Map<String, EGeneratePrefix> map = new HashMap<String, EGeneratePrefix>();
        for (EGeneratePrefix orderType : EGeneratePrefix.values()) {
            map.put(orderType.getCode(), orderType);
        }
        return map;
    }

    EGeneratePrefix(String code, String value) {
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
