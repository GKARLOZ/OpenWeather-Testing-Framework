package com.giancodes.desktopTests;

import com.giancodes.gui.pages.common.HomePageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;

public interface IBase extends IAbstractTest {


    default HomePageBase openHomePage(){

        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Homepage did not open.");
        return homePage;

    }

    default SignInPageBase openSignInPage(){
        HomePageBase hp = openHomePage();

        SignInPageBase signInPage = hp.getHeaderMenu().clickSignInButton();
        String formTitle = signInPage.getSignInFormText().getText();
        Assert.assertTrue(formTitle.equals("Sign In To Your Account"), "SignIn Page did not open");

        return signInPage;

    }

}
