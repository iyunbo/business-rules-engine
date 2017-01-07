/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.workshop;

import com.digcredit.decisionengine.model.Applicant;
import com.digcredit.decisionengine.service.DataProviderService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author iyunbo
 */
@RunWith(Arquillian.class)
public class RulesTest {

    public RulesTest() {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "com.digcredit")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "kmodule.xml");
    }

    @Inject
    @KSession("p2pKSession")
    private KieSession kSession;

    @Inject
    private DataProviderService dataProviderService;

    @Test
    public void test_credit_card_verification() {
        assertNotNull(kSession);
        System.out.println(" ---- Starting test_credit_card_verification() Test ---");

        for (Applicant a : dataProviderService.applicants()) {
            kSession.insert(a);
        }

        assertThat(kSession.fireAllRules(), is(50));
        System.out.println(" ---- Finished test_credit_card_verification() Test ---");
        kSession.dispose();
    }

}
