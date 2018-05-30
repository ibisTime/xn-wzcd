package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632110ReqCreditUser;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632111ReqCreditUser;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632112ReqCreditUser;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EButtonCode;
import com.cdkj.loan.enums.ECreditNode;
import com.cdkj.loan.enums.ELoanRole;
import com.cdkj.loan.exception.BizException;

/**
 * 征信
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:09:48 
 * @history:
 */
@Service
public class CreditAOImpl implements ICreditAO {

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    public String addCredit(XN632110Req req) {

        // 操作人编号
        SYSUser sysUser = sysUserBO.getUser(req.getOperator());

        // 新增征信单
        Credit credit = new Credit();
        credit.setLoanBankCode(req.getLoanBankCode());
        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        credit.setBizType(req.getBizType());
        credit.setSecondCarReport(req.getSecondCarReport());
        credit.setXszFront(req.getXszFront());
        credit.setXszReverse(req.getXszReverse());

        credit.setCompanyCode(sysUser.getCompanyCode());
        credit.setSaleUserId(req.getOperator());
        credit.setApplyDatetime(new Date());

        /*
         * if (null != sysUser.getCompanyCode() &&
         * !"".equals(sysUser.getCompanyCode())) { Department department =
         * departmentBO.getDepartment(sysUser .getCompanyCode());
         * credit.setCompanyName(department.getName()); }
         */
        ECreditNode currentNode = ECreditNode.START;
        credit.setCurNodeCode(currentNode.getCode());
        // 设置节点
        if (EButtonCode.SEND.getCode().equals(req.getButtonCode())) {
            currentNode = ECreditNode.getMap().get(
                nodeFlowBO.getNodeFlowByCurrentNode(
                    ECreditNode.FILLIN_CREDIT.getCode()).getNextNode());
            credit.setCurNodeCode(currentNode.getCode());
        }

        String creditCode = creditBO.saveCredit(credit);

        // 新增征信人员
        List<XN632110ReqCreditUser> childList = req.getCreditUserList();
        for (XN632110ReqCreditUser child : childList) {
            CreditUser creditUser = new CreditUser();
            creditUser.setCreditCode(creditCode);
            creditUser.setRelation(child.getRelation());
            creditUser.setUserName(child.getUserName());
            creditUser.setLoanRole(child.getLoanRole());
            creditUser.setMobile(child.getMobile());

            creditUser.setIdNo(child.getIdNo());
            creditUser.setIdNoFront(child.getIdNoFront());
            creditUser.setIdNoReverse(child.getIdNoReverse());
            creditUser.setAuthPdf(child.getAuthPdf());
            creditUser.setInterviewPic(child.getInterviewPic());
            creditUserBO.saveCreditUser(creditUser);
        }

        // 日志记录
        sysBizLogBO.saveSYSBizLog(creditCode, EBizLogType.CREDIT, creditCode,
            currentNode.getCode(), null, req.getOperator());

        return creditCode;
    }

    @Override
    public void editCredit(XN632112Req req) {

        Credit credit = creditBO.getCredit(req.getCreditCode());

        if (null == credit) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据征信单编号查询不到征信单");
        }

        if (!ECreditNode.MODIFY.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是修改征信节点，不能操作");
        }

        // 修改征信单
        credit.setLoanBankCode(req.getLoanBank());
        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        credit.setBizType(req.getBizType());
        credit.setSecondCarReport(req.getSecondCarReport());
        credit.setXszFront(req.getXszFront());

        credit.setXszReverse(req.getXszReverse());
        credit.setSaleUserId(req.getOperator());

