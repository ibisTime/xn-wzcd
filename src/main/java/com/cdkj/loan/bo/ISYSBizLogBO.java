package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.enums.EBizLogType;

public interface ISYSBizLogBO extends IPaginableBO<SYSBizLog> {

    // 流程第一步，执行当前方法（记录第一步操作）
    public void recordCurrentSYSBizLog(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode, String dealNote, String operator);

    // 流程第一步，执行当前方法（为下一个节点生成的 有开始时间 待填入操作人和结束时间）
    public void saveSYSBizLog(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode);

    // 不是流程第一步，执行当前方法
    public void saveNewAndPreEndSYSBizLog(String parentOrder,
            EBizLogType refType, String refOrder, String preDealNode,
            String nowDealNode, String preDealNote, String operator);

    // 流程最后一步，执行当前方法
    public void refreshPreSYSBizLog(EBizLogType refType, String refOrder,
            String dealNode, String dealNote, String operator);

    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition);

    public SYSBizLog getSYSBizLog(int id);

}
