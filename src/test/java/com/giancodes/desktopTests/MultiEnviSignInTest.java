package com.giancodes.desktopTests;


import com.giancodes.IBase;
import com.giancodes.gui.pages.common.HomePageBase;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.giancodes.gui.pages.common.UserHomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class MultiEnviSignInTest implements IAbstractTest, IBase {
    private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private SignInPageBase signInPage;
    @BeforeMethod()
    @Parameters("browser")
    public void pickBrowser(@Optional("Chrome") String browser){

        HomePageBase hp = openHomePage(browser);

        signInPage = hp.getHeaderMenu().clickSignInButton();
        String formTitle = signInPage.getSignInFormText().getText();
        Assert.assertTrue(formTitle.equals("Sign In To Your Account"), "SignIn Page did not open");

    }

    @Test(description = "Validate with valid email and password. Test case: TC_LF_001, TC_LC_001")
    public void ValidCreditsSignInTest(){

        UserHomePageBase userHomePage = signInPage.signIn("testytestio836@gmail.com", "123qwe!@#QWE");
        Assert.assertTrue(userHomePage.getGreenPanelMessage().getText().equals("Signed in successfully."),"Sign in not successful.");

    }

    @Test(description = "Validate back button after logging in. Test case: TC_LF_009")
    public void backButtonValidSignInTest(){

        UserHomePageBase userHomePage =  signInPage.signIn("testytestio836@gmail.com","123qwe!@#QWE");
        Assert.assertTrue(userHomePage.getGreenPanelMessage().getText().equals("Signed in successfully."), "Sign in not successful.");
        getDriver().navigate().back();// back button on browser
        Assert.assertTrue(signInPage.getSignInFormText().getText().equals("Sign In To Your Account"), "SignIn Page did not open");
        Assert.assertTrue(signInPage.getHeaderMenu().getUserNameOnMenu().isPresent(), "User is not logged in when clicking the back button on browser.");
        Assert.assertTrue(signInPage.getHeaderMenu().getUserNameOnMenu().getText().equals("testio55"), "Invalid username on header menu.");

    }
//    @Test( dataProvider = "invalidCreds", description = "Validate signing in with invalid credentials. Test Cases: TC_LF_002,003,004,005")
    public void InvalidCreditsSignInTest(String email, String password){

        signInPage.signIn(email, password);
        Assert.assertTrue(signInPage.getAlertMessage().getText().equals("Invalid Email or password."), " Wrong error message displayed when entering invalid credentials in Sign In");

    }

    @Test(description = "Validate links, placeholders, copy and paste. Test case: TC_LF_006,008,016,013")
    public void SmallDetailsSignInTest() {

        SoftAssert softAssert = new SoftAssert();

        //TC_LF_008
        softAssert.assertTrue(signInPage.getEmailTextBox().getElement().getAttribute("placeholder").equals("Enter email"), "Email text box has invalid placeholder in SignIn.");
        softAssert.assertTrue(signInPage.getPasswordTextBox().getElement().getAttribute("placeholder").equals("Password"), "Password text box has invalid placeholder in SignIn.");

        //TC_LF_006 // TC_LF_016 // duplicates
        softAssert.assertTrue(signInPage.getCreateAccount().isPresent(),"Create Account Link in SignIn not present");
        softAssert.assertTrue(signInPage.getRecoverEmailElement().isPresent(),"Recover Link in SignIn not present");
        signInPage.getRecoverEmailElement().clickIfPresent();
        softAssert.assertTrue(signInPage.getRecoverEmailSendButton().isElementPresent(),"Send button not present.");

        //TC_LF_013
        signInPage.getEmailTextBox().type("testytestio836@gmail.com");
        signInPage.getPasswordTextBox().type("123qwe!@#QWE");
        signInPage.getPasswordTextBox().click();
        signInPage.getPasswordTextBox().getElement().sendKeys(Keys.CONTROL + "a");
        signInPage.getPasswordTextBox().getElement().sendKeys(Keys.CONTROL + "c");

        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String copied_txt = (String) clipboard.getData(DataFlavor.stringFlavor);
            softAssert.assertFalse(copied_txt.equals("123qwe!@#QWE"),"Password in SignIn should not be able to be copied. Current copied text: "+ clipboard);

        } catch (UnsupportedFlavorException | IOException e) {
            LOGGER.error("Error getting data from clipboard", e);
        }

        softAssert.assertAll();

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
