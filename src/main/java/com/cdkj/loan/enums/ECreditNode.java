package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 征信节点
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:01:56 
 * @history:
 */
public enum ECreditNode {

    START("001_01", "填写征信单"), LRZXY("001_02", "录入征信源结果"), PRIMARYAUDIT(
            "001_03", "征信初审"), FIRSTAUDIT("001_04", "征信一审"), MODIFY("001_05",
            "重新上传征信资料"), ACHIEVE("001_06", "征信完成");

    public static Map<String, ECreditNode> getMap() {
        Map<String, ECreditNode> map = new HashMap<String, ECreditNode>();
        for (ECreditNode node : ECreditNode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    private ECreditNode(String code, String value) {
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
