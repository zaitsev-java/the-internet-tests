package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementPresentButHiddenTests extends TestBase {

    String hiddenElementOnePage = "https://the-internet.herokuapp.com/dynamic_loading/1";
    private final By startButton = By.xpath("//button[contains(text(),'Start')]");
    private final By hiddenText = By.xpath("//h4[contains(text(),'Hello World!')]");
    private final String expectedMessage = "Hello World!";


    @Test (priority = 1)
    public void hiddenTextTest() {
        driver.get(hiddenElementOnePage);
        driver.findElement(startButton).click();

        WebElement hiddenTextElement = driver.findElement(hiddenText);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(hiddenTextElement));

        String hiddenTextVar = driver.findElement(hiddenText).getText();
        Assert.assertEquals(hiddenTextVar, expectedMessage);
    }

    @Test (priority = 2)
    public void hiddenTextAndButtonHidingTest() {
        hiddenTextTest();
        try {
            driver.findElement(startButton).click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Start button hidden as expected");
        }
    }

    @Test (priority = 3)
    public void timeOutTest() {
        driver.get(hiddenElementOnePage);
        driver.findElement(startButton).click();

        WebElement hiddenTextElement = driver.findElement(hiddenText);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(hiddenTextElement));
        } catch (TimeoutException e) {
            System.out.println("Exception cached : " + e.getMessage());
            sleep(3000);
        }

        String hiddenTextVar = driver.findElement(hiddenText).getText();
        Assert.assertEquals(hiddenTextVar, expectedMessage);
    }

}
