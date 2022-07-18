package com.weborders.pages;

import com.weborders.utilites.Driver;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MotorSportsDriversPage {
    public MotorSportsDriversPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@aria-label='1 / 4'][@data-swiper-slide-index=0]//div[contains(@class, 'styles_copy')]")
    public WebElement firstRacerInfo;

    @FindBy(xpath = "//div[@aria-label='2 / 4'][@data-swiper-slide-index=1]//div[contains(@class, 'styles_copy')]")
    public WebElement secondRacerInfo;

    @FindBy(xpath = "//div[@aria-label='3 / 4'][@data-swiper-slide-index=2]//div[contains(@class, 'styles_copy')]")
    public WebElement thirdRacerInfo;

    @FindBy(xpath = "//div[@aria-label='4 / 4'][@data-swiper-slide-index=3]//div[contains(@class, 'styles_copy')]")
    public WebElement forthRacerInfo;


    public static void waitForForthRacerInfo(){
        SeleniumUtils.waitForVisibility(By.xpath("//div[@aria-label='4 / 4'][@data-swiper-slide-index=3]//div[contains(@class, 'styles_copy')]//span"), 5);
    }

    public WebElement returnSpecificRacer(int order){
        switch (order){
            case 1:
                return firstRacerInfo;
            case 2:
                return secondRacerInfo;
            case 3:
                return thirdRacerInfo;
            case 4:
                return forthRacerInfo;
            default:
                return null;
        }
    }

    public String getRacerFirstName(WebElement element){
        return element.findElement(By.xpath(".//span[contains(@class, 'styles_firstName')]")).getText().trim();
    }

    public String getRacerLastName(WebElement element){
        return element.findElement(By.xpath(".//span[contains(@class, 'styles_lastName')]")).getText().trim();
    }

    public String getRacerCarNo(WebElement element){
        return element.findElement(By.xpath(".//span[contains(@class, 'styles_car')]/span")).getText().trim();
    }
}
