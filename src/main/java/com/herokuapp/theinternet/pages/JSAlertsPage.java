package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage extends BasePage {


    private String pageUrl = "https://the-internet.herokuapp.com/javascript_alerts";

    private final By clickForJSAlertButton = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private final By clickForJSConfirmButton = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private final By clickForJSPromptButton = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
    private final By resultTextField = By.xpath("//p[@id='result']");

    private final String resultJSAlertMessage = "You successfuly clicked an alert";
    private final String resultJSConfirmOkMessage = "You clicked: Ok";
    private final String resultJSConfirmCancelMessage = "You clicked: Cancel";
    private final String resultJSPromptOklMessage = "You entered: ";
    private final String resultJSPromptCancelMessage = "You entered: null";


    public JSAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openJSAlert() {
        log.info("Clicking on 'Click for JS Alert' Button");
        click(clickForJSAlertButton);
    }

    public void openJSConfirm() {
        log.info("Clicking on 'Click for JS Confirm' Button");
        click(clickForJSConfirmButton);
    }

    public void openJSPrompt() {
        log.info("Clicking on 'Click for JS Prompt' Button");
        click(clickForJSPromptButton);
    }

public String getAlertText() {
    Alert alert = switchToAlert();
    String alertText = alert.getText();
    log.info("Alert says : " + alertText);
    return alertText;
}

public void acceptAlert() {
        log.info("Switching to Alert and pressing OK");
        Alert alert = switchToAlert();
        alert.accept();
}

public void dismissAlert() {
        log.info("Switching to Alert and pressing CANCEL");
        Alert alert = switchToAlert();
        alert.dismiss();
}

public void typeTextIntoAlert(String text) {
        log.info("Typing text into Alert and pressing OK");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
}

public String getResultText() {
        String result = find(resultTextField).getText();
        log.info("Result text : " + result);
        return result;
}



}
