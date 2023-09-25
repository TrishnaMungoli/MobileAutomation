package Base;

import Utility.ConfigReader;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import helper.ScreenShotHelper;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    ConfigReader reader= new ConfigReader();
    ExtentTest Reportlogger;
    private static AppiumDriverLocalService server;
    AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
    String appiumServiceUrl;

    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.initiliazeExtentReport(System.getProperty("user.dir")+"//"+"Reports"+"//" + createFolder() + "//" +timestamp()+"Reports.html",
                System.getProperty("user.dir") +reader.extentConfigPath());

        serviceBuilder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");
        serviceBuilder.withLogFile(new File(System.getProperty("user.dir") + "/appium_logs/" + timestamp() + ".txt"));
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
        server.clearOutPutStreams();



    }

    @BeforeTest
    @Parameters({"deviceType", "deviceName", "udid", "apkName", "grantPermissions","apkPath", "appActivity","appPackage","userName","password"})
    public void initializeBrowser(String deviceType, String deviceName,String udid,String apkName
                                  , @Optional("true") Boolean grantPermissions,String apkPath,
                                  String appActivity,String appPackage,String userName,String password) {

        try {
            String appiumServiceUrl=server.getUrl().toString();
            AndroidAppInitialization.startApp(deviceType, deviceName, udid, apkName,grantPermissions,apkPath,appActivity,appPackage,userName,password);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }



    @BeforeMethod(alwaysRun = true)
    public void nameBefore(Method method) {
        String testClassName = method.getDeclaringClass().getSimpleName();
        String testMethodName = method.getName();
        System.out.println("Test executing right now:");
        System.out.println("Class = " + testClassName);
        System.out.println("Method = " + testMethodName);
        Reportlogger = ExtentReport.extent.startTest(testClassName + "." + testMethodName);
    }

    @AfterMethod(alwaysRun = true)
    public  void getResult(ITestResult result) {
        String screenshotPath=null;
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                screenshotPath=System.getProperty("user.dir") + "//Screenshots//"+timestamp()+".png";
                ScreenShotHelper.captureScreenshot(AndroidAppInitialization.driver,screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Reportlogger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            Reportlogger.log(LogStatus.FAIL, "Snapshot below: " +
                    Reportlogger.addScreenCapture(screenshotPath));
            Reportlogger.log(LogStatus.FAIL, "Test case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            Reportlogger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
            Reportlogger.log(LogStatus.SKIP, "Test case errors  are " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Reportlogger.log(LogStatus.PASS, "Test case passed is " + result.getName());

        }
        ExtentReport.extent.endTest(Reportlogger);
    }

    @AfterTest(alwaysRun = true)
    public void TearDown() {
        AndroidAppInitialization.quitApp();

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        server.stop();
        ExtentReport.extent.flush();
        ExtentReport.extent.close();
    }


    public String createFolder(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(now);
        File dir = new File(time);
        dir.mkdir();
        return dir.toString();
    }

    public  String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public  void reportLog(String message) {
        Reportlogger.log(LogStatus.INFO, message);//For extentTest HTML report
    }


}
