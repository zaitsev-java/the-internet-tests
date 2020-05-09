package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTests extends TestUtilities {

    @Test
    public void testUser2Profile() {
        log.info("Starting testUser2Profile test");
        HomePage homePage = new HomePage(driver,log);
        homePage.open();
        HoversPage hoversPage = homePage.clickHoversLink();
        hoversPage.openUserProfile(2);
        Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"));
    }
}
