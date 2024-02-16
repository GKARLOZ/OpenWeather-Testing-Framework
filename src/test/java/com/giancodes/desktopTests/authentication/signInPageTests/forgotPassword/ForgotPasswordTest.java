package com.giancodes.desktopTests.authentication.signInPageTests.forgotPassword;

import com.giancodes.IBase;
import com.giancodes.gui.pages.common.ProfilePageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.giancodes.gui.pages.common.UserHomePageBase;
import com.giancodes.gui.pages.desktop.ProfilePage;
import com.giancodes.gui.pages.desktop.SignInPage;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordTest implements IAbstractTest, IBase {

    private SignInPageBase signInPage;
    private final String user = "{crypt:kBotoK+cN6NSRB6esXyilEWWd1S2udvgg2aeKU8k/oc=}";
    private final String password = "{crypt:Gx+NSrPrmdYKFS31L5lNtg==}";

    @BeforeMethod(groups = {"regression","smoke"})
    public void setUp(){

        signInPage = openSignInPage();

    }

    //this test will fail if resetting password is in progress. Takes 24 hours to send another email.
    @Test( groups = {"regression","smoke"}, description = "Recovery link to reset password.")
    @TestCaseKey("OPWEA-26")
    public void resetPasswordTest(){

        signInPage.recoverPassword(user);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signInPage.getAlertMessage().isPresent(),"No alert message is present.");
        softAssert.assertTrue(signInPage.getAlertMessage().getText().equals("You will receive an email with instructions on how to reset your password in a few minutes."),
                "Wrong alert message.");
        softAssert.assertAll();

    }

    //This method should fill if resetPasswordTest was nt executed first.
    @Test(dependsOnMethods = "resetPasswordTest",description = "Recovery link to reset password after submitting a request to reset.")
    @TestCaseKey("")
    public void resetPasswordInProgressTest(){

        signInPage.recoverPassword(user);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signInPage.getAlertMessage().isPresent(),"No alert message is present.");
        softAssert.assertTrue(signInPage.getAlertMessage().getText().equals("You have recently requested password recovery. Please try again later"),
                "Wrong alert message.");
        softAssert.assertAll();

    }

    @Test(description = "Recovery link to reset password.")
    @TestCaseKey("OPWEA-30")
    public void recoverPasswordNonUserTest(){

        signInPage.recoverPassword("FakeEmailfake555@gmail.com");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signInPage.getAlertMessage().isPresent(),"No alert message is present.");
        softAssert.assertTrue(signInPage.getAlertMessage().getText().equals("Email not found"),
                "Wrong alert message.");
        softAssert.assertAll();

    }

    @Test( groups = {"regression"}, description = "Validate user can immediately login after changing password.")
    @TestCaseKey("")
    public void changePasswordTest(){

        SoftAssert softAssert = new SoftAssert();

        UserHomePageBase userHomePage = signInPage.signIn(user,password);
        Assert.assertTrue(userHomePage.getHeaderMenu().getUserNameOnMenu().isClickable(),"User name not clickable.");
        userHomePage.getHeaderMenu().getUserNameOnMenu().click();
        userHomePage.getHeaderMenu().getElementFromUserMenu("My profile").click();

        ProfilePageBase profilePage = new ProfilePage(getDriver());
        profilePage.setChangePassword(password);
        softAssert.assertTrue(profilePage.getConfirmPasswordAlertMes().isPresent(),"Green alert message not present after changing password.");
        profilePage.header().getUserNameOnMenu().click();
        profilePage.header().getElementFromUserMenu("logout").click();


        SignInPageBase signInPage = new SignInPage(getDriver());
        Assert.assertTrue(signInPage.getAlertMessage().isPresent(),"Red Alert message not present.");

        userHomePage = signInPage.signIn(user,password);
        softAssert.assertTrue(userHomePage.getGreenPanelMessage().getText().equals("Signed in successfully."),"Sign In not successful.");
        Assert.assertTrue(userHomePage.getHeaderMenu().getUserNameOnMenu().isPresent(),"Username not present on main menu.");

        //change password to original password.
        userHomePage.getHeaderMenu().getUserNameOnMenu().click();
        userHomePage.getHeaderMenu().getElementFromUserMenu("My profile").click();

        profilePage.setChangePassword(password);
        softAssert.assertTrue(profilePage.getConfirmPasswordAlertMes().isPresent(),"Green alert message not present after changing password.");
        profilePage.header().getUserNameOnMenu().click();
        profilePage.header().getElementFromUserMenu("logout").click();

        softAssert.assertTrue(signInPage.getAlertMessage().isPresent(),"Red Alert message not present.");

        softAssert.assertAll();

    }

}