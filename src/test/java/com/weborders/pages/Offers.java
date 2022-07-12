package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Offers {
    public Offers() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(xpath = "//div[.='1/6']")//verify offers number
        public WebElement featuredOffersCount;

        @FindBy(xpath = "//button[contains(text(),'FILTER')]")//filter button
        public WebElement filterButton;

        @FindBy(xpath = "//button[contains(text(),'FINANCE')]")//finance button
        public WebElement financeOption;

        @FindBy(xpath = "//label[.='ALL SEDANS']")//all sedan button
        public WebElement allSedansOptions;

       @FindBy(xpath = "//input[@placeholder='Enter Zip']")//enter zip
        public WebElement enterZip;

    @FindBy(xpath = "//button[.='APPLY']")//apply button
    public WebElement applyButton;

    @FindBy(xpath = "//div[@data-testid='BreadCrumbs']//button[@data-testid='LexusButton']")//appliedFilterFinance
    public WebElement appliedFilterFinance;



    }

