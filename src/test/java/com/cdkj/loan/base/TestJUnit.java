package com.cdkj.loan.base;

import java.io.IOException;
import java.math.BigDecimal;

import org.unitils.UnitilsJUnit4;

import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.core.StringValidater;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) throws IOException {
        String loanPeriods = "24";
        String loanAmount = "200000";
        double rate = 0.155;// 基准利率
        String bankRate = "0.16";
        BigDecimal bankRateD = StringValidater.toBigDecimal(bankRate);
        BigDecimal rateD = new BigDecimal(rate);
        Long poundage = AmountUtil.mul(StringValidater.toLong(loanAmount),
            bankRateD.subtract(rateD).doubleValue());// 服务费
        Long amount = AmountUtil
            .mul((StringValidater.toLong(loanAmount) + poundage), (rate + 1));
        Long monthAmount = (long) AmountUtil.div(amount,
            (StringValidater.toInteger(loanPeriods) - 1));// 月供

        System.out.println(String.valueOf(poundage));
        // String p = "123456";
        // byte[] decodeFromString = Base64Utils.decodeFromString(p);
        // System.out.println(decodeFromString);
        //
        // String encodeToString = Base64Utils.encodeToString(decodeFromString);
        // System.out.println(encodeToString);
    }
}
