package com.weborders.tests;

import com.weborders.pages.HomePage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class OwnershipTests extends BaseClass{

  @Test()
  public void itemCountTest(){
    driver.get(ConfigReader.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    SeleniumUtils.waitForVisibility(By.xpath("//div[@id='content-grid']/h3[contains(text(), 'LEXUS OWNERSHIP')]//parent::div"), 20);
    HomePage home = new HomePage();
    System.out.println(home.lexusOwnershipDiv.getText());
  }
}
