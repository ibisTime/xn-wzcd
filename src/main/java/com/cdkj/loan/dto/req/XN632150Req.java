package com.cdkj.loan.dto.req;

/**
 * 资料传递发送
 * @author: silver 
 * @since: 2018年5月29日 下午11:02:18 
 * @history:
 */
public class XN632150Req {
    // 寄送材料清单(逗号隔开)
    private String sendFileList;

    // 寄送方式(1 线下 2 快递)
    private String sendType;

    // 快递公司
    private String logisticsCompany;

    // 快递单号
    private String logisticsCode;

    // 发货说明
    private String sendNote;

    public String getSendFileList() {
        return sendFileList;
    }

    public void setSendFileList(String sendFileList) {
        this.sendFileList = sendFileList;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getSendNote() {
        return sendNote;
    }

    public void setSendNote(String sendNote) {
        this.sendNote = sendNote;
    }

}
