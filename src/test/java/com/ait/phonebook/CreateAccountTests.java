package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            //click on Sign out button
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test (enabled = false)
    public void newUserRegistrationPostiveTest() {

        //click on login link
        app.getHeader().clickOnLoginLink();

        //verify LOGIN form displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        //fill registration form
        app.getUser().fillLoginRegForm(new User().setEmail("Ivanov3@gmail.com").setPassword("Ivanov1234567!"));

        //click on registration button
        app.getUser().clickOnRegistrationButton();

        //verify sign out button displayed
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test
    public void newUserRegistrationNegativeWithoutPasswordTest() {

        //click on login link
        app.getHeader().clickOnLoginLink();

        //verify LOGIN form displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        //fill registration form
        app.getUser().fillLoginRegForm(new User().setEmail("Ivanov3@gmail.com"));

        //click on registration button
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
