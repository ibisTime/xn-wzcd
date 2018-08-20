package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.bo.IAdvanceFundBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632170Req;
import com.cdkj.loan.dto.req.XN632171Req;
import com.cdkj.loan.dto.req.XN632172Req;
import com.cdkj.loan.dto.req.XN632173Req;
import com.cdkj.loan.dto.req.XN632175Req;
import com.cdkj.loan.dto.req.XN632177Req;
import com.cdkj.loan.dto.res.XN632178Res;
import com.cdkj.loan.dto.res.XN632188Res;
import com.cdkj.loan.enums.EAdvanceFundNode;
import com.cdkj.loan.enums.EAdvanceType;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBankRepointStatus;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ECity;
import com.cdkj.loan.enums.EDepartmentType;
import com.cdkj.loan.enums.EFbhStatus;
import com.cdkj.loan.enums.EIsAdvanceFund;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:37:45 
 * @history:
 */
@Service
public class AdvanceFundAOImpl implements IAdvanceFundAO {

    @Autowired
    private IAdvanceFundBO advanceFundBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private ICarDealerBO carDealerBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private IReqBudgetBO reqBudgetBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public void confirmAdvanceFund(XN632170Req req) {
        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        if (!EAdvanceFundNode.PARENT_CONFIRM.getCode().equals(
            data.getCurNodeCode())
                && !EAdvanceFundNode.BRANCH_CONFIRM.getCode().equals(
                    data.getCurNodeCode())
                && !EAdvanceFundNode.PARENT_AGAIN.getCode().equals(
                    data.getCurNodeCode())
                && !EAdvanceFundNode.BRANCH_AGAIN.getCode().equals(
                    data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是垫资流程确认用款单节点，不能操作");
        }
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setApplyUser(req.getOperator());
        data.setApplyDatetime(new Date());
        data.setIsAdvanceFund(req.getIsAdvanceFund());
        String preNodeCode = data.getCurNodeCode();
        data.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
            .getNextNode());
        EBizLogType refType = null;
        if (EAdvanceType.PARENT_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_PARENT;
        } else if (EAdvanceType.BRANCH_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_BRANCH;
        }
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getBudgetCode(), refType,
            data.getCode(), preNodeCode, data.getCurNodeCode(), null,
            req.getOperator());

