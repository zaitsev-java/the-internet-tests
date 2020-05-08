package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends TestUtilities {


    @Test
    public void testKeyPresses() {
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        KeyPressesPage keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.pressKey(Keys.ENTER);
        String result = keyPressesPage.getResultText();
        Assert.assertEquals(result, "You entered: ENTER");
    }
}
