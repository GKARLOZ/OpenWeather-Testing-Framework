package com.giancodes.desktopTests.authentication.signInPageTests.signIn;

import com.giancodes.IBase;
import com.giancodes.gui.pages.common.HomePageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;

public class NegativeSignInTest implements IAbstractTest, IBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private SignInPageBase signInPage;


    @BeforeMethod(groups = "regression")
    public void setUp(){

        HomePageBase hp = openHomePage();

        signInPage = hp.getHeaderMenu().clickSignInButton();
        String formTitle = signInPage.getSignInFormText().getText();
        Assert.assertTrue(formTitle.equals("Sign In To Your Account"), "SignIn Page did not open");

    }

    @Test(  groups = "regression", dataProvider = "invalidCreds", description = "Validate signing in with invalid credentials.")
    @TestCaseKey({"OPWEA-2","OPWEA-4","OPWEA-5"})
    public void InvalidCreditsSignInTest(String email, String password){

        signInPage.signIn(email, password);
        Assert.assertTrue(signInPage.getAlertMessage().getText().equals("Invalid Email or password."), " Wrong error message displayed when entering invalid credentials in Sign In");

    }

    @DataProvider(name = "invalidCreds", parallel = true)
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
