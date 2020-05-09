package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePage {

    private String pageUrl = "https://the-internet.herokuapp.com/drag_and_drop";


    private final By columnA = By.id("column-a");
    private final By columnB = By.id("column-b");


    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void dragAToB() {
        log.info("Drag and drop A box on B box");
        performDragAndDrop(columnA, columnB);
    }

    public String getColumnAText() {
        String text = find(columnA).getText();
        log.info("Column A text: " + text);
        return text;
    }

    public String getColumnBText() {
        String text = find(columnB).getText();
        log.info("Column B text: " + text);
        return text;
    }




}
