package com.cdkj.coin.bo;

import com.cdkj.coin.domain.AdsDisplayTime;

/**
 * Created by tianlei on 2017/十一月/15.
 */
public interface IAdsDisplayTimeBO {

    //插入展示时间
    void insertDisplayTime(AdsDisplayTime adsDisplayTime);

    //删除广告的展示时间
    void deleteAdsDisplayTimeByAdsCode(String adsCode);
}
