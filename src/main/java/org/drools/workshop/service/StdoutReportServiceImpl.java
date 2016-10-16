package org.drools.workshop.service;

/**
 * Created by iyunbo on 2016/10/16.
 */
public class StdoutReportServiceImpl implements ReportService {
    public void notify(String message) {
        System.out.println(">>> 判断结果: " + message);
    }
}
