package com.herokuapp.theinternet.unused;

import com.herokuapp.theinternet.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectElementPresentTests extends TestUtilities {


    String hiddenElementTwoPage = "https://the-internet.herokuapp.com/dynamic_loading/2";
    private final By startButton = By.xpath("//button[contains(text(),'Start')]");
    private final By hiddenText = By.xpath("//h4[contains(text(),'Hello World!')]");
    private final String expectedMessage = "Hello World!";

    @Test
    public void delayedPresentsOfElement() {
        driver.get(hiddenElementTwoPage);
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(hiddenText));
        String hiddenTextVar = driver.findElement(hiddenText).getText();
        Assert.assertEquals(hiddenTextVar, expectedMessage);
    }


}
