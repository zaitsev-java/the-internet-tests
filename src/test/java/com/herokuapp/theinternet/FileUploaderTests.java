package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTests extends TestUtilities {


    @Test
    public void testUploadImage() {
        log.info("Starting testUploadImage test");
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        FileUploaderPage fileUploaderPage = homePage.clickFileUploadLink();
        String fileName = "java.jpg";
        fileUploaderPage.selectFile(fileName);
        fileUploaderPage.pushUploadButton();
        String uploadedFileName = fileUploaderPage.getUploadedFileNames();
        Assert.assertTrue(uploadedFileName.contains(fileName));

    }
}
