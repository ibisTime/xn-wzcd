package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.dto.req.XN802010Req;
import com.cdkj.loan.dto.req.XN802012Req;
import com.cdkj.loan.dto.req.XN802013Req;

/**
 * @author: xieyj 
 * @since: 2017年6月7日 下午10:34:08 
 * @history:
 */
@Component
public interface IBankcardAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBankcard(XN802010Req req);

    public void dropBankcard(String code);

    public void editBankcard(XN802012Req req);

    public void editBankcard(XN802013Req req);

    public Paginable<Bankcard> queryBankcardPage(int start, int limit,
            Bankcard condition);

    public List<Bankcard> queryBankcardList(Bankcard condition);

    public Bankcard getBankcard(String code);

}
