package com.digcredit.decisionengine.model;

//贷款
public class Loan {
    private String LoanType = "房贷";
    private String number = "L" + System.currentTimeMillis();

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLoanType() {
        return LoanType;
    }

    public void setLoanType(String loanType) {
        LoanType = loanType;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "LoanType='" + LoanType + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
