package com.weborders.tests;

import com.weborders.pages.*;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SprintTwoTestS extends BaseClass {

    @Test
    public void pressRelease() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.LCConvertable);
        SeleniumUtils.jsClick(homePage.LCConvertable);
        SeleniumUtils.waitForVisibility(By.xpath("//a[@href='/content/dam/lexus/documents/brochures/special-edition/2022/2022_LC_500_Inspiration_Series.pdf']"), 5);
        ModelLCPage modelLCPage = new ModelLCPage();
        SeleniumUtils.scrollToElement(modelLCPage.pressRelease);
        Thread.sleep(3000);
        SeleniumUtils.jsClick(modelLCPage.pressRelease);
        SeleniumUtils.switchToWindowByUrl("https://www.lexus.com/content/dam/lexus/documents/brochures/special-edition/2022/2022_LC_500_Inspiration_Series.pdf");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lexus.com/content/dam/lexus/documents/brochures/special-edition/2022/2022_LC_500_Inspiration_Series.pdf");
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
    public void buildOptionsList() {
        String[] bespokeBuildOptions = {"WHEEL", "SPOILER", "INTERIOR", "ROOF", "CROME ACCENTS", "ADDITIONAL OPTIONS"};
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.LCBespoke);
        SeleniumUtils.jsClick(homePage.LCBespoke);
        ModelLCBPage modelLCBPage = new ModelLCBPage();
        // SeleniumUtils.scrollToElement((WebElement) modelLCBPage.modelOptions);
        List<WebElement> options = driver.findElements(By.xpath("//div[@data-testid='DealerSearchTabs']//ul/li"));
        for (int i = 0; i < options.size(); i++) {
            Assert.assertEquals(options.get(i).getText(), bespokeBuildOptions[i]);

        }
    }

    @Test
    public void showIncludedFeatures() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.GXBlack);
        SeleniumUtils.jsClick(homePage.GXBlack);
        ModelGXPage modelGXPage = new ModelGXPage();
        Thread.sleep(5000);
       // SeleniumUtils.scrollToElement(modelGXPage.pressReleaseGX);
        // SeleniumUtils.scroll(0,4000);
         Actions actions = new Actions(driver);
         actions.scrollByAmount(0,5000);
        SeleniumUtils.getScreenshot("INCLUDED FEATURES"); //would not catch features
        Assert.assertTrue(driver.getPageSource().contains("INCLUDED FEATURES"));
    }

    @Test
    public void screenShotLEMNames() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.LEM);
        Thread.sleep(5000);
        SeleniumUtils.getScreenshot("LIMITED EDITION MODELS");
        Assert.assertTrue(driver.getPageSource().contains("LIMITED EDITION MODELS"));
        }
    }

