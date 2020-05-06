package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pageobject.HomePage;
import com.herokuapp.theinternet.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test
    public void testLoginNegative(String username, String password, String expectedErrorMessage) {
        log.info("Starting testLoginNegative test");
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        LoginPage loginPage = homePage.clickLoginLink();
        loginPage.logInNegative(username, password);
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();
        Assert.assertTrue(message.contains(expectedErrorMessage));

    }
}
