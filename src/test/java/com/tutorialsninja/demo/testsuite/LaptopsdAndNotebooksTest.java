package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * <p>
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
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
 * 2.25 Verify the message “Warning: Payment method required!”
 */
@Listeners(CustomListeners.class)

public class LaptopsdAndNotebooksTest extends BaseTest {

    //Declaration
    HomePage homePage;
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;

    //Initialisation
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
        checkOutPage = new CheckOutPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    //* 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //Mouse hover on Currency Dropdown and click
        homePage.mouseHoverAndClickOnCurrencyDroDownMenu();
        homePage.selectOnSterlingPoundCurrency();

        // * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverAndClickOnLaptopsAndNotebooksTab();

        // * 1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        // * 1.3 Select Sort By "Price (High > Low)"
        laptopsAndNoteBooksPage.selectPriceHighToLow("Price (High > Low)");

        // * 1.4 Verify the Product price will arrange in High to Low order.
        laptopsAndNoteBooksPage.verifyProductPriceArrangeInHighToLow();

    }

    @Test(groups = {"smoke", "regression"})
    // * 2. Test name verifyThatUserPlaceOrderSuccessfully()
    public void verifyThatUserPlaceOrderSuccessfully() {
        //Mouse hover on Currency Dropdown and click
        homePage.mouseHoverAndClickOnCurrencyDroDownMenu();
        homePage.selectOnSterlingPoundCurrency();

        // * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverAndClickOnLaptopsAndNotebooksTab();

        // * 1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        // * 2.3 Select Sort By "Price (High > Low)"
        laptopsAndNoteBooksPage.selectPriceHighToLow("Price (High > Low)");

        // * 2.4 Select Product “MacBook”
        laptopsAndNoteBooksPage.selectMacBookProduct();

        // * 2.5 Verify the text “MacBook”
        laptopsAndNoteBooksPage.verifyTheTextMacBook("MacBook");

        // * 2.6 Click on ‘Add To Cart’ button
        laptopsAndNoteBooksPage.clickOnAddToCart();

        // * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        laptopsAndNoteBooksPage.verifySuccessMessageForAddingProductToShoppingCart("Success: You have added MacBook to your shopping cart!\n×");

        // * 2.8 Click on link “shopping cart” display into success message
        laptopsAndNoteBooksPage.clickOnLinkToShoppingCartMessage();

        // * 2.9 Verify the text "Shopping Cart"
        String actualCartText = shoppingCartPage.verifyShoppingCartText();
        String expectedCartText = "Shopping Cart  (0.00kg)";
        Assert.assertEquals(actualCartText, expectedCartText, "Incorrect Shopping Cart Message displayed!");

        // * 2.10 Verify the Product name "MacBook"
        shoppingCartPage.verifyProductNameIsMacBook("MacBook");

        // * 2.11 Change Quantity "2"
        shoppingCartPage.clearTheQtyBox();
        shoppingCartPage.enterQuantityIntoTheBox("2");

        // * 2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateTheQuantityBox();

        // * 2.13 Verify the message “Success: You have modified your shopping cart!”
        shoppingCartPage.verifyUpdatedSuccessMessage("Success: You have modified your shopping cart!\n×");

        // * 2.14 Verify the Total £737.45
        shoppingCartPage.verifyTotalPrice("£737.45");

        // * 2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();

        // * 2.16 Verify the text “Checkout”
        checkOutPage.verifyCheckOutText("Checkout");

        // * 2.17 Verify the Text “New Customer”
        checkOutPage.verifyTextNewCustomer("New Customer");

        // * 2.18 Click on “Guest Checkout” radio button
        checkOutPage.clickOnGuestCheckOutButton();

        // * 2.19 Click on “Continue” tab
        checkOutPage.clickOnContinueButtonTab();

        // * 2.20 Fill the mandatory fields
        checkOutPage.enterFirstNameIntoTheFirstNameField("Robert");
        checkOutPage.enterLastNameIntoTheLastNameField("Jackson");
        checkOutPage.enterEmailIntoTheEmailField("rjackson@gmail.com");
        checkOutPage.enterTelephoneIntoTheTelephoneField("07865325614");
        checkOutPage.enterAddressIntoTheAddress1Field("Harry Porter Road");
        checkOutPage.enterCityIntoTheCityField("London");
        checkOutPage.enterPostcodeIntoThePostCodeField("HP4 2PH");
        checkOutPage.enterCountryIntoTheCountryField("United Kingdom");
        checkOutPage.enterZoneIntoTheZoneField("Derbyshire");

        // * 2.21	Click on “Continue” Button
        checkOutPage.clickOnContinueButtonForGuest();

        // * 2.22	Add Comments About your order into text area
        checkOutPage.addCommentsAboutYourOrderIntoTheTextArea("Leave it by door please");

        // * 2.23	Check the Terms & Conditions check box
        checkOutPage.clickOnCheckBoxForTermsAndConditions();

        // * 2.24	Click on “Continue” button
        checkOutPage.clickOnContinueButtonForPaymentMethod();

        // * 2.25 Verify the message “Warning: Payment method required!”
        checkOutPage.verifyWarningMessageForPaymentMethod("Warning: Payment method required!\n×");

    }
}
