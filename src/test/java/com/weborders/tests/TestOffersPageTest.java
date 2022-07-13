package com.weborders.tests;

import com.weborders.pages.HomePage;
import com.weborders.pages.OffersPage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOffersPageTest extends BaseClass {


    @Test
    public void sixFeatured() throws InterruptedException {
        char hello = '6';
        driver.get(ConfigReader.getProperty("url"));
        HomePage home = new HomePage();
        Thread.sleep(3000);
        home.viewAllOffers.click();
        OffersPage offer = new OffersPage();
        offer.enterZip.sendKeys("22003", Keys.ENTER);
        Thread.sleep(4000);
        Assert.assertEquals(offer.featuredOffersCount.getText().charAt(2), hello);
    }

    @Test
    public void sortFinance() throws InterruptedException {
        logger.info("Intializing the browser. Navigating to URL");
        driver.get(ConfigReader.getProperty("url"));
        HomePage home = new HomePage();
        Thread.sleep(3000);
        home.viewAllOffers.click();
        Thread.sleep(3000);
        OffersPage offer = new OffersPage();
        offer.enterZip.sendKeys("22003", Keys.ENTER);
        Thread.sleep(3000);
        SeleniumUtils.jsClick(offer.filterButton);
        SeleniumUtils.jsClick(offer.financeOption);
        SeleniumUtils.jsClick(offer.applyButton);
        logger.info("Asserting the title ");
        Assert.assertEquals(offer.appliedFilterFinance.getText(), "FINANCE");
    }

    @Test
    public void sortAllSedan() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage home = new HomePage();
        Thread.sleep(3000);
        home.viewAllOffers.click();
        Thread.sleep(3000);
        OffersPage offer = new OffersPage();
        offer.enterZip.sendKeys("22003", Keys.ENTER);
        WebElement filterButton = offer.filterButton;
        Thread.sleep(3000);
        offer.filterButton.click();
        offer.allSedansOptions.click();
        offer.applyButton.click();
        Assert.assertEquals(offer.appliedFilterFinance.getText(), "ALL SEDANS");
    }

    @Test
    public void urlNotBroken() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        String offerUrl = "https://www.lexus.com/offers";
        HomePage home = new HomePage();
        Thread.sleep(2000);
        SeleniumUtils.jsClick(home.viewAllOffers);
        Assert.assertEquals(driver.getCurrentUrl(), offerUrl);

    }


}
