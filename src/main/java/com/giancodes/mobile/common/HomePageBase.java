package com.giancodes.mobile.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public abstract class HomePageBase extends AbstractPage implements IMobileUtils {

    public HomePageBase(WebDriver driver){
        super(driver);

    }

    public abstract void  searchBox(String searchItem);
    public abstract ExtendedWebElement getSearchText();


    }
