package com.giancodes.gui.pages.common;

import com.giancodes.gui.components.Header.HeaderMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProfilePageBase extends AbstractPage {


    public ProfilePageBase(WebDriver driver){
        super(driver);
    }
    public abstract void setChangePassword(String newPassword);
    public abstract HeaderMenu header();
    public abstract ExtendedWebElement getConfirmPasswordAlertMes();


    }
