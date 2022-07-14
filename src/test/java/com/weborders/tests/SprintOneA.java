package com.weborders.tests;

import com.weborders.utilites.UtilityAmine;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SprintOneA extends BaseClass {

    @Test(groups = "smoke")

    public void CurrentOffers() {
        driver.get("https://www.lexus.com/");

        UtilityAmine.jsClick(driver, driver.findElement(By.xpath("//a[@aria-label='SEE OFFERS']")));

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lexus.com/offers");

    }
    @Test

    public void Explore() throws InterruptedException {
        driver.get("https://www.lexus.com/");
        Thread.sleep(3000);
        UtilityAmine.jsClick(driver, driver.findElement(By.xpath("//a[@href='/future/RZ' ]")));

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lexus.com/future/RZ");

    }

    @Test
    public void LearnMore() throws InterruptedException {
        driver.get("https://www.lexus.com/");
        Thread.sleep(3000);
        UtilityAmine.jsClick(driver, driver.findElement(By.xpath("//a[@href='/newrx']")));

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lexus.com/newRX");

    }


   @Test
    public void CoupeA(){
       driver.get("https://www.lexus.com/");
       UtilityAmine.jsClick(driver, driver.findElement(By.xpath("//*[@id=\"react-tabs-4\"]")));

   }

    @Test
    public void PerformanceA(){
        driver.get("https://www.lexus.com/");
        UtilityAmine.jsClick(driver, driver.findElement(By.xpath("//*[@id=\"react-tabs-8\"]/span")));


    }

}

