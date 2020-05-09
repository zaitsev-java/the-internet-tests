package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestUtilities {


    @Test
    public void testHorizontalSlider() {

        log.info("Starting testHorizontalSlider test");
        HomePage homePage = new HomePage(driver,log);
        homePage.open();
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSliderLink();
        String testingValue = "3.5";
        horizontalSliderPage.setSliderTo(testingValue);
        String actualValue = horizontalSliderPage.getSliderValue();
        Assert.assertEquals(actualValue,testingValue);
    }
}
