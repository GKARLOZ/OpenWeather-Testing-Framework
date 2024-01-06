package com.giancodes.gui.pages.common;

import com.giancodes.gui.components.Header.HeaderMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class APIKeysPageBase extends AbstractPage {



    public APIKeysPageBase(WebDriver driver){
        super(driver);
    }

    public abstract HeaderMenu getHeaderMenu();
    public abstract ExtendedWebElement getKeyTable();



    }
