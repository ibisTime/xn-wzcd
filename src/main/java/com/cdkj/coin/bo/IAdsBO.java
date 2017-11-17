package com.cdkj.coin.bo;

import java.math.BigDecimal;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.Ads;
import com.cdkj.coin.domain.Market;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsBO {

    //改变剩余金额
    public void changeLeftAmount(String adsCode, BigDecimal value);

    //下架广告
    public void xiaJiaAds(Ads adsSell);

    //上架广告
    public void shangJiaAds(String adsCode);

    //插入广告
    public void insertAdsSell(Ads adsSell);

    //草稿发布
    public void draftPublish(Ads adsSell);

    //广告详情
    public Ads adsSellDetail(String adsCode);

    //更新广告的市场价格
    public void refreshAllAdsMarketPrice(Market market);

    public Paginable<Ads> frontSellPage(Integer start, Integer limit,
                                        Ads condition);

    public Paginable<Ads> ossSellPage(Integer start, Integer limit,
                                      Ads condition);

}
