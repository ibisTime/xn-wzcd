package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.dto.req.XN632152Req;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午10:34:47 
 * @history:
 */
public interface ILogisticsBO extends IPaginableBO<Logistics> {
    // 添加资料传递记录
    public String saveLogistics(String type, String bizCode, String userId,
            String fromNodeCode, String toNodeCode);

    // 添加状态为待补件的资料传递记录
    public String saveLogisticsToSupplement(String type, String bizCode,
            String userId, String fromNodeCode, String toNodeCode);

    // 发货
    public void sendLogistics(Logistics data);

    // 收货
    public void receiveLogistics(Logistics data);

    // 审核通过
    public void auditePassLogistics(String code, String remark);

    // 补发
    public void sendAgainLogistics(XN632152Req req, String code);

    // 查询
    public Logistics getLogistics(String code);

    // 列表查
    public List<Logistics> queryLogisticsList(Logistics condition);

    // 退件
    public void backPieceLogistics(Logistics data);

    // 修改收发节点
    public void updateLogistics(Logistics logistics);

    // 确认提交银行时的最近的资料传递
    public Logistics getLogisticsByCommitBank(Logistics domain);
}
