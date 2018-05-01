package com.cdkj.loan.dto.req;

/**
 * 修改运费
 * @author: xieyj 
 * @since: 2017年10月17日 下午1:08:14 
 * @history:
 */
public class XN808060Req {

    // 编号（必填）
    private String code;

    // 运费（必填）
    private String yunfei;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getYunfei() {
        return yunfei;
    }

    public void setYunfei(String yunfei) {
        this.yunfei = yunfei;
    }
}
