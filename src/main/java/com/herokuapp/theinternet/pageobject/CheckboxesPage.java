package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePage {


    private String pageUrl = "https://the-internet.herokuapp.com/checkboxes";

    private By checkbox1 = By.xpath("//body//input[1]");
    private By checkbox2 = By.xpath("//body//input[2]");
    private By checkboxAll = By.xpath("//body//input");


    public CheckboxesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void checkAllCheckboxes() {
        log.info(("Checking all unchecked checkboxes"));
        List<WebElement> checkboxes = findAll(checkbox1);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public boolean areAllCheckboxesChecked() {
        log.info("Verifying are all checkboxes checked");
        List<WebElement> checkboxes = findAll(checkbox1);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }



}
