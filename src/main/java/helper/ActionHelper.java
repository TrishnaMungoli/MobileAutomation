package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;


public class ActionHelper {
	
	/**
	 * Taps on a WebElement through W3C Actions. Pointer's type is 'touch' to
	 * simulate a real finger's interaction. Assumes a WebView context.
	 */
	public static void touchTapWebElement(WebElement webElement, AppiumDriver<MobileElement> driver) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tapWebElement = new Sequence(finger, 1);
		
		tapWebElement.addAction(finger.createPointerMove(Duration.ofMillis(100), Origin.fromElement(webElement), 0, 0));
		tapWebElement.addAction(finger.createPointerDown(0));
		tapWebElement.addAction(new Pause(finger, Duration.ofMillis(100)));
		tapWebElement.addAction(finger.createPointerUp(0));
		
		driver.perform(Arrays.asList(tapWebElement));
	}
	
	/**
	 * Provided the driver is in a native context, it swipes up until mobileElement is displayed.
	 * @param mobileElement
	 * @param driver
	 */
	public static void swipeUpUntilDisplayed(MobileElement mobileElement, AppiumDriver<MobileElement> driver) {
		for(int i =0; i<10; i++) {
			try {
				if(mobileElement.isDisplayed()) break;
			}catch(Exception e) {
				ActionHelper.verticalSwipeByPercentages(.50, .25, .98, driver);
			}
		}
	}
	
	
    /**
     * Tapping on any element via mobile
     * @param androidElement
     * @param driver
     */
    public static void tapByElement (WebElement androidElement,AppiumDriver<MobileElement>driver) {
    	TouchAction  action = new TouchAction(driver);
    	action.tap(tapOptions().withElement(element(androidElement))).perform();
    	
    }
     
    
    /**
     * For tapping by cordinates 
     * @param x
     * @param y
     * @param driver
     */
    public static void tapByCordinates (int x,int y,AppiumDriver<MobileElement>driver) {
    	TouchAction  action = new TouchAction(driver);
    	action.tap(point(x,y)).perform();
    	
    }
    
    /**
     * pressByCoordinates
     * @param x
     * @param y
     * @param driver
     */
    public static void pressByCoordinates (int x, int y,AppiumDriver<MobileElement>driver) {
    	TouchAction  action = new TouchAction(driver);
       action.press(point(x,y)).release().perform();
    }
    

    /**
     * Press by element
     * @param androidElement
     * @param driver
     */
    public static void pressByElement (AndroidElement androidElement,AppiumDriver<MobileElement>driver) {
    	
    	TouchAction  action = new TouchAction(driver);	
    	action.press(element(androidElement)).release().perform();
        
    }
    


    /**
     * Horizontal Swipe by percentages
     * @param startPercentage
     * @param endPercentage
     * @param anchorPercentage
     * @param driver
     */
    public static void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage,AppiumDriver<MobileElement>driver) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        
    	TouchAction  action = new TouchAction(driver);	
    	action
    		.press(point(startPoint, anchor))
    		.moveTo(point(endPoint, anchor))
    		.release()
    		.perform();
    }
    
 
    /**
     * Vertical Swipe by percentages
     * @param startPercentage
     * @param endPercentage
     * @param anchorPercentage
     * @param driver
     */
    @SuppressWarnings("rawtypes")
	public static void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage,AppiumDriver<MobileElement>driver) {
        try{
	        Dimension size = driver.manage().window().getSize();
	        int anchor = (int) (size.width * anchorPercentage);
	        int startPoint = (int) (size.height * startPercentage);
	        int endPoint = (int) (size.height * endPercentage);
	        
	        TouchAction  action = new TouchAction(driver);	
	        
	        action
	        	.press(point(anchor, startPoint))
	        	.moveTo(point(anchor, endPoint))
	        	.release()
				.perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
     * Swipe by elements
     * @param startElement
     * @param endElement
     */
    public static void swipeByElements (WebElement startElement, WebElement endElement,AppiumDriver<MobileElement>driver) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
 
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
        
        TouchAction  action = new TouchAction(driver);
 
        action.press(point(startX,startY)).moveTo(point(endX, endY)).release().perform();
    }
    
	
	/**
	 * Scroll down from one element to other 
	 * @param driver
	 * @param element1
	 * @param element2
	 */
	public static void scrollDown(AppiumDriver<MobileElement>driver,WebElement element1,WebElement element2) {
		TouchAction action = new TouchAction(driver);
		
		action.longPress(element(element1)).moveTo(element(element2)).release().perform();
	     
	}
	
	
	/**
	 * Click on app inbuild back button
	 * @param driver
	 */
	public void clickOnAppBackButton(AppiumDriver<MobileElement>driver)
	{
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	
	/**
	 * Click on app inbuild home button 
	 * @param driver
	 */
	public void clickOnAppHomeButton(AppiumDriver<MobileElement>driver)
	{
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	public static void hideKeyboardAndroid(AppiumDriver<MobileElement>driver) {
	    if (((AndroidDriver)driver).isKeyboardShown()) {
	        try {driver.hideKeyboard();} catch (Exception e) {}
	    }
	}
	
	/**
	 * Gets the height of an EditText Android widget and taps below it at said
	 * distance from the center of the widget to select the first autocomplete
	 * suggestion.
	 * 
	 * @param editTextElement
	 * @param driver
	 */
	public static void tapFirstEditTextSuggestion(MobileElement editTextElement, AppiumDriver<MobileElement> driver) {
		Rectangle elementBox = editTextElement.getRect();
		int y = elementBox.height;
		
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tapNativeElement = new Sequence(finger, 0);
		
		tapNativeElement.addAction(finger.createPointerMove(Duration.ofMillis(100), Origin.fromElement(editTextElement), 0, y));
		tapNativeElement.addAction(finger.createPointerDown(0));
		tapNativeElement.addAction(new Pause(finger, Duration.ofMillis(100)));
		tapNativeElement.addAction(finger.createPointerUp(0));
		
		driver.perform(Arrays.asList(tapNativeElement));
		
	}

	public static void  scrollIntoViewportCenter(WebElement webElement , AppiumDriver<MobileElement> driver)  {
		driver.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 2);",webElement);

	}
    
}
