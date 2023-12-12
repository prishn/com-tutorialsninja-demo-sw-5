package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement topMenuList;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopsTab;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksTab;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;
    @CacheLookup
    //@FindBy(xpath = "//span[normalize-space()='Currency']")
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyDropDownMenu;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement sterlingPoundCurrency;
    @CacheLookup
    @FindBy(xpath = "(//span[normalize-space()='My Account'])[1]")
    //@FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountTab;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement accountLink;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    WebElement myAccountOptions;

    public void selectMenu(String menu) {
        //listOfProductsElement(topMenuList, menu);
        WebElement menuList = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuList).click().build().perform();
    }

    // * 1.1 Mouse hover on “Desktops” Tab and click
    public void mouseHoverAndClickOnDesktopsTab() {
        mouseHoverToElementAndClick(desktopsTab);
    }

    // * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
    public void mouseHoverAndClickOnLaptopsAndNotebooksTab() {
        mouseHoverToElementAndClick(laptopsAndNotebooksTab);
    }

    public void mouseHoverAndClickOnComponentsTab() {
        mouseHoverToElementAndClick(componentsTab);
    }

    // * 2.1	Mouse hover on Currency Dropdown and click
    public void mouseHoverAndClickOnCurrencyDroDownMenu() {
        // waitUntilVisibilityOfElementLocated(currencyDropDownMenu, 10).click();
        mouseHoverToElementAndClick(currencyDropDownMenu);
    }

    // * 2.2	Mouse hover on £Pound Sterling and click
    public void selectOnSterlingPoundCurrency() {
        // waitUntilVisibilityOfElementLocated(sterlingPoundCurrency, 10).click();
        mouseHoverToElementAndClick(sterlingPoundCurrency);
    }

    // * 1.1 Click on My Account Link.
    public void clickOnAccountLink() {
        mouseHoverToElementAndClick(accountLink);
    }

    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option) {
        listOfProductsElement(myAccountOptions, option);
    }
    public void selectOption(String option) {
        WebElement menuList = driver.findElement(By.linkText(option));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuList).click().build().perform();
    }
    // * 1.2 call selectMenu method and pass the menu = “Show All Desktops”

    // * 1.3 Verify the text ‘Desktops’

}
