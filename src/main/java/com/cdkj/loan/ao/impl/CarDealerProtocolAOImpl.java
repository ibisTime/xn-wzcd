package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarDealerProtocolAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.dto.req.XN632060ReqProtocol;
import com.cdkj.loan.dto.req.XN632291Req;
import com.cdkj.loan.dto.res.XN632291Res;
import com.cdkj.loan.enums.EAssureType;
import com.cdkj.loan.enums.EBankType;
import com.cdkj.loan.enums.EGpsTypeProtocol;
import com.cdkj.loan.enums.ELyAmountType;
import com.cdkj.loan.enums.EOtherType;

@Service
public class CarDealerProtocolAOImpl implements ICarDealerProtocolAO {

    @Autowired
    private ICarDealerProtocolBO carDealerProtocolBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IBankBO bankBO;

    @Override
    public int addCarDealerProtocol(XN632060ReqProtocol req) {
        CarDealerProtocol data = new CarDealerProtocol();

        data.setCarDealerCode(req.getCarDealerCode());
        data.setBankCode(req.getBankCode());
        data.setPlatCtRate12(StringValidater.toDouble(req.getPlatCtRate12()));
        data.setPlatCtRate24(StringValidater.toDouble(req.getPlatCtRate24()));
        data.setPlatCtRate36(StringValidater.toDouble(req.getPlatCtRate36()));

        data.setPlatZkRate12(StringValidater.toDouble(req.getPlatZkRate12()));
        data.setPlatZkRate24(StringValidater.toDouble(req.getPlatZkRate24()));
        data.setPlatZkRate36(StringValidater.toDouble(req.getPlatZkRate36()));
        data.setAssureType(req.getAssureType());
        data.setAssureFee(StringValidater.toLong(req.getAssureFee()));

        data.setAssureRate(StringValidater.toDouble(req.getAssureRate()));
        data.setLyAmountType(req.getLyAmountType());
        data.setLyAmountFee(StringValidater.toLong(req.getLyAmountFee()));
        data.setLyAmountRate(StringValidater.toDouble(req.getLyAmountRate()));
        data.setGpsType(req.getGpsType());

        data.setGpsFee(StringValidater.toLong(req.getGpsFee()));
        data.setGpsRate(StringValidater.toDouble(req.getGpsRate()));
        data.setOtherType(req.getOtherType());
        data.setOtherFee(StringValidater.toLong(req.getOtherFee()));
        data.setOtherRate(StringValidater.toDouble(req.getOtherRate()));

        data.setIntroduceType(req.getIntroduceType());
        data.setIntroduceFee(StringValidater.toLong(req.getIntroduceFee()));
        data.setIntroduceRate(StringValidater.toDouble(req.getIntroduceRate()));
        data.setReturnPointType(req.getReturnPointType());
        data.setReturnPointFee(StringValidater.toLong(req.getReturnPointFee()));

        data.setReturnPointRate(StringValidater.toDouble(req
            .getReturnPointRate()));
        data.setIsDz(req.getIsDz());
        data.setInsuAgencyYear1Type(req.getInsuAgencyYear1Type());
        data.setInsuAgencyYear1Fee(StringValidater.toLong(req
            .getInsuAgencyYear1Fee()));
        data.setInsuAgencyYear2Type(req.getInsuAgencyYear2Type());

        data.setInsuAgencyYear2Fee(StringValidater.toLong(req
            .getInsuAgencyYear2Fee()));
        data.setInsuAgencyYear3Type(req.getInsuAgencyYear3Type());
        data.setInsuAgencyYear3Fee(StringValidater.toLong(req
            .getInsuAgencyYear3Fee()));

        return carDealerProtocolBO.saveCarDealerProtocol(data);
    }

    @Override
    public Paginable<CarDealerProtocol> queryCarDealerProtocolPage(int start,
            int limit, CarDealerProtocol condition) {
        return carDealerProtocolBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CarDealerProtocol> queryCarDealerProtocolList(
            CarDealerProtocol condition) {
        return carDealerProtocolBO.queryCarDealerProtocolList(condition);
    }

    @Override
    public CarDealerProtocol getCarDealerProtocol(int id) {
        return carDealerProtocolBO.getCarDealerProtocol(id);
    }

    @Override
    public XN632291Res protocolFee(XN632291Req req) {

        XN632291Res res = new XN632291Res();

        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req
            .getBudgetOrderCode());

        Long loanAmount = budgetOrder.getLoanAmount();

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
        if (EAssureType.SINGLE.getCode().equals(
            carDealerProtocol.getAssureType())) {
            res.setFxAmount(String.valueOf(carDealerProtocol.getAssureFee()));
        } else {
            res.setFxAmount(String.valueOf(AmountUtil.mul(loanAmount,
                carDealerProtocol.getAssureRate())));
        }

        if (ELyAmountType.SINGLE.getCode().equals(
            carDealerProtocol.getLyAmountType())) {
            res.setLyAmount(String.valueOf(carDealerProtocol.getLyAmountFee()));
        } else {
            res.setLyAmount(String.valueOf(AmountUtil.mul(loanAmount,
                carDealerProtocol.getLyAmountRate())));
        }

        if (EGpsTypeProtocol.SINGLE.getCode().equals(
            carDealerProtocol.getGpsType())) {
            res.setGpsFee(String.valueOf(carDealerProtocol.getGpsRate()));
        } else {
            res.setGpsFee(String.valueOf(AmountUtil.mul(loanAmount,
                carDealerProtocol.getGpsRate())));
        }

        if (EOtherType.SINGLE.getCode()
            .equals(carDealerProtocol.getOtherType())) {
            res.setOtherFee(String.valueOf(carDealerProtocol.getOtherFee()));
        } else {
            res.setOtherFee(String.valueOf(AmountUtil.mul(loanAmount,
                carDealerProtocol.getOtherRate())));
        }

        return res;
    }
}
