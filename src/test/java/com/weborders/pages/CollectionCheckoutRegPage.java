package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionCheckoutRegPage {
    public CollectionCheckoutRegPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//input[@id=\'website_user_first_name\'])[2]")
    public WebElement firstName;

    @FindBy (name = "website_user[last_name]")
    public WebElement lastName;

    @FindBy (name = "website_user[username]")
    public WebElement userName;

    @FindBy (name = "website_user[email]")
    public WebElement email;

    @FindBy (name = "website_user[password]")
    public WebElement password;

    @FindBy (name = "website_user[password_confirmation]")
    public WebElement passwordConf;
}
