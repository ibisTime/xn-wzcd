package com.cdkj.loan.dto.req;

/**
 * 分页查询库存
 * @author: silver 
 * @since: 2018年6月5日 下午2:44:57 
 * @history:
 */
public class XN632765Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5933298866541905618L;

    // 产品
    private String productCode;

    // 类别
    private String categoryCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

}
