package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement text;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'MacBook')])[2]")
    WebElement checkNameOfProductMacBook;
    @CacheLookup
    @FindBy(xpath = "//input[@class='form-control']")
    WebElement clearTheQtyBox;
    @CacheLookup
    @FindBy(xpath = "//input[@class='form-control']")
    WebElement changeQuantity;
    @CacheLookup
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement updateTheBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement modifiedSuccessMessage;
    @CacheLookup
    @FindBy(xpath = "(//td[contains(text(),'£737.45')])[3]")
    WebElement totalPrice;
    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkOutButton;


    // * 2.11 Verify the text "Shopping Cart"
    public String verifyShoppingCartText() {
        return getTextFromElement(text);
    }

    // * 2.12 Verify the Product name <productName>
    public String verifyProductName() {
        return getTextFromElement(productName);
    }
    // * 2.13 Verify the Model <model>
    public String verifyModel() {
        return getTextFromElement(model);
    }

    // * 2.14 Verify the Total <total>
    public String verifyTotal() {
        return getTextFromElement(total);
    }

    // * 2.10 Verify the Product name "MacBook"
    public void verifyProductNameIsMacBook(String text) {
         verifyThatTextIsDisplayed(checkNameOfProductMacBook, text);
    }

    // * 2.11 Change Quantity "2"
    public void clearTheQtyBox() {
        clearTextField(clearTheQtyBox);
    }
    public void enterQuantityIntoTheBox(String qty) {
        sendTextToElement(changeQuantity, qty);
    }

    // * 2.12 Click on “Update” Tab
    public void clickOnUpdateTheQuantityBox() {
        clickOnElement(updateTheBox);
    }

    // * 2.13 Verify the message “Success: You have modified your shopping cart!”
    public void verifyUpdatedSuccessMessage(String text) {
        verifyThatTextIsDisplayed(modifiedSuccessMessage, text);
    }
    // * 2.14	Verify the Total £737.45
    public void verifyTotalPrice(String text) {
        verifyThatTextIsDisplayed(totalPrice, text);
    }

    // * 2.15	Click on “Checkout” button
    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
    }

}
