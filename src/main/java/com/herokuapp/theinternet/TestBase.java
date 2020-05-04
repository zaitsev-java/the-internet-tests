package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(@Optional("chrome") String browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Starting Chrome as Default");
                driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    //  For Maintenance
    void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

