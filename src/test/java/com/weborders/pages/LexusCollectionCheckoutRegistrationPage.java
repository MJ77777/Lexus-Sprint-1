package com.weborders.pages;

import com.github.javafaker.Faker;
import com.weborders.utilites.Driver;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LexusCollectionCheckoutRegistrationPage {
    public LexusCollectionCheckoutRegistrationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public final static String SIGN_UP_SUCCESS_MESSAGE = "A message with a confirmation link has been sent to your email address. Please follow the link to activate your account.";

    @FindBy(xpath = "//div[contains(@class, 'notification-success')]")
    public WebElement signupSuccessNotification;

    @FindBy(xpath = "//form[@id='new-user'][@action='/checkout/registration/create']//input[@id='website_user_first_name']")
    public WebElement formFirstName;

    @FindBy(xpath = "//form[@id='new-user'][@action='/checkout/registration/create']//input[@id='website_user_last_name']")
    public WebElement formLastName;

    @FindBy(xpath = "//form[@id='new-user'][@action='/checkout/registration/create']//input[@id='website_user_username']")
    public WebElement formUsername;

    @FindBy(xpath = "//form[@id='new-user'][@action='/checkout/registration/create']//input[@id='website_user_email']")
    public WebElement formEmail;

    @FindBy(xpath = "//form[@id='new-user'][@action='/checkout/registration/create']//input[@id='website_user_password']")
    public WebElement formPassword;

    @FindBy(xpath = "//form[@id='new-user'][@action='/checkout/registration/create']//input[@id='website_user_password_confirmation']")
    public WebElement formPassword2;

    @FindBy(xpath = "//input[@value='create account']")
    public WebElement signUpButton;

    public static void waitForForm(){
        SeleniumUtils.waitForVisibility(By.id("new-user"), 5);
    }
    public static void waitForSignupSuccessNotification(){
        SeleniumUtils.waitForVisibility(By.xpath("//div[contains(@class, 'notification-success')]"), 5);
    }

    public void signUp(){
        Faker faker = new Faker();
        String password = faker.internet().password(7, 10, true, false, true);
        formFirstName.sendKeys(faker.name().firstName());
        formLastName.sendKeys(faker.name().lastName());
        formUsername.sendKeys(faker.name().username());
        formEmail.sendKeys(faker.internet().emailAddress());
        formPassword.sendKeys(password);
        formPassword2.sendKeys(password);
        signUpButton.click();
        waitForSignupSuccessNotification();
    }
}
