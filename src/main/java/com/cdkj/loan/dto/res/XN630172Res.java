package com.cdkj.loan.dto.res;

/**
 * 代办事项APP
 * @author: jiafr 
 * @since: 2018年8月29日 下午4:17:24 
 * @history:
 */
public class XN630172Res {
    // 资信调查001_02 001_03 001_04 001_05
    private int creditTodo;

    // 准入申请 002_01
    private int accessTodo;

    // 财务垫资 003_01 004_01
    private int advanceFundTodo;

    // 银行放款 007_06 007_07
    private int bankLoanTodo;

    // 车辆抵押 008_04 009_09
    private int entryMortgageTodo;

    // 资料传递 Status = 0124 GPS的时候为 Status = 014
    private int logisticsTodo;

    // 以下待定
    private int relieveMortgageTodo;// 解除抵押007_01

    public int getCreditTodo() {
        return creditTodo;
    }

    public void setCreditTodo(int creditTodo) {
        this.creditTodo = creditTodo;
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

    public XN630172Res(int creditTodo, int accessTodo, int advanceFundTodo,
            int bankLoanTodo, int entryMortgageTodo, int relieveMortgageTodo,
            int logisticsTodo) {
        super();
        this.creditTodo = creditTodo;
        this.accessTodo = accessTodo;
        this.advanceFundTodo = advanceFundTodo;
        this.bankLoanTodo = bankLoanTodo;
        this.entryMortgageTodo = entryMortgageTodo;
        this.relieveMortgageTodo = relieveMortgageTodo;
        this.logisticsTodo = logisticsTodo;
    }

    public int getAccessTodo() {
        return accessTodo;
    }

    public void setAccessTodo(int accessTodo) {
        this.accessTodo = accessTodo;
    }

    public int getAdvanceFundTodo() {
        return advanceFundTodo;
    }

    public void setAdvanceFundTodo(int advanceFundTodo) {
        this.advanceFundTodo = advanceFundTodo;
    }

    public int getBankLoanTodo() {
        return bankLoanTodo;
    }

    public void setBankLoanTodo(int bankLoanTodo) {
        this.bankLoanTodo = bankLoanTodo;
    }

    public int getRelieveMortgageTodo() {
        return relieveMortgageTodo;
    }

    public void setRelieveMortgageTodo(int relieveMortgageTodo) {
        this.relieveMortgageTodo = relieveMortgageTodo;
    }

    public XN630172Res() {
        super();
    }

}
