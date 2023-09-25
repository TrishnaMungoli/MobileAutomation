package Base;


import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AndroidAppInitialization {

    public static AppiumDriver<MobileElement> driver = null;


    public static AppiumDriver<MobileElement> startApp(String deviceType, String deviceName, String udid, String apkName
                                                       , Boolean grantPermissions,String apkPath
                                                       ,String appActivity,String appPackage,String userName,String password) throws MalformedURLException {




       String url = "https://"+userName+":"+password+"@hub-cloud.browserstack.com/wd/hub";

        if (driver == null) {
            switch (deviceType) {

                case "Android":
                case "Android Emulator": {
                    DesiredCapabilities cap = new DesiredCapabilities();

                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    cap.setCapability("deviceName", deviceName);
                    cap.setCapability("app", apkPath);
                    cap.setCapability("deviceName", deviceName);
                    cap.setCapability("udid", udid);
                    cap.setCapability("appActivity", appActivity);
                    cap.setCapability("appPackage", appPackage);
                    cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, grantPermissions);
                    driver = new AndroidDriver<>(new URL(url), cap);

                }
                break;
                case "iOS": {
                    DesiredCapabilities cap = new DesiredCapabilities();

                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.7.1");
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                    cap.setCapability(MobileCapabilityType.UDID, udid);

                    driver = new IOSDriver<>(new URL(url), cap);
                    break;
                }



                default: {
                    throw new RuntimeException(deviceType + " is an invalid value for deviceType");
                }
            }
        }
        return driver;
    }

    public static void quitApp() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


