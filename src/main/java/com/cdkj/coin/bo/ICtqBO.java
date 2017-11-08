/**
 * @Title ICtqBO.java 
 * @Package com.cdkj.coin.bo 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月7日 下午1:54:35 
 * @version V1.0   
 */
package com.cdkj.coin.bo;

import java.util.List;

/** 
 * @author: haiqingzheng 
 * @since: 2017年11月7日 下午1:54:35 
 * @history:
 */
public interface ICtqBO {
    // 上传地址
    public void uploadAddress(String address, String type);

    // 交易确认
    public void confirm(List<String> hashList);
}
