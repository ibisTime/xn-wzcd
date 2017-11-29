package com.cdkj.coin.bo.impl;

import com.cdkj.coin.bo.ITradeOrderBO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by tianlei on 2017/十一月/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class TradeOrderBOImplTest {

    @Autowired
    ITradeOrderBO tradeOrderBO;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void contactBuySubmit() throws Exception {
    }

    @Test
    public void contactSellSubmit() throws Exception {
    }

    @Test
    public void buySubmit() throws Exception {
    }

    @Test
    public void sellSubmit() throws Exception {
    }

    @Test
    public void buyRefresh() throws Exception {
    }

    @Test
    public void sellRefresh() throws Exception {
    }

    @Test
    public void cancel() throws Exception {
    }

    @Test
    public void markPay() throws Exception {
    }

    @Test
    public void release() throws Exception {
    }

    @Test
    public void doBsComment() throws Exception {
    }

    @Test
    public void doSbComment() throws Exception {
    }

    @Test
    public void applyArbitrate() throws Exception {
    }

    @Test
    public void revokePay() throws Exception {
    }

    @Test
    public void arbitrateUnPass() throws Exception {
    }

    @Test
    public void queryTradeOrderList() throws Exception {
    }

    @Test
    public void getTradeOrder() throws Exception {
    }

    @Test
    public void getToSubmitTradeOrder() throws Exception {
    }

    @Test
    public void isExistOningOrder() throws Exception {
    }

    @Test
    public void checkUserHasUnFinishOrder() throws Exception {
    }

    @Test
    public void obtainUserStatistics() throws Exception {
    }

    @Test
    public void getUserTotalTradeCount() throws Exception {

        BigDecimal totalCount = this.tradeOrderBO.getUserTotalTradeCount("U201711212030187015235");
        System.out.print(totalCount);

    }

    @Test
    public void removeTradeOrder() throws Exception {
    }

    @Test
    public void removeDaiXiaDanOrders() throws Exception {
    }

}