package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BasePage{


    private String pageUrl = "https://the-internet.herokuapp.com/windows";
    private String newWindowText = "New Window";

    private final By clickHereLink = By.xpath("//a[contains(text(),'Click Here')]");
    private final By newWindowTextField = By.xpath("//h3[contains(text(),'New Window')]");


    public WindowsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openNewWindow() {
        log.info("Clicking on 'Click here' link");
        click(clickHereLink);
    }

    public NewWindowPage switchToNewWindowPage() {
        log.info("Looking for 'New Window' page");
        switchToWindowWithTitle("New Window");
        return new NewWindowPage(driver,log);
    }


}
