package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoversPage extends BasePage {

    private String pageUrl = "https://the-internet.herokuapp.com/hovers";

    private By avatarsLocator = By.xpath("//div[@class='figure']");
    private By viewProfileLink = By.xpath(".//a[contains(text(), 'View profile')]");


    public HoversPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openUserProfile(int profileNo) {
        List<WebElement> avatars = findAll(avatarsLocator);
        WebElement specifiedUserAvatar = avatars.get(profileNo -1);
        hoverOverElement(specifiedUserAvatar);
        specifiedUserAvatar.findElement(viewProfileLink).click();

    }





}
