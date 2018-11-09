package com.seleniumbdd.travel.page_object;

import com.seleniumbdd.travel.driver.DriverHelper;
import org.openqa.selenium.By;

public class HomePage extends DriverHelper {
    public void selectJourneyType(String jrnyType)
    {
        if(jrnyType.equalsIgnoreCase("Single")) {
            driver.findElement(By.cssSelector("#single")).click();
        }
    }

    public void doSearch()
    {
        driver.findElement(By.id("fromStation")).sendKeys();
    }
}
