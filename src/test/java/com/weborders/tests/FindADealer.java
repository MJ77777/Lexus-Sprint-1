package com.weborders.tests;

import com.weborders.utilites.UtilityE;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindADealer extends BaseClass {

  @Test(groups = "smoke")

  public void findADealerCheck(){
    String[] dealerSearchTabsValues = {"ZIP CODE", "DEALER NAME", "STATE"};
    driver.get("https://www.lexus.com");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    UtilityE.explicitWaitUntilElementVisible(driver, 20, By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='FIND A DEALER']"));
    WebElement findADealer = driver.findElement(By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='FIND A DEALER']"));
    UtilityE.jsScrollTo(driver, findADealer);
    UtilityE.explicitWaitUntilElementClickable(driver,20, By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='FIND A DEALER']"));
    findADealer = driver.findElement(By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='FIND A DEALER']")); // due to scroll event, the dom element gets deattached from the page, therefore assigning it again helps with this issue.
    String currentWindowHandle = driver.getWindowHandle();
    findADealer.click();

    UtilityE.changeWindow(driver, driver.getWindowHandles(), currentWindowHandle, false);

    UtilityE.explicitWaitUntilElementVisible(driver, 20, By.xpath("//input[@name='zipcode']"));
    UtilityE.sendKeys(driver.findElement(By.xpath("//input[@name='zipcode']")), "22043" + Keys.ENTER);

    UtilityE.explicitWaitUntilElementVisible(driver, 20, By.xpath("//div[@data-testid='DealerSearchTabs']//ul/li"));
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertEquals(currentURL, "https://www.lexus.com/dealers");
    Assert.assertEquals(currentTitle, "Lexus - Find a Dealer");

    List<WebElement> dealerSearchTabs = driver.findElements(By.xpath("//div[@data-testid='DealerSearchTabs']//ul/li"));
    Assert.assertTrue(dealerSearchTabs.size() == 3);

    for(int i = 0; i < dealerSearchTabs.size(); i++){
      Assert.assertEquals(dealerSearchTabs.get(i).getText(), dealerSearchTabsValues[i]);
    }
  }
}
