/**
 * @Title GoogleAuthAOImpl.java 
 * @Package com.cdkj.coin.ao.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年12月6日 下午4:42:29 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.IGoogleAuthAO;
import com.cdkj.coin.bo.IGoogleAuthBO;

/** 
 * @author: haiqingzheng 
 * @since: 2017年12月6日 下午4:42:29 
 * @history:
 */
@Service
public class GoogleAuthAOImpl implements IGoogleAuthAO {

    @Autowired
    private IGoogleAuthBO googleAuthBO;

    /** 
     * @see com.cdkj.coin.ao.IGoogleAuthAO#generateSecretKey()
     */
    @Override
    public String generateSecretKey() {
        return googleAuthBO.generateSecretKey();
    }

}
