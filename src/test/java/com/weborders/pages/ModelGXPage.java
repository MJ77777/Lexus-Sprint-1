package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModelGXPage {
    public ModelGXPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/content/dam/lexus/documents/brochures/special-edition/2022/2022_Lexus_GX460BlackLine.pdf']")
    public WebElement pressReleaseGX;
}

