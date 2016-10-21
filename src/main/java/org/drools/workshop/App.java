package org.drools.workshop;

import org.drools.workshop.model.Person;
import org.drools.workshop.service.DataProviderService;
import org.drools.workshop.service.ReportService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.inject.Inject;

/**
 * Hello Drools world!
 */
public class App {

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
        // The KieSession was injected so we can use it now
        for (Person p : dataProviderService.getPersons()) {
            kSession.insert(p);
        }
        int rulesFired = kSession.fireAllRules();
        System.out.println(">>> 总计执行规则次数: " + rulesFired);

    }

    public static void main(String[] args) {
        //Boostrap the CDI container, in this case WELD
        Weld w = new Weld();

        WeldContainer wc = w.initialize();
        App app = wc.instance().select(App.class).get();
        app.bootstrapDrools();

        w.shutdown();
    }
}
