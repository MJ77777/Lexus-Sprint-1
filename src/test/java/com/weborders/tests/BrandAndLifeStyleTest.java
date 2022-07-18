package com.weborders.tests;

import com.weborders.pages.HomePage;
import com.weborders.pages.HybridPage;
import com.weborders.pages.MotorSportPage;
import com.weborders.pages.PerformancePage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrandAndLifeStyleTest extends BaseClass {

    @Test
    public void lexusPerformance() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        SeleniumUtils.waitForVisibility(By.xpath("//a[.='LEXUS PERFORMANCE']"), 5);
        HomePage home = new HomePage();
        SeleniumUtils.jsClick(home.performanceFooter);
        SeleniumUtils.waitForVisibility(By.xpath("//a[.='SEE ALL MODELS']"), 5);
        PerformancePage performance=new PerformancePage();
        Assert.assertEquals(performance.seeAllModels.getText(),"SEE ALL MODELS");
    }

    @Test
    public void motorSports() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        SeleniumUtils.waitForVisibility(By.xpath("//a[.='MOTORSPORTS']"), 5);
        HomePage home = new HomePage();
        SeleniumUtils.jsClick(home.motorFooter);
        SeleniumUtils.waitForVisibility(By.xpath("(//a[.='RACE RESULTS'])[3]"), 5);
        MotorSportPage motor=new MotorSportPage();
        SeleniumUtils.jsClick(motor.raceResultOption);

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lexus.com/motorsports/results");

    }

    @Test
    public void safetyTech() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        SeleniumUtils.waitForVisibility(By.xpath("//a[.='SAFETY TECHNOLOGY']"), 5);
        HomePage home = new HomePage();
        SeleniumUtils.jsClick(home.safetyFooter);
        SeleniumUtils.waitForTitleContains("Lexus Safety", 5);
        Assert.assertEquals(driver.getTitle(),"Lexus Safety Technology | Lexus.com");


    }

    @Test
    public void lexusHybrid() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        SeleniumUtils.waitForVisibility(By.xpath("//a[.='LEXUS HYBRID & ELECTRIC']"), 5);
        HomePage home = new HomePage();
        SeleniumUtils.jsClick(home.hybridElectricFooter);
        SeleniumUtils.waitForVisibility(By.xpath("(//h3[.='THE LEXUS HYBRID ELECTRIC LINE'])[2]"), 5);
        HybridPage hybrid =new HybridPage();
        Assert.assertEquals(hybrid.hybridText.getText(),"THE LEXUS HYBRID ELECTRIC LINE");


    }

    @Test
    public void lexusElectrified() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        SeleniumUtils.waitForVisibility(By.xpath("//a[.='LEXUS ELECTRIFIED']"), 5);
        HomePage home = new HomePage();
        SeleniumUtils.jsClick(home.electrifiedFooter);
        SeleniumUtils.waitForTitleContains("Lexus Electrified All-Electric", 5);
        Assert.assertEquals(driver.getTitle(),"Lexus Electrified All-Electric Concepts | Lexus.com");


    }
}
