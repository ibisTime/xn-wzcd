package com.cdkj.coin.bo;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.AdsSell;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsBO {

    void insertAdsSell(AdsSell adsSell);

    public AdsSell adsSellDetail(String adsCode);

    public Paginable<AdsSell> frontSellPage(Integer start, Integer limit, String coin);

    public Paginable<AdsSell> ossSellPage(Integer start, Integer limit, String coin);

}
