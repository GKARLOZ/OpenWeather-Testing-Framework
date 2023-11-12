package com.giancodes;

import com.giancodes.mobile.common.HomePageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class MobileTest implements IAbstractTest {

    @Test
    public void testSearchItems(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        pause(5);
        homePage.searchBox("San Diego, California, United States");


    }

}
