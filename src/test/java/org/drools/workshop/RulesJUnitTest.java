/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.workshop;

import javax.inject.Inject;

import org.drools.workshop.model.Person;
import org.drools.workshop.service.DataProviderService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Row;
import org.kie.api.runtime.rule.ViewChangedEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author salaboy
 */
@RunWith(Arquillian.class)
public class RulesJUnitTest {

    public RulesJUnitTest() {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "org.drools.workshop.model")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    @KBase("identityKBase")
    private KieBase kBase;

    @Inject
    private DataProviderService dataProviderService;

    @Test
    public void test_personal_info_validation() {
        Assert.assertNotNull(kBase);
        KieSession kSession = kBase.newKieSession();
        System.out.println(" ---- Starting test_personal_info_validation() Test ---");

        for(Person p : dataProviderService.getPersons()){
            kSession.insert(p);
        }

        Assert.assertEquals(50, kSession.fireAllRules());
        System.out.println(" ---- Finished test_personal_info_validation() Test ---");
        kSession.dispose();
    }

}
