package com.giancodes.gui.pages.common.Header;

import com.giancodes.gui.pages.desktop.SignInPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HeaderMenu extends HeaderMenuBase{
    @FindBy(xpath = "//li[contains(@class, \"user-li\")]/a")
    private ExtendedWebElement signInButton;


    public HeaderMenu(WebDriver driver , SearchContext searchContext){
        super(driver, searchContext);
    }

    public SignInPage clickSignInButton(){


        signInButton.clickIfPresent();
        return new SignInPage(driver);
    }
}
