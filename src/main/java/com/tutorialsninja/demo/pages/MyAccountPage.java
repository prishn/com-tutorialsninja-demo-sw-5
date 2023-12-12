package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement clickOnMyAccount;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement accountCreation;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueAccountButton;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement accountLogOutText;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueLogOutButton;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement checkTextForMyAccount;


    // * 3.12	Verify the message “Your Account Has Been Created!”
    public void verifyTheMessageYourAccountHasBeenCreated(String text) {
        verifyThatTextIsDisplayed (accountCreation, text);
    }
    // 3.14 Click on My Account Link.
    public void clickOnMyAccountLink() {
        mouseHoverToElementAndClick(clickOnMyAccount);
    }

    // * 3.13	Click on Continue button
    public void clickOnContinueAccountButton() {
       clickOnElement(continueAccountButton);
    }

    // * 3.16	Verify the text “Account Logout”
    public void verifyTextForAccountLogOut(String text) {
        verifyThatTextIsDisplayed(accountLogOutText, text);
    }

    // * 3.17	Click on Continue button
    public void clickOnContinueLogOutButton() {
        clickOnElement(continueLogOutButton);
    }

    // * 4.6	Click on Login button
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    // * 4.7	Verify text “My Account”
    public void verifyTheTextMyAccount(String text) {
       verifyThatTextIsDisplayed(checkTextForMyAccount, text);
    }
}

