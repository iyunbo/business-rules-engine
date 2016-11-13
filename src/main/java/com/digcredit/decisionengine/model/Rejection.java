package com.digcredit.decisionengine.model;

//拒绝申请
public class Rejection {
    private Applicant applicant;
    private String reason;

    public Rejection(Applicant applicant, String reason) {
        this.applicant = applicant;
        this.setReason(reason);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason + ", details: " + this.applicant;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
