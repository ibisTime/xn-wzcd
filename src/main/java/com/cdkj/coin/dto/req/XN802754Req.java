package com.cdkj.coin.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 广播
 * @author: xieyj 
 * @since: 2017年5月12日 上午10:02:36 
 * @history:
 */
public class XN802754Req {

    // 取现订单编号(必填)
    @NotEmpty
    private List<String> codeList;

    // 操作人(必填)
    @NotBlank
    private String approveUser;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }

}
