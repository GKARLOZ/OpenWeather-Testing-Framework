package com.giancodes.desktopTests;

import com.giancodes.gui.pages.common.HomePageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.EdgeCapabilities;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import org.testng.Assert;

public interface IBase extends IAbstractTest {


    default HomePageBase openHomePage(){

        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Homepage did not open.");
        return homePage;

    }
    default HomePageBase openHomePage(String browser){

        HomePageBase homePage = multiBrowserDriver(browser);
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
    default SignInPageBase openSignInPage(String browser){
        HomePageBase hp = openHomePage(browser);

        SignInPageBase signInPage = hp.getHeaderMenu().clickSignInButton();
        String formTitle = signInPage.getSignInFormText().getText();
        Assert.assertTrue(formTitle.equals("Sign In To Your Account"), "SignIn Page did not open");

        return signInPage;

    }

    default  HomePageBase multiBrowserDriver(String browser){

            if(browser.equalsIgnoreCase("Chrome")){
                return initPage(getDriver(browser, new ChromeCapabilities().getCapability("Chrome Test")),HomePageBase.class);

            } else if (browser.equalsIgnoreCase("Firefox")) {
                return initPage(getDriver(browser, new FirefoxCapabilities().getCapability("Firefox Test")),HomePageBase.class);

            }else if (browser.equalsIgnoreCase("Edge")) {
                return initPage(getDriver(browser, new EdgeCapabilities().getCapability("Edge Test")),HomePageBase.class);

    }
            else return null;

    }

}
