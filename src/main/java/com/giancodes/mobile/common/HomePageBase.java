package com.giancodes.mobile.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public abstract class HomePageBase extends AbstractPage {

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement DontAllowButton; //access to devices location
    public HomePageBase(WebDriver driver){
        super(driver);
        DontAllowButton.clickIfPresent();
    }

    @Override
    public void open(){

    }

}
