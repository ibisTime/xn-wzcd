package com.cdkj.coin.dao.impl;

import com.cdkj.coin.base.ADAOTest;
import com.cdkj.coin.dao.ISYSDictDAO;
import com.cdkj.coin.dao.ITradeOrderDAO;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.unitils.spring.annotation.SpringBeanByType;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by tianlei on 2017/十一月/29.
 */
//classpath*:spring/applicationContext.xml
//        /WEB-INF/conf/spring/*-beans.xml

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class TradeOrderDAOImplTest {


    @Autowired
    private ITradeOrderDAO tradeOrderDAO;

    @Test
    public void selectedTotalTradeCount() throws Exception {

//        int a = 10;
////        TradeOrderDAOImpl tradeOrderDAO = new TradeOrderDAOImpl();
//        BigDecimal count = tradeOrderDAO.selectedTotalTradeCount("U201711212030187015235");
//        System.out.print(count);

    }

}