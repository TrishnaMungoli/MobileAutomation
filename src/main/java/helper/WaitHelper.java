package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitHelper {
	
	public static boolean explictWait(AppiumDriver<MobileElement> driver ) {
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return true;
		}
		catch (Exception e) {
			
			return false;
		}
						
	}

	public static boolean elementToBeSelected(WebElement element,AppiumDriver<MobileElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}
	
	public static boolean frameToBeAvaliableAndSwitchToIt(WebElement element,AppiumDriver<MobileElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean invisibilityOfTheElementLocated(WebElement element,AppiumDriver<MobileElement> driver)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static boolean alertToBePresent(AppiumDriver<MobileElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isClickable(WebElement element, AppiumDriver<MobileElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isStale(WebElement element,AppiumDriver<MobileElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.stalenessOf(element));
			return true;	    
	       } catch (Exception e) {
			return false;
		}
	}
	
	public static boolean invisibilityOfTheElementLocate(WebElement element,AppiumDriver<MobileElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean presenceOfAllElementsLocatedBy(By element,AppiumDriver<MobileElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean invisibilityOfElementWithText(By element, AppiumDriver<MobileElement> driver,String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.invisibilityOfElementWithText(element, text));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean textToBePresentInElement(WebElement element,AppiumDriver<MobileElement> driver,String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean textToBePresentInElementLocated(By element, AppiumDriver<MobileElement> driver,String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(element, text));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean textToBePresentInElementValue(WebElement element, AppiumDriver<MobileElement> driver,String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.textToBePresentInElementValue(element, text)); 
			return true;

		} catch (Exception e ) {
			return false;
		}
	}
	
	public static boolean titleContains( AppiumDriver<MobileElement> driver,String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.titleContains(text)); 
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean visibilityOfAllElements( AppiumDriver<MobileElement> driver,WebElement element ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfAllElements(element)); 
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean visibilityOfElementLocated(AppiumDriver<MobileElement> driver,By element ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element)); 
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isvisible(WebElement element,AppiumDriver<MobileElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element)); 
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isNotVisible(WebElement element,AppiumDriver<MobileElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public static boolean isElementPresent(WebElement element,AppiumDriver<MobileElement> driver) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
		}
		
}