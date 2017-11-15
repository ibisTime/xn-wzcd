package com.cdkj.coin.dto.req;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625228Req {

    @NotNull
    @DecimalMin(value = "1")
    private Integer start;

    @NotNull
    @DecimalMin(value = "1")
    private Integer limit;

    @NotBlank
    private String coin;




    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
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
