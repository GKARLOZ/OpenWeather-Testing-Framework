package com.giancodes.mobile.android;

import com.giancodes.mobile.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement DontAllowButton; //access to devices location
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Search\"]")
    private ExtendedWebElement searchButton;
    @FindBy(className = "android.widget.EditText")
    private ExtendedWebElement searchTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup")
    private List<ExtendedWebElement> searchResultList;

    public HomePage (WebDriver driver){
        super(driver);
        DontAllowButton.clickIfPresent();
    }

    public void searchBox(String searchItem){
        searchButton.clickIfPresent();
        searchTextBox.click();
        searchTextBox.type(searchItem);
        tap(1316,2818,1);
        System.out.println("Search result list: "+ searchResultList.toString());
        searchResultList.get(0).click();
    }



}
