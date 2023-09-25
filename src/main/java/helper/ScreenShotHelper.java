package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShotHelper {
	


	 public static String   captureScreenshot(AppiumDriver<MobileElement> driver  , String path) throws IOException {
		 
		 TakesScreenshot ts = (TakesScreenshot)driver ;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 String destination=path;
		 File finalDestination = new File(destination);
		 FileUtils.copyFile(source, finalDestination);
		 
		 return destination;
		  }

}
