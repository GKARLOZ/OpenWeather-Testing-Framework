package com.giancodes.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class UserHomePageBase extends AbstractPage {

    public UserHomePageBase(WebDriver driver){
        super(driver);
    }

    public abstract ExtendedWebElement getGreenPanelMessage();

    }
