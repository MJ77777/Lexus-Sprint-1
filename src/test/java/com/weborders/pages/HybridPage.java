package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HybridPage {
    public HybridPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="(//h3[.='THE LEXUS HYBRID ELECTRIC LINE'])[2]")
    public WebElement hybridText;

}