package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {


    @Test
    public void testLoginPositive() {
        log.info("Starting Login Test");
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        /**         taking Screenshot           */
        takeScreenshot("HomePageOpened");
        LoginPage loginPage = homePage.clickLoginLink();
        /**         adding new Cookie           */
        Cookie cookie = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
        loginPage.setCookie(cookie);
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
        /**         Getting added Cookie           */
        String usernameCookie = secureAreaPage.getCookie("username");
        log.info("Username cookie: " + usernameCookie);
        String sessionCookie = secureAreaPage.getCookie("rack.session");
        log.info("Session cookie: " + sessionCookie);

        Assert.assertEquals(secureAreaPage.getPageUrl(), secureAreaPage.getPageUrl());
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "Logout Button Invisible");
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
    }

}
