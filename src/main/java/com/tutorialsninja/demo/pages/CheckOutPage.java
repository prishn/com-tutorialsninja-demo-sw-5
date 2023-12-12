package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkOutText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement checkNewCustomerText;
    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckoutButton;
    @CacheLookup
    @FindBy(css = "#button-account")
    WebElement continueTabButton;
    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailAddress;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement addressField;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement cityName;
    @CacheLookup
    @FindBy(name = "postcode")
    WebElement zipCode;
    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryName;
    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement zoneName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement addCommentIn;
    @CacheLookup
    @FindBy(css = "input[value='1'][name='agree']")
    WebElement termsAndConditions;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonForPayment;
    @CacheLookup
    @FindBy(xpath = "//div[@class ='alert alert-danger alert-dismissible']")
    WebElement checkWarningForPayment;


    // * 2.16	Verify the text “Checkout”
    public void verifyCheckOutText(String text) {
        verifyThatTextIsDisplayed(checkOutText, text);
    }

    // * 2.17	Verify the Text “New Customer”

    public void verifyTextNewCustomer(String text) {
        verifyThatTextIsDisplayed(checkNewCustomerText, text);
    }

    // * 2.18	Click on “Guest Checkout” radio button
    public void clickOnGuestCheckOutButton() {
        clickOnElement(guestCheckoutButton);
    }

    // * 2.19	Click on “Continue” tab
    public void clickOnContinueButtonTab() {
        clickOnElement(continueTabButton);
    }

    // * 2.20	Fill the mandatory fields
    public void enterFirstNameIntoTheFirstNameField(String name) {
        sendTextToElement(firstName, name);
    }

    public void enterLastNameIntoTheLastNameField(String surname) {
        sendTextToElement(lastName, surname);
    }

    public void enterEmailIntoTheEmailField(String email) {
        sendTextToElement(emailAddress, email);
    }

    public void enterTelephoneIntoTheTelephoneField(String phone) {
        sendTextToElement(telephone, phone);
    }

    public void enterAddressIntoTheAddress1Field(String address) {
        sendTextToElement(addressField, address);
    }

    public void enterCityIntoTheCityField(String city) {
        sendTextToElement(cityName, city);
    }

    public void enterPostcodeIntoThePostCodeField(String postcode) {
        sendTextToElement(zipCode, postcode);
    }

    public void enterCountryIntoTheCountryField(String country) {
        selectByVisibleTextFromDropDown(countryName, country);
    }

    public void enterZoneIntoTheZoneField(String zone) {
        selectByVisibleTextFromDropDown(zoneName, zone);
    }

    // * 2.21	Click on “Continue” Button
    public void clickOnContinueButtonForGuest() {
        clickOnElement(continueButton);
    }

    // * 2.22	Add Comments About your order into text are
    public void addCommentsAboutYourOrderIntoTheTextArea(String comment) {
        sendTextToElement(addCommentIn, comment);
    }

    // * 2.23	Check the Terms & Conditions check box
    public void clickOnCheckBoxForTermsAndConditions() {
        clickOnElement(termsAndConditions);
    }

    // * 2.24	Click on “Continue” button
    public void clickOnContinueButtonForPaymentMethod() {
        clickOnElement(continueButtonForPayment);
    }

    // * 2.25	Verify the message “Warning: Payment method required!”
    public void verifyWarningMessageForPaymentMethod(String text) {
        verifyThatTextIsDisplayed(checkWarningForPayment, text);
    }

}
