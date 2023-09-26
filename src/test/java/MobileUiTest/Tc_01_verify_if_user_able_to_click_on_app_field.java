package MobileUiTest;

import Base.AndroidAppInitialization;
import Base.TestBase;
import Pages.LandingScreen;

import helper.AssertionHelper;
import org.testng.annotations.Test;

public class Tc_01_verify_if_user_able_to_click_on_app_field extends TestBase {

    @Test
    public void verify_if_user_able_to_click_on_app_field(){
        LandingScreen landingScreen=new LandingScreen(AndroidAppInitialization.driver);
        landingScreen.clickOnAppField();

        AssertionHelper.verifyText(landingScreen.getTextAlarmField(),"Alarm","Alarm field is not matching");
        AssertionHelper.verifyText(landingScreen.getTextActivityField(),"Activity","Activity field is not matching");
        AssertionHelper.verifyText(landingScreen.getTextActionBarField(),"Action Bar","Action Bar field is not matching");

    }

}
