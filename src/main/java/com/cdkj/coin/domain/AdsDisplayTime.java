package com.cdkj.coin.domain;

import com.cdkj.coin.dao.base.ABaseDO;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class AdsDisplayTime extends ABaseDO implements Serializable {
    private Integer id;

    @NotBlank
    private String adsCode;

    @NotBlank
    private String week;

    @NotBlank
    private Integer startTime;

    @NotBlank
    private Integer endTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdsCode() {
        return adsCode;
    }

    public void setAdsCode(String adsCode) {
        this.adsCode = adsCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}