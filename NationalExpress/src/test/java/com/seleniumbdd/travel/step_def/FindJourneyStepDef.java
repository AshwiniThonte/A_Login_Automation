package com.seleniumbdd.travel.step_def;

import com.seleniumbdd.travel.driver.DriverHelper;
import com.seleniumbdd.travel.page_object.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.sql.Driver;
import java.util.List;
import java.util.Map;

public class FindJourneyStepDef extends DriverHelper {
    private HomePage homePage = new HomePage();
    @Given("^I am on home page$")
    public void i_am_on_home_page() {
    }

    @When("^I select journey type \"([^\"]*)\"$")
    public void i_select_journey_type(String jrnyType) {
    homePage.selectJourneyType(jrnyType);
    }

    @And("^I add Travel From and Travel To$")
    public void iAddTravelFromAndTravelTo(List<Map<String,String>> data) {
    driver.findElement(By.id("fromStation")).sendKeys(data.get(0).get("From"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> fromStops = driver.findElements(By.cssSelector(".station-dropdown-item.plannerForm--nearby-stops--item"));
        System.out.println("size:"+fromStops.size());
        for(WebElement stop:fromStops)
    {
        if(stop.getText().contains("VICTORIA"))
        {
            stop.click();
            break;
        }
    }
         driver.findElement(By.id("fromStation")).click();

      driver.findElement(By.id("toStation")).sendKeys(data.get(0).get("To"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> toStops = driver.findElements(By.cssSelector(".station-dropdown-item.plannerForm--nearby-stops--item"));
        System.out.println(toStops.size());

      for(WebElement stop2:toStops)
      {
          if(stop2.getText().contains("Gloucester"))
          {
              try {
                  Thread.sleep(2000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              stop2.click();
              break;
          }
      }

    }

    @And("^I select journey date$")
    public void iSelectJourneyDate()
    {
    driver.findElement(By.id("departDate")).click();
    List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
    int totaldates = dates.size();
        System.out.println(totaldates);
        for(int i=0;i<totaldates;i++)
        {
            String date = dates.get(i).getText();
            if(date.equals("29"))
            {
                dates.get(i).click();
                break;
            }
        }
    }

    @And("^I select No Of Passengers and search$")
    public void iSelectNoOfPassengersAndSearch(){
    Select sel = new Select(driver.findElement(By.id("passengerCount")));
    sel.selectByVisibleText("1");
    }
    @Then("^I should see all the available journey options with details$")
    public void i_should_see_all_the_available_journey_options_with_details() {

    }

}
