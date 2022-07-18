package com.weborders.pages;

import com.weborders.utilites.Driver;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LexusCollectionPage {
    public LexusCollectionPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public final static String SIGN_UP_SUCCESS_MESSAGE = "A message with a confirmation link has been sent to your email address. Please follow the link to activate your account.";

    @FindBy(xpath = "//a[@href='/account/login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'notification-success')]")
    public WebElement signupSuccessNotification;

    @FindBy(xpath = "//div[@data-product-url='/products/728624']")
    public WebElement cloudThrowTowelItem;

    public static void waitForLoginButton(){
        SeleniumUtils.waitForVisibility(By.xpath("//a[@href='/account/login']"), 5);
    }

    public static void waitForSignupSuccessNotification(){
        SeleniumUtils.waitForVisibility(By.xpath("//div[contains(@class, 'notification-success')]"), 5);
    }

    public static void waitForCloudThrowTowelItem(){
        SeleniumUtils.waitForVisibility(By.xpath("//div[@data-product-url='/products/728624']"), 5);
    }
}
