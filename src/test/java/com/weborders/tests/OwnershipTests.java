package com.weborders.tests;

import com.weborders.pages.DriversPage;
import com.weborders.pages.HomePage;
import com.weborders.pages.MaintenanceSchedulePage;
import com.weborders.utilites.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OwnershipTests extends BaseClass{

  @Test
  public void itemCountTest(){
    driver.get(ConfigReader.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    SeleniumUtils.waitForVisibility(By.xpath("//div[@id='content-grid']/h3[contains(text(), 'LEXUS OWNERSHIP')]//parent::div"), 20);
    HomePage home = new HomePage();
    Assert.assertEquals(home.lexusOwnershipDivs.size(), 4);
  }

  @Test(priority = 1, groups = {"flaky"})
  public void hoverColorTest() throws InterruptedException {
    String beforeHoverColorOriginal = "rgba(0, 0, 0, 1)";
    String afterHoverColorOriginal = "rgba(255, 255, 255, 1)";
    driver.get(ConfigReader.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    SeleniumUtils.waitForVisibility(By.xpath("//div[@id='content-grid']/h3[contains(text(), 'LEXUS OWNERSHIP')]//parent::div"), 20);
    Thread.sleep(2000);
    HomePage home = new HomePage();
    WebElement ownerResources = home.lexusOwnershipDivs.get(2);
    String beforeHoverColor = ownerResources.findElement(By.xpath(".//div//a")).getCssValue("color");// get the element's color value before hover
    Assert.assertEquals(SeleniumUtils.getColorHexFromRGBA(beforeHoverColorOriginal), SeleniumUtils.getColorHexFromRGBA(beforeHoverColor));// compare the color value with the original

    SeleniumUtils.hover(ownerResources);

    String afterHoverColor = ownerResources.findElement(By.xpath(".//div//a")).getCssValue("color");
    Assert.assertEquals(SeleniumUtils.getColorHexFromRGBA(afterHoverColorOriginal), SeleniumUtils.getColorHexFromRGBA(afterHoverColor));

  }

  @Test(priority = 2)
  public void navigateToDriverLexus(){
    String urlContains = "https://drivers.lexus.com/lexusdrivers";
    driver.get(ConfigReader.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    SeleniumUtils.waitForClickablility(By.xpath("//div[@id='content-grid']/div//h3[contains(text(), 'OWNER RESOURCES AND BENEFITS')]/following-sibling::div/a"), 20);
    HomePage home = new HomePage();
    SeleniumUtils.jsClick(home.ownerResourcesLearnMoreButton);
    SeleniumUtils.switchToWindowContainUrl("https://drivers.lexus.com/lexusdrivers");
    Assert.assertTrue(driver.getCurrentUrl().contains(urlContains));
  }

  @Test(priority = 3)
  public void clickMaintenanceScheduleOnDriverLexus(){
    String urlContains = "https://drivers.lexus.com/lexusdrivers/service/maintenance-schedules";
    String selectVehicleText = "Select A Vehicle";
    driver.get(ConfigReader.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    SeleniumUtils.waitForClickablility(By.xpath("//div[@id='content-grid']/div//h3[contains(text(), 'OWNER RESOURCES AND BENEFITS')]/following-sibling::div/a"), 20);
    HomePage home = new HomePage();
    SeleniumUtils.jsClick(home.ownerResourcesLearnMoreButton);
    SeleniumUtils.switchToWindowContainUrl("https://drivers.lexus.com/lexusdrivers");
    SeleniumUtils.waitForVisibility(By.xpath("//a[@aria-label='Maintenance Schedule']"), 20);
    SeleniumUtils.waitForClickablility(By.xpath("//a[@aria-label='Maintenance Schedule']"), 20);
    DriversPage driversPage = new DriversPage();
    driversPage.maintenanceScheduleButton.click();

    SeleniumUtils.waitForVisibility(By.xpath("//a[@id='nav-bar-selectVehicle-tab']"), 20);

    Assert.assertTrue(driver.getCurrentUrl().contains(urlContains));
    MaintenanceSchedulePage schedulePage = new MaintenanceSchedulePage();
    Assert.assertEquals(schedulePage.navBarSelectVehicle.getText(), selectVehicleText);

  }

  @Test(priority = 4, dataProvider = "carModelsWithYears", dataProviderClass = DataProviderCollectionE.class)
  public void scheduleMaintenanceOnDriverLexus(String car, String year) throws InterruptedException {
    // create a csv file from the dropdown menu options, since the data cannot be obtained
    /*
      let rows = [];

      myArray = Object.entries(ServletReducer.response); //ServletReducer returns from the server

      myArray.forEach(eachCar => {
          eachCar[1].forEach(eachYear => {
              rows.push([eachCar[0], eachYear])
          })
      })

      let createCSVAndDownload = function(){
          let csvContent = "data:text/csv;charset=utf-8,"
          + rows.map(e => e.join(",")).join("\n");

          var encodedUri = encodeURI(csvContent);
          var link = document.createElement("a");
          link.setAttribute("href", encodedUri);
          link.setAttribute("download", "my_data.csv");
          document.body.appendChild(link);

          link.click();
      }

      createCSVAndDownload();
     */

    String noMaintenanceFoundText = "THERE ARE CURRENTLY NO MAINTENANCE DETAIL AVAILABLE FOR SELECTED VEHICLE.";
    driver.get(ConfigReader.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    SeleniumUtils.waitForClickablility(By.xpath("//div[@id='content-grid']/div//h3[contains(text(), 'OWNER RESOURCES AND BENEFITS')]/following-sibling::div/a"), 20);
    HomePage home = new HomePage();
    SeleniumUtils.jsClick(home.ownerResourcesLearnMoreButton);
    SeleniumUtils.switchToWindowContainUrl("https://drivers.lexus.com/lexusdrivers");
    SeleniumUtils.waitForVisibility(By.xpath("//a[@aria-label='Maintenance Schedule']"), 20);
    SeleniumUtils.waitForClickablility(By.xpath("//a[@aria-label='Maintenance Schedule']"), 20);
    DriversPage driversPage = new DriversPage();
    SeleniumUtils.jsClick(driversPage.maintenanceScheduleButton);
    SeleniumUtils.waitForVisibility(By.xpath("//a[@id='nav-bar-selectVehicle-tab']"), 20);
    MaintenanceSchedulePage schedulePage = new MaintenanceSchedulePage();
    schedulePage.navBarSelectVehicle.click();

    schedulePage.vehicleSelect.click();
    schedulePage.vehicleSelectValue(car.replace(" ", ""));
    Thread.sleep(1000);
    schedulePage.yearSelect.click();
    Thread.sleep(1000);
    schedulePage.yearSelectValue(year);

    schedulePage.submitButton.click();

    SeleniumUtils.waitForVisibilityByMultiple(By.xpath("//p[@class='main-error']"), By.xpath("//label[contains(text(), 'Model / Year')]//following-sibling::span"), 20);

    try{
      Assert.assertEquals(schedulePage.errorResultMessage.getText(), noMaintenanceFoundText);
    } catch (Exception e){
      String foundCombination = car.substring(0, 2) + " " + car.substring(2).toUpperCase() + " " + year;
      Assert.assertEquals(schedulePage.foundModelYearCombination.getText().toUpperCase(), foundCombination.replace("  ", " ").trim());
    }
  }

}
