package com.demoblaze.testsuite;

import com.demoblaze.pages.HomePage;
import com.demoblaze.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Sunil Suhagiya
 */

public class LogInTest extends BaseTest {

    HomePage homePage = new HomePage();

    private static final String userName = generateRandomString(8);
    private static final String password = generateRandomString(10);

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(description = "Verify user is able to sign up and can login successfully", groups = {"smoke", "login"})
    public void verifyUserIsAbleToSignUpAndLogInSuccessfully() {
        //SIGNUP SCENARIO
        homePage.clickOnNavigationTab("Sign up");
        homePage.enterUserName(userName);
        homePage.enterPassword(password);
        homePage.clickSignUpButton();
        Assert.assertEquals(homePage.getSignUpSuccessText(), "Sign up successful.", "Sign up success text did not match");
        //LOGIN SCENARIO
        homePage.clickOnNavigationTab("Log in");
        homePage.enterLogInUserName(userName);
        homePage.enterLogInPassword(password);
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getSignedInUser(), "Welcome " +userName, "user name did not match");
    }
}
