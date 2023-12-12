package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * 1.Test name verifyProductArrangeInAlphabeticalOrder()
 * 1.1 Mouse hover on Desktops Tab. and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * <p>
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
 * DATA SET
 * | product        | qty       | successMessage                                               | productName   | model      | total     |
 * | HTC Touch HD   | 1         | Success: You have added HTC Touch HD to your shopping cart!  | HTC Touch HD  | Product 1  | £74.73    |
 * | iPhone         | 2         | Success: You have added iPhone to your shopping cart!        | iPhone        | product 11 | £150.92   |
 * | Palm Treo Pro  | 3         | Success: You have added Palm Treo Pro to your shopping cart! | Palm Treo Pro | Product 2  | £1,242.11 |
 */
@Listeners(CustomListeners.class)

public class DeskTopsTest extends BaseTest {

    //Declaration
    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    //Initialisation
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    // 1.Test name verifyProductArrangeInAlphabeticalOrder()
    public void verifyProductArrangeInAlphabeticalOrder() {
        //Mouse hover on Currency Dropdown and click
        homePage.mouseHoverAndClickOnCurrencyDroDownMenu();
        homePage.selectOnSterlingPoundCurrency();

        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktopsTab();

        //1.2 call selectMenu method and pass the menu = “Show AllDesktops”
        homePage.selectMenu("Show AllDesktops");

        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.selectSortByOption("Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        desktopPage.verifySortedElementsInReverseOrder();

    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "getTestData", dataProviderClass = TestData.class)
    //* 2. Test name verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
    // * String successMessage, String productName, String model, String total )
    public void verifyProduct1AddedToShoppingCartSuccessFully(String product, String qty, String successMessage,
                                                              String productName, String model, String total) {
        // * 2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverAndClickOnCurrencyDroDownMenu();

        // * 2.2 Mouse hover on £Pound Sterling and click
        homePage.selectOnSterlingPoundCurrency();

        // * 2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverAndClickOnDesktopsTab();

        // * 2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        // * 2.5 Select Sort By position "Name: A to Z"
        desktopPage.selectSortByOption("Name (A - Z)");

        // * 2.6 Select product <product>
        desktopPage.selectProduct1(product);

        // * 2.7 Enter Qty <qty> using Select class.
        productPage.enterQuantity(qty);

        // * 2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCart();

        // * 2.9 Verify the Message <successMessage>
        String expectedMessage = successMessage + "\n×";
        String actualMessage = productPage.verifySuccessMessageToAddInCart();
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Text!");

        // * 2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLinkIntoSuccessMessage();

        //2.11 Verify the text "Shopping Cart"
        String expectedTxt = "Shopping Cart  (0.15kg)";
        String actualTxt = shoppingCartPage.verifyShoppingCartText();
        Assert.assertEquals(actualTxt, expectedTxt, "Incorrect Text!");

        //2.12 Verify the Product name
        String expectedName = productName;
        String actualName = shoppingCartPage.verifyProductName();
        Assert.assertEquals(actualName, expectedName, "Incorrect Text!");

        //2.13 Verify the Model
        String expectedModel = model;
        String actualModel = shoppingCartPage.verifyModel();
        Assert.assertEquals(actualModel, expectedModel, "Incorrect Model!");

        //2.14 Verify the Total
        String expectedTotal = total;
        String actualTotal = shoppingCartPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Incorrect Total!");

    }


    @Test(groups = {"smoke", "regression"}, dataProvider = "getTestData", dataProviderClass = TestData.class)
    //* 2. Test name verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
    // * String successMessage, String productName, String model, String total )
    public void verifyProduct2AddedToShoppingCartSuccessFully(String product, String qty, String successMessage,
                                                              String productName, String model, String total) {
        // * 2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverAndClickOnCurrencyDroDownMenu();

        // * 2.2 Mouse hover on £Pound Sterling and click
        homePage.selectOnSterlingPoundCurrency();

        // * 2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverAndClickOnDesktopsTab();

        // * 2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        // * 2.5 Select Sort By position "Name: A to Z"
        desktopPage.selectSortByOption("Name (A - Z)");

        // * 2.6 Select product <product>
        desktopPage.selectProduct2(product);

        // * 2.7 Enter Qty <qty> using Select class.
        productPage.enterQuantity(qty);

        // * 2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCart();

        // * 2.9 Verify the Message <successMessage>
        String expectedMessage = successMessage + "\n×";
        String actualMessage = productPage.verifySuccessMessageToAddInCart();
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Text!");

        // * 2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLinkIntoSuccessMessage();

        //2.11 Verify the text "Shopping Cart"
        String expectedTxt = "Shopping Cart  (20.00kg)";
        String actualTxt = shoppingCartPage.verifyShoppingCartText();
        Assert.assertEquals(actualTxt, expectedTxt, "Incorrect Text!");

        //2.12 Verify the Product name
        String expectedName = productName;
        String actualName = shoppingCartPage.verifyProductName();
        Assert.assertEquals(actualName, expectedName, "Incorrect Text!");

        //2.13 Verify the Model
        String expectedModel = model;
        String actualModel = shoppingCartPage.verifyModel();
        Assert.assertEquals(actualModel, expectedModel, "Incorrect Model!");

        //2.14 Verify the Total
        String expectedTotal = total;
        String actualTotal = shoppingCartPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Incorrect Total!");

    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "getTestData", dataProviderClass = TestData.class)
    //* 2. Test name verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
    // * String successMessage, String productName, String model, String total )
    public void verifyProduct3AddedToShoppingCartSuccessFully(String product, String qty, String successMessage,
                                                              String productName, String model, String total) {
        // * 2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverAndClickOnCurrencyDroDownMenu();

        // * 2.2 Mouse hover on £Pound Sterling and click
        homePage.selectOnSterlingPoundCurrency();

        // * 2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverAndClickOnDesktopsTab();

        // * 2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        // * 2.5 Select Sort By position "Name: A to Z"
        desktopPage.selectSortByOption("Name (A - Z)");

        // * 2.6 Select product <product>
        desktopPage.selectProduct3(product);

        // * 2.7 Enter Qty <qty> using Select class.
        productPage.enterQuantity(qty);

        // * 2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCart();

        // * 2.9 Verify the Message <successMessage>
        String expectedMessage = successMessage + "\n×";
        String actualMessage = productPage.verifySuccessMessageToAddInCart();
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Text!");

        // * 2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLinkIntoSuccessMessage();

        //2.11 Verify the text "Shopping Cart"
        String expectedTxt = "Shopping Cart  (0.40kg)";
        String actualTxt = shoppingCartPage.verifyShoppingCartText();
        Assert.assertEquals(actualTxt, expectedTxt, "Incorrect Text!");

        //2.12 Verify the Product name
        String expectedName = productName;
        String actualName = shoppingCartPage.verifyProductName();
        Assert.assertEquals(actualName, expectedName, "Incorrect Text!");

        //2.13 Verify the Model
        String expectedModel = model;
        String actualModel = shoppingCartPage.verifyModel();
        Assert.assertEquals(actualModel, expectedModel, "Incorrect Model!");

        //2.14 Verify the Total
        String expectedTotal = total;
        String actualTotal = shoppingCartPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Incorrect Total!");
        CustomListeners.test.addScreenCaptureFromPath("test-output/html/verifyProduct3AddedToShoppingCartSuccessFullyTue_Dec_12_22_04_58_GMT_2023.jpg");
    }
}

