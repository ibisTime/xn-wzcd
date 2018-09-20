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
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ECollectBankcardType;
import com.cdkj.loan.enums.EGpsFeeWay;
import com.cdkj.loan.enums.ELoanPeriod;
import com.cdkj.loan.enums.ERateType;
import com.cdkj.loan.enums.ERepointType;
import com.cdkj.loan.enums.EServiceChargeWay;
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
    public Paginable<RepointDetail> queryRepointDetailPage(int start, int limit,
            RepointDetail condition) {
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
    public List<RepointDetail> calculateRepointDetail(BudgetOrder data) {
        // 返回数据 只有协议内返点
        ArrayList<RepointDetail> returnList = new ArrayList<RepointDetail>();
        Long loanAmount = getLong(data.getLoanAmount());// 贷款金额
        Bank bank = bankBO.getBankBySubbranch(data.getLoanBankCode());
        CarDealerProtocol carDealerProtocol = carDealerProtocolBO
            .getCarDealerProtocolByCarDealerCode(data.getCarDealerCode(),
                bank.getBankCode());
        Double bankRate = getDouble(data.getBankRate()); // 银行利率
        Double globalRate = getDouble(data.getGlobalRate()); // 综合利率（银行实际利率）
        Double benchmarkRate = 0D;// 基准利率
        String rateType = data.getRateType();// 利率类型
        if (ELoanPeriod.ONE_YEAER.getCode().equals(data.getLoanPeriods())
                && ERateType.CT.getCode().equals(rateType)) {
            benchmarkRate = getDouble(carDealerProtocol.getPlatCtRate12());
        }
        if (ELoanPeriod.ONE_YEAER.getCode().equals(data.getLoanPeriods())
                && ERateType.ZK.getCode().equals(rateType)) {
            benchmarkRate = getDouble(carDealerProtocol.getPlatZkRate12());
        }
        if (ELoanPeriod.TWO_YEAR.getCode().equals(data.getLoanPeriods())
                && ERateType.CT.getCode().equals(rateType)) {
            benchmarkRate = getDouble(carDealerProtocol.getPlatCtRate24());
        }
        if (ELoanPeriod.TWO_YEAR.getCode().equals(data.getLoanPeriods())
                && ERateType.ZK.getCode().equals(rateType)) {
            benchmarkRate = getDouble(carDealerProtocol.getPlatZkRate24());
        }
        if (ELoanPeriod.THREE_YEAR.getCode().equals(data.getLoanPeriods())
                && ERateType.CT.getCode().equals(rateType)) {
            benchmarkRate = getDouble(carDealerProtocol.getPlatCtRate36());
        }
        if (ELoanPeriod.THREE_YEAR.getCode().equals(data.getLoanPeriods())
                && ERateType.ZK.getCode().equals(rateType)) {
            benchmarkRate = getDouble(carDealerProtocol.getPlatZkRate36());
        }
        if (bankRate < benchmarkRate) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "银行利率小于我司基准利率，不符合贷前准入单提交条件！");
        }
        Long repointAmount = 0L;// 返点支付总金额
        if (ERateType.CT.getCode().equals(rateType)) {
            // 传统返点支付总金额:贷款额*（银行实际利率-基准利率） =贷款额*[(服务费/贷款额)+银行利率-基准利率]
            repointAmount = AmountUtil.mul(loanAmount,
                (bankRate - benchmarkRate));
        }
        if (ERateType.ZK.getCode().equals(rateType)) {
            // 直客返点支付总金额 :贷款额*基准利率
            repointAmount = AmountUtil.mul(loanAmount, benchmarkRate);
        }
        // 实际返点金额：
        // 协议里的返点类型是百分比:（返点支付总金额-手续费（返点扣）-GPS（返点扣））*（1- 返点税点）
        // 协议里的返点类型是单笔 :（返点支付总金额-手续费（返点扣）-GPS（返点扣））-单笔
        Long actualRepointAmount = 0L;// 实际返点金额
        Long lyAmount = getLong(data.getLyAmount());
        Long fxAmount = getLong(data.getFxAmount());
        Long otherFee = getLong(data.getOtherFee());
        Long sxFee = 0L;// 收客户手续费合计：履约保证金+担保风险金+杂费
        if (EServiceChargeWay.REPOINT.getCode()
            .equals(data.getServiceChargeWay())) {
            sxFee = lyAmount + fxAmount + otherFee;
        }
        Long gpsFee = 0L;// GPS费
        if (EGpsFeeWay.REPOINT.getCode().equals(data.getGpsFeeWay())) {
            gpsFee = getLong(data.getGpsFee());
        }
        actualRepointAmount = repointAmount - sxFee - gpsFee;
        if (ERepointType.SINGLE.getCode()
            .equals(carDealerProtocol.getReturnPointType())) {
            actualRepointAmount = actualRepointAmount
                    - getLong(carDealerProtocol.getReturnPointFee());
        }
        if (ERepointType.PERCENT.getCode()
            .equals(carDealerProtocol.getReturnPointType())) {
            actualRepointAmount = AmountUtil.mul(actualRepointAmount,
                (1 - getDouble(carDealerProtocol.getReturnPointRate())));
        }
        // 获得与业务单贷款银行对应的汽车经销商返点账号集合
        List<CollectBankcard> list = collectBankcardBO
            .queryCollectBankcardByCompanyCodeAndTypeAndBankCode(
                data.getCarDealerCode(),
                ECollectBankcardType.DEALER_REBATE.getCode(),
                bank.getBankCode());
        for (CollectBankcard collectBankcard : list) {
            RepointDetail repointDetail = new RepointDetail();
            Double pointRate = getDouble(collectBankcard.getPointRate());
            repointDetail
                .setUseMoneyPurpose(EUseMoneyPurpose.PROTOCOL_INNER.getCode());
            repointDetail.setRepointAmount(
                AmountUtil.mul(actualRepointAmount, pointRate));// 实际返点金额*返点比例=实际给汽车经销商返点的金额
            repointDetail.setAccountCode(collectBankcard.getCode());
            repointDetail.setBenchmarkRate(benchmarkRate);
            returnList.add(repointDetail);
        }
        return returnList;
    }

    private Long getLong(Object obj) {
        if (null == obj) {
            return 0L;
        } else {
            return (Long) obj;
        }
    }

    private Double getDouble(Object obj) {
        if (null == obj) {
            return 0D;
        } else {
            return (Double) obj;
        }
    }

    @Override
    public List<RepointDetail> queryRepointDetailListByCarDealer(
            RepointDetail condition) {
        return repointDetailBO.queryRepointDetailListByCarDealer(condition);
    }
}
