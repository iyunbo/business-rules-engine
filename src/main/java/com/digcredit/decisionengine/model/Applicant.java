package com.digcredit.decisionengine.model;

import java.util.ArrayList;
import java.util.List;

import static com.digcredit.decisionengine.model.Applicant.Status.正常;

//申请人
public class Applicant {
    public enum Status {
        正常,
        不良
    }

    private String applicationNumber = "AP" + System.currentTimeMillis();
    private String applicantName = "申请人-" + System.currentTimeMillis() % 1000;
    private List<CreditCard> creditCards = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private Status accountStatus = 正常;

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Status getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Status accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
    }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicationNumber='" + applicationNumber + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", creditCards=" + creditCards +
                ", loans=" + loans +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
