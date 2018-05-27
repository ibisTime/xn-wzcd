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
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632110ReqChild;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632112ReqChild;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.dto.req.XN632114Req;
import com.cdkj.loan.dto.req.XN632116Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
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
    private INodeBO nodeBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    // 征信新增
    @Override
    public String addCredit(XN632110Req req) {

        // 操作人编号
        SYSUser sysUser = sysUserBO.getUser(req.getOperator());

        // 新增征信单
        Credit credit = new Credit();
        credit.setCompanyCode(sysUser.getCompanyCode());
        credit.setSaleUserId(sysUser.getUserId());
        credit.setLoanBankCode(req.getLoanBankCode());
        credit.setShopWay(req.getShopWay());
        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        credit.setXszFront(req.getXszFront());
        credit.setXszReverse(req.getXszReverse());

        credit.setApplyDatetime(new Date());

        credit.setCurNodeCode(nodeBO.getNode(ECreditNode.START.getCode())
            .getNextNode());

        String creditCode = creditBO.addCredit(credit);

        // 新增征信人员
        List<XN632110ReqChild> childList = req.getCreditUserList();
        for (XN632110ReqChild child : childList) {
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

            creditUserBO.addCreditUser(creditUser);
        }

        return creditCode;
    }

    // 修改征信
    @Override
    public void editCredit(XN632112Req req) {

        // 修改征信单
        Credit credit = new Credit();

        credit.setCode(req.getCreditCode());

        credit.setLoanBankCode(req.getLoanBank());

        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));

        credit.setShopWay(req.getShopWay());

        credit.setXszFront(req.getXszFront());

        credit.setXszReverse(req.getXszReverse());

        creditBO.updateCredit(credit);

        // 修改征信人员
        List<XN632112ReqChild> list = req.getCreditUserList();

        for (XN632112ReqChild reqChild : list) {

            CreditUser creditUser = new CreditUser();

            creditUser.setCode(reqChild.getCreditUserCode());

            creditUser.setUserName(reqChild.getUserName());

            creditUser.setLoanRole(reqChild.getLoanRole());

            creditUser.setRelation(reqChild.getRelation());

            creditUser.setMobile(reqChild.getMobile());

            creditUser.setIdNo(reqChild.getIdNo());

            creditUser.setIdNoFront(reqChild.getIdNoFront());

            creditUser.setIdNoReverse(reqChild.getIdNoReverse());

            creditUser.setAuthPdf(reqChild.getAuthPdf());

            creditUser.setInterviewPic(reqChild.getInterviewPic());

            creditUserBO.updateCreditUser(creditUser);

        }

        Credit creditCurrent = creditBO.getCredit(req.getCreditCode());
        creditCurrent.setCurNodeCode(nodeBO.getNode(
            ECreditNode.MODIFY.getCode()).getNextNode());

        creditBO.refreshCreditNode(creditCurrent);

    }

    // 分页查询 按角色权限
    @Override
    public Paginable<Credit> queryCreditPageByRole(int start, int limit,
            Credit condition) {
        Paginable<Credit> result = creditBO.getPaginable(start, limit,
            condition);
        List<Credit> list = result.getList();
        for (Credit credit : list) {
            // 从征信人员表查申请人的客户姓名 手机号 身份证号
            credit.setCreditUser(creditUserBO.getCreditUserByCreditCode(
                credit.getCode(), ELoanRole.APPLY_USER));

            // 从部门表查业务公司名
            credit.setCompanyName((departmentBO.getDepartment(credit
                .getCompanyCode()).getName()));
            // 从银行表查贷款银行名
            // Bank bank = new Bank();
            // bank.setBankCode(credit.getLoanBankCode());
            // credit.setLoanBankName((bankBO.getBank(bank)).getBankName());
            // 从业务员表查业务员姓名
            // credit.setSalesmanName((saleUserBO.getSaleUser(credit
            // .getSaleUserId())).getRealName());
            // 从节点表查节点名称
            // credit.setStatus(nodeBO.getNode(credit.getCurNodeCode()).getName());
        }

        return result;
    }

    // 征信详情查询
    @Override
    public Credit queryCreditDetail(String code) {
        Credit credit = creditBO.getCredit(code);

        List<CreditUser> creditUserList = creditUserBO
            .queryCreditUserListByCreditCode(code);

        credit.setCreditUserList(creditUserList);

        return credit;
    }

    // 查询征信单 根据征信单编号
    @Override
    public Credit queryCreditByCode(String creditCode) {
        return creditBO.getCredit(creditCode);
    }

    // 征信初审
    @Override
    public void primaryAudit(XN632113Req req) {

        Credit credit = creditBO.getCredit(req.getCode());

        if (!ECreditNode.PRIMARYAUDIT.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是业务员初审节点，不能操作");
        }

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过，改变节点

            credit.setCurNodeCode(nodeBO.getNode(credit.getCurNodeCode())
                .getNextNode());
            // 审核通过并且选填了附件
            if (null != req.getAccessory() && !"".equals(req.getAccessory())) {
                credit.setAccessory(req.getAccessory());
                creditBO.updateCredit(credit);

            }

        } else {
            credit.setCurNodeCode(nodeBO.getNode(credit.getCurNodeCode())
                .getBackNode());
        }

        creditBO.refreshCreditNode(credit);
    }

    // 征信一审
    @Override
    public void firstAudit(XN632114Req req) {

        Credit credit = creditBO.getCredit(req.getCode());

        if (!ECreditNode.FIRSTAUDIT.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是一审节点，不能操作");
        }

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过，改变节点
            credit.setCurNodeCode(nodeBO.getNode(
                ECreditNode.FIRSTAUDIT.getCode()).getNextNode());

        } else {
            credit.setCurNodeCode(nodeBO.getNode(
                ECreditNode.FIRSTAUDIT.getCode()).getBackNode());
        }

        creditBO.refreshCreditNode(credit);

    }

    // 分页查询
    @Override
    public Paginable<Credit> queryCreditPage(XN632116Req req) {

        // 征信表分页查询结果
        Credit condition = new Credit();

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        String Column = req.getOrderColumn();

        condition.setOrder(Column, req.getOrderDir());

        condition.setApplyDatetime(DateUtil.strToDate(req.getApplyDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        condition.setLoanBankCode(req.getLoanBankCode());

        condition.setSaleUserId(req.getSaleUserId());

        condition.setCode(req.getCreditCode());

        Paginable<Credit> result = creditBO.getPaginableAll(start, limit,
            condition);

        List<Credit> list = result.getList();

        for (Credit credit : list) {

            // 从征信人员表查申请人的客户姓名 手机号 身份证号
            credit.setCreditUser(creditUserBO.getCreditUserByCreditCode(
                credit.getCode(), ELoanRole.APPLY_USER));

            // 从部门表查业务公司名
            credit.setCompanyName((departmentBO.getDepartment(credit
                .getCompanyCode()).getName()));
            // 从银行表查贷款银行名
            Bank bank = new Bank();
            bank.setBankCode(credit.getLoanBankCode());
            credit.setLoanBankName((bankBO.getBank(bank)).getBankName());
            // // 从业务员表查业务员姓名
            // credit.setSalesmanName((saleUserBO.getSaleUser(credit
            // .getSaleUserId())).getRealName());
            // 从节点表查节点名称
            credit.setStatus(nodeBO.getNode(credit.getCurNodeCode()).getName());
        }

        return result;
    }
}
