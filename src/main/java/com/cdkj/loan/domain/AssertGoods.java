package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 办公物品列表
* @author: jiafr 
* @since: 2018-06-06 19:37:49
* @history:
*/
public class AssertGoods extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 办公用品编号
	private String assertCode;

	// 品名
	private String productCode;

	// 规格
	private String mode;

	// 申请数量
	private String quantity;

	// 出库价格
	private String price;

	// 备注
	private String remark;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setAssertCode(String assertCode) {
		this.assertCode = assertCode;
	}

	public String getAssertCode() {
		return assertCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}