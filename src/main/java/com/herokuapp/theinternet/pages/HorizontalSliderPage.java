package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage extends BasePage{

    private String pageUrl = "https://the-internet.herokuapp.com/horizontal_slider";

    private By rangeLocator = By.id("range");
    private By sliderLocator = By.tagName("input");


    public HorizontalSliderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

//    Does not work For this specific page
//
//    public void setSliderTo(String value) {
//        log.info("Moving slider to " + value);
//        int with = find(sliderLocator).getSize().getWidth();
//        double percent = Double.parseDouble(value) / 5;
//        int xOffset = (int) (with * percent);
//        Actions action = new Actions(driver);
//        action.dragAndDropBy(find(sliderLocator), xOffset, 0).build().perform();
//    }

//      WorkAround
    public void setSliderTo(String value) {
        log.info("Moving slider to " + value);
        int steps = (int) (Double.parseDouble(value) / 0.5);
        pressKeyOnElement(sliderLocator, Keys.ENTER);
        for (int i = 0; i< steps; i++) {
            pressKeyOnElement(sliderLocator, Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        String value = find(rangeLocator).getText();
        log.info("Slider value is " + value);
        return value;
    }





}
