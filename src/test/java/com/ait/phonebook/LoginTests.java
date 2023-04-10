package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            //click on Sign out button
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest() {
        //click on login link
        app.getHeader().clickOnLoginLink();

        //fill login form
        app.getUser().fillLoginRegForm(new User().setEmail("ivanov@gmail.com").setPassword("Ivanov12345!"));

        //click on Login button
        app.getUser().clickOnLoginButton();

        //verify user Logged in
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test(priority = 2)
    public void loginRegisteredUserNegativeWithInvalidPasswordTest() {
        //click on login link
        app.getHeader().clickOnLoginLink();

        //fill login form
        app.getUser().fillLoginRegForm(new User().setEmail("ivanov@gmail.com").setPassword("Ivanov12345"));

        //click on Login button
        app.getUser().clickOnLoginButton();
        app.getUser().pause(1000);

        //verify user Logged in
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test(priority = 3)
    public void loginRegisteredUserNegativeWithInvalidEmailTest() {
        //click on login link
        app.getHeader().clickOnLoginLink();

        //fill login form
        app.getUser().fillLoginRegForm(new User().setEmail("ivanov@@gmail.com").setPassword("Ivanov12345!"));

        //click on Login button
        app.getUser().clickOnLoginButton();
        app.getUser().pause(1000);

        //verify user Logged in
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
