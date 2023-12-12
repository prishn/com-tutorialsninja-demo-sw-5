package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.pages.AccountRegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)
 * <p>
 * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 * 1.1 Click on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
 * 1.3 Verify the text “Register Account”.
 * <p>
 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 * 2.1 Click on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
 * 2.3 Verify the text “Returning Customer”.
 * <p>
 * 3. Test name verifyThatUserRegisterAccountSuccessfully()
 * 3.1 Click on My Account Link.
 * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
 * 3.3 Enter First Name
 * 3.4 Enter Last Name
 * 3.5 Enter Email
 * 3.6 Enter Telephone
 * 3.7 Enter Password
 * 3.8 Enter Password Confirm
 * 3.9 Select Subscribe Yes radio button
 * 3.10 Click on Privacy Policy check box
 * 3.11 Click on Continue button
 * 3.12 Verify the message “Your Account Has Been Created!”
 * 3.13 Click on Continue button
 * 3.14 Click on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button
 * <p>
 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 * 4.1 Click on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Click on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */
@Listeners(CustomListeners.class)

public class MyAccountTest extends BaseTest {
    //Declaration
    HomePage homePage;
    AccountRegisterPage registerPage;
    MyAccountPage myAccountPage;

    //Initialisation
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new AccountRegisterPage();
        myAccountPage = new MyAccountPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    // 1.	Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // * 1.1	Click on My Account Link.
        homePage.clickOnAccountLink();

        // * 1.2	Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectOption("Register");

        // * 1.3	Verify the text “Register Account”.
        registerPage.verifyRegisterAccountText("Register Account");
    }

    @Test(groups = {"smoke", "regression"})
    //2.	Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // * 2.1	Click on My Account Link.
        homePage.clickOnAccountLink();

        // * 2.2	Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectOption("Login");

        // * 2.3	Verify the text “Returning Customer”.
        registerPage.verifyTextReturningCustomerOnLoginPage("Returning Customer");
    }


    @Test(groups = {"regression"})
    // * 3.	Test name verifyThatUserRegisterAccountSuccessfully()
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        // * 3.1	Click on My Account Link.
        homePage.clickOnAccountLink();

        // * 3.2	Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectOption("Register");

        // * 3.3	Enter First Name
        registerPage.enterFirstName("Robert");

        // * 3.4	Enter Last Name
        registerPage.enterLastName("Jackson");

        // * 3.5	Enter Email
        final String randomEmail;
        randomEmail = AccountRegisterPage.randomEmail();
        registerPage.enterEmail(randomEmail);

        // * 3.6	Enter Telephone
        registerPage.enterTelephoneNumber("07896542365");

        // * 3.7	Enter Password
        registerPage.enterPassword("12345678");

        // * 3.8	Enter Password Confirm
        registerPage.enterConfirmPassword("12345678");

        // * 3.9	Select Subscribe Yes radio button
        registerPage.clickOnSubscribeRadioButton();

        // * 3.10	Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicyCheckBox();

        // * 3.11	Click on Continue button
        registerPage.clickOnContinueButton();

        // * 3.12	Verify the message “Your Account Has Been Created!”
        myAccountPage.verifyTheMessageYourAccountHasBeenCreated("Your Account Has Been Created!");

        // * 3.13	Click on Continue button
        myAccountPage.clickOnContinueAccountButton();

        // 3.14 Click on My Account Link.
        myAccountPage.clickOnMyAccountLink();

        // * 3.15	Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectOption("Logout");

        // * 3.16	Verify the text “Account Logout”
        myAccountPage.verifyTextForAccountLogOut("Logout");

        // * 3.17	Click on Continue button
        myAccountPage.clickOnContinueLogOutButton();
    }

    @Test(groups = {"regression"})
    // * 4.	Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        // * 4.1	Click on My Account Link.
        homePage.clickOnAccountLink();

        // * 4.2	Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectOption("Login");

        // * 4.3	Enter Email address

        registerPage.enterEmail("robert_jackson@gmail.com");

        // * 4.5	Enter Password
        registerPage.enterPassword("12345678");

        // * 4.6	Click on Login button
        myAccountPage.clickOnLoginButton();

        // * 4.7	Verify text “My Account”
        myAccountPage.verifyTheTextMyAccount("My Account");

        // 4.8  Click on My Account Link.
        myAccountPage.clickOnMyAccountLink();

        // * 4.9	Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectOption("Logout");

        // * 4.10	Verify the text “Account Logout”
        myAccountPage.verifyTextForAccountLogOut("Logout");

        // * 4.11	Click on Continue button
        myAccountPage.clickOnContinueLogOutButton();
    }
}

