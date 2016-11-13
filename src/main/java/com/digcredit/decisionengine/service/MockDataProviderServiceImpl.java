package com.digcredit.decisionengine.service;

import com.digcredit.decisionengine.model.Applicant;
import com.digcredit.decisionengine.model.CreditCard;
import com.digcredit.decisionengine.model.CreditCard.Status;
import com.digcredit.decisionengine.model.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by iyunbo on 2016/10/16.
 */
public class MockDataProviderServiceImpl implements DataProviderService {

    public List<Applicant> applicants() {
        System.out.println(">>> loading Applicants ...");
        return generate(50);
    }

    private List<Applicant> generate(int amount) {
        List<Applicant> results = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            results.add(createApplicant(i));
        }
        return results;
    }

    private Applicant createApplicant(int index) {
        Applicant applicant = new Applicant();
        applicant.setApplicantName("申请人-" + index);
        applicant.addCreditCard(generateCreditCard());
        applicant.addLoan(generateLoan());
        return applicant;
    }

    private Loan generateLoan() {
        return new Loan();
    }

    private CreditCard generateCreditCard() {
        CreditCard creditCard = new CreditCard();
        Random random = new Random();
        creditCard.setMaxDebtAmount((double) random.nextInt(600));
        creditCard.setMaxOverdueTimes12Mon(random.nextInt(5));
        creditCard.setOverdueAmount((double) random.nextInt(1200));
        creditCard.setOverduePeriods(random.nextInt(3));
        creditCard.setAccountStatus(Status.values()[random.nextInt(4)]);
        return creditCard;
    }

}
