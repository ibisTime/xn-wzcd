package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ScopePeople;
import com.cdkj.loan.dto.req.XN632720ReqScope;

/**
 * 公告范围
 * @author: silver 
 * @since: 2018年6月7日 下午1:58:42 
 * @history:
 */
public interface IScopePeopleBO extends IPaginableBO<ScopePeople> {

    public void saveScopePeople(String refCode, String refType,
            List<XN632720ReqScope> scopePeople);

    public List<ScopePeople> queryScopePeopleList(ScopePeople condition);

}
