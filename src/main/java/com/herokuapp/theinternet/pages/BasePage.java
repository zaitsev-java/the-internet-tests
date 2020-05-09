package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        for (String allWindow : allWindows) {
            if (!allWindow.equals(firstWindow)) {
                driver.switchTo().window(allWindow);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

    protected void switchToFrame(By frameLocator) {
        driver.switchTo().frame(find(frameLocator));
    }

    protected void pressKeyOnElement(By locator, Keys key) {
        find(locator).sendKeys(key);
    }

    public void scrollToBottom() {
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

//     Method does not work at this particular page

//    protected void performDragAndDrop(By from, By to) {
//        Actions action = new Actions(driver);
//        action.dragAndDrop(find(from), find(to)).build().perform();
//    }

//    Work around for performDragAndDrop method
    protected void performDragAndDrop(By from, By to) {
       JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
       javascriptExecutor.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
               + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
               + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
               + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
               + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
               + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
               + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
               + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
               + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
               + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
               + "var dropEvent = createEvent('drop');\n"
               + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
               + "var dragEndEvent = createEvent('dragend');\n"
               + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
               + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
               + "simulateHTML5DragAndDrop(source,destination);", find(from), find(to));
    }

    protected void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }




}
