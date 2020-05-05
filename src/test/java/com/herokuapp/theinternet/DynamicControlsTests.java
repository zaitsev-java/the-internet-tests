package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTests extends TestUtilities {

    String dynamicControlsPage = "https://the-internet.herokuapp.com/dynamic_controls";
    private final By checkboxFirst = By.xpath("//div[@id='checkbox']//input");
    private final By checkboxNew = By.xpath("//input[@id='checkbox']");
    private final By removeButton = By.xpath("//button[contains(text(),'Remove')]");
    private final By addButton = By.xpath("//button[contains(text(),'Add')]");
    private final By firstGoneBackMessage = By.xpath("//p[ @id='message']");
    private final String expectedGoneMessage = "It's gone!";
    private final String expectedBackMessage = "It's back!";

    private final By inputField = By.xpath("//form[@id='input-example']//input");
    private final By enableButton = By.xpath("//button[contains(text(),'Enable')]");
    private final By disableButton = By.xpath("//button[contains(text(),'Disable')]");
    private final By message = By.xpath("//p[@id='message']");
    private final String expectedEnableMessage = "It's enabled!";
    private final String expectedDisableMessage = "It's disabled!";

    @Test
    public void dynamicControlsPresentsTest() {
        driver.get(dynamicControlsPage);
        driver.findElement(checkboxFirst).click();
        driver.findElement(removeButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        waitForElement(wait, expectedGoneMessage);
        driver.findElement(addButton).click();
        waitForElement(wait, expectedBackMessage);
        driver.findElement(checkboxNew).click();
    }

    private void waitForElement(WebDriverWait wait, String s) {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstGoneBackMessage));
        String hiddenTextVar = driver.findElement(firstGoneBackMessage).getText();
        Assert.assertEquals(hiddenTextVar, s);
    }

    @Test
    public void dynamicControlsStalenessTest() {
        driver.get(dynamicControlsPage);
        driver.findElement(checkboxFirst).click();
        driver.findElement(removeButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(driver.findElement(checkboxFirst))));
    }

    @Test
    public void dynamicControlsInvisibilityTest() {
        driver.get(dynamicControlsPage);
        driver.findElement(checkboxFirst).click();
        driver.findElement(removeButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(driver.findElement(checkboxFirst))));
    }

    @Test
    public void disabledElementTest() {
        driver.get(dynamicControlsPage);
        driver.findElement(enableButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        String actualEnabledMessage = driver.findElement(message).getText();
        Assert.assertEquals(actualEnabledMessage, expectedEnableMessage);

        driver.findElement(disableButton).click();

        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(inputField)));
        String actualDisabledMessage = driver.findElement(message).getText();
        Assert.assertEquals(actualDisabledMessage, expectedDisableMessage);
    }
}


