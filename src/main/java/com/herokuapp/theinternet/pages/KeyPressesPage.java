package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePage {

    private String pageUrl = "https://the-internet.herokuapp.com/key_presses";

    private final By clickForJSAlertButton = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private final By body = By.xpath("//body");
    private final By resultText = By.xpath("//p[@id='result']");



    public KeyPressesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void pressKey(Keys key) {
        log.info("Pressing " + key.name());
        pressKeyOnElement(body, key);
    }

    public String getResultText() {
        String result = find(resultText).getText();
        log.info("Result text: " + result);
        return result;
    }


}
