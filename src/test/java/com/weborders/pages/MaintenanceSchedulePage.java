package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MaintenanceSchedulePage {

    public MaintenanceSchedulePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@id='nav-bar-selectVehicle-tab']")
    public WebElement navBarSelectVehicle;

    @FindBy(xpath = "//select[@id='m-selector']")
    public WebElement vehicleSelect;

    @FindBy(xpath = "//select[@id='yr-selector']")
    public WebElement yearSelect;

    @FindBy(xpath = "//input[@value='SUBMIT']")
    public WebElement submitButton;

    @FindBy(xpath = "//p[@class='main-error']")
    public WebElement errorResultMessage;

    @FindBy(xpath = "//label[contains(text(), 'Model / Year')]//following-sibling::span")
    public WebElement foundModelYearCombination;



    public void vehicleSelectValue(String vehicle){
        new Select(vehicleSelect).selectByValue(vehicle);
    }

    public void yearSelectValue(String year){
        new Select(yearSelect).selectByValue(year);
    }

}
