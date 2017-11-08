/**
 * @Title CtqBOImpl.java 
 * @Package com.cdkj.coin.bo.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月7日 下午1:56:29 
 * @version V1.0   
 */
package com.cdkj.coin.bo.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.ICtqBO;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.dto.req.XN616000Req;
import com.cdkj.coin.dto.req.XN616020Req;
import com.cdkj.coin.http.BizConnecter;

/** 
 * @author: haiqingzheng 
 * @since: 2017年11月7日 下午1:56:29 
 * @history:
 */
@Component
public class CtqBOImpl implements ICtqBO {

    /** 
     * @see com.cdkj.coin.bo.ICtqBO#uploadAddress(java.lang.String, java.lang.String)
     */
    @Override
    public void uploadAddress(String address, String type) {
        XN616000Req req = new XN616000Req();
        req.setAddress(address);
        req.setType(type);
        BizConnecter.getBizData("616000", JsonUtil.Object2Json(req));
    }

    @Override
    public void confirm(List<String> hashList) {
        XN616020Req req = new XN616020Req();
        req.setHashList(hashList);
        BizConnecter.getBizData("616020", JsonUtil.Object2Json(req));
    }
}
