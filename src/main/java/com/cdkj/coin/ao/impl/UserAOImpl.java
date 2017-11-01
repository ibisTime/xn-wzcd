/**
 * @Title UserAO.java 
 * @Package com.cdkj.ylq.ao.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年8月21日 下午9:22:32 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.common.RandomUtil;
import com.cdkj.coin.dto.res.XN805041Res;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.eth.EthAccount;
import com.cdkj.coin.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2017年8月21日 下午9:22:32 
 * @history:
 */
@Service
public class UserAOImpl implements IUserAO {
    @Autowired
    private IUserBO userBO;

    @Autowired
    private IEthAddressBO ethAddressBO;

    /** 
     * @see com.cdkj.coin.ao.IUserAO#doRegister(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public XN805041Res doRegister(String mobile, String loginPwd,
            String userReferee, String userRefereeKind, String smsCaptcha) {
        // 创建一个新地址
        String ethPwd = RandomUtil.generate6();
        String ethName = mobile;
        EthAccount account = new EthAccount();
        String accountId = account.createAccount(ethName, ethPwd, null);
        System.out.println("以太坊账户创建成功:" + accountId);
        if (StringUtils.isBlank(accountId)) {
            throw new BizException("xn625000", "以太坊账户创建失败，请检查节点是否正常！");
        }
        // 注册用户
        XN805041Res res = userBO.doCustomerRegister(mobile, loginPwd,
            userReferee, userRefereeKind, smsCaptcha);
        // 落地用户跟以太坊地址的对应关系
        if (res != null && StringUtils.isNotBlank(res.getUserId())) {
            ethAddressBO.saveEthAddress(EEthAddressType.D, res.getUserId(),
                accountId, ethPwd);
        }
        return res;
    }
}
