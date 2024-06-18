package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class TopMenuPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Desktops']")
    WebElement desktops;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement textDesktops;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement click;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsNotebooks;


    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Components']")
    WebElement components;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Components']")
    WebElement textComponents;


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


    public void mouseHoverAndClickOnDesktops() {
        mouseHoverToElementAndClick(desktops);
        Reporter.log("Click on " + desktops.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + desktops.toString());
    }

    public String verifyTextDesktops() {
        Reporter.log("Desktops" + textDesktops.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(textDesktops);
    }

    public void mouseHoverAndClickOnLaptopsNotebooks() {
        mouseHoverToElementAndClick(click);
        Reporter.log("Click on " + click.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + click.toString());
    }

    public String verifyTextLaptopsNotebooks() {
        Reporter.log("get " + laptopsNotebooks.toString());
        CustomListeners.test.log(Status.PASS, "get " + laptopsNotebooks.toString());
        return getTextFromElement(laptopsNotebooks);
    }

    public void mouseHoverAndClickOnComponents() {
        mouseHoverToElementAndClick(components);
        Reporter.log("Click on " + components.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + components.toString());
    }

    public String verifyTextComponents() {
        Reporter.log("get " + textComponents.toString());
        CustomListeners.test.log(Status.PASS, "get " + textComponents.toString());
        return getTextFromElement(textComponents);
    }

}
