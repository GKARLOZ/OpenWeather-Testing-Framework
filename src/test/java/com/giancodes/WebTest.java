package com.giancodes;

import com.giancodes.gui.pages.common.HomePageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.CsvDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest, IAbstractDataProvider {

    @Test(dataProvider = "DataProvider")
    @CsvDataSourceParameters(path = "data_source/SignInData.csv", dsUid = "TUID", dsArgs = "username,password")
    public void testSignIn(String username, String password){
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"HomePage did not open.");
        SignInPageBase signInPage = homePage.getHeaderMenu().clickSignInButton();
        signInPage.signIn(username,password);

    }
    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "qpsdemo")
    @CsvDataSourceParameters(path = "data_source/calculator.csv", dsUid = "TUID", dsArgs = "a,b,c")
    public void testCsvSumOperation(String a, String b, String c) {
        int actual = Integer.valueOf(a) + Integer.valueOf(b);
        int expected = Integer.valueOf(c);
        Assert.assertEquals(actual, expected, "Invalid sum result!");
    }
    @DataProvider(name="SigninData")
    public static Object[][] dataproviderOne(){

        return new Object[][]{

                {"qqqwe@GMAIL.COM","234WER@#$wer"}

        };
    }
}
