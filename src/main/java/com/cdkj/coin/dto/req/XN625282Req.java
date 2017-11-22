package com.cdkj.coin.dto.req;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by tianlei on 2017/十一月/22.
 */
public class XN625282Req   {

    @NotBlank
    private String currency;

    @NotNull
    @Min(0)
    private Integer start;

    @NotNull
    @Min(1)
    private Integer limit;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
