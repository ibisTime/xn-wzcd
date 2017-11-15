package com.cdkj.coin.bo;

import java.math.BigDecimal;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.AdsSell;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsSellBO {

    public void changeLeftAmount(String adsCode, BigDecimal value);

    public void xiaJiaAds(AdsSell adsSell);

    public void shangJiaAds(String adsCode);

    // ***************** 卖币广告方法 ************************ //
    public void insertAdsSell(AdsSell adsSell);

    public void sellDraftPublish(AdsSell adsSell);

    public AdsSell adsSellDetail(String adsCode);

    public Paginable<AdsSell> frontSellPage(Integer start, Integer limit,
            AdsSell condition);

    public Paginable<AdsSell> ossSellPage(Integer start, Integer limit,
            AdsSell condition);

}
