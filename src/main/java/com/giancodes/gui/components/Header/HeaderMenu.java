package com.giancodes.gui.components.Header;

import com.giancodes.gui.pages.desktop.DashBoardPage;
import com.giancodes.gui.pages.desktop.SignInPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends HeaderMenuBase{
    @FindBy(xpath = "//li[contains(@class, \"user-li\")]/a")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//div[contains(@id, \"desktop-menu\")]//a[@href = \"/weather-dashboard\" and contains (text(), \"Dashboard\")]")
    private ExtendedWebElement dashBoardButton;


    public HeaderMenu(WebDriver driver , SearchContext searchContext){
        super(driver, searchContext);
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
