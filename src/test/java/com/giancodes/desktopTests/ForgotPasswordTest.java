package com.giancodes.desktopTests;

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

public class ForgotPasswordTest implements IAbstractTest,IBase {

    private SignInPageBase signInPage;

    @BeforeMethod()
    public void signIn(){

        signInPage = openSignInPage();



    }

    //this test will fail if reseting password is in progress.
    @Test(description = "Reset password")
    public void resetPassword(){

        signInPage.recoverPassword("testytestio836@gmail.com");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signInPage.getAlertMessage().isPresent(),"No alert message is present.");
        softAssert.assertTrue(signInPage.getAlertMessage().getText().equals("You will receive an email with instructions on how to reset your password in a few minutes."),
                "Wrong alert message.");
        softAssert.assertAll();


    }

//    @Test(description = "Validate user can immediately login after changing password.")
    @TestCaseKey({""})
    public void changePassword(){
        UserHomePageBase userHomePage = signInPage.signIn("testytestio836@gmail.com", "123qwe!@#QWE");
        Assert.assertTrue(userHomePage.getHeaderMenu().getUserNameOnMenu().isClickable(),"User name not clickable.");
        userHomePage.getHeaderMenu().getUserNameOnMenu().click();
        userHomePage.getHeaderMenu().getElementFromUserMenu("My profile").click();

        ProfilePageBase profilePage = new ProfilePage(getDriver());
        profilePage.setChangePassword("123qwe!@#QWE1");
        Assert.assertTrue(profilePage.getConfirmPasswordAlertMes().isPresent(),"Green alert message not present after changing password.");
        profilePage.header().getUserNameOnMenu().click();
        profilePage.header().getElementFromUserMenu("logout").click();


        SignInPageBase signInPage = new SignInPage(getDriver());
        Assert.assertTrue(signInPage.getAlertMessage().isPresent(),"Red Alert message not present.");

        userHomePage = signInPage.signIn("testytestio836@gmail.com", "123qwe!@#QWE1");
        Assert.assertTrue(userHomePage.getGreenPanelMessage().getText().equals("Signed in successfully."),"Sign In not successful.");
        Assert.assertTrue(userHomePage.getHeaderMenu().getUserNameOnMenu().isPresent(),"Username not present on main menu.");

        //change password to original password.
        userHomePage.getHeaderMenu().getUserNameOnMenu().click();
        userHomePage.getHeaderMenu().getElementFromUserMenu("My profile").click();

        profilePage.setChangePassword("123qwe!@#QWE");
        Assert.assertTrue(profilePage.getConfirmPasswordAlertMes().isPresent(),"Green alert message not present after changing password.");
        profilePage.header().getUserNameOnMenu().click();
        profilePage.header().getElementFromUserMenu("logout").click();

        Assert.assertTrue(signInPage.getAlertMessage().isPresent(),"Red Alert message not present.");




    }


}
