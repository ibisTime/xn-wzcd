package com.cdkj.loan.dto.res;

/**
 * 代办事项APP
 * @author: jiafr 
 * @since: 2018年8月29日 下午4:17:24 
 * @history:
 */
public class XN632912Res {
    private int creditTodo;// 征信

    private int interviewTodo;// 面签

    private int gpsInstallTodo;// gps安装

    private int carSettleTodo;// 车辆落户

    private int entryMortgageTodo;// 车辆抵押

    private int logisticsTodo;// 资料传递

    public int getCreditTodo() {
        return creditTodo;
    }

    public void setCreditTodo(int creditTodo) {
        this.creditTodo = creditTodo;
    }

    public int getInterviewTodo() {
        return interviewTodo;
    }

    public void setInterviewTodo(int interviewTodo) {
        this.interviewTodo = interviewTodo;
    }

    public int getGpsInstallTodo() {
        return gpsInstallTodo;
    }

    public void setGpsInstallTodo(int gpsInstallTodo) {
        this.gpsInstallTodo = gpsInstallTodo;
    }

    public int getCarSettleTodo() {
        return carSettleTodo;
    }

    public void setCarSettleTodo(int carSettleTodo) {
        this.carSettleTodo = carSettleTodo;
    }

    public int getEntryMortgageTodo() {
        return entryMortgageTodo;
    }

    public void setEntryMortgageTodo(int entryMortgageTodo) {
        this.entryMortgageTodo = entryMortgageTodo;
    }

    public int getLogisticsTodo() {
        return logisticsTodo;
    }

    public void setLogisticsTodo(int logisticsTodo) {
        this.logisticsTodo = logisticsTodo;
    }

    public XN632912Res(int creditTodo, int interviewTodo, int gpsInstallTodo,
            int carSettleTodo, int entryMortgageTodo, int logisticsTodo) {
        super();
        this.creditTodo = creditTodo;
        this.interviewTodo = interviewTodo;
        this.gpsInstallTodo = gpsInstallTodo;
        this.carSettleTodo = carSettleTodo;
        this.entryMortgageTodo = entryMortgageTodo;
        this.logisticsTodo = logisticsTodo;
    }

    public XN632912Res() {
        super();
    }

}
