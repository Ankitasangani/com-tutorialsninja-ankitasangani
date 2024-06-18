package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement radioBtn;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement tabContinue;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement fNameField;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lNameField;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement mobileField;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address1Field;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement cityField;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postcodeField;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryField;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement stateField;

    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement billingDetailsContButton;

    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement guest;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement comments;

    @CacheLookup
    @FindBy(id = "shipping")
    WebElement shipping;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkBox;

    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement pay;

    @CacheLookup
    @FindBy(id = "button-confirm")
    WebElement confirm;


    public String verifyTheTextNewCustomer() {
        Reporter.log("shopping cart message" + newCustomer.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(newCustomer);
    }

    public void clickOnGuestCheckout() {
        clickOnElement(radioBtn);
        Reporter.log("Click on " + radioBtn.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + radioBtn.toString());

    }

    public void clickOnContinueTab() {
        clickOnElement(tabContinue);
        Reporter.log("Click on " + tabContinue.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + tabContinue.toString());

    }

    public void fillBillingFormDetails(String fName, String lName, String email, String mobile
            , String add1, String city, String postCode, String country, String state) {
        sendTextToElement(fNameField, fName);
        sendTextToElement(lNameField, lName);
        sendTextToElement(emailField, email);
        sendTextToElement(mobileField, mobile);
        sendTextToElement(address1Field, add1);
        sendTextToElement(cityField, city);
        sendTextToElement(postcodeField, postCode);
        selectByVisibleTextFromDropDown(countryField, country);
        selectByVisibleTextFromDropDown(stateField, state);
        clickOnElement(billingDetailsContButton);
    }

    public void clickOnContinueButtonGuest() {
        clickOnElement(guest);
        Reporter.log("Click on " + guest.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + guest.toString());
    }

    public void addCommentsAboutOrder() {
        sendTextToElement(comments, "macbook is out of stock");
        Reporter.log("comments" + comments.toString());
        CustomListeners.test.log(Status.PASS, "Enter comments" + comments);
    }

    public void continueButton() {
        clickOnElement(shipping);
        Reporter.log("Click on " + shipping.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + shipping.toString());
    }

    public void termsAndConditionCheckBox() {
        clickOnElement(checkBox);
        Reporter.log("Click on " + checkBox.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + checkBox.toString());
    }

    public void nextContinueButton() {
        clickOnElement(pay);
        Reporter.log("Click on " + pay.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + pay.toString());
    }

    public void confirmOrderButton() {
        clickOnElement(confirm);
        Reporter.log("Click on " + confirm.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + confirm.toString());
    }
}
