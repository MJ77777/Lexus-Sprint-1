package com.weborders.tests;

import com.weborders.pages.HomePage;
import com.weborders.pages.Offers;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testOffers extends BaseClass{

    @Test
    public void sixFeatured() throws InterruptedException {
        char hello='6';
        driver.get(ConfigReader.getProperty("url"));
        HomePage home=new HomePage();
        Offers offer=new Offers();
        SeleniumUtils.jsClick(home.viewAllOffers);
        driver.findElement(By.xpath("//input[@placeholder='Enter Zip']")).sendKeys("22003", Keys.ENTER);
        Thread.sleep(4000);
//        SeleniumUtils.waitForVisibility(offer.featuredOffersCount,5);
        Assert.assertEquals(offer.featuredOffersCount.getText().charAt(2),hello);
    }
    @Test
    public void sortFinance() throws InterruptedException {
        logger.info("Intializing the browser. Navigating to URL");
        driver.get(ConfigReader.getProperty("url"));
        HomePage home=new HomePage();
        Offers offer=new Offers();
        SeleniumUtils.jsClick(home.viewAllOffers);
        driver.findElement(By.xpath("//input[@placeholder='Enter Zip']")).sendKeys("22003", Keys.ENTER);
Thread.sleep(3000);
        SeleniumUtils.jsClick(offer.filterButton);

        SeleniumUtils.jsClick(offer.financeOption);

        SeleniumUtils.jsClick(offer.applyButton);
        logger.info("Asserting the title ");

        Assert.assertEquals(offer.appliedFilterFinance.getText(),"FINANCE");


    }
    @Test
    public void sortPerformance(){
        driver.get(ConfigReader.getProperty("url"));



    }
    @Test
    public void UrlNotBroken(){
        driver.get(ConfigReader.getProperty("url"));



    }


}
