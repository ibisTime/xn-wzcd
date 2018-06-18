package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRepointDetailAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IRepointDetailBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.dto.req.XN632290Req;
import com.cdkj.loan.dto.res.XN632290Res;
import com.cdkj.loan.enums.EBankType;
import com.cdkj.loan.enums.ECollectBankcard;
import com.cdkj.loan.enums.EUseMoneyPurpose;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月16日 下午2:43:55 
 * @history:
 */
@Service
public class RepointDetailAOImpl implements IRepointDetailAO {

    @Autowired
    private IRepointDetailBO repointDetailBO;

    @Autowired
    private ICarDealerProtocolBO carDealerProtocolBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private ICarDealerBO carDealerBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IBankBO bankBO;

    @Override
    public String addRepointDetail(RepointDetail data) {
        return repointDetailBO.saveRepointDetail(data);
    }

    @Override
    public int editRepointDetail(RepointDetail data) {
        if (!repointDetailBO.isRepointDetailExist(data.getCode())) {
            throw new BizException("xn0000", "返点明细编号不存在");
        }
        return repointDetailBO.refreshRepointDetail(data);
    }

    @Override
    public int dropRepointDetail(String code) {
        if (!repointDetailBO.isRepointDetailExist(code)) {
            throw new BizException("xn0000", "返点明细编号不存在");
        }
        return repointDetailBO.removeRepointDetail(code);
    }

    @Override
    public Paginable<RepointDetail> queryRepointDetailPage(int start,
            int limit, RepointDetail condition) {
        return repointDetailBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<RepointDetail> queryRepointDetailList(RepointDetail condition) {
        return repointDetailBO.queryRepointDetailList(condition);
    }

    @Override
    public RepointDetail getRepointDetail(String code) {
        return repointDetailBO.getRepointDetail(code);
    }

    @Override
    public List<XN632290Res> showRepointDetail(XN632290Req req) {

        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req
            .getBudgetOrderCode());

        List<XN632290Res> resList = new ArrayList<XN632290Res>();

        Bank bank = bankBO.getBankBySubbranch(budgetOrder.getLoanBankCode());

        EBankType eBankType = null;
        // 协议内返点
        if (EBankType.GH.getCode().equals(bank.getBankCode())) {
            eBankType = EBankType.GH;
        } else if (EBankType.ZH.getCode().equals(bank.getBankCode())) {
            eBankType = EBankType.ZH;
        } else if (EBankType.JH.getCode().equals(bank.getBankCode())) {
            eBankType = EBankType.JH;
        }
        CarDealerProtocol carDealerProtocol = carDealerProtocolBO
            .getCarDealerProtocolByCarDealerCode(req.getCarDealerCode(),
                eBankType.getCode());
        CollectBankcard condition = new CollectBankcard();
        condition.setCompanyCode(req.getCarDealerCode());
        condition.setType(ECollectBankcard.DEALER_REBATE.getCode());
        List<CollectBankcard> list = collectBankcardBO
            .queryCollectBankcardByCompanyCodeAndType(condition);
        for (CollectBankcard collectBankcard : list) {
            Double pointRate = collectBankcard.getPointRate();
            XN632290Res res = new XN632290Res();
            res.setUseMoneyPurpose(EUseMoneyPurpose.PROTOCOL_INNER.getCode());
            // 1单笔 2贷款额百分比
            if ("1".equals(carDealerProtocol.getReturnPointType())) {
                res.setRepointAmount(AmountUtil.mul(
                    carDealerProtocol.getReturnPointFee(), pointRate));
            } else if ("2".equals(carDealerProtocol.getReturnPointType())) {
                Long loanAmount = budgetOrder.getLoanAmount();
                Double returnPointRate = carDealerProtocol.getReturnPointRate();
                Long RepointAmount = AmountUtil
                    .mul(loanAmount, returnPointRate);
                res.setRepointAmount(AmountUtil.mul(RepointAmount, pointRate));
            }
            res.setId(String.valueOf(carDealerProtocol.getId()));
            res.setAccountCode(collectBankcard.getBankcardNumber());
            CarDealer carDealer = carDealerBO.getCarDealer(req
                .getCarDealerCode());
            res.setCompanyName(carDealer.getFullName());
            res.setBankcardNumber(collectBankcard.getBankcardNumber());
            res.setSubbranch(collectBankcard.getRealName());
            resList.add(res);
        }

        // 应退按揭款
        XN632290Res res = new XN632290Res();
        res.setUseMoneyPurpose(EUseMoneyPurpose.MORTGAGE.getCode());
        res.setRepointAmount(budgetOrder.getLoanAmount());
        Department department = departmentBO.getDepartment(budgetOrder
            .getCompanyCode());
        res.setCompanyName(department.getName());
        CollectBankcard condition2 = new CollectBankcard();
        condition2.setCompanyCode(department.getCode());
        condition2.setType(ECollectBankcard.PLATFORM.getCode());
        List<CollectBankcard> list2 = collectBankcardBO
            .queryCollectBankcardByCompanyCodeAndType(condition2);
        CollectBankcard collectBankcard2 = list2.get(0);
        res.setBankcardNumber(collectBankcard2.getBankcardNumber());
        res.setSubbranch(collectBankcard2.getRealName());
        resList.add(res);
        return resList;
    }

    @Override
    public Object queryRepointDetailListByCarDealerCode(RepointDetail condition) {

        return repointDetailBO.queryRepointDetailList(condition);
    }
}
