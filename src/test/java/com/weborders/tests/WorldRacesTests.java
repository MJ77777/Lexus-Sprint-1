package com.weborders.tests;

import com.weborders.pages.HomePage;
import com.weborders.pages.MotorSportsDriversPage;
import com.weborders.pages.MotorSportsPage;
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
        String secondLastRaceTitle = "MICHELIN GT CHALLENGE AT VIRGINIA";
        String secondLastRaceTrackDetail = "3.27 MILES / 17 TURNS";
        String secondLastRaceDate = "8.28.2022/2:10";
        String secondLastRaceLocation = "Virginia International Raceway,Alton, VA";

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
        motorSportsPage.clickRacesNextArrowButtonNTimes(3);

        Assert.assertEquals(secondLastRaceTitle, motorSportsPage.returnActiveCardRaceTitle());
        Assert.assertEquals(secondLastRaceTrackDetail, motorSportsPage.returnActiveCardRaceTrackDetail());
        Assert.assertEquals(secondLastRaceDate, motorSportsPage.returnActiveCardRaceDateDetail());
        Assert.assertEquals(secondLastRaceLocation, motorSportsPage.returnActiveCardRaceLocationDetail());
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
}
