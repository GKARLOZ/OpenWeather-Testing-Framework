package com.giancodes.gui.pages.desktop;

import com.giancodes.gui.components.Header.HeaderMenu;
import com.giancodes.gui.pages.common.APIKeysPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class APIKeysPage extends APIKeysPageBase {

    @FindBy(xpath = "//table[contains(@class, \"material_table\")]")
    private ExtendedWebElement keyTable;
    @FindBy(xpath = "//nav[contains(@id, \"nav-website\")]" )
    private HeaderMenu headerMenu;

    public APIKeysPage(WebDriver driver){

        super(driver);

    }
    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
    public ExtendedWebElement getKeyTable() {
        return keyTable;
    }
}
