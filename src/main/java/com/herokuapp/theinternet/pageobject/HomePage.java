package com.herokuapp.theinternet.pageobject;

import com.herokuapp.theinternet.TestUtilities;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    private String pageUrl = "https://the-internet.herokuapp.com";

    private By loginPageUrl = By.linkText("https://the-internet.herokuapp.com/login");


    public void openPage() {
        log.info("Opening page: " + pageUrl);
        driver.get(pageUrl);
        log.info("Page opened.");
    }

    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking on Form Authentication link on HomePage");
        driver.findElement(loginPageUrl).click();
        return new LoginPage(driver, log);
    }


}
