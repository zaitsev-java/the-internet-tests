package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pageobject.CheckboxesPage;
import com.herokuapp.theinternet.pageobject.HomePage;
import org.testng.annotations.Test;

public class CheckboxTests extends TestUtilities{

    @Test
    public void testTwoCheckboxSelected() {
        log.info("Starting testTwoCheckboxSelected test");
        HomePage homePage = new HomePage(driver,log);
        homePage.open();
        CheckboxesPage checkboxesPage = homePage.clickOnCheckboxesLink();


    }
}
