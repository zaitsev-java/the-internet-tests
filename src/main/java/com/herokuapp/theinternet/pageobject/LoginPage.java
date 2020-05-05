package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends Page {


    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    String loginPageUrl = "https://the-internet.herokuapp.com/login";
    private final By loginMessage = By.xpath("//div[@id='flash']");
    private final By usernameField = By.xpath("//input[@id='username']");
    private final By passwordField = By.xpath("//input[@id='password']");

    private final By loginButton = By.xpath("//i[contains(text(),'Login')]");


    public SecureAreaPage logIn(String username, String password) {

        log.info("Logging in with username [" + username + "] and password [" +password+ "]");
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver, log);
    }



}
