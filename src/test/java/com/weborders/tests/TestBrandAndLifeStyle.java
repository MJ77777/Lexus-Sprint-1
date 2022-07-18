package com.weborders.tests;

import com.weborders.pages.HomePage;
import com.weborders.pages.HybridPage;
import com.weborders.pages.MotorSportPage;
import com.weborders.pages.PerformancePage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBrandAndLifeStyle extends BaseClass {

    @Test
    public void lexusPerformance() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage home = new HomePage();
        Thread.sleep(3000);
       SeleniumUtils.jsClick(home.performanceFooter);
        PerformancePage performance=new PerformancePage();
        Thread.sleep(2000);
        Assert.assertEquals(performance.seeAllModels.getText(),"SEE ALL MODELS");
    }

    @Test
    public void motorSports() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage home = new HomePage();
        Thread.sleep(3000);
        SeleniumUtils.jsClick(home.motorFooter);
        MotorSportPage motor=new MotorSportPage();
        SeleniumUtils.jsClick(motor.raceResultOption);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lexus.com/motorsports/results");

    }

    @Test
    public void safetyTech() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage home = new HomePage();
        Thread.sleep(3000);
        SeleniumUtils.jsClick(home.safetyFooter);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"Lexus Safety Technology | Lexus.com");


    }

    @Test
    public void lexusHybrid() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage home = new HomePage();
        Thread.sleep(3000);
        SeleniumUtils.jsClick(home.hybridElectricFooter);
        HybridPage hybrid =new HybridPage();
        Assert.assertEquals(hybrid.hybridText.getText(),"THE LEXUS HYBRID ELECTRIC LINE");


    }

    @Test
    public void lexusElectrified() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage home = new HomePage();
        Thread.sleep(3000);
        SeleniumUtils.jsClick(home.electrifiedFooter);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"Lexus Electrified All-Electric Concepts | Lexus.com");


    }
}
