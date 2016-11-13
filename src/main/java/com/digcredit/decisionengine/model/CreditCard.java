package com.digcredit.decisionengine.model;

//信用卡
public class CreditCard {
    public enum Status {
        呆账,
        核销,
        冻结,
        止付,
        正常
    }
    private String number = "CC" + System.currentTimeMillis();
    private Status accountStatus = Status.正常;
    private Double creditAmount = 1000.0;
    private Double maxDebtAmount= 0.0;
    private int overduePeriods = 0;
    private Double overdueAmount = 0.0;
    private int maxOverdueTimes12Mon = 0;

    public int getMaxOverdueTimes12Mon() {
        return maxOverdueTimes12Mon;
    }

    public void setMaxOverdueTimes12Mon(int maxOverdueTimes12Mon) {
        this.maxOverdueTimes12Mon = maxOverdueTimes12Mon;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Status getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Status accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Double getMaxDebtAmount() {
        return maxDebtAmount;
    }

    public void setMaxDebtAmount(Double maxDebtAmount) {
        this.maxDebtAmount = maxDebtAmount;
    }

    public int getOverduePeriods() {
        return overduePeriods;
    }

    public void setOverduePeriods(int overduePeriods) {
        this.overduePeriods = overduePeriods;
    }

    public Double getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Double overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "number='" + number + '\'' +
                ", accountStatus=" + accountStatus +
                ", creditAmount=" + creditAmount +
                ", maxDebtAmount=" + maxDebtAmount +
                ", overduePeriods=" + overduePeriods +
                ", overdueAmount=" + overdueAmount +
                ", maxOverdueTimes12Mon=" + maxOverdueTimes12Mon +
                '}';
    }
}
