package com.weborders.pages;

import com.github.javafaker.Faker;
import com.weborders.utilites.Driver;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LexusCollectionLoginPage {

    public LexusCollectionLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "website_user_first_name")
    public WebElement formFirstName;

    @FindBy(id = "website_user_last_name")
    public WebElement formLastName;

    @FindBy(id = "website_user_username")
    public WebElement formUsername;

    @FindBy(id = "website_user_email")
    public WebElement formEmail;

    @FindBy(xpath = "//form[@id='new_website_user'][@action='/account']//input[@id='website_user_password']")
    public WebElement formPassword;

    @FindBy(id = "website_user_password_confirmation")
    public WebElement formPassword2;

    @FindBy(xpath = "//input[@value='Create account']")
    public WebElement signUpButton;

    public static void waitForForm(){
        SeleniumUtils.waitForVisibility(By.xpath("//form[@id='new_website_user'][@action='/account']"), 5);
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
        LexusCollectionPage.waitForSignupSuccessNotification();
    }

}
