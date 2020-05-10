package com.herokuapp.theinternet;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserDriverFactory {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final String browser;
    private final Logger log;

    public BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public WebDriver createDriver() {
        log.info("Created driver: " + browser);

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                driver.set(new FirefoxDriver());
                break;
            default:
                System.out.println("Do not know how to start: " + browser + " starting Chrome");
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver.set(new ChromeDriver());
                break;
        }
        return driver.get();
    }

    public WebDriver createChromeWithMobileEmulation(String deviceName) {
        log.info("Starting driver with " + deviceName + " emulation]");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", deviceName);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver.set(new ChromeDriver(chromeOptions));
        return driver.get();
    }


}
