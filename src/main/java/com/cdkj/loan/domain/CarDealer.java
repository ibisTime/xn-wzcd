package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

public class CarDealer extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String code;// 编号

    private String fullName;// 全称

    private String abbrName;// 简称

    private String isSelfDevelop;// 是否自主开发

    private String address;// 地址

    private String carDealerType;// 车行经营性质

    private String mainContact;// 主要联系人

    private String contactPhone;// 联系人电话

    private String mainBrand;// 主营品牌

    private String parentGroup;// 所属集团

    private Date agreementValidDateStart;// 合作协议有效期起

    private Date agreementValidDateEnd;// 合作协议有效期止

    private String agreementStatus;// 协议状态

    private String agreementPic;// 车商合作协议

    private String settleWay;// 结算方式

    private String businessArea;// 业务区域

    private String belongBranchCompany;// 归属分公司

    private String curNodeCode;// 当前节点编号

    private String approveNote;// 审核说明

    private String policyNote;// 政策说明

    private String remark;// 备注

    /*--------辅助字段----------*/

    private List<CollectBankcard> collectBankcardList;

    private List<CollectBankcard> jxsCollectBankcardList;// 经销商收款账号列表

    private List<CarDealerProtocol> carDealerProtocolList;// 经销商协议表

    private List<CollectBankcard> gsCollectBankcardList;// 工商银行返点账号列表

    private List<CollectBankcard> zhCollectBankcardList;// 中行银行返点账号列表

    private List<CollectBankcard> jhCollectBankcardList;// 建行银行返点账号列表

    public List<CollectBankcard> getCollectBankcardList() {
        return collectBankcardList;
    }

    public void setCollectBankcardList(
            List<CollectBankcard> collectBankcardList) {
        this.collectBankcardList = collectBankcardList;
    }

    public List<CarDealerProtocol> getCarDealerProtocolList() {
        return carDealerProtocolList;
    }

    public void setCarDealerProtocolList(
            List<CarDealerProtocol> carDealerProtocolList) {
        this.carDealerProtocolList = carDealerProtocolList;
    }

    public List<CollectBankcard> getJxsCollectBankcardList() {
        return jxsCollectBankcardList;
    }

    public void setJxsCollectBankcardList(
            List<CollectBankcard> jxsCollectBankcardList) {
        this.jxsCollectBankcardList = jxsCollectBankcardList;
    }

    public List<CollectBankcard> getGsCollectBankcardList() {
        return gsCollectBankcardList;
    }

    public void setGsCollectBankcardList(
            List<CollectBankcard> gsCollectBankcardList) {
        this.gsCollectBankcardList = gsCollectBankcardList;
    }

    public List<CollectBankcard> getZhCollectBankcardList() {
        return zhCollectBankcardList;
    }

    public void setZhCollectBankcardList(
            List<CollectBankcard> zhCollectBankcardList) {
        this.zhCollectBankcardList = zhCollectBankcardList;
    }

    public List<CollectBankcard> getJhCollectBankcardList() {
        return jhCollectBankcardList;
    }

    public void setJhCollectBankcardList(
            List<CollectBankcard> jhCollectBankcardList) {
        this.jhCollectBankcardList = jhCollectBankcardList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public String getIsSelfDevelop() {
        return isSelfDevelop;
    }

    public void setIsSelfDevelop(String isSelfDevelop) {
        this.isSelfDevelop = isSelfDevelop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarDealerType() {
        return carDealerType;
    }

    public void setCarDealerType(String carDealerType) {
        this.carDealerType = carDealerType;
    }

    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getMainBrand() {
        return mainBrand;
    }

    public void setMainBrand(String mainBrand) {
        this.mainBrand = mainBrand;
    }

    public String getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(String parentGroup) {
        this.parentGroup = parentGroup;
    }

    public Date getAgreementValidDateStart() {
        return agreementValidDateStart;
    }

    public void setAgreementValidDateStart(Date agreementValidDateStart) {
        this.agreementValidDateStart = agreementValidDateStart;
    }

    public Date getAgreementValidDateEnd() {
        return agreementValidDateEnd;
    }

    public void setAgreementValidDateEnd(Date agreementValidDateEnd) {
        this.agreementValidDateEnd = agreementValidDateEnd;
    }

    public String getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(String agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public String getAgreementPic() {
        return agreementPic;
    }

    public void setAgreementPic(String agreementPic) {
        this.agreementPic = agreementPic;
    }

    public String getSettleWay() {
        return settleWay;
    }

    public void setSettleWay(String settleWay) {
        this.settleWay = settleWay;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getBelongBranchCompany() {
        return belongBranchCompany;
    }

    public void setBelongBranchCompany(String belongBranchCompany) {
        this.belongBranchCompany = belongBranchCompany;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getPolicyNote() {
        return policyNote;
    }

    public void setPolicyNote(String policyNote) {
        this.policyNote = policyNote;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
