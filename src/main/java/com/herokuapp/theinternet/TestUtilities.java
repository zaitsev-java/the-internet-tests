package com.herokuapp.theinternet;

import org.testng.annotations.DataProvider;

public class TestUtilities extends TestBase {

    @DataProvider(name = "files")
    protected static Object[][] files() {
        return new Object[][]{
                {1, "index.html"},
                {2, "java.jpg"},
                {3, "text.txt"}
        };
    }


    // Static Sleep For Maintenance
    void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
