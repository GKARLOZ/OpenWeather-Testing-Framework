package com.giancodes.desktop;

import com.giancodes.gui.pages.common.DashBoardPageBase;
import com.giancodes.gui.pages.common.HomePageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.giancodes.gui.pages.common.UserHomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.CsvDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest, IAbstractDataProvider {

    @Test()
    public void testDashBoardPage(){

        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"HomePage did not open.");

        DashBoardPageBase dashBoardPage = homePage.getHeaderMenu().clickDashBoardButton();
        Assert.assertTrue(dashBoardPage.getPageTitle().getText().equals("Weather dashboard"));
    }
    @Test()
    public void testPricingPage(){

        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"HomePage did not open.");

        DashBoardPageBase dashBoardPage = homePage.getHeaderMenu().clickDashBoardButton();
        Assert.assertTrue(dashBoardPage.getPageTitle().getText().equals("Weather dashboard"));
    }

    @Test(dataProvider = "DataProvider")
    @CsvDataSourceParameters(path = "data_source/SignInData.csv", dsUid = "TUID", dsArgs = "username,password")
    public void testSignInNegativeScenario(String username, String password){
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"HomePage did not open.");
        SignInPageBase signInPage = homePage.getHeaderMenu().clickSignInButton();
        String formTitle = signInPage.getSignInFormText().getText();
        Assert.assertTrue(formTitle.equals("Sign In To Your Account"), "SignIn Page did not open");
        signInPage.signIn(username,password);
        System.out.println(signInPage.getAlertMessage().getText());
        Assert.assertTrue(signInPage.getAlertMessage().getText().equals("Invalid Email or password."), "SignIn form alert message did not appear or different message.");


    }

    @Test()
    public void testPositiveSignIn(){
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Homepage did not open.");

        SignInPageBase signInPage = homePage.getHeaderMenu().clickSignInButton();
        String formTitle = signInPage.getSignInFormText().getText();
        Assert.assertTrue(formTitle.equals("Sign In To Your Account"), "SignIn Page did not open");

        UserHomePageBase userHomePage =  signInPage.signIn("testytestio836@gmail.com","123qwe!@#QWE");
        Assert.assertTrue(userHomePage.getGreenPanelMessage().getText().equals("Signed in successfully."));

    }

    @DataProvider(name="SigninData")
    public static Object[][] dataproviderOne(){

        return new Object[][]{

                {"qqqwe@GMAIL.COM","234WER@#$wer"}

        };
    }
}
