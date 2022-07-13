package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExploreESPage {
    public ExploreESPage() {
        PageFactory.initElements(Driver.getDriver(), this);


    }
   @FindBy(xpath ="//a[@href='#model_styles']")
    public WebElement styleButton;


    @FindBy(xpath ="//h3[@letter-spacing='narrow'])[2]")
    public WebElement styleText;

    @FindBy(xpath ="//a[@href='#model_design']")
    public WebElement designButton;

    @FindBy(xpath ="")
    public WebElement designText;

    @FindBy(xpath ="//a[@href='#model_gallery']")
    public WebElement galleryButton;

    @FindBy(xpath ="")
    public WebElement galleryText;

    @FindBy(xpath ="//a[@href='#model_technology']")
    public WebElement technologyButton;

    @FindBy(xpath ="//h3[@letter-spacing='narrow'])[10]")
    public WebElement techText;


    @FindBy(xpath ="//input[@name='zip']")
    public WebElement zipcode;

    @FindBy(xpath ="https://www.lexus.com/build-your-lexus/#!/zip/22182/series/ES/year/2022/trim")
    public WebElement newWindow;

    @FindBy(xpath ="//img[@data-code='01L2']")//click on color
    public WebElement colorButton;

    @FindBy(xpath ="(//a[@role='button'])[3]")
    public WebElement interiorButton;

     @FindBy(xpath ="//img[@data-code='VL70']")//click on leather color
     public WebElement interiorColor;

     @FindBy(xpath =" (//a[@href='javascript: void(0)'])[8]")
     public WebElement PackagesButton;

     @FindBy(xpath =" (//a[@role='button'])[3]")
     public WebElement choisButton;

     @FindBy(xpath ="(//a[@role='button'])[14]")
     public WebElement accessoriesButton;

     @FindBy(xpath ="(//a[@role='button'])[6]")
     public WebElement chois2Button;


     @FindBy(xpath =" (//a[@href='javascript: void(0)'])[8]")//summary button
     public WebElement summary;





}