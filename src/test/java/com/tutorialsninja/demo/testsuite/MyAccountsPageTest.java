package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1. Create the class MyAccountsTest
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name
 * "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 * <p>
 * 1.1 Clickr on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 1.3 Verify the text “Register Account”.
 * <p>
 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 * <p>
 * 2.1 Clickr on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 2.3 Verify the text “Returning Customer”.
 * <p>
 * 3. Test name verifyThatUserRegisterAccountSuccessfully()
 * <p>
 * 3.1 Clickr on My Account Link.
 * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 3.3 Enter First Name
 * <p>
 * 3.4 Enter Last Name
 * 3.5 Enter Email
 * 3.6 Enter Telephone
 * 3.7 Enter Password
 * 3.8 Enter Password Confirm
 * 3.9 Select Subscribe Yes radio button
 * 3.10 Click on Privacy Policy check box
 * 3.11 Click on Continue button
 * 3.12 Verify the message “Your Account Has Been Created!”
 * 3.13 Click on Continue button
 * 3.14 Clickr on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button
 * <p>
 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 * <p>
 * 4.1 Clickr on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Clickr on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */
@Listeners(CustomListeners.class)
public class MyAccountsPageTest extends BaseTest {


    HomePage homePage;
    MyAccountsPage myAccountsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        myAccountsPage = new MyAccountsPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // Click on My Account Link.
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register"); // Call the method “selectMyAccountOptions” method and pass the parameter “Register”

        // Verify the text “Register Account”
        String expectedResult = "Register Account";
        String actualResult = myAccountsPage.verifyTextRegisterAccount();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountLink(); // Clickr on My Account Link.
        homePage.selectMyAccountOptions("Login"); // // Call the method “selectMyAccountOptions” method and pass the parameter "Login"

        // Verify the text “Returning Customer”
        String expectedResult = "Returning Customer";
        String actualResult = myAccountsPage.verifyTextReturningCustomer();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        // Click on My Account Link.
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register"); // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        // Enter First Name
        // Enter Last Name
        // Enter Email
        // Enter Telephone
        // Enter Password
        // Enter Password Confirm
        // Select Subscribe Yes radio button
        // Click on Privacy Policy check box
        // Click on Continue button
        myAccountsPage.fillRegistrationData("Ankita", "Sangi", "ABC345@gmail.com", "07833662976", "turd@123", "turd@123");

        //Verify the message “Your Account Has Been Created!”
        String expectedResult = "Your Account Has Been Created!";
        String actualResult = myAccountsPage.verifyAccountMessage();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

        myAccountsPage.clickOnNextContinueButton();
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");

        //Verify the text “Account Logout”
        String expectedText = "Account Logout";
        String actualText = myAccountsPage.verifyAccountLogout();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");

        myAccountsPage.clickOnNextContinueButton();
    }


    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccountLink(); // Clickr on My Account Link.
        homePage.selectMyAccountOptions("Login"); // // Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        // Enter Email address
        // Enter Last Name
        // Enter Password
        // Click on Login button
        myAccountsPage.fillLoginData("p344561425@gmail.com", "sjfh@123");

        // Verify text “My Account”
        String expectedResult = "My Account";
        String actualResult = myAccountsPage.verifyTextMyAccount();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");
        myAccountsPage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");

        //Verify the text “Account Logout”
        String expectedText = "Account Logout";
        String actualText = myAccountsPage.verifyAccountLogout();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");

        myAccountsPage.clickOnNextContinueButton();

    }
}
