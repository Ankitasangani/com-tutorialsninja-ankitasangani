package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MyAccountsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement verify;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement verifyText;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement fNameField;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lNameField;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement mobileField;


    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreeCheckbox;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement verifyMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement nextButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement logout;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement account;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement link;

    public String verifyTextRegisterAccount() {
        Reporter.log("Register Account" + verify.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(verify);
    }

    public String verifyTextReturningCustomer() {
        Reporter.log("Returning Customer" + verifyText.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(verifyText);
    }

    public void fillRegistrationData(String fName, String lName, String email, String mobile
            , String pwd, String cpwd) {
        sendTextToElement(fNameField, fName);
        sendTextToElement(lNameField, lName);
        sendTextToElement(emailField, email);
        sendTextToElement(mobileField, mobile);
        sendTextToElement(passwordField, pwd);
        sendTextToElement(confirmPasswordField, cpwd);
        clickOnElement(agreeCheckbox);
        clickOnElement(continueButton);
    }

    public String verifyAccountMessage() {
        Reporter.log("Account Message" + verifyMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(verifyMessage);
    }

    public void clickOnNextContinueButton() {
        clickOnElement(nextButton);
        Reporter.log("Click on " + nextButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + nextButton.toString());
    }

    public String verifyAccountLogout() {
        Reporter.log("Account Logout" + logout.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(logout);
    }

    public void fillLoginData(String email, String pwd) {
        sendTextToElement(emailField, email);
        sendTextToElement(passwordField, pwd);
        clickOnElement(loginButton);
    }

    public String verifyTextMyAccount() {
        Reporter.log("My Account" + account.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(account);
    }

    public void clickOnMyAccountLink() {
        clickOnElement(link);
        Reporter.log("Click on " + link.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + link.toString());
    }

}
