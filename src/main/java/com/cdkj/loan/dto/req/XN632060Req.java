package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.cdkj.loan.domain.CollectBankcard;

public class XN632060Req {

    @NotBlank
    private String fullName;// 全称

    @NotBlank
    private String abbrName;// 简称

    @NotBlank
    private String isSelfDevelop;// 是否自主开发

    @NotBlank
    private String address;// 地址

    @NotBlank
    private String carDealerType;// 车行经营性质

    @NotBlank
    private String mainContact;// 主要联系人

    @NotBlank
    private String contactPhone;// 联系人电话

    @NotBlank
    private String mainBrand;// 主营品牌

    @NotBlank
    private String parentGroup;// 所属集团

    @NotBlank
    private String agreement;// 协议

    @NotBlank
    private String agreementValidDate;// 合作协议有效期

    @NotBlank
    private String agreementStatus;// 协议状态

    @NotBlank
    private String agreementPic;// 车商合作协议

    @NotBlank
    private String settleWay;// 结算方式

    @NotBlank
    private String businessArea;// 业务区域

    @NotBlank
    private String belongBranchCompany;// 归属分公司

    private String approveNote;// 审核说明

    private String policyNote;// 政策说明

    private String remark;// 备注

    private List<CollectBankcard> jxsCollectBankcardList;// 经销商收款账号列表

    private List<XN632060ReqProtocol> CarDealerProtocolList;// 经销商协议表

    private List<CollectBankcard> gsCollectBankcardList;// 工商银行返点账号列表

    private List<CollectBankcard> zhCollectBankcardList;// 中行银行返点账号列表

    private List<CollectBankcard> jhCollectBankcardList;// 建行银行返点账号列表

    public String getFullName() {
        return fullName;
    }

    public List<CollectBankcard> getJxsCollectBankcardList() {
        return jxsCollectBankcardList;
    }

    public void setJxsCollectBankcardList(
            List<CollectBankcard> jxsCollectBankcardList) {
        this.jxsCollectBankcardList = jxsCollectBankcardList;
    }

    public List<XN632060ReqProtocol> getCarDealerProtocolList() {
        return CarDealerProtocolList;
    }

    public void setCarDealerProtocolList(
            List<XN632060ReqProtocol> carDealerProtocolList) {
        CarDealerProtocolList = carDealerProtocolList;
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

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getAgreementValidDate() {
        return agreementValidDate;
    }

    public void setAgreementValidDate(String agreementValidDate) {
        this.agreementValidDate = agreementValidDate;
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
