package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CollectionPage {
    public CollectionPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@href='/products?s%5Bf%5D%5Bc%5D%5B%5D=%2FApparel']")
    public WebElement apparel;

    @FindBy (xpath = "//a[@href='/products/756696']")
    public WebElement hoodie;

    @FindBy (xpath = "//input[@name='product[grid][18330918][18330921][quantity]']")
    public WebElement quantityInputSm;

    @FindBy(xpath = "//div[@id='category-navigation']")
    public List<WebElement> productTypeList;

    @FindBy(xpath = "//a[@href=\'/\']")
    public WebElement loqo;











}