package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    String loginPageUrl = "https://the-internet.herokuapp.com/login";
    private final By loginMessage = By.xpath("//div[@id='flash']");
    private final By loginField = By.xpath("//input[@id='username']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//i[@class='fa fa-2x fa-sign-in']");


    @Parameters({"username", "password", "message"})
    @Test(groups = {"negative"}, priority = 1)
    public void wrongLoginTest(String username, String password, String message) {
        driver.get(loginPageUrl);
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        String logErrTxt = driver.findElement(loginMessage).getText();
        Assert.assertTrue(logErrTxt.contains(message));
    }

}
