package com.cdkj.loan.base;

import java.io.IOException;
import java.math.BigDecimal;

import org.unitils.UnitilsJUnit4;

import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.core.StringValidater;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) throws IOException {

        // a)服务费=(实际利率-基准利率)*贷款额
        // b)月供=((贷款额+服务费)*(1+基准利率))/贷款期数
        double rate = 0.00500000;// 基准利率
        String loanPeriods = "36";
        String loanAmount = "100000";
        String bankRate = "0.12";
        BigDecimal bankRateD = StringValidater.toBigDecimal(bankRate);
        BigDecimal rateD = new BigDecimal(rate);

        BigDecimal fwRate = bankRateD.subtract(rateD);
        Long poundage = AmountUtil.mul(StringValidater.toLong(loanAmount),
            fwRate.doubleValue());// 服务费
        Long amount = AmountUtil
            .mul((StringValidater.toLong(loanAmount) + poundage), (rate + 1));
        Long monthAmount = (long) AmountUtil.div(amount,
            (StringValidater.toInteger(loanPeriods) - 1));// 月供

        System.out.println(String.valueOf(monthAmount));
        System.out.println(String.valueOf(monthAmount));
        System.out.println(String.valueOf(poundage));
    }
}
