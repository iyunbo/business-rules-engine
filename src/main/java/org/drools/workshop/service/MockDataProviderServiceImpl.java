package org.drools.workshop.service;

import org.drools.workshop.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by iyunbo on 2016/10/16.
 */
public class MockDataProviderServiceImpl implements DataProviderService {

    public List<Person> getPersons() {
        System.out.println(">>> Loading Persons ...");
        return generatePersons(50);
    }

    private List<Person> generatePersons(int amount) {
        List<Person> results = new ArrayList<Person>();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            results.add(new Person("匿名用户-" + i, random.nextInt(60), "1399996487" + (i % 10), i % 2 == 0, Person.Employment.values()[i % 3]));
        }
        return results;
    }

}
