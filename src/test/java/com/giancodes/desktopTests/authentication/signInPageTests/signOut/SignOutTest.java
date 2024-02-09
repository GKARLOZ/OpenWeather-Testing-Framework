package com.giancodes.desktopTests.authentication.signInPageTests.signOut;

import com.giancodes.IBase;
import com.giancodes.gui.pages.common.APIKeysPageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.giancodes.gui.pages.common.UserHomePageBase;
import com.giancodes.gui.pages.desktop.APIKeysPage;
import com.giancodes.gui.pages.desktop.SignInPage;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignOutTest implements IAbstractTest, IBase {

    private UserHomePageBase userHomePage;

    @BeforeMethod(groups = {"regression","smoke"})
    public void setUp(){

        SignInPageBase signInPage = openSignInPage();

        userHomePage = signInPage.signIn("testytestio836@gmail.com", "123qwe!@#QWE");
        Assert.assertTrue(userHomePage.getGreenPanelMessage().getText().equals("Signed in successfully."),"Sign In not successful.");
        Assert.assertTrue(userHomePage.getHeaderMenu().getUserNameOnMenu().isPresent(),"Username not present on main menu.");

    }

    @Test( groups = {"regression","smoke"}, description = "Validate Logging out by selecting Logout option username dropdown menu")
    @TestCaseKey("OPWEA-19")
    public void validLogOutTest(){
        userHomePage.getHeaderMenu().getUserNameOnMenu().click();
        Assert.assertTrue(userHomePage.getHeaderMenu().getElementFromUserMenu("logout").isClickable(),"User menu did not appear.");
        userHomePage.getHeaderMenu().getElementFromUserMenu("Logout").click();
        SignInPageBase signInPage = new SignInPage(getDriver());
        Assert.assertTrue(signInPage.getAlertMessage().isPresent(),"Red Alert message not present.");

    }
    @Test( groups = "regression", description = "Validate logging out then back on browser")
    @TestCaseKey("OPWEA-21")
    public void logOutGoBackTest(){

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

}
