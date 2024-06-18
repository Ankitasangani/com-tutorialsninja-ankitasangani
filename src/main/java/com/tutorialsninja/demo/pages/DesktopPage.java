package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {


    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement price;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement link;

    @CacheLookup
    @FindBy(xpath = "//div[@class='caption']//h4//a")
    List<WebElement> descend;

    @CacheLookup
    @FindBy(xpath = "//div[@class='caption']//h4")
    List<WebElement> element;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sort;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByDropdown;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantityTextBox;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successAlertMsg;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement cartLinkInMsg;


    // create method with name "selectMenu" it has one parameter name "menu" of type string
    // This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu) {
        List<WebElement> elements = getMultipleElements(By.xpath("//a[@class='see-all']"));
        for (WebElement e : elements) {
            if (e.getText().equalsIgnoreCase(menu)) {
                e.click();
                break;
            }
        }
    }


    public void selectSortByPriceHighToLow() {
        selectByValueFromDropDown(price, "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
        Reporter.log("Click on " + addToCart.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + addToCart.toString());
    }

    public void clickOnLinkShoppingCart() {
        clickOnElement(link);
        Reporter.log("Click on " + link.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + link.toString());

    }

    public void SortByPositionZtoA() {
        selectByVisibleTextFromDropDown(sort, "Name (Z - A)");
        Reporter.log("Click on " + sort.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + sort.toString());
    }

    public List<String> verifyDescendingOrder() {
        List<WebElement> elements = descend;
        //Create arraylist
        List<String> beforeFilterProductNamesList = new ArrayList<>();
        //Store elements text to array list
        for (WebElement p : elements) {
            beforeFilterProductNamesList.add(p.getText().toUpperCase());
        }
        // Sort arraylist to ascending order
        Collections.sort(beforeFilterProductNamesList);
        // //Reverse the list
        Collections.reverse(beforeFilterProductNamesList);
        return beforeFilterProductNamesList;
    }

    public List<String> getProductsNameAfterFilterZToA() {
        //Store elements after filtering
        List<WebElement> afterFilterProductNames = element;
        //Create another list to store text of elements after clicking on filter Z to A
        List<String> afterFilterProductNamesList = new ArrayList<>();
        for (WebElement s : afterFilterProductNames) {
            afterFilterProductNamesList.add(s.getText().toUpperCase());
        }
        return afterFilterProductNamesList;
    }


    public void selectFromSortByDropdown(String value) {
        selectByVisibleTextFromDropDown(sortByDropdown, value);
        Reporter.log("Click on " + sortByDropdown.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + sortByDropdown.toString());
    }


    public void clickOnProduct(String product) {
        List<WebElement> products = listOfProducts;
        List<String> productList = new ArrayList<>();
        for (WebElement e : products) {
            if (e.getText().equalsIgnoreCase(product)) {
                e.click();
                break;
            }
        }

        Reporter.log("Click on " + product);
        CustomListeners.test.log(Status.PASS, "Click on " + product);
    }


    public void enterQuantity(String qty) {
        quantityTextBox.clear();
        sendTextToElement(quantityTextBox, qty);
        Reporter.log("update " + qty);
        CustomListeners.test.log(Status.PASS, "update " + qty);
    }

    public String getSuccessAlertMsg() {
        Reporter.log("Get " + successAlertMsg.toString());
        CustomListeners.test.log(Status.PASS, "Get " + successAlertMsg);
        return getTextFromElement(successAlertMsg);
    }

    public void clickOnCartLinkInMsgButton() {
        clickOnElement(cartLinkInMsg);
        Reporter.log("Click on " + cartLinkInMsg.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + cartLinkInMsg.toString());
    }

}
