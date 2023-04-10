package com.ait.phonebook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    static ApplicationManager app = new ApplicationManager();

    //@BeforeSuite //даёт алфавитный порядок + все в одном окне
    @BeforeSuite
    public void setUp() {
        app.init();
    }


    //@AfterSuite(enabled = false)
    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
