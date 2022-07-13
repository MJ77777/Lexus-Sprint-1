package com.weborders.pages;

import com.weborders.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModelRZPage {
    public ModelRZPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href=\'/content/dam/lexus/documents/brochures/models/2023/MY23-Lexus-RZ-PreBrochure.pdf\']")
    public WebElement preOrderGuide;
}

