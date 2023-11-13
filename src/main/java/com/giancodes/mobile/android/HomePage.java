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
    private ExtendedWebElement searchTextBox;// search textbox in searching page
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Search\"]/android.widget.TextView")
    private ExtendedWebElement searchTextBoxHP;// search textbox in homepage

    @FindBy(xpath = "//android.widget.ScrollView//android.widget.TextView")
    private List<ExtendedWebElement> searchResultList;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id = \"daily\"]")
    private ExtendedWebElement dailyWeather;

    public HomePage (WebDriver driver){
        super(driver);
        DontAllowButton.clickIfPresent();
    }

    @Override
    public boolean isPageOpened(){
        System.out.println("daily element: "+ dailyWeather.getText());
        return dailyWeather.isElementPresent();
    }



    public void searchBox(String searchItem){
        searchButton.clickIfPresent();
        searchTextBox.click();
        searchTextBox.type(searchItem);
        tap(1316,2818,1);
        searchResultList.get(0).click();
    }

    public ExtendedWebElement getSearchText(){
        return searchTextBoxHP;
    }



}
