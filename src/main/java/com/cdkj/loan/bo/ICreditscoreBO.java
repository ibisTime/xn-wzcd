package com.cdkj.loan.bo;

import java.math.BigDecimal;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.User;

public interface ICreditscoreBO extends IPaginableBO<User> {

    /**
     * 信用分变动
     * @param account 信用分账户
     * @param changeScore 变动的信用分，正数标识加信用分，负数表示减信用分
     * @param refNo 此次变动相关的业务编号
     * @param bizNote 备注说明
     * @create: 2018年5月16日 上午12:18:47 CYL
     * @history:
     */
    public void changeCreditscore(Account account, BigDecimal changeScore,
            String refNo, String bizNote);

}
