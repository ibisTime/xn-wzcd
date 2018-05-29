package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Logistics;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午10:34:47 
 * @history:
 */
public interface ILogisticsBO extends IPaginableBO<Logistics> {
    // 添加资料传递记录
    public String saveLogistics(String type, String bizCode, String userId,
            String bizNoteCode, String refFileList);

    // 发货
    public void sendLogistics(Logistics data);

    // 收货
    public void receiveLogistics(String code, String remark);

    // 补发
    public void sendAgainLogistics(String code, String remark);

    // 删除
    public void dropLogistics(String code);

    // 查询
    public Logistics getLogistics(String code);

    // 列表查
    public List<Logistics> getLogisticsList(Logistics condition);
}
