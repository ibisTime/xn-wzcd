package com.cdkj.coin.bo.impl;

import com.cdkj.coin.bo.IAdsDisplayTimeBO;
import com.cdkj.coin.dao.IDisplayTimeDAO;
import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.AdsDisplayTime;
import com.cdkj.coin.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tianlei on 2017/十一月/15.
 */
@Component
public class AdsDisplayTimeBOImpl implements IAdsDisplayTimeBO {


    @Autowired
    IDisplayTimeDAO displayTimeDAO;

    @Override
    public void insertDisplayTime(AdsDisplayTime adsDisplayTime) {

        this.displayTimeDAO.insert(adsDisplayTime);

    }

    @Override
    public void check(AdsDisplayTime adsDisplayTime) {

        if (adsDisplayTime.getEndTime().compareTo(adsDisplayTime.getStartTime()) <= 0) {
            throw new BizException("xn000", "结束时间需要大于开始时间");
        }

    }

    @Override
    public void deleteAdsDisplayTimeByAdsCode(String adsCode) {

        this.displayTimeDAO.deleteByAdsCode(adsCode);

    }

}
