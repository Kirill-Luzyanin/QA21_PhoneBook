package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    //precondition: verify User log out, log in
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isSignOutButtonPresent()) {
            app.getHeader().clickOnLoginLink();

            app.getUser().fillLoginRegForm(new User().setEmail("ivanov@gmail.com").setPassword("Ivanov12345!"));
            app.getUser().clickOnLoginButton();
        }
    }


    @Test(priority = 1)
    public void addContactPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        //click on Add link
        app.getContact().clickOnAddLink();

        //fill add contact form
        app.getContact().addContact(new Contact().setName("Leon" + i)
                .setSurname("Luz")
                .setPhone("1234567890")
                .setEmail("lds@google.com")
                .setAddress("Koblenz")
                .setDesc("torwart"));

        //click on save button
        // так:
        //click(By.xpath("//button[contains(.,'Save')]"));
        // либо так:
        app.getContact().clickOnSaveButton();

        //check Contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Leon"));

    }

    @Test(priority = 2)
    public void addContactNegativeWithIncorrectPhoneTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        //click on Add link
        app.getContact().clickOnAddLink();

        //fill add contact form
        app.getContact().addContact(new Contact().setName("Leon" + i)
                .setSurname("Luz")
                .setPhone("12345")
                .setEmail("lds@google.com")
                .setAddress("Koblenz")
                .setDesc("torwart"));

        //click on save button
        app.getContact().clickOnSaveButton();

        //verify alert appeared after fill form and click save button
        Assert.assertTrue(app.getContact().isAlertPresent());
    }


}