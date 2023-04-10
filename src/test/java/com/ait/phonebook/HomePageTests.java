package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test(priority = 1)
    public void openHomePageTest() {
        //check to displayed Home Component form
        // isComponentFormPresent2();
        // System.out.println("Home Component form: " + isComponentFormPresent2());
        //isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        Assert.assertTrue(app.getHome().isComponentFormPresent());
    }

}
