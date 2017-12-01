package com.cdkj.coin.bo.impl;

import com.cdkj.coin.bo.IAdsBO;
import com.cdkj.coin.domain.Ads;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tianlei on 2017/十二月/01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class AdsBOImplTest {

    @Autowired
    IAdsBO adsBO;

    @Test
    public void insertAdsSell() throws Exception {
    }

    @Test
    public void adsDetail() throws Exception {
    }

    @Test
    public void addLeftCount() throws Exception {
    }

    @Test
    public void cutLeftCount() throws Exception {
    }

    @Test
    public void xiaJiaAds() throws Exception {
    }

    @Test
    public void draftPublish() throws Exception {
    }

    @Test
    public void frontPage() throws Exception {
    }

    @Test
    public void ossPage() throws Exception {
    }

    @Test
    public void queryShangJiaAdsList() throws Exception {
    }

    @Test
    public void totalCountOfShangJiaAds() throws Exception {
    }

    @Test
    public void refreshStatus() throws Exception {

        String adsCode = "ADS201712011532328739009";
        this.adsBO.refreshStatus(adsCode,true);
        Ads ads = this.adsBO.adsDetail(adsCode);

    }

    @Test
    public void updateAdsPriceByPrimaryKey() throws Exception {
    }

}