package com.cdkj.coin.domain;

/**
 * Created by tianlei on 2017/十一月/22.
 */
public class UserStatistics {

    //交易总数
    int jiaoYiCount;

    //被评价的次数
    int beiPingJiaCount;

    //被好评次数
    int beiHaoPingCount;

    //被信任次数
    long beiXinRenCount;

    //交易量
    private String totalTradeCount;

    //********* 以下在用户详情页使用  *******//
    //是否信任
    private String isTrust;

    //是否加入到黑名单
    private String isAddBlackList;

    //访客和主人之间的交易次数
    private String betweenTradeTimes;

    public String getTotalTradeCount() {
        return totalTradeCount;
    }

    public void setTotalTradeCount(String totalTradeCount) {
        this.totalTradeCount = totalTradeCount;
    }

    public int getJiaoYiCount() {
        return jiaoYiCount;
    }

    public void setJiaoYiCount(int jiaoYiCount) {
        this.jiaoYiCount = jiaoYiCount;
    }

    public int getBeiPingJiaCount() {
        return beiPingJiaCount;
    }

    public void setBeiPingJiaCount(int beiPingJiaCount) {
        this.beiPingJiaCount = beiPingJiaCount;
    }

    public int getBeiHaoPingCount() {
        return beiHaoPingCount;
    }

    public void setBeiHaoPingCount(int beiHaoPingCount) {
        this.beiHaoPingCount = beiHaoPingCount;
    }

    public long getBeiXinRenCount() {
        return beiXinRenCount;
    }

    public void setBeiXinRenCount(long beiXinRenCount) {
        this.beiXinRenCount = beiXinRenCount;
    }

    public String getIsTrust() {
        return isTrust;
    }

    public void setIsTrust(String isTrust) {
        this.isTrust = isTrust;
    }

    public String getIsAddBlackList() {
        return isAddBlackList;
    }

    public void setIsAddBlackList(String isAddBlackList) {
        this.isAddBlackList = isAddBlackList;
    }

    public String getBetweenTradeTimes() {
        return betweenTradeTimes;
    }

    public void setBetweenTradeTimes(String betweenTradeTimes) {
        this.betweenTradeTimes = betweenTradeTimes;
    }
}
