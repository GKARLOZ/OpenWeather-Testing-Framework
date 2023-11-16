package com.giancodes.gui.pages.desktop;

import com.giancodes.gui.pages.common.DashBoardPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends DashBoardPageBase {

    @FindBy(xpath = "//h1[contains(@class,\"breadcrumb-title\")]")
    private ExtendedWebElement PageTitle;

    public DashBoardPage(WebDriver driver){
        super(driver);
    }

    public ExtendedWebElement getPageTitle(){
        return PageTitle;
    }
}
