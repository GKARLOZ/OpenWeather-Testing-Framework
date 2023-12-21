package com.giancodes.gui.pages.desktop;

import com.giancodes.gui.components.Header.HeaderMenu;
import com.giancodes.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(xpath = "//nav[contains(@id, \"nav-website\")]" )
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//div[contains(@class,\"input-group\")]//input[contains(@name, \"user[email]\")]")
    private ExtendedWebElement emailTextBox;

    @FindBy(xpath = "//div[contains(@class,\"input-group\")]//input[contains(@name, \"user[password]\")]")
    private ExtendedWebElement passwordTextBox;

    @FindBy(xpath = "//form[contains(@class,\"simple_form new_user\")]//input[contains(@name, \"commit\")]\n")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[contains(@class, \"sign-form\")]//h3")
    private ExtendedWebElement signInFormText;

    @FindBy(xpath = "//div[contains(@class, \"panel-body\")]")
    private ExtendedWebElement alertMessage;

    @FindBy(xpath = "//div[contains(@class, \"pwd-lost-q show\")]/a")
    private ExtendedWebElement recoverEmail;

    @FindBy(xpath = "//input[contains(@value, \"Send\")]")
    private ExtendedWebElement recoverEmailSendButton;

    public SignInPage(WebDriver driver){
        super(driver);

    }

    public ExtendedWebElement getEmailTextBox() {
        return emailTextBox;
    }

    public ExtendedWebElement getPasswordTextBox() {
        return passwordTextBox;
    }

    public ExtendedWebElement getAlertMessage(){
        return alertMessage;
    }

    public ExtendedWebElement getSignInFormText(){
        return signInFormText;
    }

    public ExtendedWebElement getRecoverEmailElement(){return recoverEmail;}
    public ExtendedWebElement getRecoverEmailSendButton(){return recoverEmailSendButton;}

    public HeaderMenu getHeaderMenu(){

        return headerMenu;


    }

    public UserHomePage signIn(String username, String password){
        emailTextBox.type(username);
        passwordTextBox.type(password);
        submitButton.click();
        return new UserHomePage(driver);

    }

}
