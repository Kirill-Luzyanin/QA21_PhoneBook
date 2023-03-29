package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            //need to login
            driver.findElement(By.xpath("//button[contains(.,'LOGIN')]")).click();

            //fill email
            driver.findElement(By.cssSelector("[placeholder='Email']")).click();
            driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
            driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("Leon5@google.com");

            //fill password
            driver.findElement(By.cssSelector("[placeholder='Password']")).click();
            driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
            driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Le12345!5");

            //click on login button
            driver.findElement(By.name("login")).click(); //глючит сайт. приходится через регистрацию
            //driver.findElement(By.name("registration")).click();


        }
    }

    @Test
    public void newUserRegistrationTest() {


        //click on add button
        driver.findElement(By.xpath("//button[contains(.,'ADD')]")).click();

        //find fild Name
        driver.findElement(By.cssSelector("[placeholder='Name']")).click();
        driver.findElement(By.cssSelector("[placeholder='Name']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Name']")).sendKeys("Leonid");

        //find fild Phone
        driver.findElement(By.cssSelector("[placeholder='Phone']")).click();
        driver.findElement(By.cssSelector("[placeholder='Phone']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Phone']")).sendKeys("1234567890");

        //find fild description
        driver.findElement(By.cssSelector("[placeholder='description']")).click();
        driver.findElement(By.cssSelector("[placeholder='description']")).clear();
        driver.findElement(By.cssSelector("[placeholder='description']")).sendKeys("description");

        //click on save button
        driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();

        //verify new contact displayed
        driver.findElement(By.xpath("//button[contains(.,'CONTACTS')]")).click();

    }

}
