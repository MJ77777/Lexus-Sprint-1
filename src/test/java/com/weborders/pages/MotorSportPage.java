package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MotorSportPage {
    public MotorSportPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(xpath="(//a[.='RACE RESULTS'])[3]")
        public WebElement raceResultOption;

}
