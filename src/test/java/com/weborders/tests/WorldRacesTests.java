package com.weborders.tests;

import com.weborders.pages.*;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.DataProviderCollection;
import com.weborders.utilites.SeleniumUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorldRacesTests extends BaseClass {

    @Test()
    public void clickWorldRacesLearnMore(){
        String worldRacesTestURL = "https://www.lexus.com/motorsports";
        driver.get(ConfigReader.getProperty("url"));
        HomePage.waitForMotorSportsElementVisibility();
        HomePage homePage = new HomePage();
        SeleniumUtils.jsClick(homePage.motorSportsElement);
        SeleniumUtils.switchToWindowByUrl("https://www.lexus.com/motorsports");
        Assert.assertEquals(driver.getCurrentUrl(), worldRacesTestURL);
    }

    @Test(priority = 1, dataProvider = "getRaceDriversWithNumbersData", dataProviderClass = DataProviderCollection.class)
    public void checkRaceTeamNamesWithNumbers(String order, String firstName, String lastName, String no){
        driver.get(ConfigReader.getProperty("url"));
        HomePage.waitForMotorSportsElementVisibility();
        HomePage homePage = new HomePage();
        SeleniumUtils.jsClick(homePage.motorSportsElement);
        SeleniumUtils.switchToWindowByUrl("https://www.lexus.com/motorsports");
        MotorSportsPage.waitForDriversNavigationButton();
        MotorSportsPage motorSportsPage = new MotorSportsPage();
        SeleniumUtils.jsClick(motorSportsPage.driversNavigationButton);

        MotorSportsDriversPage.waitForForthRacerInfo();
        MotorSportsDriversPage motorSportsDriversPage = new MotorSportsDriversPage();
        SeleniumUtils.scrollToElement(motorSportsDriversPage.forthRacerInfo);

        String firstNameLocal = motorSportsDriversPage.getRacerFirstName(motorSportsDriversPage.returnSpecificRacer(Integer.parseInt(order)));
        String lastNameLocal = motorSportsDriversPage.getRacerLastName(motorSportsDriversPage.returnSpecificRacer(Integer.parseInt(order)));
        String noLocal = motorSportsDriversPage.getRacerCarNo(motorSportsDriversPage.returnSpecificRacer(Integer.parseInt(order)));

        Assert.assertEquals(firstName, firstNameLocal);
        Assert.assertEquals(lastName, lastNameLocal);
        Assert.assertEquals(no, noLocal);
    }

    @Test(priority = 2)
    public void checkPreviousRaces(){
        String raceTitle = "MOTUL PETIT LE MANS";
        String raceTrackDetail = "2.54 MILES / 12 TURNS";
        String raceData = "10.1.2022/12:10";
        String raceLocation = "Michelin Raceway Road Atlanta,Braselton, GA";
        int nextArrowNTimes = 4;

        if(SeleniumUtils.isHeadless()){
            raceTitle = "MICHELIN GT CHALLENGE AT VIRGINIA";
            raceTrackDetail = "3.27 MILES / 17 TURNS";
            raceData = "8.28.2022/2:10";
            raceLocation = "Virginia International Raceway,Alton, VA";
            nextArrowNTimes = 3;
        }

        driver.get(ConfigReader.getProperty("url"));
        HomePage.waitForMotorSportsElementVisibility();
        HomePage homePage = new HomePage();
        SeleniumUtils.jsClick(homePage.motorSportsElement);
        SeleniumUtils.switchToWindowByUrl("https://www.lexus.com/motorsports");
        MotorSportsPage.waitForDriversNavigationButton();
        MotorSportsPage.waitForLastRaceCard();
        MotorSportsPage.waitForRacesNextArrowButton();
        MotorSportsPage motorSportsPage = new MotorSportsPage();
        SeleniumUtils.scrollToElement(motorSportsPage.racesTitle);
        motorSportsPage.clickRacesNextArrowButtonNTimes(nextArrowNTimes);

        Assert.assertEquals(raceTitle, motorSportsPage.returnActiveCardRaceTitle());
        Assert.assertEquals(raceTrackDetail, motorSportsPage.returnActiveCardRaceTrackDetail());
        Assert.assertEquals(raceData, motorSportsPage.returnActiveCardRaceDateDetail());
        Assert.assertEquals(raceLocation, motorSportsPage.returnActiveCardRaceLocationDetail());
    }

    @Test(priority = 3)
    public void updateCookieConsentOptions() {
        String expectedBackgroundColor = "#bbbbbb";
        driver.get(ConfigReader.getProperty("url"));
        HomePage.waitForMotorSportsElementVisibility();
        HomePage homePage = new HomePage();
        SeleniumUtils.jsClick(homePage.motorSportsElement);
        SeleniumUtils.switchToWindowByUrl("https://www.lexus.com/motorsports");
        MotorSportsPage.waitForCookieConsentOptions();

        MotorSportsPage motorSportsPage = new MotorSportsPage();
        SeleniumUtils.scrollToElement(motorSportsPage.cookieConsentOptions);
        SeleniumUtils.jsClick(motorSportsPage.cookieConsentOptions);
        motorSportsPage.updateTargetingCookiesSlideStatus();
        SeleniumUtils.jsClick(motorSportsPage.cookieConsentOptionsSaveButton);
        Assert.assertEquals(SeleniumUtils.getColorHexFromRGBA(motorSportsPage.getTargetingCookiesSwitchSpan()), expectedBackgroundColor);
    }

    @Test(priority = 4)
    public void lexusShopPurchaseTowelEndToEnd() throws InterruptedException {
        String towelProductURL = "https://www.thelexuscollection.com/products/728624";
        driver.get(ConfigReader.getProperty("url"));
        HomePage.waitForMotorSportsElementVisibility();
        HomePage homePage = new HomePage();
        SeleniumUtils.jsClick(homePage.motorSportsElement);
        SeleniumUtils.switchToWindowByUrl("https://www.lexus.com/motorsports");

        MotorSportsPage.waitForShopLexus();

        MotorSportsPage motorSportsPage = new MotorSportsPage();
        SeleniumUtils.scrollToElement(motorSportsPage.shopLexus);
        SeleniumUtils.jsClick(motorSportsPage.shopLexus);

        SeleniumUtils.switchToWindowByUrl("https://www.thelexuscollection.com/");
        LexusCollectionPage.waitForLoginButton();
        LexusCollectionPage lexusCollectionPage = new LexusCollectionPage();
        lexusCollectionPage.loginButton.click();

        LexusCollectionLoginPage.waitForForm();
        LexusCollectionLoginPage lexusCollectionLoginPage = new LexusCollectionLoginPage();
        lexusCollectionLoginPage.signUp();

        LexusCollectionPage.waitForSignupSuccessNotification();
        Assert.assertEquals(lexusCollectionPage.signupSuccessNotification.getText(), LexusCollectionPage.SIGN_UP_SUCCESS_MESSAGE);

        LexusCollectionPage.waitForCloudThrowTowelItem();
        lexusCollectionPage.cloudThrowTowelItem.click();

        Assert.assertEquals(driver.getCurrentUrl(), towelProductURL);

        LexusCollectionProductPage.waitForProductQuantityInput();
        LexusCollectionProductPage lexusCollectionProductPage = new LexusCollectionProductPage();

        lexusCollectionProductPage.setProductQuantity(lexusCollectionProductPage.getInStockCount() + 1);// try to add more than what's in stock and get the error message

        lexusCollectionProductPage.addToCardButton.click();
        LexusCollectionProductPage.waitForErrorNotification();
        Assert.assertTrue(lexusCollectionProductPage.isErrorNotificationDisplayed());

        lexusCollectionProductPage.setProductQuantity(lexusCollectionProductPage.getInStockCount() - 1); // needs to pass
        Thread.sleep(1000);
        Assert.assertTrue(lexusCollectionProductPage.itemPriceAndTotalMatching());
        lexusCollectionProductPage.addToCardButton.click();

        LexusCollectionCartPage.waitForTopCheckoutButton();
        LexusCollectionCartPage lexusCollectionCartPage = new LexusCollectionCartPage();
        lexusCollectionCartPage.topCheckoutButton.click();

        LexusCollectionCheckoutRegistrationPage.waitForForm();

        LexusCollectionCheckoutRegistrationPage lexusCollectionCheckoutRegistrationPage = new LexusCollectionCheckoutRegistrationPage();
        lexusCollectionCheckoutRegistrationPage.signUp();

        Assert.assertEquals(lexusCollectionCheckoutRegistrationPage.signupSuccessNotification.getText(), LexusCollectionCheckoutRegistrationPage.SIGN_UP_SUCCESS_MESSAGE);
    }



}
