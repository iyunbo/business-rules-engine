package com.digcredit.decisionengine.service;

import com.digcredit.decisionengine.model.Applicant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iyunbo on 29/12/2016.
 */
public class CacheService {

    private Map<Applicant, String> cache = new HashMap<>();

    public void reject(Applicant applicant) {
        System.out.println(applicant + " 被拒绝");
        cache.remove(applicant);
    }

    public void insert(Applicant applicant) {
        cache.put(applicant, applicant.getApplicantName());
    }

    public void printApplicants() {
        System.out.println("审批通过的申请人：");
        for (Applicant applicant : cache.keySet()) {
            System.out.println(cache.get(applicant) + " : " + applicant.getAccountStatus());
        }
    }
}
