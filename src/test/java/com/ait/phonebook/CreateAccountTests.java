package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            //click on Sign out button
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
    }

    @Test (enabled = false)
    public void newUserRegistrationTest() {
        //click on login link
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();

        //verify LOGIN link displayed
        Assert.assertTrue(isElementPresent(By.className("login_login__3EHKB")));

        //fill registration form
        type(By.cssSelector("[placeholder='Email']"), "Ivanov3@gmail.com");
        type(By.cssSelector("[placeholder='Password']"), "Ivanov1234567!");

        //click on registration button
        driver.findElement(By.name("registration")).click();

        //verify sign out button displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));

    }


}
