package com.giancodes.desktopTests;

import com.giancodes.gui.pages.common.APIKeysPageBase;
import com.giancodes.gui.pages.common.ProfilePageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.giancodes.gui.pages.common.UserHomePageBase;
import com.giancodes.gui.pages.desktop.APIKeysPage;
import com.giancodes.gui.pages.desktop.ProfilePage;
import com.giancodes.gui.pages.desktop.SignInPage;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignOutTest implements IAbstractTest, IBase {

    private UserHomePageBase userHomePage;

    @BeforeMethod()
    public void signIn(){

        SignInPageBase signInPage = openSignInPage();

        userHomePage = signInPage.signIn("testytestio836@gmail.com", "123qwe!@#QWE");
        Assert.assertTrue(userHomePage.getGreenPanelMessage().getText().equals("Signed in successfully."),"Sign In not successful.");
        Assert.assertTrue(userHomePage.getHeaderMenu().getUserNameOnMenu().isPresent(),"Username not present on main menu.");

    }

    @Test(description = "Validate Logging out by selecting Logout option username dropdown menu")
    @TestCaseKey("OPENW-688")
    public void validLogOut(){
        userHomePage.getHeaderMenu().getUserNameOnMenu().click();
        Assert.assertTrue(userHomePage.getHeaderMenu().getElementFromUserMenu("logout").isClickable(),"User menu did not appear.");
        userHomePage.getHeaderMenu().getElementFromUserMenu("Logout").click();
        SignInPageBase signInPage = new SignInPage(getDriver());
        Assert.assertTrue(signInPage.getAlertMessage().isPresent(),"Red Alert message not present.");


    }
    @Test(description = "Validate logging out then back on browser")
    @TestCaseKey("OPENW-690")
    public void logOutGoBack(){

       userHomePage.getHeaderMenu().getUserNameOnMenu().click();
       Assert.assertTrue(userHomePage.getHeaderMenu().getElementFromUserMenu("My API keys").isClickable(),"User menu did not appear.");
       userHomePage.getHeaderMenu().getElementFromUserMenu("My API keys").click();

       APIKeysPageBase  apiPage = new APIKeysPage(getDriver());
       Assert.assertTrue(apiPage.isTitleAsExpected("Members"),"API keys page not open.");
       apiPage.getHeaderMenu().getUserNameOnMenu().click();
       apiPage.getHeaderMenu().getElementFromUserMenu("LOGOUT").click();

       getDriver().navigate().back();// back button on browser
       Assert.assertFalse(apiPage.getKeyTable().isPresent(),"API key table should not be displayed after logout.");

    }
    @Test(description = "Validate user can immediately login after changing password.")
    @TestCaseKey({"OPENW-693"})
    public void changePassword(){

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
