package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyOrLeaseQuizPage {

  public BuyOrLeaseQuizPage(){
    PageFactory.initElements(Driver.getDriver(), this);
  }

  @FindBy(xpath = "//div[@id='q1']//following-sibling::h4")
  public WebElement questionOne;
}
