package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    private String pageUrl = "https://the-internet.herokuapp.com";

    private By loginPageLink = By.xpath("//a[contains(text(),'Form Authentication')]");



    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void open() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened.");
    }

    public LoginPage clickOnLoginLink() {
        log.info("Clicking on Form Authentication link on HomePage");
        click(loginPageLink);
        return new LoginPage(driver, log);
    }


}
