package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 列表查询返点明细 通过汽车经销编号和返点账号编号
 * @author: jiafr 
 * @since: 2018年6月18日 下午5:32:52 
 * @history:
 */
public class XN632297Req {

    // 经销商返点账号编号
    private String accountCode;

    // 汽车经销商编号
    @NotBlank
    private String carDealerCode;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

}
