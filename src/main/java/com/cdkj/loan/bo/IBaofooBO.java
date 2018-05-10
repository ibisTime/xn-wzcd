/**
 * @Title IBaofooBO.java 
 * @Package com.std.account.bo 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年9月13日 下午3:43:57 
 * @version V1.0   
 */
package com.cdkj.loan.bo;

import com.cdkj.loan.baofoo.BaofooResult;
import com.cdkj.loan.baofoo.CompanyChannel;

/** 
 * @author: haiqingzheng 
 * @since: 2017年9月13日 下午3:43:57 
 * @history:
 */
public interface IBaofooBO {

    // 代扣
    public BaofooResult withhold(String transId, String bankCode,
            String accountNo, String idNo, String realName, String mobile,
            Long transAmount, CompanyChannel companyChannel);

}
