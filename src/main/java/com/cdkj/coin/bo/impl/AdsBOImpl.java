package com.cdkj.coin.bo.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.coin.bo.IAdsBO;
import com.cdkj.coin.bo.base.Page;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.dao.IAdsSellDAO;
import com.cdkj.coin.domain.AdsSell;
import com.cdkj.coin.enums.EAdsStatus;
import com.cdkj.coin.exception.BizException;

/**
 * Created by tianlei on 2017/十一月/14.
 */
@Component
public class AdsBOImpl extends PaginableBOImpl implements IAdsBO {

    @Autowired
    IAdsSellDAO adsSellDAO;

    @Override
    @Transactional
    public void insertAdsSell(AdsSell adsSell) {

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

    @Override
    public void changeLeftAmount(String adsCode, BigDecimal value) {

        AdsSell condition = new AdsSell();
        condition.setCode(adsCode);
        AdsSell adsSell = this.adsSellDAO.select(condition);

        if (adsSell == null) {
            throw new BizException("xn", "广告不存在");
        }
        adsSell.setLeftAmount(adsSell.getLeftAmount().add(value));
        // 校验余额，
        int count = this.adsSellDAO.updateByPrimaryKeySelective(adsSell);
        if (count != 1) {
            throw new BizException("xn", "更新失败");
        }

    }

    @Override
    public void xiaJiaAds(AdsSell adsSell) {

        adsSell.setStatus(EAdsStatus.XIA_JIA.getCode());
        //todo 释放剩余冻结金额
        int count = this.adsSellDAO.updateByPrimaryKeySelective(adsSell);
        if (count != 1) {
            throw new BizException("xn000000", "下架失败");
        }

    }

    @Override
    public void shangJiaAds(String adsCode) {

        AdsSell condition = new AdsSell();
        condition.setCode(adsCode);
        condition.setStatus(EAdsStatus.SHANG_JIA.getCode());
        int count = this.adsSellDAO.updateByPrimaryKeySelective(condition);
        if (count != 1) {
            throw new BizException("xn000000", "下架失败");
        }

    }

    @Override
    public void sellDraftPublish(AdsSell adsSell) {

        this.adsSellDAO.updateByPrimaryKey(adsSell);

    }

    // 前端分页
    @Override
    public Paginable<AdsSell> frontSellPage(Integer start, Integer limit,
            AdsSell condition) {

        // 只查正在上架中的
        condition.setStatus(EAdsStatus.SHANG_JIA.getCode());
        // 传现在是 周几 java 周日 = 1，
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w == 0) {
            w = 7;
        }
        condition.setCurrentWeek(w);

        // 传入现在是几点
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        condition.setCurrentTime(1.0 * hour + minute * 1.0 / 60);

        //
        long totalCount = adsSellDAO.selectFrontTotalCount(condition);
        Paginable<AdsSell> page = new Page<AdsSell>(start, limit, totalCount);
        List<AdsSell> dataList = adsSellDAO.selectFrontList(condition,
            page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;

    }

    // oss分页
    @Override
    public Paginable<AdsSell> ossSellPage(Integer start, Integer limit,
            AdsSell condition) {

        //
        long totalCount = adsSellDAO.selectTotalCount(condition);
        Paginable<AdsSell> page = new Page<AdsSell>(start, limit, totalCount);
        List<AdsSell> dataList = adsSellDAO.selectList(condition,
            page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;

    }

}
