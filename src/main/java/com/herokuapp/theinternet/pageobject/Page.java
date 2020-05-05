package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Page {

    protected WebDriver driver;
    protected Logger log;

    public Page(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }
}
