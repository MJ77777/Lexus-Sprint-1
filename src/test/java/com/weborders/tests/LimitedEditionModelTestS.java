package com.weborders.tests;

import com.weborders.pages.*;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LimitedEditionModelTestS extends BaseClass {

    @Test
    public void pressRelease() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        Thread.sleep(5000);
        SeleniumUtils.scrollToElement(homePage.LCConvertable);
        Thread.sleep(3000);
        SeleniumUtils.jsClick(homePage.LCConvertable);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lexus.com/models/LC-convertible"));
    }

    @Test
    public void fillUpForm() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.RCFFuji);
        SeleniumUtils.jsClick(homePage.RCFFuji);
        ModelRCFPage modelRCFPage = new ModelRCFPage();
        SeleniumUtils.jsClick(modelRCFPage.StayInformed);
        Thread.sleep(3000);
        modelRCFPage.firstName.sendKeys("Jack");
        modelRCFPage.lastName.sendKeys("Nicholson");
        modelRCFPage.email.sendKeys("sabina1105@hotmail.com");
        modelRCFPage.zipCode.sendKeys("77036");
        SeleniumUtils.scrollToElement(modelRCFPage.RCFOption);
        SeleniumUtils.jsClick(modelRCFPage.RCFOption);
        WebElement RCF = modelRCFPage.RCFOption;
        Actions actions = new Actions(driver);
        WebElement LC = modelRCFPage.RCFOption;
        actions.moveToElement(LC);
        Thread.sleep(5000);
        modelRCFPage.submitButton.click();
        Thread.sleep(5000);
        String pageSource = driver.getPageSource();
        String expectedText = "We have received your submission and you will hear from us shortly.";
        Assert.assertTrue(pageSource.contains(expectedText));
    }

    @Test
    public void checkUrlOfNewRX() {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.newrx);
        SeleniumUtils.jsClick(homePage.newrx);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lexus.com/newRX");
        }

    @Test
    public void showIncludedFeatures() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.rz450);
        SeleniumUtils.jsClick(homePage.rz450);
        Thread.sleep(3000);
        ModelRZPage modelRZPage = new ModelRZPage();
        SeleniumUtils.jsClick(modelRZPage.preOrderGuide);
        SeleniumUtils.switchToWindowByUrl("https://www.lexus.com/content/dam/lexus/documents/brochures/models/2023/MY23-Lexus-RZ-PreBrochure.pdf");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lexus.com/content/dam/lexus/documents/brochures/models/2023/MY23-Lexus-RZ-PreBrochure.pdf");
    }

    @Test
    public void screenShotLEMNames() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.LEM);
        Thread.sleep(3000);
        SeleniumUtils.getScreenshot("FUTURE AND LIMITED EDITION VEHICLES");
        Assert.assertTrue(driver.getPageSource().contains("FUTURE AND LIMITED EDITION VEHICLES"));

    }
    }

