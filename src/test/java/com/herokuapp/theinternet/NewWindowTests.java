package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewWindowTests extends TestUtilities {

    @Test
    public void testNewWindow() {
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        WindowsPage windowsPage = homePage.clickMultipleWindowsLink();
        windowsPage.openNewWindow();
        NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();
        String pageSource = newWindowPage.getCurrentPageSource();
        Assert.assertTrue(pageSource.contains("New Window"));


    }
}
