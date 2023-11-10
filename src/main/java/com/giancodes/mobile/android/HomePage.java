package com.giancodes.mobile.android;

import com.giancodes.mobile.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement DontAllowButton; //access to devices location
    public HomePage (WebDriver driver){
        super(driver);
    }



}
