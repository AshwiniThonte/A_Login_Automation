package com.seleniumbdd.travel;

import com.seleniumbdd.travel.driver.DriverHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
    DriverHelper driverHelper = new DriverHelper();
    @Before
    public void setUp()
    {
        driverHelper.openBrowser();
        driverHelper.navigateTo("https://www.nationalexpress.com/en");
        driverHelper.maxBrowser();
        driverHelper.closeCookie();
    }
    //@After
    public void tearDown()
    {
        driverHelper.closeBrowser();
    }
}
