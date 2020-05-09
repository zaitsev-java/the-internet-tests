package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTests extends TestUtilities {


    @Test(dataProvider = "files")
    public void testUploadFile(int testNo, String fileName) {
        log.info("Starting testUploadFile #" +testNo+" for " + fileName);
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        FileUploaderPage fileUploaderPage = homePage.clickFileUploadLink();
        fileUploaderPage.selectFile(fileName);
        fileUploaderPage.pushUploadButton();
        String uploadedFileName = fileUploaderPage.getUploadedFileNames();
        Assert.assertTrue(uploadedFileName.contains(fileName));

    }
}
