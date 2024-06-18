package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.List;

/**
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab. and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
 * String successMessage, String productName, String model, String total )
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product <product>
 * 2.7 Enter Qty <qty> using Select class.
 * 2.8 Click on “Add to Cart” button
 * 2.9 Verify the Message <successMessage>
 * 2.10 Click on link “shopping cart” display into success message
 * 2.11 Verify the text "Shopping Cart"
 * 2.12 Verify the Product name <productName>
 * 2.13 Verify the Model <model>
 * 2.14 Verify the Total <total>
 */
@Listeners(CustomListeners.class)
public class DesktopsPageTest extends BaseTest {

    DesktopPage desktopPage;
    TopMenuPage topMenuPage;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        desktopPage = new DesktopPage();
        topMenuPage = new TopMenuPage();
        homePage = new HomePage();
        shoppingCartPage = new ShoppingCartPage();
    }


    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        topMenuPage.mouseHoverAndClickOnDesktops(); // Mouse hover on Desktops Tab.
        topMenuPage.selectMenu("Show AllDesktops"); // Click on “Show All Desktops”
        // Verify the Product will arrange in Descending order.
        List<String> actualText = desktopPage.verifyDescendingOrder();
        desktopPage.SortByPositionZtoA(); //  Select Sort By position "Name: Z to A"
        Thread.sleep(2000);
        List<String> expectedText = desktopPage.getProductsNameAfterFilterZToA();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");
    }


    @Test(groups = {"smoke", "regression"}, dataProvider = "desktopData", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
                                                             String successMessage, String productName, String model, String total) throws InterruptedException {
        //2.1 Mouse hover on Currency Dropdown and click
        homePage.clickOnCurrency();
        // 2.2 Mouse hover on £Pound Sterling and click
        //homePage.selectPoundCurrency();
        // 2.3 Mouse hover on Desktops Tab.
        topMenuPage.mouseHoverAndClickOnDesktops();
        //2.4 Click on “Show All Desktops”
        topMenuPage.selectMenu("Show AllDesktops");
        //2.5 Select Sort By position "Name: A to Z"
        desktopPage.selectFromSortByDropdown("Name (A - Z)");
        //2.6 Select product <product>
        desktopPage.clickOnProduct(product);
        //2.7 Enter Qty <qty> using Select class.
        desktopPage.enterQuantity(qty);
        //2.8 Click on “Add to Cart” button
        desktopPage.clickOnAddToCartButton();
        Thread.sleep(2000);
        //2.9 Verify the Message <successMessage>
        String expString = desktopPage.getSuccessAlertMsg();
        String expString2 = expString.split("!")[0];
        Assert.assertEquals(expString, "Success: You have added " + product + " to your shopping cart!\n" + "×");
        // 2.10 Click on link “shopping cart” display into success message
        desktopPage.clickOnCartLinkInMsgButton();
        //2.11 Verify the text "Shopping Cart"
        Assert.assertEquals(shoppingCartPage.verifyTheTextShoppingCart().substring(0, 13), "Shopping Cart");
        //2.12 Verify the Product name <productName>
        Assert.assertEquals(shoppingCartPage.getProductName(), product);
        //2.13 Verify the Model <model>
        Assert.assertEquals(shoppingCartPage.getModelName(), model);
        //2.14 Verify the Total <total>
        Assert.assertEquals(shoppingCartPage.getTotalPrice(), total);
    }
}
