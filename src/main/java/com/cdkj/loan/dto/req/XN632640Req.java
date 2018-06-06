package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 新增办公用品/固定资产申请
 * @author: jiafr 
 * @since: 2018年6月6日 下午5:52:40 
 * @history:
 */
public class XN632640Req {

    private String applyNote;

    private String isPrint;

    private String remark;

    private String pdf;

    private String applyUser;

    private String type;

    private String updater;

    private List<XN632640ReqChild1> list1;

    private List<XN632640ReqChild2> list2;

    public List<XN632640ReqChild1> getList1() {
        return list1;
    }

    public void setList1(List<XN632640ReqChild1> list1) {
        this.list1 = list1;
    }

    public List<XN632640ReqChild2> getList2() {
        return list2;
    }

    public void setList2(List<XN632640ReqChild2> list2) {
        this.list2 = list2;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(String isPrint) {
        this.isPrint = isPrint;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
