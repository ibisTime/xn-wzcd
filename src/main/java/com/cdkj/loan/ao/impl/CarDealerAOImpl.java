package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICarDealerAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.dto.req.XN632060Req;
import com.cdkj.loan.dto.req.XN632061Req;
import com.cdkj.loan.dto.req.XN632062Req;
import com.cdkj.loan.dto.req.XN632064Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ECarDealerNode;
import com.cdkj.loan.enums.ECarDealerProtocolStatus;
import com.cdkj.loan.enums.ECollectBankcardType;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EbelongBank;
import com.cdkj.loan.exception.BizException;

@Service
@Transactional
public class CarDealerAOImpl implements ICarDealerAO {

    @Autowired
    private ICarDealerBO carDealerBO;

    @Autowired
    ICollectBankcardBO collectBankcardBO;

    @Autowired
    ICarDealerProtocolBO carDealerProtocolBO;

    @Autowired
    ISYSBizLogBO sysBizLogBO;

    @Autowired
    INodeFlowBO nodeFlowBO;

    @Autowired
    IBankBO bankBO;

    @Override
    public String addCarDealer(XN632060Req req) {
        CarDealer data = new CarDealer();
        String code = OrderNoGenerater.generate(EGeneratePrefix.CARDEALER
            .getCode());
        data.setCode(code);
        data.setFullName(req.getFullName());
        data.setAbbrName(req.getAbbrName());
        data.setIsSelfDevelop(req.getIsSelfDevelop());
        data.setAddress(req.getAddress());
        data.setCarDealerType(req.getCarDealerType());
        data.setMainContact(req.getMainContact());
        data.setContactPhone(req.getContactPhone());
        data.setMainBrand(req.getMainBrand());
        data.setParentGroup(req.getParentGroup());
        data.setAgreementValidDateStart(DateUtil.strToDate(
            req.getAgreementValidDateStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setAgreementValidDateEnd(DateUtil.strToDate(
            req.getAgreementValidDateEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setAgreementPic(req.getAgreementPic());
        data.setSettleWay(req.getSettleWay());
        data.setBusinessArea(req.getBusinessArea());
        data.setBelongBranchCompany(req.getBelongBranchCompany());
        data.setCurNodeCode(ECarDealerNode.TODO_AUDIT.getCode());// 新增之后待审核
        data.setPolicyNote(req.getPolicyNote());
        data.setRemark(req.getRemark());
        carDealerBO.saveCarDealer(data);
        // 日志记录
        // 记录本次新增操作日志
        sysBizLogBO.recordCurrentSYSBizLog(code, EBizLogType.CAR_DEALER_AUDIT,
            code, ECarDealerNode.NEW_ADD.getCode(), req.getRemark(),
            req.getOperator());
        // 下个节点审核的操作日志
        sysBizLogBO.saveSYSBizLog(code, EBizLogType.CAR_DEALER_AUDIT, code,
            ECarDealerNode.TODO_AUDIT.getCode());
        // 经销商收款账号
        collectBankcardBO.saveCollectBankcardList(
            req.getJxsCollectBankcardList(),
            ECollectBankcardType.DEALER_COLLECT.getCode(), code);
        // 协议
        carDealerProtocolBO.saveCarDealerProtocolList(
            req.getCarDealerProtocolList(), code);
        // 工行返点账号
        collectBankcardBO.saveCollectBankcardList(
            req.getGsCollectBankcardList(),
            ECollectBankcardType.DEALER_REBATE.getCode(),
            EbelongBank.GH.getCode(), code);
        // 中行返点账号
        collectBankcardBO.saveCollectBankcardList(
            req.getZhCollectBankcardList(),
            ECollectBankcardType.DEALER_REBATE.getCode(),
            EbelongBank.ZH.getCode(), code);
        // 建行返点账号
        collectBankcardBO.saveCollectBankcardList(
            req.getJhCollectBankcardList(),
            ECollectBankcardType.DEALER_REBATE.getCode(),
            EbelongBank.JH.getCode(), code);

        return code;
    }

    @Override
    @Transactional
    public void editCarDealer(XN632062Req req) {
        CarDealer data = carDealerBO.getCarDealer(req.getCode());
        // 删除经销商下的收款账号
        collectBankcardBO.removeCollectBankcardByCompanyCode(data.getCode());
        // 删除协议
        carDealerProtocolBO.removeCarDealerProtocolByCarDealerCode(data
            .getCode());

        data.setFullName(req.getFullName());
        data.setAbbrName(req.getAbbrName());
        data.setIsSelfDevelop(req.getIsSelfDevelop());
        data.setAddress(req.getAddress());
        data.setCarDealerType(req.getCarDealerType());
        data.setMainContact(req.getMainContact());
        data.setContactPhone(req.getContactPhone());
        data.setMainBrand(req.getMainBrand());
        data.setParentGroup(req.getParentGroup());
        data.setAgreementValidDateStart(DateUtil.strToDate(
            req.getAgreementValidDateStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setAgreementValidDateEnd(DateUtil.strToDate(
            req.getAgreementValidDateEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setAgreementPic(req.getAgreementPic());
        data.setSettleWay(req.getSettleWay());
        data.setBusinessArea(req.getBusinessArea());
        data.setBelongBranchCompany(req.getBelongBranchCompany());

        data.setApproveNote(req.getOperator());
        data.setPolicyNote(req.getPolicyNote());
        data.setRemark(req.getRemark());
        data.setCurNodeCode(ECarDealerNode.TODO_AUDIT.getCode());// 修改之后待审核
        carDealerBO.refreshCarDealer(data);

        // 日志
        SYSBizLog sysBizLog = sysBizLogBO.getSYSBizLoglatest(
            EBizLogType.CAR_DEALER_AUDIT.getCode(), data.getCode(),
            ECarDealerNode.AUDIT_NOT_PASS.getCode());
        if (null != sysBizLog && null == sysBizLog.getOperator()
                && null == sysBizLog.getEndDatetime()) {
            // 审核不通过进来的修改
            sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
                EBizLogType.CAR_DEALER_AUDIT, data.getCode(),
                ECarDealerNode.AUDIT_NOT_PASS.getCode(),
                ECarDealerNode.TODO_AUDIT.getCode(), null, req.getOperator());
        } else {
            // 修改
            sysBizLogBO.saveSYSBizLog(data.getCode(),
                EBizLogType.CAR_DEALER_AUDIT, data.getCode(),
                ECarDealerNode.TODO_AUDIT.getCode());
        }

        // 保存
        collectBankcardBO.saveCollectBankcardList(
            req.getJxsCollectBankcardList(),
            ECollectBankcardType.DEALER_COLLECT.getCode(), req.getCode());

        carDealerProtocolBO.saveCarDealerProtocolList(
            req.getCarDealerProtocolList(), req.getCode());

        collectBankcardBO.saveCollectBankcardList(
            req.getGsCollectBankcardList(),
            ECollectBankcardType.DEALER_REBATE.getCode(),
            EbelongBank.GH.getCode(), req.getCode());

        collectBankcardBO.saveCollectBankcardList(
            req.getZhCollectBankcardList(),
            ECollectBankcardType.DEALER_REBATE.getCode(),
            EbelongBank.ZH.getCode(), req.getCode());

        collectBankcardBO.saveCollectBankcardList(
            req.getJhCollectBankcardList(),
            ECollectBankcardType.DEALER_REBATE.getCode(),
            EbelongBank.JH.getCode(), req.getCode());

    }

    // 审核
    @Override
    public void audit(String code, String auditResult, String auditor,
            String approveNote) {
        CarDealer carDealer = carDealerBO.getCarDealer(code);
        String preCurNodeCode = carDealer.getCurNodeCode();// 当前节点
        if (!ECarDealerNode.TODO_AUDIT.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是汽车经销商审核节点，不能操作");
        }
        if (EApproveResult.PASS.getCode().equals(auditResult)) {
            // 审核通过
            carDealer.setAgreementStatus(ECarDealerProtocolStatus.UP.getCode());// 审核通过之后汽车经商协议状态改为上架
            carDealerBO.refreshCarDealer(carDealer);
            carDealer.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preCurNodeCode).getNextNode());
            // 日志
            sysBizLogBO.refreshPreSYSBizLog(EBizLogType.CAR_DEALER_AUDIT,
                carDealer.getCode(), preCurNodeCode, approveNote, auditor);
        } else {
            carDealer.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preCurNodeCode).getBackNode());
            // 日志
            sysBizLogBO.saveNewAndPreEndSYSBizLog(carDealer.getCode(),
                EBizLogType.CAR_DEALER_AUDIT, carDealer.getCode(),
                preCurNodeCode, carDealer.getCurNodeCode(), approveNote,
                auditor);
        }
        carDealer.setApproveNote(approveNote);
        carDealerBO.refreshCarDealerNode(carDealer);// 更新节点
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
                collectBankcard.setType(ECollectBankcardType.DEALER_COLLECT
                    .getCode());
                List<CollectBankcard> jxsCollectBankcardList = collectBankcardBO
                    .queryCollectBankcardList(collectBankcard);// 经销商收款账号
                carDealer.setJxsCollectBankcardList(jxsCollectBankcardList);
                collectBankcard.setType(ECollectBankcardType.DEALER_REBATE
                    .getCode());
                List<CollectBankcard> queryCollectBankcardList = collectBankcardBO
                    .queryCollectBankcardList(collectBankcard);// 经销商返点账号

                // 协议
                CarDealerProtocol carDealerProtocol = new CarDealerProtocol();
                carDealerProtocol.setCarDealerCode(carDealer.getCode());
                List<CarDealerProtocol> queryCarDealerProtocolList = carDealerProtocolBO
                    .queryCarDealerProtocolList(carDealerProtocol);
                carDealer.setCarDealerProtocolList(queryCarDealerProtocolList);

                List<CollectBankcard> ghList = new ArrayList<CollectBankcard>();
                List<CollectBankcard> zhList = new ArrayList<CollectBankcard>();
                List<CollectBankcard> jhList = new ArrayList<CollectBankcard>();
                for (CollectBankcard collectBankcard2 : queryCollectBankcardList) {
                    // 工行
                    if (collectBankcard2.getBelongBank().equals(
                        EbelongBank.GH.getCode())) {
                        ghList.add(collectBankcard2);
                    }
                    // 中行
                    if (collectBankcard2.getBelongBank().equals(
                        EbelongBank.ZH.getCode())) {
                        zhList.add(collectBankcard2);
                    }
                    // 建行
                    if (collectBankcard2.getBelongBank().equals(
                        EbelongBank.JH.getCode())) {
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
            // 收款账号
            CollectBankcard collectBankcard = new CollectBankcard();
            collectBankcard.setCompanyCode(carDealer.getCode());
            collectBankcard.setType(ECollectBankcardType.DEALER_COLLECT
                .getCode());
            List<CollectBankcard> jxsCollectBankcardList = collectBankcardBO
                .queryCollectBankcardList(collectBankcard);
            carDealer.setJxsCollectBankcardList(jxsCollectBankcardList);// 经销商收款账号

            // 协议
            CarDealerProtocol carDealerProtocol = new CarDealerProtocol();
            carDealerProtocol.setCarDealerCode(carDealer.getCode());
            List<CarDealerProtocol> queryCarDealerProtocolList = carDealerProtocolBO
                .queryCarDealerProtocolList(carDealerProtocol);
            carDealer.setCarDealerProtocolList(queryCarDealerProtocolList);

            // 返点账号
            collectBankcard.setType(ECollectBankcardType.DEALER_REBATE
                .getCode());
            List<CollectBankcard> queryCollectBankcardList = collectBankcardBO
                .queryCollectBankcardList(collectBankcard);

            List<CollectBankcard> ghList = new ArrayList<CollectBankcard>();
            List<CollectBankcard> zhList = new ArrayList<CollectBankcard>();
            List<CollectBankcard> jhList = new ArrayList<CollectBankcard>();
            for (CollectBankcard domain : queryCollectBankcardList) {
                // 工行
                if (domain.getBelongBank().equals(EbelongBank.GH.getCode())) {
                    ghList.add(domain);
                }
                // 中行
                if (domain.getBelongBank().equals(EbelongBank.ZH.getCode())) {
                    zhList.add(domain);
                }
                // 建行
                if (domain.getBelongBank().equals(EbelongBank.JH.getCode())) {
                    jhList.add(domain);
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
        collectBankcard.setType(ECollectBankcardType.DEALER_COLLECT.getCode());
        List<CollectBankcard> jxsCollectBankcardList = collectBankcardBO
            .queryCollectBankcardList(collectBankcard);
        carDealer.setJxsCollectBankcardList(jxsCollectBankcardList);
        collectBankcard.setType(ECollectBankcardType.DEALER_REBATE.getCode());
        List<CollectBankcard> queryCollectBankcardList = collectBankcardBO
            .queryCollectBankcardList(collectBankcard);

        // 协议
        CarDealerProtocol carDealerProtocol = new CarDealerProtocol();
        carDealerProtocol.setCarDealerCode(carDealer.getCode());
        List<CarDealerProtocol> queryCarDealerProtocolList = carDealerProtocolBO
            .queryCarDealerProtocolList(carDealerProtocol);
        carDealer.setCarDealerProtocolList(queryCarDealerProtocolList);

        List<CollectBankcard> ghList = new ArrayList<CollectBankcard>();
        List<CollectBankcard> zhList = new ArrayList<CollectBankcard>();
        List<CollectBankcard> jhList = new ArrayList<CollectBankcard>();
        for (CollectBankcard domain : queryCollectBankcardList) {
            // 工行
            if (domain.getBelongBank().equals(EbelongBank.GH.getCode())) {
                ghList.add(domain);
            }
            // 中行
            if (domain.getBelongBank().equals(EbelongBank.ZH.getCode())) {
                zhList.add(domain);
            }
            // 建行
            if (domain.getBelongBank().equals(EbelongBank.JH.getCode())) {
                jhList.add(domain);
            }
        }
        carDealer.setGsCollectBankcardList(ghList);
        carDealer.setZhCollectBankcardList(zhList);
        carDealer.setJhCollectBankcardList(jhList);

        return carDealer;
    }

    @Override
    public List<CarDealer> expireWarning(String year, String month) {
        CarDealer condition = new CarDealer();
        condition.setWarnDatetimeStart(DateUtil.getBeginTime(
            StringValidater.toInteger(year), StringValidater.toInteger(month)));
        condition.setWarnDatetimeEnd(DateUtil.getEndTime(
            StringValidater.toInteger(year), StringValidater.toInteger(month)));
        List<CarDealer> queryCarDealerList = carDealerBO
            .queryCarDealerList(condition);
        return queryCarDealerList;
    }

    @Override
    public void carDealerProtocolDown(XN632061Req req) {
        CarDealer carDealer = carDealerBO.getCarDealer(req.getCode());
        if (ECarDealerProtocolStatus.DOWN.getCode().equals(
            carDealer.getAgreementStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前汽车经销商协议已下架，不能操作");
        }
        carDealer.setAgreementStatus(ECarDealerProtocolStatus.DOWN.getCode());
        carDealerBO.refreshCarDealer(carDealer);
        sysBizLogBO.recordCurrentSYSBizLog(carDealer.getCode(),
            EBizLogType.CAR_DEALER_AUDIT, carDealer.getCode(),
            ECarDealerNode.DOWN.getCode(), null, req.getOperator());
    }

    @Override
    public void carDealerProtocolUp(XN632064Req req) {
        CarDealer carDealer = carDealerBO.getCarDealer(req.getCode());
        if (ECarDealerProtocolStatus.UP.getCode().equals(
            carDealer.getAgreementStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前汽车经销商协议已上架，不能操作");
        }
        if (ECarDealerNode.TODO_AUDIT.getCode().equals(
            carDealer.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前汽车经销商待审核中，不能操作");
        }
        carDealer.setCurNodeCode(ECarDealerNode.TODO_AUDIT.getCode());// 上架之后待审核审核通过之后改为上架
        carDealerBO.refreshCarDealerNode(carDealer);
        sysBizLogBO.recordCurrentSYSBizLog(carDealer.getCode(),
            EBizLogType.CAR_DEALER_AUDIT, carDealer.getCode(),
            ECarDealerNode.UP.getCode(), null, req.getOperator());
        sysBizLogBO.saveSYSBizLog(carDealer.getCode(),
            EBizLogType.CAR_DEALER_AUDIT, carDealer.getCode(),
            ECarDealerNode.TODO_AUDIT.getCode());
    }

}
