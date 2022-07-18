package com.weborders.pages;

import com.weborders.utilites.Driver;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LexusCollectionCartPage {
    public LexusCollectionCartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//input[@name='checkout'][@type='submit'])[1]")
    public WebElement topCheckoutButton;

    public static void waitForTopCheckoutButton(){
        SeleniumUtils.waitForVisibility(By.xpath("(//input[@name='checkout'][@type='submit'])[1]"), 5);
    }
}
