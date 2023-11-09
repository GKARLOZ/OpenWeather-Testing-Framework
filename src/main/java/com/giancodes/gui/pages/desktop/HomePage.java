package com.giancodes.gui.pages.desktop;

import com.giancodes.gui.components.Header.HeaderMenu;
import com.giancodes.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//nav[contains(@id, \"nav-website\")]" )
    private HeaderMenu headerMenu;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HeaderMenu getHeaderMenu(){

        return headerMenu;


    }




}
