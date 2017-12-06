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

    //交易量
//    BigDecimal totalTradeCount;

}
