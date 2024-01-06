package com.giancodes.gui.pages.desktop;

import com.giancodes.gui.components.Header.HeaderMenu;
import com.giancodes.gui.pages.common.UserHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = UserHomePageBase.class)
public class UserHomePage extends UserHomePageBase {

    @FindBy(xpath = "//div[@class='panel-body' and contains(text(), 'Signed in successfully.')]\n")
    private ExtendedWebElement GreenPanelMessage;

    @FindBy(xpath = "//nav[contains(@id, \"nav-website\")]" )
    private HeaderMenu headerMenu;

    public UserHomePage(WebDriver driver) {
        super(driver);
    }


    public ExtendedWebElement getGreenPanelMessage() {
        return GreenPanelMessage;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

}
