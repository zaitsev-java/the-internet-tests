package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.JSErrorPage;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JSErrorTests extends TestUtilities {

    @Test
    public void testJcSError() {
        log.info("Starting testJcSError test");
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        JSErrorPage jsErrorPage = homePage.clickJSOnLoadEventErrorLink();
        List<LogEntry> logs = getBrowserLogs();
        for (LogEntry logEntry : logs) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }
        }
        softAssert.assertAll();

    }
}
