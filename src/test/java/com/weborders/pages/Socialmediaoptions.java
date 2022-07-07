package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Socialmediaoptions {

    public Socialmediaoptions() {
        PageFactory.initElements(Driver.getDriver(), this);


    }

    @FindBy(xpath = "//a[@href='https://www.facebook.com/lexus']")//Facebook
    public WebElement facebook;

    @FindBy(xpath = "//a[@href='https://twitter.com/lexus']")//twitter
    public WebElement twitter;

    @FindBy(xpath = "//a[@href='https://www.youtube.com/Lexus']")//youtube
    public WebElement youtube;

    @FindBy(xpath = "//a[@href='http://instagram.com/lexususa']")//instagram
    public WebElement instagram;

    @FindBy(xpath = "//a[@href='https://www.pinterest.com/lexususa']")//pinterest
    public WebElement pinterest;

    @FindBy(xpath = "//a[@href='https://www.tiktok.com/@lexususa']")//tiktok
    public WebElement tiktok;
}
