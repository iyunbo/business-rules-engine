package org.drools.workshop.service;

import org.drools.workshop.model.Person;

import java.util.List;

public interface DataProviderService {

    List<Person> getPersons();
}
