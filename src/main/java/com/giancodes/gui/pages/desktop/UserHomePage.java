package com.giancodes.gui.pages.desktop;

import com.giancodes.gui.pages.common.UserHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = UserHomePageBase.class)
public class UserHomePage extends UserHomePageBase {

    public UserHomePage(WebDriver driver){
        super(driver);
    }
}
