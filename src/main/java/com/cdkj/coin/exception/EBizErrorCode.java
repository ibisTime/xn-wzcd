package com.cdkj.coin.exception;

/**
 * @author: haiqingzheng 
 * @since: 2017年11月14日 下午1:05:03 
 * @history:
 */
public enum EBizErrorCode {

    DEFAULT_ERROR_CODE("xn625000", "业务异常");
    // PUSH_STATUS_UPDATE_FAILURE("eth000001","地址状态更新失败");

    private String errorCode;

    private String errorInfo;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    EBizErrorCode(String errorCode, String errorInfo) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }
}
