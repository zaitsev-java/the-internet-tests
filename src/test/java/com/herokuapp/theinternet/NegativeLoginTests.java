package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLoginTests extends TestUtilities {


    @Test(dataProvider = "csvReader", dataProviderClass = CSVDataProviders.class)
    public void testLoginNegative(Map<String, String> testData) {
        String no = testData.get("no");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedMessage = testData.get("expectedMessage");
        log.info("Starting testLoginNegative test # " + no);
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        LoginPage loginPage = homePage.clickLoginLink();
        loginPage.logInNegative(username, password);
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();
        Assert.assertTrue(message.contains(expectedMessage));

    }
}
