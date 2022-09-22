package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    static ExtentReports extent;
    public static ExtentReports getReportObject(){
        String path=System.getProperty("user.dir")+"\\test-output\\Report.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web automation report");
        reporter.config().setDocumentTitle("test results");
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("tester","Josna");
        return extent;
    }
}
