package com.cdkj.coin.domain;

import java.io.Serializable;
import java.util.Date;

public class AdsDisplayTime implements Serializable {
    private Integer id;

    private String adscode;

    private String week;

    private Date startTime;

    private Date endTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdscode() {
        return adscode;
    }

    public void setAdscode(String adscode) {
        this.adscode = adscode == null ? null : adscode.trim();
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}