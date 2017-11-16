package com.cdkj.coin.bo;

import java.math.BigDecimal;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.Ads;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsBO {

    public void changeLeftAmount(String adsCode, BigDecimal value);

    public void xiaJiaAds(Ads adsSell);

    public void shangJiaAds(String adsCode);

    // ***************** 卖币广告方法 ************************ //
    public void insertAdsSell(Ads adsSell);

    public void sellDraftPublish(Ads adsSell);

    public Ads adsSellDetail(String adsCode);

    public Paginable<Ads> frontSellPage(Integer start, Integer limit,
                                        Ads condition);

    public Paginable<Ads> ossSellPage(Integer start, Integer limit,
                                      Ads condition);

}
