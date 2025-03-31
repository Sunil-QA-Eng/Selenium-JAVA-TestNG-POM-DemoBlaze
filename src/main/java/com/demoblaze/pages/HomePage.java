package com.demoblaze.pages;

import com.demoblaze.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

/**
 * Created by Sunil Suhagiya
 */
public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(xpath = "//a[@class=\"nav-link\"]")
    List<WebElement> topNavigation;

    @CacheLookup
    @FindBy(id = "sign-username")
    WebElement signUpUserNameField;

    @CacheLookup
    @FindBy(id = "sign-password")
    WebElement signUpPasswordField;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signUpButton;

    @CacheLookup
    @FindBy(id = "loginusername")
    WebElement loginUserName;

    @CacheLookup
    @FindBy(id = "loginpassword")
    WebElement loginPassword;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Log in']")
    WebElement logInButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(), 'Welcome')]")
    WebElement nameOfUser;

    public void clickOnNavigationTab(String tab) {
        for (WebElement nav : topNavigation) {
            if (nav.getText().contains(tab)) {
                log.info("Click on '" + tab + "' tab <br>");
                clickOnElement(nav);
                break;
            }
        }
    }

    public void enterUserName(String userName) {
        Reporter.log("Enter username : '" + userName + "' to user name field");
        waitForVisibility(signUpUserNameField, 30);
        sendTextToElement(signUpUserNameField, userName);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter Password : '" + password + "' to password field" + "<br>");
        waitForVisibility(signUpPasswordField, 30);
        sendTextToElement(signUpPasswordField, password);
    }

    public void clickSignUpButton() {
        Reporter.log("Click signup Button");
        waitForVisibility(signUpButton, 30);
        clickOnElement(signUpButton);
    }

    public void enterLogInUserName(String userName) {
        Reporter.log("Enter Login user name : " + userName);
        waitForVisibility(loginUserName, 30);
        sendTextToElement(loginUserName, userName);
    }

    public void enterLogInPassword(String password) {
        Reporter.log("Enter Login Password :  " + password );
        waitForVisibility(loginPassword, 30);
        sendTextToElement(loginPassword, password);
    }

    public void clickLoginButton() {
        Reporter.log("Clicking on Login button");
        clickOnElement(logInButton);
    }

    public String getSignedInUser() {
        Reporter.log("Get signed in user name");
        createWait(30);
        return getTextFromElement(nameOfUser);
    }

    public String getSignUpSuccessText() {
        waitForAlertToPresent(30);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
        return alertText;
    }

    public void clickOKAlertButton() {
        acceptAlert();
    }
}

