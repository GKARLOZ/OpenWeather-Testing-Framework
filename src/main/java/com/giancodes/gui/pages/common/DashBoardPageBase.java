package com.giancodes.gui.pages.common;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DashBoardPageBase extends AbstractPage {

    public DashBoardPageBase(WebDriver driver){
        super(driver);
    }
    public abstract ExtendedWebElement getPageTitle();


    }
