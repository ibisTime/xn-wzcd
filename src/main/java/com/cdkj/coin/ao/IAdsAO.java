package com.cdkj.coin.ao;

import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.dto.res.BooleanRes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsAO {

    public void insertAds(XN625220Req req);

    public void draftPublish(XN625220Req req);

    public Object adsDetail(String adsCode,String tradeType);

    public void xiaJiaAds(String adsCode, String tradeType, String userId);

    public Object frontPage(Integer start, Integer limit,String coin,String tradeType);

    public Object ossPage(Integer start, Integer limit,String coin,String tradeType);


}
