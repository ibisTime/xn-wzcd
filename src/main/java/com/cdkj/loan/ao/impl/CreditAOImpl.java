package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepointDetailBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632110ReqChild;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632112ReqChild;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.dto.req.XN632114Req;
import com.cdkj.loan.dto.req.XN632114ReqCNR;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ECreditNode;
import com.cdkj.loan.enums.EIDKind;
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

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IRepointDetailBO repointDetailBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Override
    public String addCredit(XN632110Req req) {
        // 操作人编号
        SYSUser sysUser = sysUserBO.getUser(req.getOperator());
        if (StringUtils.isBlank(sysUser.getPostCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前用户还未设置岗位");
        }

        // 新增征信单
        Credit credit = new Credit();
        credit.setCompanyCode(sysUser.getCompanyCode());
        credit.setSaleUserId(req.getOperator());
        credit.setLoanBankCode(req.getLoanBankCode());
        credit.setShopWay(req.getShopWay());
        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));

        credit.setXszFront(req.getXszFront());
        credit.setXszReverse(req.getXszReverse());
        credit.setApplyDatetime(new Date());

        // if (null != sysUser.getCompanyCode()
        // && !"".equals(sysUser.getCompanyCode())) {
        // Department department = departmentBO.getDepartment(sysUser
        // .getCompanyCode());
        // credit.setCompanyName(department.getName());
        // }

        // 设置当前节点
        ECreditNode currentNode = ECreditNode.getMap().get(
            nodeFlowBO.getNodeFlowByCurrentNode(ECreditNode.START.getCode())
                .getNextNode());
        credit.setCurNodeCode(currentNode.getCode());

        String creditCode = creditBO.saveCredit(credit);

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
            creditUserBO.saveCreditUser(creditUser);
        }

        // 日志记录
        sysBizLogBO.saveSYSBizLog(creditCode, EBizLogType.CREDIT, creditCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
        return creditCode;
    }

    @Override
    @Transactional
    public void editCredit(XN632112Req req) {
        Credit credit = creditBO.getCredit(req.getCreditCode());
        if (null == credit) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据征信单编号查询不到征信单");
        }

        if (!ECreditNode.MODIFY.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是重新上传征信资料节点，不能操作");
        }

        // 修改征信单
        credit.setLoanBankCode(req.getLoanBankCode());
        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        credit.setShopWay(req.getShopWay());
        credit.setXszFront(req.getXszFront());
        credit.setXszReverse(req.getXszReverse());
        // 之前节点
        String PrecurNodeCode = credit.getCurNodeCode();
        // 更新当前节点
        credit.setCurNodeCode(
            nodeFlowBO.getNodeFlowByCurrentNode(PrecurNodeCode).getNextNode());
        creditBO.refreshCredit(credit);

        // 修改征信人员
        List<XN632112ReqChild> list = req.getCreditUserList();
        for (XN632112ReqChild reqChild : list) {
            CreditUser creditUser = creditUserBO
                .getCreditUserNotNull(reqChild.getCode());
            if (creditUser == null) {
                CreditUser data = new CreditUser();
                data.setCreditCode(credit.getCode());
                data.setUserName(reqChild.getUserName());
                data.setRelation(reqChild.getRelation());
                data.setLoanRole(reqChild.getLoanRole());
                data.setIdNo(reqChild.getIdNo());
                data.setMobile(reqChild.getMobile());
                data.setIdNoFront(reqChild.getIdNoFront());
                data.setIdNoReverse(reqChild.getIdNoReverse());
                data.setAuthPdf(reqChild.getAuthPdf());
                data.setInterviewPic(reqChild.getInterviewPic());
                creditUserBO.saveCreditUser(data);
            } else {
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
        }

        // 日志记录
        ECreditNode currentNode = ECreditNode.getMap()
            .get(credit.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), PrecurNodeCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    public Credit getCredit(String creditCode) {
        Credit credit = creditBO.getCredit(creditCode);
        init(credit);
        return credit;

    }

    @Override
    public Credit getCreditAndCreditUser(String code) {
        Credit credit = creditBO.getCredit(code);
        init(credit);
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
            init(credit);
        }

        return paginable;

    }

    @Override
    public Paginable<Credit> queryCreditPageByRoleCode(int start, int limit,
            Credit condition) {
        Paginable<Credit> result = creditBO.getPaginableByRoleCode(start, limit,
            condition);
        List<Credit> list = result.getList();
        for (Credit credit : list) {
            // 从征信人员表查申请人的客户姓名 手机号 身份证号
            credit.setCreditUser(creditUserBO.getCreditUserByCreditCode(
                credit.getCode(), ELoanRole.APPLY_USER));
            init(credit);
        }
        return result;
    }

    @Override
    public void primaryAudit(XN632113Req req) {
        Credit credit = creditBO.getCredit(req.getCode());

        if (!ECreditNode.PRIMARYAUDIT.getCode()
            .equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是业务员初审节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = credit.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过，改变节点
            credit.setCurNodeCode(
                nodeFlowBO.getNodeFlowByCurrentNode(credit.getCurNodeCode())
                    .getNextNode());
            // 选填了附件
            if (null != req.getAccessory() && !"".equals(req.getAccessory())) {
                credit.setAccessory(req.getAccessory());
                creditBO.refreshCredit(credit);

            }
        } else {
            credit.setCurNodeCode(
                nodeFlowBO.getNodeFlowByCurrentNode(credit.getCurNodeCode())
                    .getBackNode());
        }
        creditBO.refreshCreditNode(credit);

        // 日志记录
        ECreditNode currentNode = ECreditNode.getMap()
            .get(credit.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

    }

    @Override
    @Transactional
    public void firstAudit(XN632114Req req) {
        Credit credit = creditBO.getCredit(req.getCode());
        if (!ECreditNode.FIRSTAUDIT.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是一审节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = credit.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过，改变节点
            credit.setCurNodeCode(
                nodeFlowBO.getNodeFlowByCurrentNode(credit.getCurNodeCode())
                    .getNextNode());

            // 法院网查询结果录入
            for (XN632114ReqCNR courtNetworkResults : req
                .getCourtNetworkResultsList()) {
                if (StringUtils.isBlank(courtNetworkResults.getCode())) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "征信人员不能为空！");
                }
                if (StringUtils.isBlank(courtNetworkResults.getCode())) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "法院网查询结果不能为空！");
                }
                creditUserBO.refreshCourtNetworkResults(
                    courtNetworkResults.getCode(),
                    courtNetworkResults.getCourtNetworkResults());

            }

            // 生成预算单
            BudgetOrder data = new BudgetOrder();
            data.setCreditCode(credit.getCode());
            CreditUser customerUser = creditUserBO.getCreditUserByCreditCode(
                credit.getCode(), ELoanRole.APPLY_USER);
            if (customerUser == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "征信人员信息中缺少申请本人信息，请打回");
            }

            // 申请人信息
            data.setCustomerName(customerUser.getUserName());
            data.setApplyUserGhrRelation(customerUser.getRelation());
            data.setIdKind(EIDKind.IDCard.getCode());
            data.setIdNo(customerUser.getIdNo());
            // 通过身份证获取生日和性别
            String birth = getBirthByIdNo(customerUser.getIdNo());
            String sex = getSexByIdNo(customerUser.getIdNo());
            data.setCustomerBirth(birth);
            data.setCustomerSex(sex);
            data.setMobile(customerUser.getMobile());
            data.setLoanBankCode(credit.getLoanBankCode());
            data.setApplyBirthAddress(customerUser.getBirthAddress());

            // 共还人信息
            CreditUser ghUser = creditUserBO
                .getCreditUserByCreditCode(credit.getCode(), ELoanRole.GHR);
            if (ghUser != null) {
                data.setGhRealName(ghUser.getUserName());
                data.setGhIdNo(ghUser.getIdNo());
                String ghSex = getSexByIdNo(ghUser.getIdNo());
                data.setGhSex(ghSex);
                data.setApplyUserGhrRelation(ghUser.getRelation());
                data.setGhMobile(ghUser.getMobile());
                data.setGhMonthIncome(ghUser.getMonthIncome());
                data.setGhSettleInterest(ghUser.getSettleInterest());
                data.setGhBalance(ghUser.getBalance());
                data.setGhJourShowIncome(ghUser.getJourShowIncome());
                data.setGhIsPrint(ghUser.getIsPrint());
                data.setGhBirthAddress(ghUser.getBirthAddress());
            }

            // 担保人信息
            List<CreditUser> dbUserList = creditUserBO
                .getCreditUserListByCreditCode(credit.getCode(),
                    ELoanRole.GUARANTOR);
            if (CollectionUtils.isNotEmpty(dbUserList)) {
                CreditUser dbUser1 = dbUserList.get(0);
                data.setGuarantor1IdNo(dbUser1.getIdNo());
                data.setGuarantor1MonthIncome(dbUser1.getMonthIncome());
                data.setGuarantor1SettleInterest(dbUser1.getSettleInterest());
                data.setGuarantor1Balance(dbUser1.getBalance());
                data.setGuarantor1JourShowIncome(dbUser1.getJourShowIncome());
                data.setGuarantor1IsPrint(dbUser1.getIsPrint());
                data.setGuarantorName(dbUser1.getUserName());
                data.setGuarantorMobile(dbUser1.getMobile());
                if (dbUserList.size() > 1) {
                    CreditUser dbUser2 = dbUserList.get(1);
                    data.setGuarantor2IdNo(dbUser2.getIdNo());
                    data.setGuarantor2MonthIncome(dbUser2.getMonthIncome());
                    data.setGuarantor2SettleInterest(
                        dbUser2.getSettleInterest());
                    data.setGuarantor2Balance(dbUser2.getBalance());
                    data.setGuarantor2JourShowIncome(
                        dbUser2.getJourShowIncome());
                    data.setGuarantor2IsPrint(dbUser2.getIsPrint());
                }
            }

            data.setCompanyCode(credit.getCompanyCode());
            data.setSaleUserId(credit.getSaleUserId());
            data.setShopWay(credit.getShopWay());
            data.setLoanAmount(credit.getLoanAmount());
            EBudgetOrderNode node = EBudgetOrderNode.START_NODE;

            data.setCurNodeCode(node.getCode());
            String budgetOrderCode = budgetOrderBO.saveBudgetOrder(data);
            // 日志记录
            sysBizLogBO.saveSYSBizLog(budgetOrderCode, EBizLogType.BUDGET_ORDER,
                budgetOrderCode, node.getCode(), node.getValue(),
                req.getOperator());

            // 征信单回写预算单编号
            credit.setBudgetCode(budgetOrderCode);
            creditBO.refreshCredit(credit);
        } else {
            credit.setCurNodeCode(
                nodeFlowBO.getNodeFlowByCurrentNode(credit.getCurNodeCode())
                    .getBackNode());
        }
        creditBO.refreshCreditNode(credit);

        // 日志记录
        ECreditNode currentNode = ECreditNode.getMap()
            .get(credit.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

    }

    private String getSexByIdNo(String idNo) {
        /**
         * 根据身份编号获取性别
         * @param idCard 身份编号
         * @return 性别(M-男，F-女，N-未知)
         */
        String sGender = null;

        String sCardNum = idNo.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "男";
        } else {
            sGender = "女";
        }
        return sGender;
    }

    private String getBirthByIdNo(String idNo) {
        /**
         * 根据身份编号获取生日
         * @param idCard 身份编号
         * @return 生日(yyyyMMdd)
         */
        String birth = idNo.substring(6, 14);
        return birth;
    }

    private void init(Credit credit) {
        if (StringUtils.isNotBlank(credit.getCompanyCode())) {
            Department department = departmentBO
                .getDepartment(credit.getCompanyCode());
            if (null != department) {
                credit.setCompanyName(department.getName());
            }
        }

        if (StringUtils.isNotBlank(credit.getSaleUserId())) {
            SYSUser user = sysUserBO.getUser(credit.getSaleUserId());
            credit.setSalesmanName(user.getRealName());
        }

        if (StringUtils.isNotBlank(credit.getLoanBankCode())) {
            Bank bank = bankBO.getBankBySubbranch(credit.getLoanBankCode());
            credit.setLoanBankName(bank.getBankName());
        }

    }

}
