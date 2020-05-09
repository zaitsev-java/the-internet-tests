package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.WYSIWYGEditorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WYSIWYGEditorTests extends TestUtilities {


    @Test
    public void testEditorsDefaultValues() {
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        homePage.scrollToBottom();
        WYSIWYGEditorPage wYSIWYGEditorPage = homePage.clickWYSIWYGEditorLink();
        String editorsText = wYSIWYGEditorPage.getEditorText();
        Assert.assertEquals(editorsText, "Your content goes here.");
    }
}
