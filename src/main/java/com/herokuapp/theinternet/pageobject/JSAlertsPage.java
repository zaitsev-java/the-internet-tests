package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage extends BasePage {


    private String pageUrl = "https://the-internet.herokuapp.com/javascript_alerts";

    private By clickForJSAlertButton = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private By clickForJSConfirmButton = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private By clickForJSPromptButton = By.xpath("//button[contains(text(),'Click for JS Prompt')]");

    private By resultTextField = By.xpath("//p[@id='result']");

    private String resultJSAlertMessage = "You successfuly clicked an alert";
    private String resultJSConfirmOkMessage = "You clicked: Ok";
    private String resultJSConfirmCancelMessage = "You clicked: Cancel";
    private String resultJSPromptOklMessage = "You entered: ";
    private String resultJSPromptCancelMessage = "You entered: null";


    public JSAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }





}
