package com.weborders.tests;

import com.weborders.pages.BuyOrLeaseQuizPage;
import com.weborders.pages.FindADealerPage;
import com.weborders.pages.HomePage;
import com.weborders.pages.ShopPartsPage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FooterLinksTests extends BaseClass {

  @Test(groups = "smoke")
  public void checkAboutUs() throws InterruptedException {
    driver.get(ConfigReader.getProperty("url"));
    HomePage home = new HomePage();
    SeleniumUtils.jsClick(home.aboutUsElement);

    Thread.sleep(1500);
    String pageContent = driver.getPageSource();
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertEquals(currentURL, "https://www.lexus.com/about");
    Assert.assertEquals(currentTitle, "About Lexus | Lexus.com");
    Assert.assertTrue(pageContent.contains("THE US IN LEXUS."));
  }

  @Test
  public void checkBuyOrLeaseQuiz(){
    driver.get(ConfigReader.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    SeleniumUtils.waitForVisibility(By.xpath("//a[contains(@href, 'financing_options/buy_or_lease')]"), 20);
    HomePage home = new HomePage();
    SeleniumUtils.scrollToElement(home.buyOrLeaseQuizElement);
    SeleniumUtils.waitForClickablility(By.xpath("//a[contains(@href, 'financing_options/buy_or_lease')]"), 20);
    home.buyOrLeaseQuizElement.click();

    SeleniumUtils.switchToWindowByUrl("https://www.lexusfinancial.com/us/en/financing_options/buy_or_lease.html");

    SeleniumUtils.waitForVisibility(By.xpath("//div[@id='q1']//following-sibling::h4"), 20);
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertEquals(currentURL, "https://www.lexusfinancial.com/us/en/financing_options/buy_or_lease.html");
    Assert.assertEquals(currentTitle, "Buy or Lease Quiz | Lexus Financial");

    BuyOrLeaseQuizPage leasePage = new BuyOrLeaseQuizPage();
    Assert.assertEquals(leasePage.questionOne.getText(), "QUESTION 1 OF 7");
  }

  @Test(groups = "smoke")
  public void findADealerCheck(){
    String[] dealerSearchTabsValues = {"ZIP CODE", "DEALER NAME", "STATE"};
    driver.get(ConfigReader.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    SeleniumUtils.waitForVisibility(By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='FIND A DEALER']"), 20);
    HomePage homePage = new HomePage();
    SeleniumUtils.scrollToElement(homePage.findADealer);
    SeleniumUtils.waitForClickablility(By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='FIND A DEALER']"), 20);
    homePage.findADealer.click();

    SeleniumUtils.switchToWindowByUrl("https://www.lexus.com/dealers");

    SeleniumUtils.waitForVisibility(By.xpath("//input[@name='zipcode']"), 20);
    FindADealerPage findADealerPage = new FindADealerPage();

    findADealerPage.zipCodeInputEnter();

    SeleniumUtils.waitForVisibility(By.xpath("//div[@data-testid='DealerSearchTabs']//ul/li"), 20);
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertEquals(currentURL, "https://www.lexus.com/dealers");
    Assert.assertEquals(currentTitle, "Lexus - Find a Dealer");

    Assert.assertTrue(findADealerPage.dealerSearchTabs.size() == 3);

    for(int i = 0; i < findADealerPage.dealerSearchTabs.size(); i++){
      Assert.assertEquals(findADealerPage.dealerSearchTabs.get(i).getText(), dealerSearchTabsValues[i]);
    }
  }

  @Test(groups = "smoke")
  public void checkRoadsideAssistance() throws InterruptedException {
    driver.get(ConfigReader.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    SeleniumUtils.waitForVisibility(By.xpath("//a[.=contains(text(), 'ROADSIDE ASSISTANCE')]"), 20);
    HomePage homePage = new HomePage();
    SeleniumUtils.scrollToElement(homePage.roadsideAssistance);
    SeleniumUtils.waitForClickablility(By.xpath("//a[.=contains(text(), 'ROADSIDE ASSISTANCE')]"), 20);
    homePage.roadsideAssistance.click();

    SeleniumUtils.switchToWindow("What is Lexus Roadside Assistance?");

    SeleniumUtils.waitForVisibility(By.xpath("//h1[contains(text(), 'Lexus Roadside Assistance')]"), 20);
    Thread.sleep(2000);
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertTrue(currentURL.contains("What-is-Lexus-Roadsid"));
    Assert.assertEquals(currentTitle, "What is Lexus Roadside Assistance?");
    String pageContent = driver.getPageSource();
    Assert.assertTrue(pageContent.contains("What is Lexus Roadside Assistance?"));
  }

  @Test
  public void shopPartsCheck() throws InterruptedException {
    driver.get(ConfigReader.getProperty("url"));
    String searchInputPlaceholder = "Search by Keywords, Part Numbers or Full VIN";
    HomePage homePage = new HomePage();
    Thread.sleep(2000);
    SeleniumUtils.jsClick(homePage.shopParts);

    Thread.sleep(1000);
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertTrue(currentURL.contains("https://parts.lexus.com"));
    Assert.assertEquals(currentTitle, "Shop Lexus Parts and Accessories Online");
    ShopPartsPage shopPartsPage = new ShopPartsPage();
    String searchInput = shopPartsPage.shopPartsInput.getAttribute("placeholder");
    Assert.assertEquals(searchInput, searchInputPlaceholder);
  }

}
