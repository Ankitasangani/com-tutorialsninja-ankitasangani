package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(linkText = "Sony VAIO")
    WebElement productSony;

    @CacheLookup
    @FindBy(xpath = "//input[@class='form-control']")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement update;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Success')]")
    WebElement updateMessage;

    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[6]")
    WebElement totalAmount;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkout;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement textCheckout;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[@class='text-left'][2]")
    WebElement modelName;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]")
    WebElement totalPrice;


    public String verifyTheTextShoppingCart() {
        Reporter.log("shopping Cart" + shoppingCart.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(shoppingCart).substring(0, 13);
    }

    public String verifyTheProductSonyVAIO() {
        Reporter.log("ProductSonyVAIO" + productSony.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(productSony);
    }

    public void changeQty() {
        driver.findElement((By) quantity).clear();
        sendTextToElement(quantity, "2");
        Reporter.log("click " + quantity.toString());
        CustomListeners.test.log(Status.PASS, "click " + quantity.toString());

    }

    public void clickOnUpdateTab() {
        clickOnElement(update);
        Reporter.log("Click on " + update.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + update.toString());
    }

    public String modifiedMessage() {
        Reporter.log("update Message" + updateMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(updateMessage).substring(0, 46);
    }

    public String verifyTotal() {
        Reporter.log("Total" + totalAmount.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(totalAmount);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkout);
        Reporter.log("Click on " + checkout.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + checkout.toString());
    }

    public String verifyTheTextCheckout() {
        Reporter.log("Checkout" + textCheckout.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(textCheckout);
    }

    public String getProductName() {
        Reporter.log("Get " + productName.toString());
        CustomListeners.test.log(Status.PASS, "Get " + productName.toString());
        return getTextFromElement(productName);
    }

    public String getModelName() {
        Reporter.log("Get " + modelName.toString());
        CustomListeners.test.log(Status.PASS, "Get " + modelName.toString());
        return getTextFromElement(modelName);
    }

    public String getTotalPrice() {
        Reporter.log("Get " + totalPrice.toString());
        CustomListeners.test.log(Status.PASS, "Get " + totalPrice.toString());
        WebElement toRightOf = driver.findElement(RelativeLocator.with(By.xpath("//td[@class='text-right']")).toRightOf(By.xpath("//strong[normalize-space()='Total:']")));
        return getTextFromElement(toRightOf);
    }
}
