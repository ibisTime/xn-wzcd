/**
 * @Title UserAO.java 
 * @Package com.cdkj.ylq.ao.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年8月21日 下午9:22:32 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.dto.res.XN805041Res;

/** 
 * @author: haiqingzheng 
 * @since: 2017年8月21日 下午9:22:32 
 * @history:
 */
@Service
public class UserAOImpl implements IUserAO {
    @Autowired
    private IUserBO userBO;

    /** 
     * @see com.cdkj.coin.ao.IUserAO#doRegister(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public XN805041Res doRegister(String mobile, String loginPwd,
            String userReferee, String userRefereeKind, String smsCaptcha) {
        // 注册
        XN805041Res res = userBO.doCustomerRegister(mobile, loginPwd,
            userReferee, userRefereeKind, smsCaptcha);
        return res;
    }

}
