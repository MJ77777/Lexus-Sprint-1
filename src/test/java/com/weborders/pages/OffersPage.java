package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {
    public OffersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(xpath = "//div[.='1/6']")//verify offers number
        public WebElement featuredOffersCount;

        @FindBy(xpath = "//button[contains(text(),'FILTER')]")//filter button
        public WebElement filterButton;

        @FindBy(xpath = "//button[contains(text(),'FINANCE')]")//finance button
        public WebElement financeOption;

        @FindBy(xpath = "//span[@size='15']")//all sedan button
        public WebElement allSedansOptions;

       @FindBy(xpath = "//input[@placeholder='Enter Zip']")//enter zip
        public WebElement enterZip;

    @FindBy(xpath = "//button[.='APPLY']")//apply button
    public WebElement applyButton;

    @FindBy(xpath = "//div[@data-testid='BreadCrumbs']//button[@data-testid='LexusButton']")//appliedFilterFinance
    public WebElement appliedFilterFinance;

    @FindBy(xpath = "//span[.='PERFORMANCE']")//appliedFilterFinance
    public WebElement performanceOption;

    @FindBy(xpath = "//span[@size='15']")//all sedan button
    public WebElement allPerformance;

    @FindBy(xpath = "//button[.='CONTACT DEALER']")//all sedan button
    public WebElement contactDealer;

    @FindBy(xpath = "//button[.='SEND INFO']")//all sedan button
    public WebElement sendInfo;

    @FindBy(xpath = "//input[@name='firstName']")//all sedan button
    public WebElement firstName;



    }

