package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.IRepointDetailBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632240Req;
import com.cdkj.loan.dto.req.XN632241Req;
import com.cdkj.loan.dto.req.XN632242Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ERepointDetailStatus;
import com.cdkj.loan.enums.ERepointNode;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月18日 下午2:21:58 
 * @history:
 */
@Service
public class RepointAOImpl implements IRepointAO {

    @Autowired
    private IRepointBO repointBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ICarDealerBO carDealerBO;

    @Autowired
    private IRepointDetailBO repointDetailBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    public void addRepoint(XN632240Req req) {
        if (StringUtils.isNotBlank(req.getCode())) {
            // 审核不通过的制单（重新制单）
            Repoint data = repointBO.getRepoint(req.getCode());
            String preCurNodeCode = data.getCurNodeCode();// 当前节点
            if (!ERepointNode.MAKE_BILL.getCode().equals(data.getCurNodeCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是制单节点，不能操作");
            }
            data.setCarDealerCode(req.getCarDealerCode());
            data.setBankcardCode(req.getBankcardCode());
            data.setTotalAmount(StringValidater.toLong(req.getTotalAmount()));
            data.setReason(req.getReason());
            data.setApplyUserId(req.getOperator());
            SYSUser user = sysUserBO.getUser(req.getOperator());
            if (StringUtils.isBlank(user.getPostCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前用户还未设置岗位");
            }
            data.setCompanyCode(user.getCompanyCode());
            data.setApplyDatetime(new Date());
            CarDealer carDealer = carDealerBO.getCarDealer(req
                .getCarDealerCode());
            data.setSettleType(carDealer.getSettleWay());
            data.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                data.getCurNodeCode()).getNextNode());// 制单后设置节点为分公司总经理审批
            repointBO.refreshRepoint(data);
            // 日志记录
            sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
                EBizLogType.REPOINT, data.getCode(), preCurNodeCode,
                data.getCurNodeCode(), null, req.getOperator());
            // 更改返点明细数据的节点
            // 1、处理第一次制单的返点明细
            RepointDetail condition = new RepointDetail();
            condition.setRepointCode(req.getCode());
            List<RepointDetail> repointDetailList = repointDetailBO
                .queryRepointDetailList(condition);
            for (RepointDetail repointDetail : repointDetailList) {
                repointDetail.setCurNodeCode(ERepointDetailStatus.TODO_PAY
                    .getCode());
                repointDetail.setRepointCode(null);
                repointDetailBO.updateCurNodeCode(repointDetail);
            }
            // 2、处理本次制单返点明细
            List<String> list = req.getRepointDetailCodeList();
            for (String code : list) {
                RepointDetail repointDetail = repointDetailBO
                    .getRepointDetail(code);
                repointDetail.setCurNodeCode(ERepointDetailStatus.APPROVE
                    .getCode());
                repointDetail.setRepointCode(req.getCode());
                repointDetailBO.updateCurNodeCode(repointDetail);
            }
        } else {
            // 第一次制单
            Repoint data = new Repoint();
            data.setCarDealerCode(req.getCarDealerCode());
            data.setBankcardCode(req.getBankcardCode());
            data.setTotalAmount(StringValidater.toLong(req.getTotalAmount()));
            data.setReason(req.getReason());
            data.setApplyUserId(req.getOperator());
            SYSUser user = sysUserBO.getUser(req.getOperator());
            if (StringUtils.isBlank(user.getPostCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前用户还未设置岗位");
            }
            data.setCompanyCode(user.getCompanyCode());
            data.setApplyDatetime(new Date());
            CarDealer carDealer = carDealerBO.getCarDealer(req
                .getCarDealerCode());
            data.setSettleType(carDealer.getSettleWay());
            data.setCurNodeCode(ERepointNode.BRANCH_MANAGER_APPROVE.getCode());// 制单后设置节点为分公司总经理审批
            String repointCode = repointBO.saveRepoint(data);
            // 日志记录
            sysBizLogBO.saveSYSBizLog(repointCode, EBizLogType.REPOINT,
                repointCode, data.getCurNodeCode());
            // 更改返点明细数据的节点
            List<String> list = req.getRepointDetailCodeList();
            for (String code : list) {
                RepointDetail repointDetail = repointDetailBO
                    .getRepointDetail(code);
                repointDetail.setCurNodeCode(ERepointDetailStatus.APPROVE
                    .getCode());
                repointDetail.setRepointCode(repointCode);
                repointDetailBO.updateCurNodeCode(repointDetail);
            }
        }
    }

