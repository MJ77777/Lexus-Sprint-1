package com.weborders.tests;

import com.weborders.utilites.UtilityS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.apache.hc.core5.util.Timeout.ofSeconds;

public class SprintOne extends BaseClass {

    @Test(groups = "smoke")

    public void enterZipCode() {
        driver.get("https://www.lexus.com/");
        driver.findElement(By.xpath("//input[@name=\"zipcode\"]")).sendKeys(Keys.chord("77450"), Keys.ENTER);
        String pageSource = driver.getPageSource();
        String expectedText = "SHOWING RESULTS FOR";
        Assert.assertTrue(pageSource.contains(expectedText));
        //Assert.assertTrue(driver.getPageSource().contains("SHOWING RESULTS FOR"));
    }

    @Test
    public void buildYourLexus() throws InterruptedException {
        driver.get("https://www.lexus.com/");
        WebElement buildLexus = driver.findElement(By.xpath("//a[@href=\"/build-your-lexus/#!/\"]"));
        UtilityS.jsScrollTo(driver, buildLexus);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"quick-links\"]/div/a[1]")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.lexus.com/build-your-lexus/#!/");
    }

    @Test
    public void findDealers() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lexus.com/");
        WebElement dealers = driver.findElement(By.xpath("//div[@id='quick-links']/div/a[@href='/dealers']"));
        UtilityS.jsScrollTo(driver, dealers);
        UtilityS.jsClick(driver, driver.findElement(By.xpath("//div[@id='quick-links']/div/a[@href='/dealers']")));
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(),"Lexus - Find a Dealer");
    }

    @Test
        public void getOffers () throws InterruptedException {
            driver.get("https://www.lexus.com/");
            WebElement offers = driver.findElement(By.xpath("//*[@id=\"quick-links\"]/div/a[3]"));
            UtilityS.jsScrollTo(driver, offers);
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"quick-links\"]/div/a[3]")).click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.lexus.com/offers");
        }

        @Test
        public void changeZipCode () {
            driver.get("https://www.lexus.com/");
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.lexus.com/");
        }

    }


