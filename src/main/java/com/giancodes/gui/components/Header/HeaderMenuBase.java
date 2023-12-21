package com.giancodes.gui.components.Header;

import com.giancodes.gui.pages.desktop.SignInPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuBase extends AbstractUIObject {

    public HeaderMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SignInPage clickSignInButton();
    public abstract ExtendedWebElement getUserNameOnMenu();

    }
