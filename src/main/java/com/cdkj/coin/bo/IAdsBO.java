package com.cdkj.coin.bo;

import java.math.BigDecimal;
import java.util.List;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.Ads;
import com.cdkj.coin.domain.Market;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsBO {

    //增加可交易金额
    public void addLeftCount(String adsCode, BigDecimal value);

    //减小可交易金额
    public void cutLeftCount(String adsCode, BigDecimal value);

    // 下架广告
    public void xiaJiaAds(Ads adsSell);

//    // 上架广告
//    public void shangJiaAds(String adsCode);

    // 插入广告
    public void insertAdsSell(Ads adsSell);

    // 草稿发布
    public void draftPublish(Ads adsSell);

    // 广告详情
    public Ads adsDetail(String adsCode);

    // 更新广告的市场价格
//    public void refreshAllAdsMarketPriceAndTruePrice(Market market);

    public Paginable<Ads> frontPage(Integer start, Integer limit,
            Ads condition);

    public Paginable<Ads> ossPage(Integer start, Integer limit,
            Ads condition);

    public List<Ads> queryShangJiaAdsList();

    //刷新广告状态
    public void refreshStatus(String adsCode,boolean existOningOrder);

    //获取
    public long totalCountOfShangJiaAds(String userId,String tradeType);

    public long updateAdsPriceByPrimaryKey(Ads ads);


}
