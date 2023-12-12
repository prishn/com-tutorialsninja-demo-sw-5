package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNoteBooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
 * 1.2 This method should click on the menu whatever name is passed as parameter.

 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 *
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 *
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */
@Listeners(CustomListeners.class)

public class TopMenuTest extends BaseTest {
    //Declaration
    HomePage homePage;
    DesktopPage desktopPage;
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage;
    ComponentsPage componentsPage;

    //Initialisation
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
        componentsPage = new ComponentsPage();
    }

    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    // * 1.2 This method should click on the menu whatever name is passed as parameter.
    @Test(groups = {"sanity", "smoke", "regression"})
    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        // * 1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktopsTab();

        // * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        // * 1.3 Verify the text ‘Desktops’
        desktopPage.verifyTheTextDesktopsOnPage("Desktops");
    }
    @Test(groups = {"smoke", "regression"})
    //2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        // * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverAndClickOnLaptopsAndNotebooksTab();

        // * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        // * 2.3 Verify the text ‘Laptops & Notebooks’
        laptopsAndNoteBooksPage.verifyTheTextLaptopsAndNotebooksOnPage("Laptops & Notebooks");
    }

    @Test(groups = {"regression"})
    //3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        // * 3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverAndClickOnComponentsTab();

        // * 3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show AllComponents");

        // * 3.3 Verify the text ‘Components’
        componentsPage.verifyTheTextComponentsOnPage("Components");

    }
}
