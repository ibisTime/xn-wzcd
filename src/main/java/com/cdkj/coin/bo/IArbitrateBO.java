package com.cdkj.coin.bo;

import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.Arbitrate;

public interface IArbitrateBO extends IPaginableBO<Arbitrate> {

    public String saveArbitrate(Arbitrate data);

    public List<Arbitrate> queryArbitrateList(Arbitrate condition);

    public Arbitrate getArbitrate(String code);

}