        advanceFundBO.refreshConfirmAdvanceFund(data);
    }

    @Override
    public int editAdvanceFund(AdvanceFund data) {
        if (!advanceFundBO.isAdvanceFundExist(data.getCode())) {
            throw new BizException("xn0000", "垫资单编号不存在");
        }
        return advanceFundBO.refreshAdvanceFund(data);
    }

    @Override
    public int dropAdvanceFund(String code) {
        if (!advanceFundBO.isAdvanceFundExist(code)) {
            throw new BizException("xn0000", "垫资单编号不存在");
        }
        return advanceFundBO.removeAdvanceFund(code);
    }

    @Override
    public Paginable<AdvanceFund> queryAdvanceFundPage(int start, int limit,
            AdvanceFund condition) {
        Paginable<AdvanceFund> paginable = advanceFundBO.getPaginable(start,
            limit, condition);
        List<AdvanceFund> list = paginable.getList();
        for (AdvanceFund advanceFund : list) {
            init(advanceFund);
        }
        return paginable;
    }

    @Override
    public List<AdvanceFund> queryAdvanceFundList(AdvanceFund condition) {
        List<AdvanceFund> list = advanceFundBO.queryAdvanceFundList(condition);
        for (AdvanceFund advanceFund : list) {
            init(advanceFund);
        }
        return list;
    }

    @Override
    public AdvanceFund getAdvanceFund(String code) {
        AdvanceFund data = advanceFundBO.getAdvanceFund(code);
        init(data);
        return data;
    }

    @Override
    public void areaAudit(XN632171Req req) {
        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        if (!EAdvanceFundNode.PARENT_AREA.getCode().equals(
            data.getCurNodeCode())
                && !EAdvanceFundNode.BRANCH_AREA.getCode().equals(
                    data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是垫资流程区域总经理审核节点，不能操作");
        }
        String preNodeCode = data.getCurNodeCode();// 当前节点
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getNextNode());
        } else if (EApproveResult.NOT_PASS.getCode().equals(
            req.getApproveResult())) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getBackNode());
        }
        EBizLogType refType = null;
        if (EAdvanceType.PARENT_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_PARENT;
        } else if (EAdvanceType.BRANCH_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_BRANCH;
        }
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getBudgetCode(), refType,
            data.getCode(), preNodeCode, data.getCurNodeCode(),
            req.getApproveNote(), req.getOperator());

        advanceFundBO.refreshAreaAudit(data);

    }

    @Override
    public void provinceAudit(XN632172Req req) {
        AdvanceFund advanceFund = advanceFundBO.getAdvanceFund(req.getCode());
        String advanceFundPreNodeCode = advanceFund.getCurNodeCode();
        if (!EAdvanceFundNode.PARENT_PROVINCE.getCode().equals(
            advanceFundPreNodeCode)
                && !EAdvanceFundNode.BRANCH_PROVINCE.getCode().equals(
                    advanceFundPreNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是垫资流程省分公司总经理审核节点，不能操作！");
        }
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过
            if (EIsAdvanceFund.NO.getCode().equals(
                advanceFund.getIsAdvanceFund())) {
                // 不垫资
                // 结束垫资流程 预算单进入银行放款流程第一步
                BudgetOrder budgetOrder = budgetOrderBO
                    .getBudgetOrder(advanceFund.getBudgetCode());
                Department company = departmentBO.getDepartment(budgetOrder
                    .getCompanyCode());
                EBudgetOrderNode bankLoanNode = null;
                if (ECity.WENZHOU.getValue().equals(company.getCityNo())) {
                    // 本地业务
                    bankLoanNode = EBudgetOrderNode.SALESMAN_SEND_LOGISTICS;
                } else {
                    // 外地业务
                    bankLoanNode = EBudgetOrderNode.BRANCH_SEND_LOGISTICS;
                }
                budgetOrder.setCurNodeCode(bankLoanNode.getCode());
                // 日志记录预算单银行放款流程
                sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
                    EBizLogType.BANK_LOAN_COMMIT, budgetOrder.getCode(),
                    budgetOrder.getCurNodeCode());
                budgetOrderBO.refreshCurNodeCode(budgetOrder);

                // 当前节点
                String curNodeCode = budgetOrder.getCurNodeCode();
                String nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                    curNodeCode).getNextNode();

                // 生成资料传递
                logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
                    budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                    curNodeCode, nextNodeCode);
                // 产生物流单后改变状态为物流传递中
                budgetOrder.setIsLogistics(EBoolean.YES.getCode());
                budgetOrderBO.updateIsLogistics(budgetOrder);
                // 垫资单垫资流程结束 直接改节点到垫资流程的最后一个节点
                EBizLogType eBizLogType = null;
                if (EAdvanceType.PARENT_BIZ.getCode().equals(
                    advanceFund.getType())) {
                    // 总公司业务
                    advanceFund
                        .setCurNodeCode(EAdvanceFundNode.PARENT_ADVANCE_END
                            .getCode());
                    eBizLogType = EBizLogType.ADVANCE_FUND_PARENT;
                } else {
                    // 分公司业务
                    advanceFund
                        .setCurNodeCode(EAdvanceFundNode.BRANCH_ADVANCE_END
                            .getCode());
                    eBizLogType = EBizLogType.ADVANCE_FUND_BRANCH;
                }
                // 收尾垫资流程日志 更新节点但不产生新日志
                sysBizLogBO.refreshPreSYSBizLog(eBizLogType,
                    advanceFund.getCode(), advanceFundPreNodeCode,
                    req.getApproveNote(), req.getOperator());
                advanceFundBO.refreshProvinceAudit(advanceFund);
                return;
            } else {
                // 垫资
                // 继续向下走垫资流程
                advanceFund.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                    advanceFundPreNodeCode).getNextNode());
            }
        } else {
            // 审核不通过
            advanceFund.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                advanceFundPreNodeCode).getBackNode());
        }
        EBizLogType refType = null;
        if (EAdvanceType.PARENT_BIZ.getCode().equals(advanceFund.getType())) {
            refType = EBizLogType.ADVANCE_FUND_PARENT;
        } else if (EAdvanceType.BRANCH_BIZ.getCode().equals(
            advanceFund.getType())) {
            refType = EBizLogType.ADVANCE_FUND_BRANCH;
        }
        sysBizLogBO.saveNewAndPreEndSYSBizLog(advanceFund.getBudgetCode(),
            refType, advanceFund.getCode(), advanceFundPreNodeCode,
            advanceFund.getCurNodeCode(), req.getApproveNote(),
            req.getOperator());
        advanceFundBO.refreshProvinceAudit(advanceFund);
    }

    @Override
    public void parentMakeBill(XN632173Req req) {
        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        if (!EAdvanceFundNode.PARENT_MAKE_BILL.getCode().equals(
            data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是垫资流程总公司制单节点，不能操作！");
        }
        String preNodeCode = data.getCurNodeCode();
        data.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
            .getNextNode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getBudgetCode(),
            EBizLogType.ADVANCE_FUND_PARENT, data.getCode(), preNodeCode,
            data.getCurNodeCode(), req.getMakeBillNote(), req.getOperator());
        advanceFundBO.parentMakeBill(data);
    }

    @Override
    public void confirmPayCarDealer(XN632175Req req) {
        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        if (!EAdvanceFundNode.PARENT_CAR_DEALER.getCode().equals(
            data.getCurNodeCode())
                && !EAdvanceFundNode.BRANCH_CAR_DEALER.getCode().equals(
                    data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是垫资流程确认打款给车行节点，不能操作");
        }
        data.setAdvanceFundAmount(StringValidater.toLong(req
            .getAdvanceFundAmount()));
        data.setAdvanceFundDatetime(DateUtil.strToDate(
            req.getAdvanceFundDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));

        CollectBankcard bankcard = collectBankcardBO.getCollectBankcard(req
            .getPayBankcardCode());
        SYSUser sysUser = sysUserBO.getUser(req.getOperator());
        if (!bankcard.getCompanyCode().equals(sysUser.getCompanyCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "付款账号与当前操作人不属于同一个业务公司！");
        }
        data.setPayBankcardCode(req.getPayBankcardCode());
        data.setBillPdf(req.getBillPdf());
        data.setNote(req.getNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        String preNodeCode = data.getCurNodeCode();// 当前节点
        data.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
            .getNextNode());// 更新节点为垫资完成补全确认打款车行的日志不生成新日志
        advanceFundBO.confirmPayCarDealer(data);
        EBizLogType refType = null;
        if (EAdvanceType.PARENT_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_PARENT;
        } else if (EAdvanceType.BRANCH_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_BRANCH;
        }
        // 补全垫资单确认打款给车行的日志
        sysBizLogBO.refreshPreSYSBizLog(refType, data.getCode(), preNodeCode,
            req.getNote(), req.getOperator());

        // 银行放款流程开始 判断是本地还是外地
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(data
            .getBudgetCode());
        Department company = departmentBO.getDepartment(budgetOrder
            .getCompanyCode());
        String curNodeCode = null;
        if (ECity.WENZHOU.getValue().equals(company.getCityNo())) {
            // 本地业务
            curNodeCode = EBudgetOrderNode.SALESMAN_SEND_LOGISTICS.getCode();
        } else {
            // 外地业务
            curNodeCode = EBudgetOrderNode.BRANCH_SEND_LOGISTICS.getCode();
        }
        budgetOrder.setCurNodeCode(curNodeCode);
        String nextNode = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode)
            .getNextNode();
        // 生成资料传递
        logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
            budgetOrder.getCode(), budgetOrder.getSaleUserId(), curNodeCode,
            nextNode);
        // 产生物流单后改变状态为物流传递中
        budgetOrder.setIsLogistics(EBoolean.YES.getCode());
        budgetOrderBO.updateIsLogistics(budgetOrder);
        // 记录日志
        sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BANK_LOAN_COMMIT, budgetOrder.getCode(), curNodeCode);
        // 垫资流程结束 预算单的发保合状态改成待录入发保合
        budgetOrder.setFbhStatus(EFbhStatus.PENDING_ENTRY.getCode());
        budgetOrder.setFbhWarnDay(0);
        budgetOrderBO.bankLoanConfirmSubmitBank(budgetOrder);
        // 垫资流程结束 预算单的银行返点状态改为待返点（垫资后可以提交银行返点）
        budgetOrder.setBankRepointStatus(EBankRepointStatus.NO.getCode());
        budgetOrderBO.bankRepoint(budgetOrder);
    }

    @Override
    public void applyCancelAdvanceFund(XN632177Req req) {
        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        data.setCancelReason(req.getCancelReason());
        data.setUpdateDatetime(new Date());
        data.setUpdater(req.getOperator());
        String preCurNodeCode = data.getCurNodeCode();// 当前节点
        EBizLogType eBizLogType = null;
        if (EAdvanceType.PARENT_BIZ.getCode().equals(data.getType())) {// 本地公司
            eBizLogType = EBizLogType.ADVANCE_FUND_PARENT;
            if (EAdvanceFundNode.PARENT_CONFIRM.getCode().equals(
                data.getCurNodeCode())
                    || EAdvanceFundNode.PARENT_AREA.getCode().equals(
                        data.getCurNodeCode())
                    || EAdvanceFundNode.PARENT_PROVINCE.getCode().equals(
                        data.getCurNodeCode())) {
                data.setCurNodeCode(EAdvanceFundNode.PARENT_AGAIN.getCode());
            } else {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不能申请撤销垫资操作，需财务审核");
            }
        }
        if (EAdvanceType.BRANCH_BIZ.getCode().equals(data.getType())) {// 外地公司
            eBizLogType = EBizLogType.ADVANCE_FUND_BRANCH;
            if (EAdvanceFundNode.BRANCH_CONFIRM.getCode().equals(
                data.getCurNodeCode())
                    || EAdvanceFundNode.BRANCH_AREA.getCode().equals(
                        data.getCurNodeCode())
                    || EAdvanceFundNode.BRANCH_PROVINCE.getCode().equals(
                        data.getCurNodeCode())) {
                data.setCurNodeCode(EAdvanceFundNode.BRANCH_AGAIN.getCode());
            } else {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不能申请撤销垫资操作，需财务审核");
            }
        }
        sysBizLogBO.recordCurrentSYSBizLog(data.getBudgetCode(), eBizLogType,
            data.getCode(), preCurNodeCode, req.getCancelReason(),
            req.getOperator());
        sysBizLogBO.saveSYSBizLog(data.getBudgetCode(), eBizLogType,
            data.getCode(), data.getCurNodeCode());
        advanceFundBO.applyCancelAdvanceFund(data);
    }

    @Override
    public Paginable<AdvanceFund> queryAdvanceFundPageByRoleCode(int start,
            int limit, AdvanceFund condition) {
        Paginable<AdvanceFund> paginable = advanceFundBO
            .queryAdvanceFundPageByRoleCode(start, limit, condition);
        List<AdvanceFund> list = paginable.getList();
        for (AdvanceFund advanceFund : list) {
            init(advanceFund);
        }
        return paginable;
    }

    @Override
    public XN632188Res queryAdvanceFundListForBranch(String companyCode,
            String curNodeCode) {
        XN632188Res res = new XN632188Res();
        AdvanceFund condition = new AdvanceFund();
        condition.setCompanyCode(companyCode);
        if (EAdvanceFundNode.BRANCH_MAKE_BILL.getCode().equals(curNodeCode)) {
            condition.setCurNodeCode(EAdvanceFundNode.BRANCH_MAKE_BILL
                .getCode());
        }
        if (EAdvanceFundNode.BRANCH_COMPANY.getCode().equals(curNodeCode)) {
            condition.setCurNodeCode(EAdvanceFundNode.BRANCH_COMPANY.getCode());
        }
        List<AdvanceFund> list = advanceFundBO.queryAdvanceFundList(condition);
        res.setAdvanceFundlist(list);
        long totalAdvanceFund = 0;// 待垫资总金额（制单时通过审核的总金额 或 确认打款给分公司时通过制单的总垫资金额）
        for (AdvanceFund data : list) {
            totalAdvanceFund += data.getUseAmount();
        }
        res.setTotalAdvanceFund(String.valueOf(totalAdvanceFund));
        Long reqBudgetAmount = 0L;// 已垫资金额（当天请款预算单的金额）
        ReqBudget reqBudget = reqBudgetBO.getTodayReqBudget(companyCode);
        if (reqBudget != null) {
            reqBudgetAmount = getLong(reqBudget.getPayAmount());
        }
        res.setHasAdvanceFund(String.valueOf(reqBudgetAmount));
        if (totalAdvanceFund - reqBudgetAmount < 0) {
            res.setUnAdvanceFund("0");
        } else {
            res.setUnAdvanceFund(String.valueOf(totalAdvanceFund
                    - reqBudgetAmount));
        }
        return res;
    }

    @Override
    public Object expectPayStatistics(String companyCode) {
        ArrayList<XN632178Res> list = new ArrayList<XN632178Res>();
        if (StringUtils.isNotBlank(companyCode)) {// 统计指定分公司的预打款
            XN632178Res res = new XN632178Res();
            Department company = departmentBO.getDepartment(companyCode);
            res.setCompanyName(company.getName());// 业务公司名称

            AdvanceFund condition = new AdvanceFund();
            condition.setCompanyCode(companyCode);
            List<AdvanceFund> totalAdvanceFundList = advanceFundBO
                .queryAdvanceFundList(condition);
            Long totalAdvanceFund = 0L;
            for (AdvanceFund advanceFund : totalAdvanceFundList) {
                totalAdvanceFund += advanceFund.getUseAmount();
            }
            res.setTotalAdvanceFund(String.valueOf(totalAdvanceFund));// 垫资总额

            String curNodeCode = "";
            if (ECity.WENZHOU.getValue().equals(company.getCityNo())) {
                curNodeCode = EAdvanceFundNode.PARENT_ADVANCE_END.getCode();
            } else {
                curNodeCode = EAdvanceFundNode.BRANCH_ADVANCE_END.getCode();
            }
            condition.setCurNodeCode(curNodeCode);
            List<AdvanceFund> hasAdvanceFundList = advanceFundBO
                .queryAdvanceFundList(condition);
            Long hasAdvanceFund = 0L;
            for (AdvanceFund advanceFund : hasAdvanceFundList) {
                hasAdvanceFund += advanceFund.getAdvanceFundAmount();
            }
            res.setHasAdvanceFund(String.valueOf(hasAdvanceFund));// 已垫资金额

            res.setUnAdvanceFund(String.valueOf(totalAdvanceFund
                    - hasAdvanceFund));// 未垫资金额

            list.add(res);
        } else {// 统计所有分公司的预打款
            Department condition = new Department();
            condition.setType(EDepartmentType.SUBBRANCH_COMPANY.getCode());
            List<Department> companyList = departmentBO
                .queryDepartmentList(condition);
            for (Department company : companyList) {
                XN632178Res res = new XN632178Res();
                res.setCompanyName(company.getName());// 业务公司名称

                AdvanceFund allCondition = new AdvanceFund();
                allCondition.setCompanyCode(company.getCode());
                List<AdvanceFund> totalAdvanceFundList = advanceFundBO
                    .queryAdvanceFundList(allCondition);
                Long totalAdvanceFund = 0L;
                for (AdvanceFund advanceFund : totalAdvanceFundList) {
                    totalAdvanceFund += advanceFund.getUseAmount();
                }
                res.setTotalAdvanceFund(String.valueOf(totalAdvanceFund));// 垫资总额

                String curNodeCode = "";
                if (ECity.WENZHOU.getValue().equals(company.getCityNo())) {
                    curNodeCode = EAdvanceFundNode.PARENT_ADVANCE_END.getCode();
                } else {
                    curNodeCode = EAdvanceFundNode.BRANCH_ADVANCE_END.getCode();
                }
                allCondition.setCurNodeCode(curNodeCode);
                List<AdvanceFund> hasAdvanceFundList = advanceFundBO
                    .queryAdvanceFundList(allCondition);
                Long hasAdvanceFund = 0L;
                for (AdvanceFund advanceFund : hasAdvanceFundList) {
                    hasAdvanceFund += advanceFund.getAdvanceFundAmount();
                }
                res.setHasAdvanceFund(String.valueOf(hasAdvanceFund));// 已垫资金额

                res.setUnAdvanceFund(String.valueOf(totalAdvanceFund
                        - hasAdvanceFund));// 未垫资金额

                list.add(res);
            }
        }
        return list;
    }

    @Override
    public Object todayHasAdvanceFund(int start, int limit,
            AdvanceFund condition) {
        condition.setAdvanceFundDatetime(DateUtil.getTodayStart());
        ArrayList<String> curNodeCodeList = new ArrayList<String>();
        curNodeCodeList.add(EAdvanceFundNode.PARENT_ADVANCE_END.getCode());
        curNodeCodeList.add(EAdvanceFundNode.BRANCH_ADVANCE_END.getCode());
        condition.setCurNodeCodeList(curNodeCodeList);
        Paginable<AdvanceFund> paginable = advanceFundBO.getPaginable(start,
            limit, condition);
        List<AdvanceFund> list = paginable.getList();
        for (AdvanceFund advanceFund : list) {
            init(advanceFund);
        }
        return paginable;
    }

    private AdvanceFund init(AdvanceFund data) {
        if (StringUtils.isNotBlank(data.getBudgetCode())) {
            BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(data
                .getBudgetCode());
            data.setCreditCode(budgetOrder.getCreditCode());
            data.setBudgetOrder(budgetOrder);
            data.setApplyUserIdNo(budgetOrder.getIdNo());// 客户身份证号 不是申请人身份证号
        }
        if (StringUtils.isNotBlank(data.getCompanyCode())) {
            Department company = departmentBO.getDepartment(data
                .getCompanyCode());
            if (null != company) {
                data.setBizCompanyName(company.getName());
            }
        }
        if (StringUtils.isNotBlank(data.getCarDealerCode())) {
            CarDealer carDealer = carDealerBO.getCarDealer(data
                .getCarDealerCode());
            if (null != carDealer) {
                data.setCarDealerName(carDealer.getFullName());
            }
        }
        if (StringUtils.isNotBlank(data.getLoanBankCode())) {
            Bank bank = bankBO.getBankBySubbranch(data.getLoanBankCode());
            if (null != bank) {
                data.setLoanBankName(bank.getBankName());
            }
        }
        if (StringUtils.isNotBlank(data.getCollectBankcardCode())) {
            CollectBankcard collectBankcard = collectBankcardBO
                .getCollectBankcard(data.getCollectBankcardCode());
            if (null != collectBankcard) {
                data.setCollectionAccountNo(collectBankcard.getBankcardNumber());
                data.setCollectBankName(collectBankcard.getBankName());
                data.setCollectSubbranch(collectBankcard.getSubbranch());
                data.setCollectAccountName(collectBankcard.getRealName());
            }
        }
        if (StringUtils.isNotBlank(data.getPayBankcardCode())) {
            CollectBankcard payBankcard = collectBankcardBO
                .getCollectBankcard(data.getPayBankcardCode());
            if (null != payBankcard) {
                data.setPayAccountNo(payBankcard.getBankcardNumber());
            }
        }
        if (StringUtils.isNotBlank(data.getApplyUser())) {
            SYSUser user = sysUserBO.getUser(data.getApplyUser());
            if (null != user) {
                data.setApplyUserName(user.getRealName());
            }
        }
        return data;

    }

    private Long getLong(Object obj) {
        if (null == obj) {
            return 0L;
        } else {
            return (Long) obj;
        }
    }

}
