package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.OverdueTreatment;

public interface IOverdueTreatmentBO extends IPaginableBO<OverdueTreatment> {

    public String saveOverdueTreatment(OverdueTreatment data);

    public int removeOverdueTreatment(String code);

    public int refreshOverdueTreatment(OverdueTreatment data);

    public List<OverdueTreatment> queryOverdueTreatmentList(
            OverdueTreatment condition);

    public OverdueTreatment getOverdueTreatment(String code);

}
