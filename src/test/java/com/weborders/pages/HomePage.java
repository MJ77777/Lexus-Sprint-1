package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
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


    @FindBy(xpath = "//input[@name=\"zipcode\"]") // enterZipCode - Sabina
    public WebElement enterZipCode;

    @FindBy(xpath = ("//a[@href=\"/build-your-lexus/#!/\"]")) // buildLexus - Sabina
    public WebElement buildLexus;

    @FindBy(xpath = ("//div[@id='quick-links']/div/a[@href='/dealers']")) //dealers - Sabina
    public WebElement dealers;

    @FindBy(xpath = ("//*[@id=\"quick-links\"]/div/a[3]")) //offers - Sabina
    public WebElement offers;


    @FindBy(xpath = "//a[@href=\"/models/LC-convertible?link[model_overlay_lcc_inspiration_series][SHOW_PAGE]=true\"]")
    public WebElement LCConvertable; // - Sabina

    @FindBy(xpath = "//a[@href=\"/models/RCF\"]")
    public WebElement RCFFuji; // - Sabina

    @FindBy(xpath = "//a[@href='/models/LC.html?link[model_overlay_bespoke][SHOW_PAGE]=true']")
    public WebElement LCBespoke; // - Sabina

    @FindBy(xpath = "//a[@href='/models/GX?link[model_overlay_special_edition][SHOW_PAGE]=true']")
    public WebElement GXBlack; // - Sabina

    @FindBy(xpath = "//*[@id=\"content-grid\"]/h3")
    public WebElement LEM; // - Sabina
}
