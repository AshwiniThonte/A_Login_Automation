package com.seleniumbdd.travel.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverHelper {
    public static WebDriver driver;
    String browser = "chrome";

    public void openBrowser()
    {
        switch(browser)
        {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                FirefoxDriverManager.getInstance().setup();
                driver=new FirefoxDriver();
                break;
            case "ie":
                InternetExplorerDriverManager.getInstance().setup();
                driver=new InternetExplorerDriver();
                break;

                default:driver = new SafariDriver();
                break;

        }
    }

    public void navigateTo(String url)
    {
        driver.navigate().to(url);
    }
    public void maxBrowser()
    {
        driver.manage().window().maximize();
    }

    public void closeCookie()
    {
        driver.findElement(By.xpath("//a[@class='cookie-btn']")).click();
    }
    public void closeBrowser()
    {
        driver.close();
        driver.quit();
    }

    public void sleep()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
