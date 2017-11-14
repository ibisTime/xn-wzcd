package com.cdkj.coin.bo.impl;

import com.cdkj.coin.bo.IAdsBO;
import com.cdkj.coin.bo.base.Page;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.dao.IAdsSellDAO;
import com.cdkj.coin.dao.IDisplayTimeDAO;
import com.cdkj.coin.domain.AdsDisplayTime;
import com.cdkj.coin.domain.AdsSell;
import com.cdkj.coin.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by tianlei on 2017/十一月/14.
 */
@Component
public class AdsBOImpl extends PaginableBOImpl implements IAdsBO {

    @Autowired
    IAdsSellDAO adsSellDAO;

    @Autowired
    IDisplayTimeDAO displayTimeDAO;

    @Override
    @Transactional
    public void insertAdsSell(AdsSell adsSell) {

        if (!adsSell.getDisplayTime().isEmpty()) {
            //有展示时间限制、先掺入展示时间
            for (AdsDisplayTime displayTime : adsSell.getDisplayTime()) {
                displayTime.setAdscode(adsSell.getCode());
                this.displayTimeDAO.insert(displayTime);
            }

        }

        int count = this.adsSellDAO.insert(adsSell);
        if (count != 1) {

            throw new BizException("xn0000", "发布失败");
        }

    }

    @Override
    public AdsSell adsSellDetail(String adsCode) {

        AdsSell condition = new AdsSell();
        condition.setCode(adsCode);
        return this.adsSellDAO.select(condition);

    }

    //    public AdsSell front
    @Override
    public Paginable<AdsSell> frontSellPage(Integer start, Integer limit, String coin) {

        AdsSell condition = new AdsSell();

        condition.setTradeCoin(coin);
        //传现在是 周几 java 周日 = 1，
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w == 0) {
            w = 7;
        }
        condition.setCurrentWeek(w);

        //传入现在是几点
        condition.setCurrentTime(cal.get(Calendar.HOUR_OF_DAY));

        //
        long totalCount = adsSellDAO.selectFrontTotalCount(condition);
        Paginable<AdsSell> page = new Page<AdsSell>(start, limit, totalCount);
        List<AdsSell> dataList = adsSellDAO.selectFrontList(condition, page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;

    }

    public Paginable<AdsSell> ossSellPage(Integer start, Integer limit, String coin) {

        AdsSell condition = new AdsSell();
        //
        long totalCount = adsSellDAO.selectTotalCount(condition);
        Paginable<AdsSell> page = new Page<AdsSell>(start, limit, totalCount);
        List<AdsSell> dataList = adsSellDAO.selectList(condition, page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;

    }

}
