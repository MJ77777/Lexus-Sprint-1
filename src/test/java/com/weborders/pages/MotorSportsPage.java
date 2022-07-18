package com.weborders.pages;

import com.weborders.utilites.Driver;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MotorSportsPage {

    public MotorSportsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='https://www.thelexuscollection.com']")
    public WebElement shopLexus;
    @FindBy(xpath = "//a[@href='/motorsports/drivers'][contains(@class, 'GlobalNav_primaryLink')]")
    public WebElement driversNavigationButton;

    @FindBy(xpath = "//h2[contains(text(), 'THE RACES')]")
    public WebElement racesTitle;

    @FindBy(xpath = "//h2[contains(text(), 'THE RACES')]//parent::div//parent::div[contains(@class, 'styles_content')]//button[@aria-label='Next slide']")
    public WebElement racesNextArrowButton;

    @FindBy(xpath = "//div[contains(@class, 'swiper-slide-active')]//div[contains(@class, 'styles_card')]")
    public WebElement activeRaceCard;

    @FindBy(xpath = "//a[@href='#cookies']")
    public WebElement cookieConsentOptions;

    @FindBy(xpath = "//input[@id='TargetingCookiesSlide']")
    public WebElement targetingCookiesSlide;

    @FindBy(xpath = "//button[@id='ensSave']")
    public WebElement cookieConsentOptionsSaveButton;


    public static void waitForDriversNavigationButton() {
        SeleniumUtils.waitForVisibility(By.xpath("//a[@href='/motorsports/drivers'][contains(@class, 'GlobalNav_primaryLink')]"), 5);
    }

    public static void waitForLastRaceCard() {
        SeleniumUtils.waitForPresenceOfElementLocated(By.xpath("//span[text()=' Motul Petit Le Mans'][contains(@class, 'styles_eventTitle')]"), 5);
    }

    public static void waitForRacesNextArrowButton() {
        SeleniumUtils.waitForVisibility(By.xpath("//h2[contains(text(), 'THE RACES')]//parent::div//parent::div[contains(@class, 'styles_content')]//button[@aria-label='Next slide']"), 5);
    }

    public static void waitForCookieConsentOptions() {
        SeleniumUtils.waitForVisibility(By.xpath("//a[@href='#cookies']"), 5);
    }

    public static void waitForShopLexus(){
        SeleniumUtils.waitForVisibility(By.xpath("//a[@href='https://www.thelexuscollection.com']"), 5);
    }

    public void clickRacesNextArrowButtonNTimes(int n) {
        for(int i = 0; i < n; i++){
            SeleniumUtils.jsClick(racesNextArrowButton);
        }
    }

    public String returnActiveCardRaceTitle() {
        return activeRaceCard.findElement(By.xpath(".//span[contains(@class, 'styles_eventTitle')]")).getText().trim();
    }

    public String returnActiveCardRaceTrackDetail() {
        return activeRaceCard.findElement(By.xpath(".//span[contains(@class, 'styles_trackDetail')]")).getText().trim();
    }

    public String returnActiveCardRaceDateDetail() {
        return activeRaceCard.findElement(By.xpath(".//span[contains(@class, 'styles_date')]/span")).getText().replace(" ", "/").trim();
    }

    public String returnActiveCardRaceLocationDetail() {
        return activeRaceCard.findElement(By.xpath(".//span[contains(@class, 'styles_location')]")).getText().replace("\n", "").trim();
    }

    public void updateTargetingCookiesSlideStatus(){
        SeleniumUtils.jsClick(targetingCookiesSlide);
    }

    public String getTargetingCookiesSwitchSpan(){
        return targetingCookiesSlide.findElement(By.xpath(".//following-sibling::span[@class='switch']")).getCssValue("background-color");
    }

}


