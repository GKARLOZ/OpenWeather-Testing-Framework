package com.giancodes.desktop;

import com.giancodes.gui.pages.common.HomePageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.giancodes.gui.pages.common.UserHomePageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignInTest implements IAbstractTest, IBase {

    @Test(description = "Validate with valid email and password. Test case: TC_LF_001, TC_LC_001")
    public void ValidCreditsSignInTest(){

        SignInPageBase signInPage = openSignInPage();

        UserHomePageBase userHomePage =  signInPage.signIn("testytestio836@gmail.com","123qwe!@#QWE");
        Assert.assertTrue(userHomePage.getGreenPanelMessage().getText().equals("Signed in successfully."));

    }

    @Test(description = "Validate user is logged in when click back button . Test case: TC_LF_009")
    public void backButtonValidSignInTest(){

        SignInPageBase signInPage = openSignInPage();

        UserHomePageBase userHomePage =  signInPage.signIn("testytestio836@gmail.com","123qwe!@#QWE");
        Assert.assertTrue(userHomePage.getGreenPanelMessage().getText().equals("Signed in successfully."));
        getDriver().navigate().back();
        Assert.assertTrue(signInPage.getSignInFormText().getText().equals("Sign In To Your Account"), "SignIn Page did not open");
        Assert.assertTrue(signInPage.getHeaderMenu().getUserNameOnMenu().isPresent(), "Username not present on hearder menu.");
        Assert.assertTrue(signInPage.getHeaderMenu().getUserNameOnMenu().getText().equals("testio55"), "Invalid username on header menu.");

    }
    @Test( dataProvider = "invalidCreds", description = "Validate signing in with invalid credentials.")
    public void InvalidCreditsSignInTest(String email, String password){

        SignInPageBase signInPage = openSignInPage();

        signInPage.signIn(email, password);
        Assert.assertTrue(signInPage.getAlertMessage().getText().equals("Invalid Email or password."));

    }

    @Test()
    public void SmallDetailsSignInTest(){
        SignInPageBase signInPage = openSignInPage();
        SoftAssert softAssert = new SoftAssert();

        //TC_LF_008
        softAssert.assertTrue(signInPage.getEmailTextBox().getElement().getAttribute("placeholder").equals("Enter email"), "Email text box has invalid placeholder.");
        softAssert.assertTrue(signInPage.getPasswordTextBox().getElement().getAttribute("placeholder").equals("Password"), "Password text box has invalid placeholder.");

        //TC_LF_006
        signInPage.getRecoverEmailElement().clickIfPresent();
        softAssert.assertTrue(signInPage.getRecoverEmailSendButton().isElementPresent(),"Send button not present.");


        softAssert.assertAll();

    }





    @DataProvider(name = "invalidCreds")
    public Object[][]dataproviderForSearch(){

        return new Object[][]{
                {"xyzabc123@gmail.com", "xyzabc123"},//invalid email and password //TC_LF_002
                {"t836@gmail.com", "123qwe!@#QWE" },//invalid email and valid Password //TC_LF_003
                {"testytestio836@gmail.com", "123qwe!@#QW"},//valid email and invalid password // TC_LC_004
                {"",""},//leave blank//TC_LC_005
                {"  ", "  "}//leave spaces


        };

    }


}
