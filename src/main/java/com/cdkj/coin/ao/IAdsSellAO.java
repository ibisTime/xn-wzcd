package com.cdkj.coin.ao;

import com.cdkj.coin.domain.AdsSell;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.dto.res.BooleanRes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsSellAO {

    public void insertAds(XN625220Req req);

    public void draftPublish(XN625220Req req);

    public Object adsDetail(String adsCode);

    public void xiaJiaAds(String adsCode, String userId);

    public Object frontSellPage(Integer start, Integer limit, AdsSell condition);

    public Object ossSellPage(Integer start, Integer limit,AdsSell condition);

}
