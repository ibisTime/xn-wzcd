package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-面签
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:28:08 
 * @history:
 */
public class XN632123Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String interviewVideo;// 面签视频

    @NotBlank
    private String interviewContract;// 面签合同

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInterviewVideo() {
        return interviewVideo;
    }

    public void setInterviewVideo(String interviewVideo) {
        this.interviewVideo = interviewVideo;
    }

    public String getInterviewContract() {
        return interviewContract;
    }

    public void setInterviewContract(String interviewContract) {
        this.interviewContract = interviewContract;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
