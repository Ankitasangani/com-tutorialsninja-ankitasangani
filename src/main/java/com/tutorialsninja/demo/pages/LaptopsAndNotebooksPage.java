package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//div[1]//div[2]//div[1]//p//span[@class='price-tax']")
    List<WebElement> priceValue;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//div[1]//div[2]//div[1]//p//span[@class='price-tax']")
    List<WebElement> afterFilter;

    @CacheLookup
    @FindBy(linkText = "Sony VAIO")
    WebElement product;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Success')]")
    WebElement message;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Sony VAIO')]")
    WebElement verifySonyVAIO;


    public List<Double> beforeFilterProductPrice() throws InterruptedException {
        List<WebElement> beforeFilterProductPrice = priceValue;
        //Create arraylist
        List<Double> beforeFilterProductPriceList = new ArrayList<>();
        //Store elements text to array list
        for (WebElement p : beforeFilterProductPrice) {
            String beforeFilterPrice = p.getText().replaceAll("[E,x,T,a,x,£,:,$]", "").replace(",", "");
            Double priceValueBeforeFilter = Double.parseDouble(beforeFilterPrice);
            beforeFilterProductPriceList.add(priceValueBeforeFilter);
        }
        //Sort arraylist to ascending order
        Collections.sort(beforeFilterProductPriceList);
        //Reverse the list
        Collections.reverse(beforeFilterProductPriceList);
        return beforeFilterProductPriceList;
    }


    public List<Double> afterFilterProductPrice() {
        //Store elements after filtering
        List<WebElement> afterFilterProductPrice = afterFilter;
        //Create another list to store text of elements after clicking on filter Price high to low
        List<Double> afterFilterProductPriceList = new ArrayList<>();
        for (WebElement s : afterFilterProductPrice) {
            String afterFilterPrice = s.getText().replaceAll("[E,x,T,a,x,£,:,$]", "").replace(",", "");
            Double afterFilterPriceValue = Double.parseDouble(afterFilterPrice);
            afterFilterProductPriceList.add(afterFilterPriceValue);
        }
        return afterFilterProductPriceList;
    }

    public void selectProductSonyVAIO() {
        clickOnElement(product);
        Reporter.log("Click on " + product.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + product.toString());
    }

    public String verifyTextSonyVAIO() {
        Reporter.log("SonyVAIO" + verifySonyVAIO.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(verifySonyVAIO);
    }

    public String verifyTextMessage() {
        Reporter.log("message" + message.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(message).substring(0, 56);
    }

}
