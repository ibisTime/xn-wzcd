package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632111ReqCreditUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ECreditNode;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:51:03 
 * @history:
 */
@Service
public class CreditUserAOImpl implements ICreditUserAO {

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ICreditAO creditAO;

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    public CreditUser getCreditUserReport(String code) {

        return creditUserBO.getCreditUser(code);

    }

    @Override
    public void inputBankCreditResult(XN632111Req req) {

        Credit credit = creditAO.getCredit(req.getCreditCode());

        if (credit == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "征信单不存在");
        }

        if (!ECreditNode.INPUT_CREDIT_RESULT.getCode().equals(
            credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入征信结果节点，不能操作");
        }

        List<XN632111ReqCreditUser> list = req.getCreditResult();

        for (XN632111ReqCreditUser Child : list) {
            String code = Child.getCreditUserCode();

            CreditUser creditUser = creditUserBO.getCreditUser(code);
            creditUser.setBankCreditResultPdf(Child.getBankCreditResultPdf());

            creditUserBO.inputBankCreditResult(creditUser);
        }

        // 之前节点
        String preCurrentNode = credit.getCurNodeCode();
        credit.setCurNodeCode(nodeFlowBO.getNodeFlow(credit.getCurNodeCode())
            .getNextNode());
        creditBO.refreshCreditNode(credit);

        // 日志记录
        ECreditNode currentNode = ECreditNode.getMap().get(
            credit.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

    }
}
