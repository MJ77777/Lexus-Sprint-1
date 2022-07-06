package com.weborders.tests;

import com.weborders.utilites.UtilityE;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AboutUs extends BaseClass {

  @Test(groups = "smoke",enabled = false)
  public void checkAboutUs() {
    driver.get("https://www.lexus.com");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    UtilityE.explicitWaitUntilElementVisible(driver,20, By.xpath("//a[@href='/about']"));
    WebElement aboutUsElement = driver.findElement(By.xpath("//a[@href='/about']"));
    UtilityE.jsScrollTo(driver, aboutUsElement);
    UtilityE.explicitWaitUntilElementClickable(driver,20, By.xpath("//a[@href='/about']"));
    aboutUsElement = driver.findElement(By.xpath("//a[@href='/about']")); // due to scroll event, the dom element gets deattached from the page, therefore assigning it again helps with this issue.
    aboutUsElement.click();

    UtilityE.explicitWaitUntilElementVisible(driver,20, By.xpath("//a[@href='/about/manufacturing']"));
    String pageContent = driver.getPageSource();
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertEquals(currentURL, "https://www.lexus.com/about");
    Assert.assertEquals(currentTitle, "About Lexus | Lexus.com");
    Assert.assertTrue(pageContent.contains("THE US IN LEXUS."));
  }
}
