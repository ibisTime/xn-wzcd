package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增档案存放位置
 * @author: jiafr 
 * @since: 2018年6月5日 下午5:59:25 
 * @history:
 */
public class XN632820Req {

    // 位置名称
    @NotBlank
    private String name;

    // 更新人(选填)
    @NotBlank
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
