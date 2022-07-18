package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PerformancePage {
    public PerformancePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//a[.='SEE ALL MODELS']")
    public WebElement seeAllModels;
}