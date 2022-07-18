package com.weborders.tests;

import com.github.javafaker.Faker;
import com.weborders.pages.CollectionCartPage;
import com.weborders.pages.CollectionCheckoutRegPage;
import com.weborders.pages.CollectionPage;
import com.weborders.pages.HomePage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CollectionsTest extends BaseClass{


    @Test
    public void checkCollectionUrl() {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.exploreCollections);
        SeleniumUtils.jsClick(homePage.exploreCollections);
        SeleniumUtils.switchToWindowByUrl("https://www.thelexuscollection.com/");
        Assert.assertEquals(driver.getCurrentUrl(),("https://www.thelexuscollection.com/"));
    }

    @Test
    public void addProductToAcart(){
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.exploreCollections);
        SeleniumUtils.jsClick(homePage.exploreCollections);
        SeleniumUtils.switchToWindowByUrl("https://www.thelexuscollection.com/");
        CollectionPage collectionPage = new CollectionPage();
        SeleniumUtils.jsClick(collectionPage.apparel);
        SeleniumUtils.jsClick(collectionPage.hoodie);
        SeleniumUtils.jsClick(collectionPage.quantityInputSm);
        collectionPage.quantityInputSm.clear();
        collectionPage.quantityInputSm.sendKeys("1"+ Keys.ENTER);
        SeleniumUtils.getScreenshot("Shopping Cart");
        String pageSource = driver.getPageSource();
        String expectedText = "Shopping Cart";
        Assert.assertTrue(pageSource.contains(expectedText));
    }

    @Test
    public void openAccountToCheckoutTTT() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        SeleniumUtils.scrollToElement(homePage.exploreCollections);
        SeleniumUtils.jsClick(homePage.exploreCollections);
        SeleniumUtils.switchToWindowByUrl("https://www.thelexuscollection.com/");
        CollectionPage collectionPage = new CollectionPage();
        SeleniumUtils.jsClick(collectionPage.apparel);
        SeleniumUtils.jsClick(collectionPage.hoodie);
        SeleniumUtils.jsClick(collectionPage.quantityInputSm);
        collectionPage.quantityInputSm.clear();
        collectionPage.quantityInputSm.sendKeys("1" + Keys.ENTER);
        CollectionCartPage collectionCartPage = new CollectionCartPage();
        SeleniumUtils.jsClick(collectionCartPage.checkBox);
        SeleniumUtils.jsClick(collectionCartPage.checkOut);

        Faker faker = new Faker();
        CollectionCheckoutRegPage collectionCheckoutRegPage = new CollectionCheckoutRegPage();
        SeleniumUtils.jsClick(collectionCheckoutRegPage.firstName);
        Thread.sleep(3000);
        collectionCheckoutRegPage.firstName.sendKeys(Keys.chord(faker.name().firstName(), Keys.TAB, faker.name().lastName(),
                Keys.TAB, faker.name().username(), Keys.TAB, faker.internet().emailAddress(),
                Keys.TAB, faker.internet().password(), Keys.TAB, faker.internet().password(), Keys.ENTER));
        SeleniumUtils.getScreenshot("Welcome to The Lexus Collection!");
    }


        @Test
        public void checkProductTypes() {
            String[] productTypes = {"Apparel", "MEN", "LADIES", "Bags", "Drinkware", "Headwear", "Golf", "Gifts", "Home", "Keychains & Car Accessories", "Watches", "Writing Instruments", "Lexus Racing"};
            driver.get(ConfigReader.getProperty("url"));
            HomePage homePage = new HomePage();
            SeleniumUtils.scrollToElement(homePage.exploreCollections);
            SeleniumUtils.jsClick(homePage.exploreCollections);
            SeleniumUtils.switchToWindowByUrl("https://www.thelexuscollection.com/");
            CollectionPage collectionPage = new CollectionPage();
            for (int i = 0; i < collectionPage.productTypeList.size(); i++) {
                String pageSource = driver.getPageSource();
                String expectedText[] = {"Apparel", "MEN", "LADIES", "Bags", "Drinkware", "Headwear", "Golf", "Gifts", "Home", "Keychains & Car Accessories", "Watches", "Writing Instruments", "Lexus Racing"};
                Assert.assertTrue(pageSource.contains(expectedText[i]));
            }
        }
            @Test
         public void getTitle(){
                driver.get(ConfigReader.getProperty("url"));
                HomePage homePage = new HomePage();
                SeleniumUtils.scrollToElement(homePage.exploreCollections);
                SeleniumUtils.jsClick(homePage.exploreCollections);
                SeleniumUtils.switchToWindowByUrl("https://www.thelexuscollection.com/");
                CollectionPage collectionPage =  new CollectionPage();
               SeleniumUtils.getScreenshot("The Lexus Collection");
            }
        }





