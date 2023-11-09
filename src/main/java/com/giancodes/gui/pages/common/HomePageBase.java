package com.giancodes.gui.pages.common;

import com.giancodes.gui.pages.common.Header.HeaderMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;


public abstract class HomePageBase extends AbstractPage {

    @FindBy(xpath = "//button[contains(@class, 'stick-footer-panel__link')] ")
    private ExtendedWebElement acceptCookiesButton;

    @FindBy(xpath = "//div[contains(@class, \"owm-loader\")]")
    private ExtendedWebElement loadingElements;

    public HomePageBase(WebDriver driver){
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);

    }

    @Override
    public void open(){
        super.open();
        loadingElements.waitUntilElementDisappear(5000); //This element appears when the homepage is loading and can't click acceptCookeisButton
        acceptCookiesButton.clickIfPresent();
    }
    public abstract HeaderMenu getHeaderMenu();

}
