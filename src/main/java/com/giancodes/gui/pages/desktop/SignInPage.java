package com.giancodes.gui.pages.desktop;

import com.giancodes.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(xpath = "//div[contains(@class,\"input-group\")]//input[contains(@name, \"user[email]\")]")
    private ExtendedWebElement emailTextBox;

    @FindBy(xpath = "//div[contains(@class,\"input-group\")]//input[contains(@name, \"user[password]\")]")
    private ExtendedWebElement passwordTextBox;

    @FindBy(xpath = "//form[contains(@class,\"simple_form new_user\")]//input[contains(@name, \"commit\")]\n")
    private ExtendedWebElement submitButton;
    public SignInPage(WebDriver driver){
        super(driver);

    }

    public UserHomePage signIn(String username, String password){
        emailTextBox.type(username);
        passwordTextBox.type(password);
        submitButton.click();
        return new UserHomePage(driver);

    }

}
