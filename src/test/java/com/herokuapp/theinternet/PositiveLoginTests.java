package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {


    @Test
    public void testLoginPositive() {
        log.info("Starting Login Test");
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        takeScreenshot("WelcomePageOpened");
        LoginPage loginPage = homePage.clickLoginLink();
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(secureAreaPage.getPageUrl(), secureAreaPage.getPageUrl());
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "Logout Button Invisible");
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
    }

}
