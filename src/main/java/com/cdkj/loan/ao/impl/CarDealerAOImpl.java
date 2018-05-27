package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICarDealerAO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.dto.req.XN632060Req;
import com.cdkj.loan.dto.req.XN632062Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBankCode;
import com.cdkj.loan.enums.ECarDealerNode;
import com.cdkj.loan.enums.ECollectBankcard;
import com.cdkj.loan.enums.EGeneratePrefix;

@Service
@Transactional
public class CarDealerAOImpl implements ICarDealerAO {

    @Autowired
    private ICarDealerBO carDealerBO;

    @Autowired
    ICollectBankcardBO collectBankcardBO;

    @Autowired
    ICarDealerProtocolBO carDealerProtocolBO;

    @Override
    public String addCarDealer(XN632060Req req) {
        CarDealer data = new CarDealer();
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.CARDEALER.getCode());
        data.setCode(code);
        data.setFullName(req.getFullName());
        data.setAbbrName(req.getAbbrName());
        data.setIsSelfDevelop(req.getIsSelfDevelop());
        data.setAddress(req.getAddress());
        data.setCarDealerType(req.getCarDealerType());
        data.setMainContact(req.getMainContact());
        data.setContactPhone(StringValidater.toLong(req.getContactPhone()));
        data.setMainBrand(req.getMainBrand());
        data.setParentGroup(req.getParentGroup());
        data.setAgreementValidDate(DateUtil.strToDate(
            req.getAgreementValidDate(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setAgreementStatus(req.getAgreementStatus());
        data.setAgreementPic(req.getAgreementPic());
        data.setSettleWay(req.getSettleWay());
        data.setBusinessArea(req.getBusinessArea());
        data.setBelongBranchCompany(req.getBelongBranchCompany());
        data.setCurNodeCode(ECarDealerNode.TO_AUDIT.getCode());
        data.setApproveNote(req.getApproveNote());
        data.setPolicyNote(req.getPolicyNote());
        data.setRemark(req.getRemark());
        carDealerBO.saveCarDealer(data);
        // 经销商收款账号
        collectBankcardBO.saveCollectBankcardList(
            req.getJxsCollectBankcardList(),
            ECollectBankcard.DEALER_COLLECT.getCode(), code);
        // 协议
        carDealerProtocolBO
            .saveCarDealerProtocolList(req.getCarDealerProtocolList());
        // 工行返点账号
        collectBankcardBO.saveCollectBankcardList(
            req.getGsCollectBankcardList(),
            ECollectBankcard.DEALER_REBATE.getCode(), EBankCode.ICBC.getCode(),
            code);
        // 中行返点账号
        collectBankcardBO.saveCollectBankcardList(
            req.getZhCollectBankcardList(),
            ECollectBankcard.DEALER_REBATE.getCode(), EBankCode.BOC.getCode(),
            code);
        // 建行返点账号
        collectBankcardBO.saveCollectBankcardList(
            req.getJhCollectBankcardList(),
            ECollectBankcard.DEALER_REBATE.getCode(), EBankCode.CCB.getCode(),
            code);

        return code;
    }

    @Override
    public void editCarDealer(XN632062Req req) {
        CarDealer data = carDealerBO.getCarDealer(req.getCode());
        data.setFullName(req.getFullName());
        data.setAbbrName(req.getAbbrName());
        data.setIsSelfDevelop(req.getIsSelfDevelop());
        data.setAddress(req.getAddress());
        data.setCarDealerType(req.getCarDealerType());
        data.setMainContact(req.getMainContact());
        data.setContactPhone(StringValidater.toLong(req.getContactPhone()));
        data.setMainBrand(req.getMainBrand());
        data.setParentGroup(req.getParentGroup());
        data.setAgreementValidDate(DateUtil.strToDate(
            req.getAgreementValidDate(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setAgreementStatus(req.getAgreementStatus());
        data.setAgreementPic(req.getAgreementPic());
        data.setSettleWay(req.getSettleWay());
        data.setBusinessArea(req.getBusinessArea());
        data.setBelongBranchCompany(req.getBelongBranchCompany());

        data.setApproveNote(req.getApproveNote());
        data.setPolicyNote(req.getPolicyNote());
        data.setRemark(req.getRemark());
        carDealerBO.refreshCarDealer(data);
        // 删除
        collectBankcardBO
            .removeCollectBankcardByList(req.getJxsCollectBankcardList());
        collectBankcardBO
            .removeCollectBankcardByList(req.getGsCollectBankcardList());
        collectBankcardBO
            .removeCollectBankcardByList(req.getZhCollectBankcardList());
        collectBankcardBO
            .removeCollectBankcardByList(req.getJhCollectBankcardList());
        // 保存
        collectBankcardBO.saveCollectBankcardList(
            req.getJxsCollectBankcardList(),
            ECollectBankcard.DEALER_COLLECT.getCode(), req.getCode());

        carDealerProtocolBO
            .saveCarDealerProtocolList(req.getCarDealerProtocolList());

        collectBankcardBO.saveCollectBankcardList(
            req.getGsCollectBankcardList(),
            ECollectBankcard.DEALER_REBATE.getCode(), EBankCode.ICBC.getCode(),
            req.getCode());

        collectBankcardBO.saveCollectBankcardList(
            req.getZhCollectBankcardList(),
            ECollectBankcard.DEALER_REBATE.getCode(), EBankCode.BOC.getCode(),
            req.getCode());

        collectBankcardBO.saveCollectBankcardList(
            req.getJhCollectBankcardList(),
            ECollectBankcard.DEALER_REBATE.getCode(), EBankCode.CCB.getCode(),
            req.getCode());

    }

    // 审核
    @Override
    public void audit(String code, String auditResult, String auditor,
            String approveNote) {
        CarDealer carDealer = carDealerBO.getCarDealer(code);
        if (EApproveResult.PASS.getCode().equals(auditResult)) {
            carDealer.setCurNodeCode(ECarDealerNode.AUDIT_PASS.getCode());
        } else {
            carDealer.setCurNodeCode(ECarDealerNode.AUDIT_NOT_PASS.getCode());
        }
        carDealer.setApproveNote(approveNote);
        carDealerBO.refreshCarDealerNode(carDealer);
    }

    @Override
    public int dropCarDealer(String code) {
        return carDealerBO.removeCarDealer(code);
    }

    @Override
    public Paginable<CarDealer> queryCarDealerPage(int start, int limit,
            CarDealer condition) {
        Paginable<CarDealer> results = carDealerBO.getPaginable(start, limit,
            condition);
        if (CollectionUtils.isNotEmpty(results.getList())) {
            for (CarDealer carDealer : results.getList()) {
                CollectBankcard collectBankcard = new CollectBankcard();
                collectBankcard.setCompanyCode(carDealer.getCode());
                collectBankcard
                    .setType(ECollectBankcard.DEALER_COLLECT.getCode());
                List<CollectBankcard> jxsCollectBankcardList = collectBankcardBO
                    .queryCollectBankcardList(collectBankcard);
                carDealer.setJxsCollectBankcardList(jxsCollectBankcardList);
                collectBankcard
                    .setType(ECollectBankcard.DEALER_REBATE.getCode());
                List<CollectBankcard> queryCollectBankcardList = collectBankcardBO
                    .queryCollectBankcardList(collectBankcard);

                // 协议
                CarDealerProtocol carDealerProtocol = new CarDealerProtocol();
                carDealerProtocol.setCarDealerCode(carDealer.getCode());
                List<CarDealerProtocol> queryCarDealerProtocolList = carDealerProtocolBO
                    .queryCarDealerProtocolList(carDealerProtocol);
                carDealer.setCarDealerProtocolList(queryCarDealerProtocolList);

                List<CollectBankcard> ghList = null;
                List<CollectBankcard> zhList = null;
                List<CollectBankcard> jhList = null;
                for (CollectBankcard collectBankcard2 : queryCollectBankcardList) {
                    // 工行
                    if (collectBankcard2.getBankCode()
                        .equals(EBankCode.ICBC.getCode())) {
                        ghList.add(collectBankcard2);
                    }
                    // 中行
                    if (collectBankcard2.getBankCode()
                        .equals(EBankCode.BOC.getCode())) {
                        zhList.add(collectBankcard2);
                    }
                    // 建行
                    if (collectBankcard2.getBankCode()
                        .equals(EBankCode.CCB.getCode())) {
                        jhList.add(collectBankcard2);
                    }
                }
                carDealer.setGsCollectBankcardList(ghList);
                carDealer.setZhCollectBankcardList(zhList);
                carDealer.setJhCollectBankcardList(jhList);

            }
        }

        return results;
    }

    @Override
    public List<CarDealer> queryCarDealerList(CarDealer condition) {
        List<CarDealer> queryCarDealerList = carDealerBO
            .queryCarDealerList(condition);
        for (CarDealer carDealer : queryCarDealerList) {
            CollectBankcard collectBankcard = new CollectBankcard();
            collectBankcard.setCompanyCode(carDealer.getCode());
            collectBankcard.setType(ECollectBankcard.DEALER_COLLECT.getCode());
            List<CollectBankcard> jxsCollectBankcardList = collectBankcardBO
                .queryCollectBankcardList(collectBankcard);
            carDealer.setJxsCollectBankcardList(jxsCollectBankcardList);
            collectBankcard.setType(ECollectBankcard.DEALER_REBATE.getCode());
            List<CollectBankcard> queryCollectBankcardList = collectBankcardBO
                .queryCollectBankcardList(collectBankcard);

            // 协议
            CarDealerProtocol carDealerProtocol = new CarDealerProtocol();
            carDealerProtocol.setCarDealerCode(carDealer.getCode());
            List<CarDealerProtocol> queryCarDealerProtocolList = carDealerProtocolBO
                .queryCarDealerProtocolList(carDealerProtocol);
            carDealer.setCarDealerProtocolList(queryCarDealerProtocolList);

            List<CollectBankcard> ghList = null;
            List<CollectBankcard> zhList = null;
            List<CollectBankcard> jhList = null;
            for (CollectBankcard collectBankcard2 : queryCollectBankcardList) {
                // 工行
                if (collectBankcard2.getBankCode()
                    .equals(EBankCode.ICBC.getCode())) {
                    ghList.add(collectBankcard2);
                }
                // 中行
                if (collectBankcard2.getBankCode()
                    .equals(EBankCode.BOC.getCode())) {
                    zhList.add(collectBankcard2);
                }
                // 建行
                if (collectBankcard2.getBankCode()
                    .equals(EBankCode.CCB.getCode())) {
                    jhList.add(collectBankcard2);
                }
            }
            carDealer.setGsCollectBankcardList(ghList);
            carDealer.setZhCollectBankcardList(zhList);
            carDealer.setJhCollectBankcardList(jhList);
        }
        return queryCarDealerList;
    }

    @Override
    public CarDealer getCarDealer(String code) {
        CarDealer carDealer = carDealerBO.getCarDealer(code);

        CollectBankcard collectBankcard = new CollectBankcard();
        collectBankcard.setCompanyCode(carDealer.getCode());
        collectBankcard.setType(ECollectBankcard.DEALER_COLLECT.getCode());
        List<CollectBankcard> jxsCollectBankcardList = collectBankcardBO
            .queryCollectBankcardList(collectBankcard);
        carDealer.setJxsCollectBankcardList(jxsCollectBankcardList);
        collectBankcard.setType(ECollectBankcard.DEALER_REBATE.getCode());
        List<CollectBankcard> queryCollectBankcardList = collectBankcardBO
            .queryCollectBankcardList(collectBankcard);

        // 协议
        CarDealerProtocol carDealerProtocol = new CarDealerProtocol();
        carDealerProtocol.setCarDealerCode(carDealer.getCode());
        List<CarDealerProtocol> queryCarDealerProtocolList = carDealerProtocolBO
            .queryCarDealerProtocolList(carDealerProtocol);
        carDealer.setCarDealerProtocolList(queryCarDealerProtocolList);

        List<CollectBankcard> ghList = null;
        List<CollectBankcard> zhList = null;
        List<CollectBankcard> jhList = null;
        for (CollectBankcard collectBankcard2 : queryCollectBankcardList) {
            // 工行
            if (collectBankcard2.getBankCode()
                .equals(EBankCode.ICBC.getCode())) {
                ghList.add(collectBankcard2);
            }
            // 中行
            if (collectBankcard2.getBankCode()
                .equals(EBankCode.BOC.getCode())) {
                zhList.add(collectBankcard2);
            }
            // 建行
            if (collectBankcard2.getBankCode()
                .equals(EBankCode.CCB.getCode())) {
                jhList.add(collectBankcard2);
            }
        }
        carDealer.setGsCollectBankcardList(ghList);
        carDealer.setZhCollectBankcardList(zhList);
        carDealer.setJhCollectBankcardList(jhList);

        return carDealer;
    }

}
