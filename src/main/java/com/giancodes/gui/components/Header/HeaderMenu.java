package com.giancodes.gui.components.Header;

import com.giancodes.gui.pages.common.SignInPageBase;
import com.giancodes.gui.pages.desktop.DashBoardPage;
import com.giancodes.gui.pages.desktop.SignInPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends HeaderMenuBase{
    @FindBy(xpath = "//li[contains(@class, \"user-li\")]/a")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//div[contains(@id, \"desktop-menu\")]//a[@href = \"/weather-dashboard\" and contains (text(), \"Dashboard\")]")
    private ExtendedWebElement dashBoardButton;

    @FindBy(xpath = "//div[contains(@class,\"inner-user-container\")]")
    private ExtendedWebElement userNameOnMenu;
    @FindBy(xpath = "//ul[contains(@id, \"user-dropdown-menu\")]//a[contains(@class, \"logout\")]")
    private ExtendedWebElement logout;

    @FindBy(xpath = "//ul[contains(@id, \"user-dropdown-menu\")]//a[contains(@href, \"/api_keys\")]")
    private ExtendedWebElement apiKeys;

    @FindBy(xpath = "//ul[contains(@id, \"user-dropdown-menu\")]//a[contains(@href,\"/home\")]")
    private ExtendedWebElement profile;


    public HeaderMenu(WebDriver driver , SearchContext searchContext){
        super(driver, searchContext);
    }

    public ExtendedWebElement getUserNameOnMenu() {
        return userNameOnMenu;
    }

    public ExtendedWebElement getElementFromUserMenu(String element) {

        if (element.equalsIgnoreCase("Logout")) {

            return logout;
        } else if (element.equalsIgnoreCase("My API keys")) {
            return apiKeys;

        } else if (element.equalsIgnoreCase("My profile")) {
            return profile;

        } else return null;

    }

    public SignInPage clickSignInButton(){


        signInButton.clickIfPresent();
        return new SignInPage(driver);
    }
    public DashBoardPage clickDashBoardButton(){
        dashBoardButton.clickIfPresent();
        return new DashBoardPage(driver);
    }
}
