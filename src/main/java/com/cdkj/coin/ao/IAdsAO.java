package com.cdkj.coin.ao;

import com.cdkj.coin.domain.Ads;
import com.cdkj.coin.dto.req.XN625220Req;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsAO {

    public void insertAds(XN625220Req req);

    public Object adsDetail(String adsCode);

    public void draftPublish(XN625220Req req);

    public void shangJia(XN625220Req req);

    public void xiaJiaAds(String adsCode, String userId);

    public void checkXiajia(String adsCode);

    public Object frontSellPage(Integer start, Integer limit, Ads condition);

    public Object ossSellPage(Integer start, Integer limit, Ads condition);

}
