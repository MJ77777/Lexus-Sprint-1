package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectedTechnologyPage {


    public ConnectedTechnologyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

        @FindBy(xpath = "//select[@name='model'][1]")
        public WebElement modelDropDown;

        @FindBy(xpath ="(//option[@value='GX 460'])[1]")
        public WebElement carModel;

        @FindBy(name="year")
        public WebElement yearDropDown;

        @FindBy(name="get-started")
        public WebElement getStartedButton;

        @FindBy(xpath ="(//p[@class='audio-multimedia-heading'])[1]")
        public WebElement text;

    @FindBy(xpath ="//html[@lang='en']")
    public WebElement window;

    @FindBy(xpath ="//article//h1[.='How does the navigation system work?']")
    public WebElement navigationGetText;





}
