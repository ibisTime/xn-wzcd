package com.cdkj.coin.bo;

import com.cdkj.coin.domain.AdsDisplayTime;

/**
 * Created by tianlei on 2017/十一月/15.
 */
public interface IAdsDisplayTimeBO {

    void insertDisplayTime(AdsDisplayTime adsDisplayTime);
    void check(AdsDisplayTime adsDisplayTime);
}
