package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class AccountRegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement registerAccount;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneNumber;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement subscribeRadioButton;
    @CacheLookup
    @FindBy(css = "input[value='1'][name='agree']")
    WebElement privacyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    // * 1.3	Verify the text “Register Account”.
    public void verifyRegisterAccountText(String text) {
       verifyThatTextIsDisplayed(registerAccount, text);
    }

    // * 2.3	Verify the text “Returning Customer”.
    public void verifyTextReturningCustomerOnLoginPage(String text) {
         verifyThatTextIsDisplayed(returningCustomerText, text);
    }
    // * 3.3	Enter First Name
    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
    }
    // * 3.4	Enter Last Name
    public void enterLastName(String surname) {
        sendTextToElement(lastName, surname);
    }
    // * 3.5	Enter Email
    final String randomEmail = randomEmail();

    public void enterEmail(String emailAddress) {
        sendTextToElement(email, emailAddress);
    }

    public static String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

    // * 3.6	Enter Telephone
    public void enterTelephoneNumber(String phone) {
        sendTextToElement(telephoneNumber, phone);
    }

    // * 3.7	Enter Password
    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    // * 3.8	Enter Password Confirm
    public void enterConfirmPassword(String confirmPassword) {
        sendTextToElement(confirmPasswordField, confirmPassword);
    }

    // * 3.9	Select Subscribe Yes radio button
    public void clickOnSubscribeRadioButton() {
        clickOnElement(subscribeRadioButton);
    }

    // * 3.10	Click on Privacy Policy check box
    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyCheckBox);
    }

    // * 3.11	Click on Continue button
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
}

