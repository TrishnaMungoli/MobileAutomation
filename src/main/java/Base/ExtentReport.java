package Base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.ITestResult;

import java.io.File;

public class ExtentReport {

    public  static ExtentReports extent;
    public static ExtentTest Reportlogger;
    private static ITestResult result;

    public static void initiliazeExtentReport(String filePath,String extentXML) {
        extent = new ExtentReports(filePath, false);
        extent.loadConfig(new File("//test-output//extent-config.xml"));
    }

}





