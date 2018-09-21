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
        BigDecimal bankRateD = StringValidater.toBigDecimal(bankRate);
        // // 本金：
        // // 1.首期=贷款额-（2）*（期数-1）
        // // 2.每期=贷款额/期数
        // BigDecimal amountB = StringValidater.toBigDecimal(loanAmount);
        // BigDecimal periodsB = StringValidater.toBigDecimal(loanPeriods);
        // BigDecimal annualPrincipal = amountB.divide(periodsB, 0, 1);//
        // 每期本金(向下取整)
        // annualPrincipal = annualPrincipal.divide(new BigDecimal(1000), 0, 1);
        // annualPrincipal = annualPrincipal.multiply(new BigDecimal(1000));
        //
        // BigDecimal multiply = annualPrincipal
        // .multiply(periodsB.subtract(new BigDecimal("1")));// 首期本金
        // BigDecimal initialPrincipal = amountB.subtract(multiply);
        // // 手续费=贷款额*利率
        // BigDecimal poundage = amountB.multiply(bankRateD);// 手续费
        // // 月供：
        // // 首期=1+手续费
        // BigDecimal initialAmount = initialPrincipal.add(poundage);
        // // 每期=2
        // BigDecimal annualAmount = annualPrincipal;

        // 本金：
        // 1.首期=贷款额-（2）*（期数-1）
        // 2.每期=贷款额/期数
        BigDecimal amountB = StringValidater.toBigDecimal(loanAmount);
        BigDecimal periodsB = StringValidater.toBigDecimal(loanPeriods);
        BigDecimal annualPrincipal = amountB.divide(periodsB, 0, 1);// 每期本金(向下取整)
        annualPrincipal = annualPrincipal.divide(new BigDecimal(1000), 0, 1);
        annualPrincipal = annualPrincipal.multiply(new BigDecimal(1000));

        BigDecimal multiply = annualPrincipal
            .multiply(periodsB.subtract(new BigDecimal("1")));// 首期本金
        BigDecimal initialPrincipal = amountB.subtract(multiply);
        // 手续费=贷款额*利率
        // 3.首期=手续费-（4）*（期数-1）
        // 4.每期=（2）*利率
        BigDecimal poundage = amountB.multiply(bankRateD);// 手续费
        BigDecimal annualPoundage = annualPrincipal.multiply(bankRateD);// 每期手续费(保留一位)
        BigDecimal multiply2 = annualPoundage
            .multiply(periodsB.subtract(new BigDecimal("1")));
        BigDecimal initialPoundage = poundage.subtract(multiply2);// 首期手续费
        initialPoundage = initialPoundage.abs();// 取绝对值

        // 月供：
        // 首期=1+3
        BigDecimal initialAmount = initialPrincipal.add(initialPoundage);
        // 每期=2+4
        BigDecimal annualAmount = annualPrincipal.add(annualPoundage);

        System.out.println("每期---" + String.valueOf(annualAmount.longValue()));
        System.out.println("首期---" + String.valueOf(initialAmount.longValue()));
        System.out.println("手续费---" + String.valueOf(poundage.longValue()));
        // String p = "123456";
        // byte[] decodeFromString = Base64Utils.decodeFromString(p);
        // System.out.println(decodeFromString);
        //
        // String encodeToString = Base64Utils.encodeToString(decodeFromString);
        // System.out.println(encodeToString);
    }
}
