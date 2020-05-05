package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pageobject.HomePage;
import com.herokuapp.theinternet.pageobject.LoginPage;
import com.herokuapp.theinternet.pageobject.SecureAreaPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests  extends TestUtilities {


    @Test
    public void logInTest() {

        log.info("Starting Login Test");
        HomePage homePage = new HomePage(driver,log);
        homePage.open();
        LoginPage loginPage = homePage.clickOnLoginLink();
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(secureAreaPage.getPageUrl(),secureAreaPage.getPageUrl());
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "Logout Button Invisible");
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));




    }
}
