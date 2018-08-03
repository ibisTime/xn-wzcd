package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.OverdueTreatment;



//@Component
public interface IOverdueTreatmentAO {
	static final String DEFAULT_ORDER_COLUMN = "code";


	public String addOverdueTreatment(OverdueTreatment data);

	public int dropOverdueTreatment(String code);

	public int editOverdueTreatment(OverdueTreatment data);

	public Paginable<OverdueTreatment> queryOverdueTreatmentPage(int start, int limit, OverdueTreatment condition);

	public List<OverdueTreatment> queryOverdueTreatmentList(OverdueTreatment condition);

	public OverdueTreatment getOverdueTreatment(String code);

}