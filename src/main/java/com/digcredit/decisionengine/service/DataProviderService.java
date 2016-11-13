package com.digcredit.decisionengine.service;

import com.digcredit.decisionengine.model.Applicant;
import org.drools.workshop.model.Person;

import java.util.List;

public interface DataProviderService {

    List<Applicant> applicants();
}
