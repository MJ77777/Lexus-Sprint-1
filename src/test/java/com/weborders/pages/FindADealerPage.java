package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindADealerPage {

  public FindADealerPage(){
    PageFactory.initElements(Driver.getDriver(), this);
  }

  @FindBy(xpath = "//input[@name='zipcode']")
  public WebElement zipCodeInput;

  @FindBy(xpath = "//div[@data-testid='DealerSearchTabs']//ul/li")
  public List<WebElement> dealerSearchTabs;

  public void zipCodeInputEnter(){
    zipCodeInput.sendKeys("22043" + Keys.ENTER);
  }
}
