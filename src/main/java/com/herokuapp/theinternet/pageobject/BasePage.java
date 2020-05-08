package com.herokuapp.theinternet.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage extends Page {
    public BasePage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    protected void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    private void waitFor(ExpectedCondition<WebElement> conditions, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(conditions);
    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attemps = 0;
        while (attemps < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null);
                break;
            } catch (StaleElementReferenceException e) {
                attemps++;
            }
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public void switchToWindowWithTitle(String expectedTitle) {
        String firstWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();
        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

    protected void switchToFrame(By framelocator) {
        driver.switchTo().frame(find(framelocator));
    }

    protected void pressKeyOnElement(By locator, Keys key) {
        find(locator).sendKeys(key);
    }


}
