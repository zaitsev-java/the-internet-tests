package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {


    String loginPageUrl = "https://the-internet.herokuapp.com/login";

    private final By loginMessage = By.xpath("//div[@id='flash']");
    private final By usernameField = By.xpath("//input[@id='username']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//i[contains(text(),'Login')]");
    private final By errorMessage = By.xpath("//div[@id='flash']");


    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public SecureAreaPage logIn(String username, String password) {
        log.info("Logging in with username [" + username + "] and password [" + password + "]");
        type(username, usernameField);
        type(password, passwordField);
        click(loginButton);
        return new SecureAreaPage(driver, log);
    }

    public void logInNegative(String username, String password) {
        log.info("[Negative]Logging in with username [" + username + "] and password [" + password + "]");
        type(username, usernameField);
        type(password, passwordField);
        click(loginButton);
    }

    public void waitForErrorMessage() {
        waitForVisibilityOf(errorMessage, 5);
    }

    public String getErrorMessageText() {
        return find(errorMessage).getText();
    }



}
