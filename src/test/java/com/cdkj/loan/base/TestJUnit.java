package com.cdkj.loan.base;

import java.io.IOException;
import java.math.BigDecimal;

import org.unitils.UnitilsJUnit4;

import com.cdkj.loan.core.StringValidater;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) throws IOException {

        String loanPeriods = "36";
        String loanAmount = "77000000";
        String bankRate = "0.0619";
        String BenchmarkRate = "0.05";
        String surcharge = "1";

        BigDecimal amountB = StringValidater.toBigDecimal(loanAmount);
        BigDecimal periodsB = StringValidater.toBigDecimal(loanPeriods);
        // 1.首期本金 = 贷款额- (2) *（期数-1）
        // 2.每期本金=贷款额/期数
        BigDecimal annualPrincipal = amountB.divide(periodsB, 0, 1);// 每期本金
        annualPrincipal = annualPrincipal.divide(new BigDecimal(1000), 0, 1);// 向下取整
        annualPrincipal = annualPrincipal.multiply(new BigDecimal(1000));

        BigDecimal initialPrincipal = amountB.subtract(
            annualPrincipal.multiply(periodsB.subtract(new BigDecimal("1"))));// 首期本金

        // 手续费=贷款额*基准利率
        // 3.首期=手续费-（4）*（期数-1）
        // 4.每期=(2)*基准利率
        BigDecimal bankRateD = StringValidater.toBigDecimal(bankRate);
        BigDecimal rateD = new BigDecimal(BenchmarkRate);
        BigDecimal poundage = amountB.multiply(rateD);// 手续费
        BigDecimal annualPoundage = annualPrincipal.multiply(rateD);// 每期手续费
        annualPoundage = annualPoundage.divide(new BigDecimal(1000), 2, 4);// 保留两位
        annualPoundage = annualPoundage.multiply(new BigDecimal(1000));
        BigDecimal initialPoundage = poundage.subtract(
            annualPoundage.multiply(periodsB.subtract(new BigDecimal("1"))));// 首期手续费
        initialPoundage = initialPoundage.abs();// 绝对值

        // 高息金额=贷款额*（总利率-基准利率）
        // 5.高息金额首期=高息金额-（6）*（期数-1）
        // 6.高息金额每期=高息金额/期数
        // HighRate
        BigDecimal highRate = amountB.multiply(bankRateD.subtract(rateD));// 高息金额
        BigDecimal annualHighRate = highRate.divide(periodsB, 0, 1);// 高息金额每期
        annualHighRate = annualHighRate.divide(new BigDecimal(1000), 0, 1);// 向下取整
        annualHighRate = annualHighRate.multiply(new BigDecimal(1000));
        BigDecimal initialHighRate = highRate.subtract(
            annualHighRate.multiply(periodsB.subtract(new BigDecimal(1))));// 高息金额首期
        // 保留两位

        // 高息手续费=高息金额*基准利率
        // 7.高息手续费首期=（8）*（期数-1）
        // 8.高息手续费每期=(6）*基准利率
        BigDecimal highRatePoundage = highRate.multiply(rateD);// 高息手续费
        highRatePoundage = highRatePoundage.divide(new BigDecimal(1000), 2, 4);
        highRatePoundage = highRatePoundage.multiply(new BigDecimal(1000));
        BigDecimal annualHighRatePoundage = annualHighRate.multiply(rateD);// 高息手续费每期
        annualHighRatePoundage = annualHighRatePoundage
            .divide(new BigDecimal(1000), 1, 4);// 保留一位
        annualHighRatePoundage = annualHighRatePoundage
            .multiply(new BigDecimal(1000));
        BigDecimal initialHighRatePoundage = annualHighRatePoundage
            .multiply(periodsB.subtract(new BigDecimal(1)));// 高息手续费首期
        // 保留两位

        // 首期月供=1+3+5+7
        BigDecimal initialAmount = initialPrincipal.add(initialPoundage)
            .add(initialHighRate).add(initialHighRatePoundage);
        // 每期月供=2+4+6+8
        BigDecimal annualAmount = annualPrincipal.add(annualPoundage)
            .add(annualHighRate).add(annualHighRatePoundage);

        System.out.println("每期---" + String.valueOf(annualAmount));
        System.out.println("首期---" + String.valueOf(initialAmount));
        System.out.println("手续费---" + String.valueOf(poundage));
        // String p = "123456";
        // byte[] decodeFromString = Base64Utils.decodeFromString(p);
        // System.out.println(decodeFromString);
        //
        // String encodeToString = Base64Utils.encodeToString(decodeFromString);
        // System.out.println(encodeToString);
    }
}
