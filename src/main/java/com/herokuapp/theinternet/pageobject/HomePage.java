package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    private String pageUrl = "https://the-internet.herokuapp.com";

    private final By loginPageLink = By.xpath("//a[contains(text(),'Form Authentication')]");
    private final By checkboxesLink = By.xpath("//a[contains(text(),'Checkboxes')]");
    private final By dropdownLink = By.xpath("//a[contains(text(),'Dropdown')]");
    private final By jSAlertLink = By.xpath("//a[contains(text(),'JavaScript Alerts')]");
    private final By multipleWindowsLink = By.xpath("//a[contains(text(),'Multiple Windows')]");
    private final By wYSIWYGEditorLink = By.xpath("//a[contains(text(),'WYSIWYG Editor')]");
    private final By keyPressesLink = By.xpath("//a[contains(text(),'Key Presses')]");

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    public void open() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened.");
    }

    public LoginPage clickLoginLink() {
        log.info("Clicking on Form Authentication link on HomePage");
        click(loginPageLink);
        return new LoginPage(driver, log);
    }

    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking on Form Authentication link on HomePage");
        click(checkboxesLink);
        return new CheckboxesPage(driver, log);
    }

    public DropdownPage clickDropdownLink() {
        log.info("Clicking on Form Authentication link on HomePage");
        click(dropdownLink);
        return new DropdownPage(driver, log);
    }

    public JSAlertsPage clickJSAlertLink() {
        log.info("Clicking on Form Authentication link on HomePage");
        click(jSAlertLink);
        return new JSAlertsPage(driver, log);
    }

    public WindowsPage clickMultipleWindowsLink() {
        log.info("Clicking on Form Authentication link on HomePage");
        click(multipleWindowsLink);
        return new WindowsPage(driver, log);
    }

    public WYSIWYGEditorPage clickWYSIWYGEditorLink() {
        log.info("Clicking on Form Authentication link on HomePage");
        click(wYSIWYGEditorLink);
        return new WYSIWYGEditorPage(driver, log);
    }

    public KeyPressesPage clickKeyPressesLink() {
        log.info("Clicking on Form Authentication link on HomePage");
        click(keyPressesLink);
        return new KeyPressesPage(driver, log);
    }










}
