package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Utility {
    @CacheLookup
    //@FindBy(xpath = "//div[@class='caption']//a[contains(text(),'HTC Touch HD')]")
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement click;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='HP LP3065']")
    WebElement productName;

    @CacheLookup
    //@FindBy(className = "form-control")
    @FindBy(name = "quantity")

    WebElement quantityField;
    @CacheLookup
   // @FindBy(id = "button-cart")
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage1;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;

    // * 2.6 Select product <product>
    public void selectProduct(String product) {
        sendTextToElement(click, product);

    }

    public void clickOnProductName(String product) {
        dynamicListDropDown(productName, product);
    }

    // * 2.7 Enter Qty <qty> using Select class.
    public void enterQuantity(String qty) {
        clearTextFromField(quantityField);
        sendTextToElement(quantityField, qty);
    }

    // * 2.8 Click on “Add to Cart” button
    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    // * 2.9 Verify the Message <successMessage>
    public String verifySuccessMessageToAddInCart() {
        return getTextFromElement(successMessage1);
    }

    // * 2.10 Click on link “shopping cart” display into success message
    public void clickOnShoppingCartLinkIntoSuccessMessage() {
        clickOnElement(shoppingCartLink);
    }
}
