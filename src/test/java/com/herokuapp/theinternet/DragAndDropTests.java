package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {



    @Test
    public void testEditorsDefaultValues() {
        HomePage homePage = new HomePage(driver, log);
        homePage.open();
        DragAndDropPage dragAndDropPage = homePage.clickDragAndDropLink();
        dragAndDropPage.dragAToB();
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertEquals(columnAText, "B");
        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertEquals(columnBText, "A");
    }


}
