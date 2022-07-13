package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModelRCFPage {

    public ModelRCFPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//a[@id=\"model_message_bar\"]")
    public WebElement StayInformed;

    @FindBy(xpath ="//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath ="//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath ="//input[@name='email']")
    public WebElement email;

    @FindBy(xpath ="//input[@name='zip']")
    public WebElement zipCode;

    @FindBy(xpath = "//*[@id=\"LexusForm\"]/div/form/div[6]/label/div[2]/div[1]")
    public WebElement RCFOption;

    @FindBy(xpath = "//button[@aria-label=\"SUBMIT\"]")
    public WebElement submitButton;

}
