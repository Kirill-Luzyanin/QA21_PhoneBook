package com.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {

    //precondition: verify User log out, log in
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"))) {
            click(By.xpath("//a[contains(.,'LOGIN')]"));

            type(By.cssSelector("[placeholder='Email']"), "ivanov@gmail.com");
            type(By.cssSelector("[placeholder='Password']"), "Ivanov12345!");
            click(By.name("login"));
        }
    }


    @Test(priority = 1)
    public void addContactPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        //click on Add link
        click(By.cssSelector("a:nth-child(5)"));

        //fill add contact form
        type(By.cssSelector("input:nth-child(1)"), "Leon" + i);
        type(By.cssSelector("input:nth-child(2)"), "Luz");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "lds@google.com");
        type(By.cssSelector("input:nth-child(5)"), "Koblenz");
        type(By.cssSelector("input:nth-child(6)"), "torwart");

        //click on save button
        // так:
        //click(By.xpath("//button[contains(.,'Save')]"));
        // либо так:
        click(By.cssSelector(".add_form__2rsm2 button"));

        //check Contact is added
        Assert.assertTrue(isContactCreated("Leon"));

    }

    @Test(priority = 1)
    public void addContactNegativeWithIncorrectPhoneTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        //click on Add link
        click(By.cssSelector("a:nth-child(5)"));

        //fill add contact form
        type(By.cssSelector("input:nth-child(1)"), "Leon" + i);
        type(By.cssSelector("input:nth-child(2)"), "Luz");
        type(By.cssSelector("input:nth-child(3)"), "12345");
        type(By.cssSelector("input:nth-child(4)"), "lds@google.com");
        type(By.cssSelector("input:nth-child(5)"), "Koblenz");
        type(By.cssSelector("input:nth-child(6)"), "torwart");

        //click on save button
        click(By.xpath("//button[contains(.,'Save')]"));

        //check Contact is added
        Assert.assertTrue(isContactCreated("Leon"));

    }


    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));

        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;

    }
}