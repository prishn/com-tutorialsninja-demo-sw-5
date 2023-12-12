package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LaptopsAndNoteBooksPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;
    @CacheLookup
    @FindBy(xpath = "(//select[@id='input-sort'])[1]")
    WebElement sortByPriceHighToLow;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement arrayListOfProducts;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement dropDownPath;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement price;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement product;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='MacBook']")
    WebElement checkTextMacBook;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessageForAddingProduct;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement linkToShoppingCartInsideMessage;

    public void verifyTheTextLaptopsAndNotebooksOnPage(String text){
        verifyThatTextIsDisplayed(laptopsAndNotebooksText, text);
    }
    // * 1.3 Select Sort By "Price (High > Low)"
    public void selectSortByPriceHighToLow(String options) {
        selectByVisibleTextFromDropDown(sortByPriceHighToLow, options);
        getArrayListOfProductsInChoice(arrayListOfProducts);

    }
    // * 1.4 Verify the Product price will arrange in High to Low order.
    public String verifyProductPriceArrangeInHighToLow() {
        return verifyTheProductArrangementInArrayList(arrayListOfProducts);
    }
    // * 2.3 Select Sort By "Price (High > Low)"
    public void selectPriceHighToLow(String inputSelectPriceOrder) {

        selectByVisibleTextFromDropDown(dropDownPath, inputSelectPriceOrder);
    }
    public void sortByPrice(String option) {
        selectByVisibleTextFromDropDown(price, option);
    }

    // * 2.4 Select Product “MacBook”
    public void selectMacBookProduct() {
        clickOnElement(product);
    }
    // * 2.5 Verify the text “MacBook”
    public void verifyTheTextMacBook(String text) {
        verifyThatTextIsDisplayed(checkTextMacBook, text);
    }
    // * 2.6 Click on ‘Add To Cart’ button
    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    // * 2.7	Verify the message “Success: You have added MacBook to your shopping cart!”
    public void verifySuccessMessageForAddingProductToShoppingCart(String text) {
         verifyThatTextIsDisplayed(successMessageForAddingProduct, text);
    }

    // * 2.8	Click on link “shopping cart” display into success message
    public void clickOnLinkToShoppingCartMessage() {
        clickOnElement(linkToShoppingCartInsideMessage);
    }

}
