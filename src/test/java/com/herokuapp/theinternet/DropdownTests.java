package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pageobject.DropdownPage;
import com.herokuapp.theinternet.pageobject.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DropdownTests extends TestUtilities{


    @Test
    public void testDropdown2() {

        log.info("Starting testDropdown2 test");
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        DropdownPage dropdownPage = homePage.clickDropdownLink();
        dropdownPage.selectOption(2);
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"));

    }
}
