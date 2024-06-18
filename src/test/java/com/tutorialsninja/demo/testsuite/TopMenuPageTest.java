package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */
@Listeners(CustomListeners.class)
public class TopMenuPageTest extends BaseTest {

    TopMenuPage topMenuPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        topMenuPage = new TopMenuPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        topMenuPage.mouseHoverAndClickOnDesktops(); // Mouse hover on “Desktops” Tab and click
        topMenuPage.selectMenu("Show AllDesktops"); // call selectMenu method and pass the menu = “Show All Desktops”

        // Verify the text ‘Desktops’
        String expectedResult = "Desktops";
        String actualResult = topMenuPage.verifyTextDesktops();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        topMenuPage.mouseHoverAndClickOnLaptopsNotebooks(); // Mouse hover on “Laptops & Notebooks” Tab and click
        topMenuPage.selectMenu("Show AllLaptops & Notebooks"); // call selectMenu method and pass the menu = “Show All Laptops & Notebooks”

        // Verify the text "Laptops & Notebooks"
        String expectedResult = "Laptops & Notebooks";
        String actualResult = topMenuPage.verifyTextLaptopsNotebooks();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        topMenuPage.mouseHoverAndClickOnComponents(); // Mouse hover on “Components” Tab and click
        topMenuPage.selectMenu("Show AllComponents"); // call selectMenu method and pass the menu = “Show All Components”

        // Verify the text "Components"
        String expectedResult = "Components";
        String actualResult = topMenuPage.verifyTextComponents();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

    }

}