        // 之前节点
        String PrecurNodeCode = credit.getCurNodeCode();
        // 更新当前节点
        credit.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            credit.getCurNodeCode()).getNextNode());
        creditBO.refreshCredit(credit);

        // 修改征信人员
        List<XN632112ReqCreditUser> list = req.getCreditUserList();
        for (XN632112ReqCreditUser reqChild : list) {
            CreditUser creditUser = creditUserBO.getCreditUser(reqChild
                .getCreditUserCode());
            creditUser.setUserName(reqChild.getUserName());
            creditUser.setLoanRole(reqChild.getLoanRole());
            creditUser.setRelation(reqChild.getRelation());
            creditUser.setMobile(reqChild.getMobile());
            creditUser.setIdNo(reqChild.getIdNo());

            creditUser.setIdNoFront(reqChild.getIdNoFront());
            creditUser.setIdNoReverse(reqChild.getIdNoReverse());
            creditUser.setAuthPdf(reqChild.getAuthPdf());
            creditUser.setInterviewPic(reqChild.getInterviewPic());
            creditUserBO.refreshCreditUser(creditUser);
        }

        // 日志记录
        ECreditNode currentNode = ECreditNode.getMap().get(
            credit.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), PrecurNodeCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

    }

    @Override
    public Credit getCredit(String creditCode) {

        return creditBO.getCredit(creditCode);

    }

    @Override
    public Credit getCreditAndCreditUser(String code) {
        Credit credit = creditBO.getCredit(code);

        CreditUser condition = new CreditUser();
        condition.setCreditCode(credit.getCode());
        List<CreditUser> creditUserList = creditUserBO
            .queryCreditUserList(condition);

        credit.setCreditUserList(creditUserList);

        return credit;
    }

    @Override
    public Paginable<Credit> queryCreditPage(int start, int limit,
            Credit condition) {

        Paginable<Credit> paginable = creditBO.getPaginable(start, limit,
            condition);

        List<Credit> list = paginable.getList();

        for (Credit credit : list) {

            // 从征信人员表查申请人的客户姓名 手机号 身份证号
            credit.setCreditUser(creditUserBO.getCreditUserByCreditCode(
                credit.getCode(), ELoanRole.APPLY_USER));
            // 从部门表查业务公司名
            Department department = departmentBO.getDepartment(credit
                .getCompanyCode());
            if (null != department) {
                credit.setCompanyName(department.getName());
            }

            // 从银行表查贷款银行名
            Bank bank = new Bank();
            bank.setBankCode(credit.getLoanBankCode());
            Bank bank2 = bankBO.getBank(bank);
            if (null != bank2) {
                credit.setLoanBankName(bank2.getBankName());
            }
            // 从用户表查业务员姓名
            SYSUser user = sysUserBO.getUser(credit.getSaleUserId());
            if (null != user) {
                credit.setSaleUserName(user.getRealName());
            }

        }

        return paginable;

    }

    @Override
    public Paginable<Credit> queryCreditPageByRoleCode(int start, int limit,
            Credit condition) {
        Paginable<Credit> result = creditBO.getPaginableByRoleCode(start,
            limit, condition);
        List<Credit> list = result.getList();
        for (Credit credit : list) {
            // 从征信人员表查申请人的客户姓名 手机号 身份证号
            credit.setCreditUser(creditUserBO.getCreditUserByCreditCode(
                credit.getCode(), ELoanRole.APPLY_USER));
            // 从部门表查业务公司名
            Department department = departmentBO.getDepartment(credit
                .getCompanyCode());
            if (null != department) {
                credit.setCompanyName(department.getName());
            }

            // 从银行表查贷款银行名
            Bank bank = new Bank();
            bank.setBankCode(credit.getLoanBankCode());
            Bank bank2 = bankBO.getBank(bank);
            if (null != bank2) {
                credit.setLoanBankName(bank2.getBankName());
            }
            // 从用户表查业务员姓名
            SYSUser user = sysUserBO.getUser(credit.getSaleUserId());
            if (null != user) {
                credit.setSaleUserName(user.getRealName());
            }
        }

        return result;
    }

    @Override
    public void audit(XN632113Req req) {

        Credit credit = creditBO.getCredit(req.getCode());

        if (null == credit) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据征信单编号查询不到征信单");
        }

        if (!ECreditNode.AUDIT.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控专员审核节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = credit.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过，改变节点
            credit.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                credit.getCurNodeCode()).getNextNode());
        } else {
            credit.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                credit.getCurNodeCode()).getBackNode());
        }
        creditBO.refreshCreditNode(credit);
        // 日志记录
        ECreditNode currentNode = ECreditNode.getMap().get(
            credit.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), preCurrentNode,
            currentNode.getCode(), req.getApproveNote(), req.getOperator());

    }

    @Override
    public void inputBankCreditResult(XN632111Req req) {

        Credit credit = creditBO.getCredit(req.getCreditCode());
        if (null == credit) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据征信单编号查询不到征信单");
        }

        if (!ECreditNode.INPUT_CREDIT_RESULT.getCode().equals(
            credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入银行征信结果节点，不能操作");
        }
        String preCurNodeCode = credit.getCurNodeCode();

        credit.setCurNodeCode((nodeFlowBO.getNodeFlowByCurrentNode(credit
            .getCurNodeCode())).getNextNode());

        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), preCurNodeCode,
            credit.getCurNodeCode(), null, req.getOperator());

        List<XN632111ReqCreditUser> creditResult = req.getCreditResult();
        for (XN632111ReqCreditUser xn632111ReqCreditUser : creditResult) {

            CreditUser creditUser = creditUserBO
                .getCreditUser(xn632111ReqCreditUser.getCreditUserCode());
            creditUser.setCode(xn632111ReqCreditUser.getCreditUserCode());
            creditUser.setBankCreditResultPdf(xn632111ReqCreditUser
                .getBankCreditResultPdf());

            creditUserBO.inputBankCreditResult(creditUser);

        }

    }
}
