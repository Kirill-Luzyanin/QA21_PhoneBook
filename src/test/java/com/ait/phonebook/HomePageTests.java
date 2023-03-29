package com.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void openHomePageTest() {
        //check to displayed Home Component form
//        isComponentFormPresent2();
//        System.out.println("Home Component form: " + isComponentFormPresent2());
        //isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        isElementPresent2(By.cssSelector("div:nth-child(2)>div>div"));
    }

    public boolean isComponentFormPresent() {
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
    }

    public boolean isComponentFormPresent2() {
        return isElementPresent2(By.cssSelector("div:nth-child(2)>div>div"));
    }


}
