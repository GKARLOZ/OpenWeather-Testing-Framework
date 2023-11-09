package com.giancodes.gui.pages.common;

import com.giancodes.gui.pages.desktop.UserHomePage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends AbstractPage {

    public SignInPageBase(WebDriver driver){
        super(driver);
    }

    public abstract UserHomePage signIn(String username, String password);

}
