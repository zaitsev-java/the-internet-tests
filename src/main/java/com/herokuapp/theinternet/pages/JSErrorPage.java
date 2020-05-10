package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSErrorPage extends BasePage {

    private String pageUrl = "https://the-internet.herokuapp.com/javascript_error";

    private final By errorJSField = By.xpath("//a[contains(text(),'Click Here')]");


    public JSErrorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }



}
