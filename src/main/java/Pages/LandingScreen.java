package Pages;

import Base.AndroidAppInitialization;
import helper.WaitHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingScreen {

    public LandingScreen(AppiumDriver<MobileElement> driver) {
        AndroidAppInitialization.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(AndroidAppInitialization.driver), this);
    }

    @AndroidFindBy(accessibility = "App")
    WebElement appField;

    @AndroidFindBy(accessibility = "Action Bar")
    WebElement actionBarField;

    @AndroidFindBy(accessibility = "Activity")
    WebElement activityField;

    @AndroidFindBy(accessibility = "Alarm")
    WebElement alarmField;


    public LandingScreen clickOnAppField() {

        WaitHelper.isClickable(appField, AndroidAppInitialization.driver);
        appField.click();

        return new LandingScreen(AndroidAppInitialization.driver);
    }

    public String getTextActivityField() {

        WaitHelper.isvisible(activityField, AndroidAppInitialization.driver);
        return this.activityField.getText();
    }

    public String getTextActionBarField() {

        WaitHelper.isvisible(actionBarField, AndroidAppInitialization.driver);
        return this.actionBarField.getText();
    }

    public String getTextAlarmField() {

        WaitHelper.isvisible(alarmField, AndroidAppInitialization.driver);

        return this.alarmField.getText();
    }


}
