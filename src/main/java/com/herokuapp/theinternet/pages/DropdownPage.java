package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private String pageUrl = "https://the-internet.herokuapp.com/dropdown";

    private By dropdown = By.xpath("//select[@id='dropdown']");


    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectOption(int optionNum) {
        log.info("Selecting option " + optionNum + " from dropdown");
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(optionNum);
//        dropdown.selectByVisibleText("Option" + optionNum);
//        dropdown.selectByValue("" + optionNum);
    }

    public String getSelectedOption() {
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        log.info(selectedOption + " is selected in dropdown");
        return selectedOption;
    }


}

