package com.cdkj.loan.dto.req;

/**
 * 新增档案存放位置
 * @author: jiafr 
 * @since: 2018年6月5日 下午5:59:25 
 * @history:
 */
public class XN632820Req {

    // 位置名称
    private String name;

    // 更新人(选填)
    private String updater;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
