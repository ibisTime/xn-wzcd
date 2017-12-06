package com.cdkj.coin.bo;

import com.cdkj.coin.domain.CurrencyRate;
import com.cdkj.coin.enums.ECurrency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tianlei on 2017/十二月/05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class ICurrencyRateBOTest {

    @Autowired
    ICurrencyRateBO currencyRateBO;

    @Test
    public void currencyRateByCurrency() throws Exception {

        CurrencyRate currencyRate = this.currencyRateBO.currencyRateByCurrency(ECurrency.CNY.getCode());
        int a = 10;
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void allCurrencyRate() throws Exception {
    }

}