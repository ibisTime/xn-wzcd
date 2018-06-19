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
import com.cdkj.loan.core.StringValidater;
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
import com.cdkj.loan.enums.ECollectBankcardType;
import com.cdkj.loan.enums.EFeeWay;
import com.cdkj.loan.enums.EGpsFeeWay;
import com.cdkj.loan.enums.ELoanPeriod;
import com.cdkj.loan.enums.ERateType;
import com.cdkj.loan.enums.ERepointType;
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
        // 返回数据 包括应退按揭款和协议内返点
        List<XN632290Res> resList = new ArrayList<XN632290Res>();

        // 1、协议内返点
        Bank bank = bankBO.getBankBySubbranch(budgetOrder.getLoanBankCode());
        EBankType eBankType = null;
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

        // 贷款额
        Long loanAmount = budgetOrder.getLoanAmount();
        // 服务费
        Long fee = StringValidater.toLong(req.getFee());
        // 银行利率
        double bankRate = StringValidater.toDouble(req.getBankRate());
        // 基准利率
        double benchmarkRate = 0;
        if (ELoanPeriod.ONE_YEAER.getCode().equals(req.getLoanPeriods())) {

            if (ERateType.CT.getCode().equals(req.getRateType())) {
                benchmarkRate = carDealerProtocol.getPlatCtRate12();
            } else if (ERateType.ZT.getCode().equals(req.getRateType())) {
                benchmarkRate = carDealerProtocol.getPlatZkRate12();
            }

        } else if (ELoanPeriod.TWO_YEAR.getCode().equals(req.getLoanPeriods())) {

            if (ERateType.CT.getCode().equals(req.getRateType())) {
                benchmarkRate = carDealerProtocol.getPlatCtRate24();
            } else if (ERateType.ZT.getCode().equals(req.getRateType())) {
                benchmarkRate = carDealerProtocol.getPlatZkRate24();
            }

        } else if (ELoanPeriod.THREE_YEAR.getCode()
            .equals(req.getLoanPeriods())) {

            if (ERateType.CT.getCode().equals(req.getRateType())) {
                benchmarkRate = carDealerProtocol.getPlatCtRate36();
            } else if (ERateType.ZT.getCode().equals(req.getRateType())) {
                benchmarkRate = carDealerProtocol.getPlatZkRate36();
            }
        }
        // 返点支付总金额
        Long repointAmount = null;
        if (ERateType.CT.getCode().equals(req.getRateType())) {
            // 传统返点支付总金额:贷款额*（银行实际利率-基准利率） =贷款额*[(服务费/贷款额)+银行利率-基准利率]
            repointAmount = AmountUtil.mul(loanAmount,
                (AmountUtil.div(fee, loanAmount) + bankRate - benchmarkRate));
        } else if (ERateType.ZT.getCode().equals(req.getRateType())) {
            // 直客 :贷款额*基准利率
            repointAmount = AmountUtil.mul(loanAmount, benchmarkRate);
        }
        // 收客户手续费合计：履约保证金+担保风险金+杂费
        Long sxFee = StringValidater.toLong(req.getLyAmount())
                + StringValidater.toLong(req.getFxAmount())
                + StringValidater.toLong(req.getOtherFee());
        // 实际返点金额：
        // 协议里的返点类型是百分比:（返点支付总金额-手续费（返点扣）-GPS（返点扣））*（1- 返点税点）
        // 协议里的返点类型是单笔 :（返点支付总金额-手续费（返点扣）-GPS（返点扣））-单笔
        Long actualRepointAmount = null;
        if (EGpsFeeWay.REPOINT.getCode().equals(req.getGpsFeeWay())
                && EFeeWay.REPOINT.getCode().equals(req.getFeeWay())) {
            actualRepointAmount = repointAmount - sxFee
                    - StringValidater.toLong(req.getGpsFee());
        } else if (!EGpsFeeWay.REPOINT.getCode().equals(req.getGpsFeeWay())
                && EFeeWay.REPOINT.getCode().equals(req.getFeeWay())) {
            actualRepointAmount = repointAmount - sxFee;
        } else if (EGpsFeeWay.REPOINT.getCode().equals(req.getGpsFeeWay())
                && !EFeeWay.REPOINT.getCode().equals(req.getFeeWay())) {
            actualRepointAmount = repointAmount
                    - StringValidater.toLong(req.getGpsFee());
        } else if (!EGpsFeeWay.REPOINT.getCode().equals(req.getGpsFeeWay())
                && !EFeeWay.REPOINT.getCode().equals(req.getFeeWay())) {
            actualRepointAmount = repointAmount;
        }
        if (ERepointType.SINGLE.getCode().equals(
            carDealerProtocol.getReturnPointType())) {
            actualRepointAmount = actualRepointAmount
                    - carDealerProtocol.getReturnPointFee();
        } else if (ERepointType.PERCENT.getCode().equals(
            carDealerProtocol.getReturnPointType())) {
            actualRepointAmount = AmountUtil.mul(actualRepointAmount,
                (1 - carDealerProtocol.getReturnPointRate()));
        }
        // 获得汽车经销商返点账号集合
        CollectBankcard condition = new CollectBankcard();
        condition.setCompanyCode(req.getCarDealerCode());
        condition.setType(ECollectBankcardType.DEALER_REBATE.getCode());
        List<CollectBankcard> list = collectBankcardBO
            .queryCollectBankcardByCompanyCodeAndType(condition);

        Bank bank2 = bankBO.getBankBySubbranch(budgetOrder.getLoanBankCode());
        String bankCode = null;
        if (null != bank2) {
            bankCode = bank2.getBankCode();
        }
        for (CollectBankcard collectBankcard : list) {
            if (collectBankcard.getBankCode() == bankCode) {
                XN632290Res res = new XN632290Res();
                Double pointRate = collectBankcard.getPointRate();
                res.setUseMoneyPurpose(EUseMoneyPurpose.PROTOCOL_INNER
                    .getCode());
                res.setRepointAmount(AmountUtil.mul(actualRepointAmount,
                    pointRate));
                res.setId(String.valueOf(carDealerProtocol.getId()));
                res.setAccountCode(collectBankcard.getBankcardNumber());
                CarDealer carDealer = carDealerBO.getCarDealer(req
                    .getCarDealerCode());
                res.setCompanyName(carDealer.getFullName());
                res.setBankcardNumber(collectBankcard.getBankcardNumber());
                res.setSubbranch(collectBankcard.getRealName());
                resList.add(res);
            }
        }
        // 2、应退按揭款
        XN632290Res res = new XN632290Res();
        res.setUseMoneyPurpose(EUseMoneyPurpose.MORTGAGE.getCode());

        Long carDealerSubsidy = StringValidater.toLong(req
            .getCarDealerSubsidy());// 厂家贴息
        Long shouldBackAmount = null;// 表里还是用的RepointAmount
        if (EGpsFeeWay.REPOINT.getCode().equals(req.getGpsFeeWay())
                && EFeeWay.REPOINT.getCode().equals(req.getFeeWay())) {
            shouldBackAmount = loanAmount - sxFee
                    - -StringValidater.toLong(req.getGpsFee())
                    - carDealerSubsidy;
        } else if (!EGpsFeeWay.REPOINT.getCode().equals(req.getGpsFeeWay())
                && EFeeWay.REPOINT.getCode().equals(req.getFeeWay())) {
            shouldBackAmount = loanAmount - sxFee - carDealerSubsidy;
        } else if (EGpsFeeWay.REPOINT.getCode().equals(req.getGpsFeeWay())
                && !EFeeWay.REPOINT.getCode().equals(req.getFeeWay())) {
            shouldBackAmount = loanAmount
                    - StringValidater.toLong(req.getGpsFee())
                    - carDealerSubsidy;
        } else if (!EGpsFeeWay.REPOINT.getCode().equals(req.getGpsFeeWay())
                && !EFeeWay.REPOINT.getCode().equals(req.getFeeWay())) {
            shouldBackAmount = loanAmount - carDealerSubsidy;
        }
        res.setRepointAmount(shouldBackAmount);// 应退按揭款金额=贷款金额-收客户手续费（按揭款扣）-GPS收费（按揭款扣）-厂家贴息
        Department department = departmentBO.getDepartment(budgetOrder
            .getCompanyCode());
        res.setCompanyName(department.getName());
        CollectBankcard condition2 = new CollectBankcard();
        condition2.setCompanyCode(department.getCode());
        condition2.setType(ECollectBankcardType.PLATFORM.getCode());
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
