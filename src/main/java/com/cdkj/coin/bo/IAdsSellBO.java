package com.cdkj.coin.bo;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.AdsSell;
import com.cdkj.coin.enums.ETradeType;

import java.math.BigDecimal;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsSellBO {

    //买卖共用方法
    public void checkAdsBelongUser(String adsCode, String userIde);

    public void changeLeftAmount(String adsCode, BigDecimal value);

    // true 需要下架，false 不需要下架
    public boolean checkXiaJia(String adsCode);

    public void xiaJiaAds(String adsCode);

    public void shangJiaAds(String adsCode);

    // *****************  卖币广告方法 ************************ //
    public void insertAdsSell(AdsSell adsSell);
    public void sellDraftPublish(AdsSell adsSell);
    public AdsSell adsSellDetail(String adsCode);
    public Paginable<AdsSell> frontSellPage(Integer start, Integer limit, AdsSell condition);
    public Paginable<AdsSell> ossSellPage(Integer start, Integer limit, AdsSell condition);



}