    @Override
    public void branchCompanyManagerApprove(XN632242Req req) {
        Repoint repoint = repointBO.getRepoint(req.getCode());
        String preCurNodeCode = repoint.getCurNodeCode();// 当前节点
        if (!ERepointNode.BRANCH_MANAGER_APPROVE.getCode().equals(
            preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是返点支付流程分公司总经理审批节点，不能操作");
        }
        NodeFlow node = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode);
        if (EBoolean.YES.getCode().equals(req.getApproveResult())) {
            // 审核通过
            repoint.setCurNodeCode(node.getNextNode());
        } else {
            // 审核不通过
            repoint.setCurNodeCode(node.getBackNode());
        }
        repointBO.branchCompanyManagerApprove(repoint);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repoint.getCode(),
            EBizLogType.REPOINT, repoint.getCode(), preCurNodeCode,
            repoint.getCurNodeCode(), req.getApproveNote(), req.getOperator());
    }

    @Override
    public void confirmLoan(XN632241Req req) {
        Repoint data = repointBO.getRepoint(req.getCode());
        String preCurNodeCode = data.getCurNodeCode();
        if (!ERepointNode.CONFIRM_PAY.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是返点支付流程确认放款(出纳打款)节点，不能操作");
        }
        data.setPayDatetime(DateUtil.strToDate(req.getPayDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setPayBankcardCode(req.getPayBankcardCode());
        data.setBillPdf(req.getBillPdf());
        data.setPayRemark(req.getPayRemark());
        NodeFlow node = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode);
        data.setCurNodeCode(node.getNextNode());
        repointBO.confirmLoan(data);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
            EBizLogType.REPOINT, data.getCode(), preCurNodeCode,
            data.getCurNodeCode(), req.getPayRemark(), req.getOperator());
        // 修改返点明细数据的状态为已打款
        RepointDetail condition = new RepointDetail();
        condition.setRepointCode(data.getCode());
        List<RepointDetail> list = repointDetailBO
            .queryRepointDetailList(condition);
        for (RepointDetail repointDetail : list) {
            repointDetail
                .setCurNodeCode(ERepointDetailStatus.HAS_PAY.getCode());
            repointDetailBO.updateCurNodeCode(repointDetail);
        }
    }

    @Override
    public Paginable<Repoint> queryRepointPage(int start, int limit,
            Repoint condition) {

        Paginable<Repoint> paginable = repointBO.getPaginable(start, limit,
            condition);
        List<Repoint> list = paginable.getList();
        for (Repoint data : list) {
            init(data);
        }

        return paginable;
    }

    @Override
    public List<Repoint> queryRepointList(Repoint condition) {
        return repointBO.queryRepointList(condition);
    }

    @Override
    public Repoint getRepoint(String code) {
        Repoint repoint = repointBO.getRepoint(code);
        init(repoint);
        RepointDetail condition = new RepointDetail();
        condition.setRepointCode(repoint.getCode());
        List<RepointDetail> list = repointDetailBO
            .queryRepointDetailList(condition);
        repoint.setRepointDetailList(list);
        return repoint;
    }

    private Repoint init(Repoint data) {
        if (StringUtils.isNotBlank(data.getCarDealerCode())) {
            CarDealer carDealer = carDealerBO.getCarDealer(data
                .getCarDealerCode());
            if (null != carDealer) {
                data.setCarDealerName(carDealer.getFullName());
            }

        }
        if (StringUtils.isNotBlank(data.getCompanyCode())) {
            Department department = departmentBO.getDepartment(data
                .getCompanyCode());
            if (null != department) {
                data.setCarDealerName(department.getName());
            }

        }
        if (StringUtils.isNotBlank(data.getApplyUserId())) {
            SYSUser user = sysUserBO.getUser(data.getApplyUserId());
            if (null != user) {
                data.setApplyUserName(user.getRealName());
            }

        }
        return data;
    }
}
