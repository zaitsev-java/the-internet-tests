package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private String pageUrl = "https://the-internet.herokuapp.com/secure";

    private By logOutButton = By.xpath("//i[contains(text(),'Logout')]");
    private By message = By.xpath("//div[contains(text(),'You logged into a secure area!')]");


    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean isLogOutButtonVisible() {
        return find(logOutButton).isDisplayed();
    }

    public String getSuccessMessageText() {
        return find(message).getText();
    }




}
