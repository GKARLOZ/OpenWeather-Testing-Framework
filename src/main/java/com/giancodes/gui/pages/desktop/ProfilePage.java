package com.giancodes.gui.pages.desktop;

import com.giancodes.gui.components.Header.HeaderMenu;
import com.giancodes.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends ProfilePageBase {

    @FindBy(xpath = "//input[contains(@name, \"password_form[password]\")]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[contains(@name, \"password_form[password_confirmation]\")]")
    private ExtendedWebElement confirmPasswordInput;

    @FindBy(xpath = "//input[contains(@value, \"Change Password\")]")
    private ExtendedWebElement changePasswordButton;

    @FindBy(xpath = "//nav[contains(@id, \"nav-website\")]" )
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//div[contains(@class,\"panel-body\")]")
    private ExtendedWebElement confirmPasswordAlertMes;

    public ProfilePage(WebDriver driver){
        super(driver);
    }
    public HeaderMenu header(){
        return headerMenu;
    }

    public void setChangePassword(String newPassword){

        passwordInput.type(newPassword);
        confirmPasswordInput.type(newPassword);
        changePasswordButton.click();
    }

    public ExtendedWebElement getConfirmPasswordAlertMes(){
        return confirmPasswordAlertMes;
    }

}
