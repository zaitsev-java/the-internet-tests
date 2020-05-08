package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage extends BasePage{

    private final By editorLocator = By.xpath("//p[contains(text(),'Your content goes here.')]");
    private final By frame = By.tagName("iframe");



    public WYSIWYGEditorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getEditorText() {
        switchToFrame(frame);
        String text = find(editorLocator).getText();
        log.info("Text from tinyMCE WYSIWYG Editor: " + text);
        return text;
    }





}



