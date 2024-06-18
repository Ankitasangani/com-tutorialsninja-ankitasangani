package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * <p>
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 */
@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksPageTest extends BaseTest {

    TopMenuPage topMenuPage;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    DesktopPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    CheckoutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        topMenuPage = new TopMenuPage();
        homePage = new HomePage();
        shoppingCartPage = new ShoppingCartPage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        checkoutPage = new CheckoutPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        topMenuPage.mouseHoverAndClickOnLaptopsNotebooks(); // Mouse hover on Laptops & Notebooks Tab and click
        topMenuPage.selectMenu("Show AllLaptops & Notebooks"); // Click on “Show All Laptops & Notebooks”
        desktopPage.selectSortByPriceHighToLow(); // Select Sort By "Price (High > Low)"
        //  Verify the Product price will arrange in High to Low order.
        List<Double> actualText = laptopsAndNotebooksPage.beforeFilterProductPrice();
        desktopPage.selectSortByPriceHighToLow();
        Thread.sleep(2000);
        List<Double> expectedText = laptopsAndNotebooksPage.afterFilterProductPrice();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        topMenuPage.mouseHoverAndClickOnLaptopsNotebooks(); // Mouse hover on Laptops & Notebooks Tab and click
        topMenuPage.selectMenu("Show AllLaptops & Notebooks"); // Click on “Show All Laptops & Notebooks”
        desktopPage.selectSortByPriceHighToLow(); // Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectProductSonyVAIO(); // Select product SonyVAIO

        //Verify the text “Sony VAIO”
        String expectedResult = "Sony VAIO";
        String actualResult = laptopsAndNotebooksPage.verifyTextSonyVAIO();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

        desktopPage.clickOnAddToCartButton();
        //Verify the message “Success: You have added Sony VAIO to your shopping cart!”
        String expectedMessage = "Success: You have added Sony VAIO to your shopping cart!";
        String actualMessage = laptopsAndNotebooksPage.verifyTextMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Text didn't match!");

        desktopPage.clickOnLinkShoppingCart();
        // Verify the text "Shopping Cart"
        String expectedText = "Shopping Cart";
        String actualText = shoppingCartPage.verifyTheTextShoppingCart();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");

        // Verify the Product name "Sony VAIO"
        String expectedProduct = "Sony VAIO";
        String actualProduct = shoppingCartPage.verifyTheProductSonyVAIO();
        Assert.assertEquals(actualProduct, expectedProduct, "Text didn't match!");

        shoppingCartPage.changeQty(); //  Change Quantity "2"
        shoppingCartPage.clickOnUpdateTab(); // Click on “Update” Tab

        // Verify the message “Success: You have modified your shopping cart!”
        String expectedUpdate = "Success: You have modified your shopping cart!";
        String actualUpdate = shoppingCartPage.modifiedMessage();
        Assert.assertEquals(actualUpdate, expectedUpdate, "Text didn't match!");

        // Verify the Total "£1,472.45"
        String expectedTotal = "£1,472.45";
        String actualTotal = shoppingCartPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Text didn't match!");
        shoppingCartPage.clickOnCheckOutButton();

        // Verify the text “Checkout”
        String expected = "Checkout";
        String actual = shoppingCartPage.verifyTheTextCheckout();
        Assert.assertEquals(actual, expected, "Text didn't match!");

        // Verify the text “New Customer”
        String expectedNew = "New Customer";
        String actualNew = checkoutPage.verifyTheTextNewCustomer();
        Assert.assertEquals(actualNew, expectedNew, "Text didn't match!");

        checkoutPage.clickOnGuestCheckout(); // Click on “Guest Checkout” radio button
        checkoutPage.clickOnContinueTab(); // Click on “Continue” tab
        // Fill the mandatory fields
        checkoutPage.fillBillingFormDetails("Ankita", "Sangi", "ankita456@gmail.com", "07724567892"
                , "25 Harbor Street", "birmingham", "B202DW", "United Kingdom", "Kent");
        checkoutPage.clickOnContinueButtonGuest();
        checkoutPage.addCommentsAboutOrder(); // Add Comments About your order into text area
        checkoutPage.continueButton();
        Thread.sleep(2000);
        checkoutPage.termsAndConditionCheckBox(); // Check the Terms & Conditions check box
        checkoutPage.nextContinueButton(); // Click on “Continue” Button
        checkoutPage.confirmOrderButton(); // Click on confirm order Button
    }
}

































