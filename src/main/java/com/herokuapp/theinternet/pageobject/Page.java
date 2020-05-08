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

    public  <TPage extends BasePage> TPage getInstance (Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class, Logger.class).newInstance(this.driver, this.log);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
