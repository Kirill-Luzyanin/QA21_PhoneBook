package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            //click on Sign out button
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
    }

    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest() {
        //click on login link
        click(By.xpath("//a[contains(.,'LOGIN')]"));

        //fill login form
        type(By.cssSelector("[placeholder='Email']"), "ivanov@gmail.com");
        type(By.cssSelector("[placeholder='Password']"), "Ivanov12345!");

        //click on Login button
        click(By.name("login"));

        //verify user Logged in
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

    @Test(priority = 2)
    public void loginRegisteredUserNegativeWithInvalidPasswordTest() {
        //click on login link
        click(By.xpath("//a[contains(.,'LOGIN')]"));

        //fill login form
        type(By.cssSelector("[placeholder='Email']"), "ivanov@gmail.com");
        type(By.cssSelector("[placeholder='Password']"), "Ivanov12345");

        //click on Login button
        click(By.name("login"));
        pause(1000);

        //verify user Logged in
        Assert.assertTrue(isAlertPresent());
    }

    @Test(priority = 3)
    public void loginRegisteredUserNegativeWithInvalidEmailTest() {
        //click on login link
        click(By.xpath("//a[contains(.,'LOGIN')]"));

        //fill login form
        type(By.cssSelector("[placeholder='Email']"), "ivanov@@gmail.com");
        type(By.cssSelector("[placeholder='Password']"), "Ivanov12345!");

        //click on Login button
        click(By.name("login"));
        pause(1000);

        //verify user Logged in
        Assert.assertTrue(isAlertPresent());
    }



}
