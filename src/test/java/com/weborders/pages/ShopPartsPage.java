package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPartsPage {
  public ShopPartsPage(){
    PageFactory.initElements(Driver.getDriver(), this);
  }

  @FindBy(xpath="//input[@id='SearchInput']")
  public WebElement shopPartsInput;
}
