package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    //precondition: login, add contact
    @BeforeMethod
    public void ensurePeconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            //click on Sign out button
            ApplicationManager.driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        } else {
            app.getHeader().clickOnLoginLink();

            //fill login form
            app.getUser().fillLoginRegForm(new User().setEmail("ivanov@gmail.com").setPassword("Ivanov12345!"));
            //click on Login button
            app.getUser().clickOnLoginButton();

            //click on Add link
            app.getContact().clickOnAddLink();

            //fill add contact form
            app.getContact().addContact(new Contact().setName("Leon")
                    .setSurname("Luz")
                    .setPhone("1234567890")
                    .setEmail("lds@google.com")
                    .setAddress("Koblenz")
                    .setDesc("torwart"));

            //click on save button
            app.getContact().clickOnSaveButton();

        }
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);

        //click on the Contact card
        //click on Remove button
        app.getContact().removeContact();

        app.getUser().pause(1_000);
        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);

        //check Contact is removed
        Assert.assertEquals(sizeBefore-1,sizeAfter);
    }

}
