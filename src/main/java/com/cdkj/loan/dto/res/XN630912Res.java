package com.cdkj.loan.dto.res;

/**
 * 奖金提成
 * @author: jiafr 
 * @since: 2018年8月23日 上午9:41:49 
 * @history:
 */
public class XN630912Res {

    private String yearMonth;// 月份(yyyyMM)

    private String saleUserName;// 业务员

    private String selfDevelopNumber;// 自主开发笔数

    private String selfDevelopBonus;// 自主开发奖金

    private String notSelfDevelopNumber;// 非自主开发笔数

    private String notSelfDevelopBonus;// 非自主开发奖金

    private String totalNumber;// 小计笔数

    private String totalBonus;// 小计奖金

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getSaleUserName() {
        return saleUserName;
    }

    public void setSaleUserName(String saleUserName) {
        this.saleUserName = saleUserName;
    }

    public String getSelfDevelopNumber() {
        return selfDevelopNumber;
    }

    public void setSelfDevelopNumber(String selfDevelopNumber) {
        this.selfDevelopNumber = selfDevelopNumber;
    }

    public String getSelfDevelopBonus() {
        return selfDevelopBonus;
    }

    public void setSelfDevelopBonus(String selfDevelopBonus) {
        this.selfDevelopBonus = selfDevelopBonus;
    }

    public String getNotSelfDevelopNumber() {
        return notSelfDevelopNumber;
    }

    public void setNotSelfDevelopNumber(String notSelfDevelopNumber) {
        this.notSelfDevelopNumber = notSelfDevelopNumber;
    }

    public String getNotSelfDevelopBonus() {
        return notSelfDevelopBonus;
    }

    public void setNotSelfDevelopBonus(String notSelfDevelopBonus) {
        this.notSelfDevelopBonus = notSelfDevelopBonus;
    }

    public String getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(String totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(String totalBonus) {
        this.totalBonus = totalBonus;
    }

}
