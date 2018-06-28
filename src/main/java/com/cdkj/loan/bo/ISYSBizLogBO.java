package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.enums.EBizLogType;

public interface ISYSBizLogBO extends IPaginableBO<SYSBizLog> {

    // 流程第一步，执行当前方法
    public void saveSYSBizLog(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode, String dealNote, String operator);

    // 不是流程第一步，执行当前方法
    public void saveNewAndPreEndSYSBizLog(String parentOrder,
            EBizLogType refType, String refOrder, String preDealNode,
            String nowDealNode, String nowDealNote, String operator);

    // 操作最后一步
    public void onlyPreEndSYSBizLog(EBizLogType refType, String refOrder,
            String preDealNode);

    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition);

    public SYSBizLog getSYSBizLog(int id);
}
