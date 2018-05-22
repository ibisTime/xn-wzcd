package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SYSNode;




public interface ISYSNodeBO extends IPaginableBO<SYSNode> {


	public String saveSYSNode(SYSNode data);


	public int removeSYSNode(String code);


	public int refreshSYSNode(SYSNode data);


	public List<SYSNode> querySYSNodeList(SYSNode condition);


	public SYSNode getSYSNode(String code);


}