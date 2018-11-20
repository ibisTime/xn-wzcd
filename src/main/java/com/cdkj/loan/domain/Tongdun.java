package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 同盾
 * @author: CYL 
 * @since: 2018年11月20日 下午4:43:47 
 * @history:
 */
public class Tongdun extends ABaseDO {

    private static final long serialVersionUID = 8322573358554172531L;

    // 浩源网页
    private String WzhyWeb;

    // 三要素
    private String mobile;

    // 在网时长
    private String online;

    // 银行卡四要素
    private String card;

    // 自然人识别
    private String police;

    // 家庭地址核验
    private String home_address;

    public String getWzhyWeb() {
        return WzhyWeb;
    }

    public void setWzhyWeb(String wzhyWeb) {
        WzhyWeb = wzhyWeb;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPolice() {
        return police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

}
