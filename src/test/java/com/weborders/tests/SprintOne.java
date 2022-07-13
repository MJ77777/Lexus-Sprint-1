package com.weborders.tests;

import com.weborders.pages.HomePage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.Driver;
import com.weborders.utilites.SeleniumUtils;
import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;



public class SprintOne extends BaseClass {

    @Test(groups = "smoke")

    public void enterZipCode() {
        driver.get((ConfigReader.getProperty("url")));
        HomePage SprintOne = new HomePage();
        SprintOne.enterZipCode.sendKeys(Keys.chord("77450"), Keys.ENTER);
        String pageSource = driver.getPageSource();
        String expectedText = "SHOWING RESULTS FOR";
        Assert.assertTrue(pageSource.contains(expectedText));
    }

    @Test
    public void buildYourLexus() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage SprintOne = new HomePage();
        SeleniumUtils.scrollToElement(SprintOne.buildLexus);
        //Thread.sleep(5000);
        SeleniumUtils.jsClick(SprintOne.buildLexus);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.lexus.com/build-your-lexus/#!/");
    }

    @Test
    public void findDealers() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage SprintOne = new HomePage();
        SeleniumUtils.scrollToElement(SprintOne.dealers);
        SeleniumUtils.jsClick(SprintOne.dealers);
        //Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(),"Lexus - Find a Dealer");
    }

    @Test
        public void getOffers () throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
            HomePage SprintOne = new HomePage();
            SeleniumUtils.scrollToElement(SprintOne.offers);
            //Thread.sleep(5000);
            SeleniumUtils.jsClick(SprintOne.offers);
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.lexus.com/offers");
        }

        @Test
        public void changeZipCode () {
            driver.get(ConfigReader.getProperty("url"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.lexus.com/");
        }

    }


