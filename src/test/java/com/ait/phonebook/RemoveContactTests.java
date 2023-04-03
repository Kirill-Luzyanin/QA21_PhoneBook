package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    //precondition: login, add contact
    @BeforeMethod
    public void ensurePeconditions() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            //click on Sign out button
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        } else {
            click(By.xpath("//a[contains(.,'LOGIN')]"));

            //fill login form
            type(By.cssSelector("[placeholder='Email']"), "ivanov@gmail.com");
            type(By.cssSelector("[placeholder='Password']"), "Ivanov12345!");
            //click on Login button
            click(By.name("login"));

            //click on Add link
            click(By.cssSelector("a:nth-child(5)"));

            //fill add contact form
            type(By.cssSelector("input:nth-child(1)"), "Leon");
            type(By.cssSelector("input:nth-child(2)"), "Luz");
            type(By.cssSelector("input:nth-child(3)"), "1234567890");
            type(By.cssSelector("input:nth-child(4)"), "lds@google.com");
            type(By.cssSelector("input:nth-child(5)"), "Koblenz");
            type(By.cssSelector("input:nth-child(6)"), "torwart");

            //click on save button
            click(By.xpath("//button[contains(.,'Save')]"));

        }
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();
        System.out.println(sizeBefore);

        //click on the Contact card
        click(By.cssSelector(".contact-item_card__2SOIM"));

        //click on Remove button
        click(By.xpath("//button[contains(.,'Remove')]"));
        pause(1_000);
        int sizeAfter = sizeOfContacts();
        System.out.println(sizeAfter);

        //check Contact is removed
        Assert.assertEquals(sizeBefore-1,sizeAfter);
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } else {
            return 0;
        }
    }

}
