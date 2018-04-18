package com.cdkj.loan.bo;

import java.math.BigDecimal;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.HLOrder;
import com.cdkj.loan.domain.Jour;
import com.cdkj.loan.enums.EHLOrderStatus;

public interface IHLOrderBO extends IPaginableBO<HLOrder> {

    String applyOrder(Account account, Jour jour, BigDecimal applyAmount,
            String applyUser, String applyNote);

    void approveOrder(HLOrder order, EHLOrderStatus status, String approveUser,
            String approveNote);

    HLOrder getHLOrder(String code, String systemCode);

    List<HLOrder> queryHLOrderList(HLOrder condition);

}
