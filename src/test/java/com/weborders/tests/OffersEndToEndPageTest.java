package com.weborders.tests;

import com.github.javafaker.Faker;
import com.weborders.pages.HomePage;
import com.weborders.pages.OffersPage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OffersEndToEndPageTest extends BaseClass {
//mvn test -Drunner=Smoke.xml

    @Test
    public void endToEndOffersPage() throws InterruptedException {
        Faker faker=new Faker();
        driver.get(ConfigReader.getProperty("url"));
        HomePage home = new HomePage();
        Thread.sleep(3000);
        home.viewAllOffers.click();
        Thread.sleep(3000);
        OffersPage offer = new OffersPage();
        offer.enterZip.sendKeys("22003", Keys.ENTER);
        Thread.sleep(3000);
        SeleniumUtils.jsClick(offer.filterButton);
        offer.performanceOption.click();
        offer.allPerformance.click();
        offer.applyButton.click();
        Assert.assertEquals(offer.appliedFilterFinance.getText(), "ALL PERFORMANCE");
        offer.contactDealer.click();
        offer.sendInfo.click();
        offer.firstName.sendKeys(faker.name().firstName(),Keys.TAB,faker.name().lastName(),
                Keys.TAB,faker.internet().emailAddress());
        SeleniumUtils.getScreenshot("hello");



}
}
