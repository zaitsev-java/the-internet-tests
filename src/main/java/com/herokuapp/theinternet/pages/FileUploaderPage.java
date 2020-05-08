package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePage {


    private String pageUrl = "https://the-internet.herokuapp.com/upload";

    private final By chooseFileButton = By.xpath("//input[@id='file-upload']");
    private final By uploadButton = By.xpath("//input[@class='button']");
    private final By uploadedFiles = By.id("uploaded-files");

    //private final String filePath = "src/main/resources/files/java.jpg";


    public FileUploaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectFile(String fileName) {
        log.info("Selecting " + fileName + " file from folder");
        String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
        type(filePath, chooseFileButton);
        log.info("File selected");
    }

    public void pushUploadButton() {
        log.info("Clicking on Upload button");
        click(uploadButton);
    }

    public String getUploadedFileNames() {
        String names = find(uploadedFiles).getText();
        log.info("Uploaded files: " + names);
        return names;
    }


}
