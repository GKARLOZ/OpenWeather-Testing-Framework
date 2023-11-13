package com.giancodes;

import com.giancodes.mobile.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MobileTest implements IAbstractTest {

    @Test(dataProvider = "DP1")
    public void testSearchItems(String city){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home Page not opened.");
        homePage.searchBox(city);

        SoftAssert softAssert = new SoftAssert();
        String searchResultText = homePage.getSearchText().getText();
        String[] stringPieces = city.split(",");
        for (String s: stringPieces) {
            softAssert.assertTrue(searchResultText.contains(s), s + " did not appear in the result.");
        }
        softAssert.assertAll();

    }
    @DataProvider(name="DP1")
    public static Object[][] dataproviderOne(){

        return new Object[][]{

                {"San Diego, California, United States"},
                {"New York, United States"}

        };
    }

}
