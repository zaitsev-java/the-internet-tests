package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.JSAlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JSAlertTests extends TestUtilities {

    @Test
    public void testJSAlert() {
        SoftAssert softAssert = new SoftAssert();
        log.info("Starting testJSAlert test");
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        JSAlertsPage jsAlertsPage = homePage.clickJSAlertLink();
        jsAlertsPage.openJSAlert();
        String alertMessage = jsAlertsPage.getAlertText();
        jsAlertsPage.acceptAlert();
        String result = jsAlertsPage.getResultText();
        softAssert.assertEquals(alertMessage, "I am a JS Alert");
        softAssert.assertEquals(result, "You successfuly clicked an alert");
        softAssert.assertAll();
    }

    @Test
    public void testJSAlertDismiss() {
        log.info("Starting testJSAlertDismiss test");
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        JSAlertsPage jsAlertsPage = homePage.clickJSAlertLink();
        jsAlertsPage.openJSConfirm();
        String alertMessage = jsAlertsPage.getAlertText();
        jsAlertsPage.dismissAlert();
        String result = jsAlertsPage.getResultText();
        Assert.assertEquals(alertMessage, "I am a JS Confirm");
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test
    public void testJSAlertPrompt() {
        log.info("Starting testJSAlertPrompt test");
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        JSAlertsPage jsAlertsPage = homePage.clickJSAlertLink();
        jsAlertsPage.openJSPrompt();
        String alertMessage = jsAlertsPage.getAlertText();
        jsAlertsPage.typeTextIntoAlert("Test text here");
        String result = jsAlertsPage.getResultText();
        Assert.assertEquals(alertMessage, "I am a JS prompt");
        Assert.assertEquals(result, "You entered: Test text here");

    }


}
