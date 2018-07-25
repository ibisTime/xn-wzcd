package com.cdkj.loan.dto.res;

import java.util.List;

import com.cdkj.loan.domain.AdvanceFund;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月19日 下午11:31:38 
 * @history:
 */
public class XN632188Res {

    // 待垫资总金额（制单时通过审核的所有垫资单相加总金额 或 确认打款给分公司时通过制单的的所有垫资单相加的总金额）
    private String totalAdvanceFund;

    // 已垫资金额（今天请款预算单的金额）
    private String hasAdvanceFund;

    // 未垫资金额
    private String unAdvanceFund;

    // 垫资单列表
    private List<AdvanceFund> advanceFundlist;

    public String getTotalAdvanceFund() {
        return totalAdvanceFund;
    }

    public void setTotalAdvanceFund(String totalAdvanceFund) {
        this.totalAdvanceFund = totalAdvanceFund;
    }

    public String getHasAdvanceFund() {
        return hasAdvanceFund;
    }

    public void setHasAdvanceFund(String hasAdvanceFund) {
        this.hasAdvanceFund = hasAdvanceFund;
    }

    public String getUnAdvanceFund() {
        return unAdvanceFund;
    }

    public void setUnAdvanceFund(String unAdvanceFund) {
        this.unAdvanceFund = unAdvanceFund;
    }

    public List<AdvanceFund> getAdvanceFundlist() {
        return advanceFundlist;
    }

    public void setAdvanceFundlist(List<AdvanceFund> advanceFundlist) {
        this.advanceFundlist = advanceFundlist;
    }

}
