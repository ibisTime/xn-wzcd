package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 垫资节点
 * @author: jiafr 
 * @since: 2018年6月15日 下午7:42:28 
 * @history:
 */
public enum EAdvanceFundNode {

    PARENT_CONFIRM("003_01", "确认用款单"), PARENT_AREA("003_02", "区域总经理审核"), PARENT_PROVINCE(
            "003_03", "省分公司总经理审核"), PARENT_MAKE_BILL("003_04", "总公司制单"), PARENT_CAR_DEALER(
            "003_05", "确认打款给车行"), PARENT_AGAIN("003_06", "重新确认用款单"),

    BRANCH_CONFIRM("004_01", "确认用款单"), BRANCH_AREA("004_02", "区域总经理审核"), BRANCH_PROVINCE(
            "004_03", "省分公司总经理审核"), BRANCH_MAKE_BILL("004_04", "分公司制单"), BRANCH_COMPANY(
            "004_05", "确认打款给分公司"), BRANCH_CAR_DEALER("004_06", "确认打款给车行"), BRANCH_AGAIN(
            "004_07", "重新确认用款单");

    public static Map<String, EAdvanceFundNode> getMap() {
        Map<String, EAdvanceFundNode> map = new HashMap<String, EAdvanceFundNode>();
        for (EAdvanceFundNode node : EAdvanceFundNode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    EAdvanceFundNode(String code, String value) {
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
