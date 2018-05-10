package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BaofooWithhold;

public interface IBaofooWithholdBO extends IPaginableBO<BaofooWithhold> {

    public String saveBaofooWithhold(BaofooWithhold data);

    public List<BaofooWithhold> queryBaofooWithholdList(
            BaofooWithhold condition);

    public BaofooWithhold getBaofooWithhold(String code);

}
