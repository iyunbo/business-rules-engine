package com.digcredit.decisionengine;

import com.digcredit.decisionengine.model.Applicant;
import com.digcredit.decisionengine.service.CacheService;
import com.digcredit.decisionengine.service.DataProviderService;
import org.drools.workshop.service.ReportService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

import javax.inject.Inject;

/**
 * Hello Drools world!
 */
public class CreditCardVerification {

    @Inject
    @KSession("p2pKSession")
    private KieSession kSession;

    @Inject
    private ReportService reportService;

    @Inject
    private DataProviderService dataProviderService;

    @Inject
    private CacheService cacheService;

    private void bootstrapDrools() {

//        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kContainer = kieServices.newKieContainer();

        kSession.setGlobal("reportService", reportService);
        kSession.setGlobal("cacheService", cacheService);
        for (Applicant a : dataProviderService.applicants()) {
            cacheService.insert(a);
            kSession.insert(a);
        }
        int rulesFired = kSession.fireAllRules();
        System.out.println(">>> 计执行规则总数: " + rulesFired);
        cacheService.printApplicants();

    }

    public static void main(String[] args) {
        Weld w = new Weld();

        WeldContainer wc = w.initialize();
        CreditCardVerification app = wc.instance().select(CreditCardVerification.class).get();
        app.bootstrapDrools();

        w.shutdown();
        System.exit(0);
    }
}
