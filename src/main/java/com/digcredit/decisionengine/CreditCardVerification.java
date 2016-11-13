package com.digcredit.decisionengine;

import com.digcredit.decisionengine.model.Applicant;
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

    private void bootstrapDrools() {

//        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kContainer = kieServices.newKieContainer();

        kSession.setGlobal("reportService", reportService);
        for (Applicant a : dataProviderService.applicants()) {
            kSession.insert(a);
        }
        int rulesFired = kSession.fireAllRules();
        System.out.println(">>> 总计执行规则次数: " + rulesFired);

    }

    public static void main(String[] args) {
        Weld w = new Weld();

        WeldContainer wc = w.initialize();
        CreditCardVerification app = wc.instance().select(CreditCardVerification.class).get();
        app.bootstrapDrools();

        w.shutdown();
    }
}
