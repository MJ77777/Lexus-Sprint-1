package com.weborders.pages;

import com.weborders.utilites.Driver;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LexusCollectionProductPage {
    public LexusCollectionProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(@class, 'notification-error')]")
    public WebElement errorNotification;

    @FindBy(xpath = "//input[@name='add_to_cart']")
    public WebElement addToCardButton;

    @FindBy(id = "stock")
    public WebElement inStockCount;
    @FindBy(xpath = "//input[@data-type='quantity']")
    public WebElement productQuantityInput;

    @FindBy(xpath = "//th[contains(text(), 'item price:')]//following-sibling::td")
    public WebElement itemPrice;

    @FindBy(xpath = "//tr[@class='total']//following-sibling::td")
    public WebElement total;

    public static void waitForProductQuantityInput(){
        SeleniumUtils.waitForVisibility(By.xpath("//input[@data-type='quantity']"), 5);
    }

    public static void waitForErrorNotification(){
        SeleniumUtils.waitForVisibility(By.xpath("//div[contains(@class, 'notification-error')]"), 5);
    }

    public static void waitForTotal(){
        SeleniumUtils.waitForVisibility(By.xpath("//tr[@class='total']"), 5);
    }

    public static void waitForInStock() { SeleniumUtils.waitForVisibility(By.id("stock"), 5); }

    public void setProductQuantity(int quantity){
        productQuantityInput.clear();
        productQuantityInput.sendKeys(quantity+"");
    }

    public int getInStockCount(){
        waitForInStock();
        return Integer.parseInt(inStockCount.getText().split(" ")[0]);
    }

    public boolean isErrorNotificationDisplayed(){
        return errorNotification.isDisplayed();
    }

    public boolean itemPriceAndTotalMatching(){
        waitForTotal();
        double itemPriceLocal = Double.parseDouble(itemPrice.getText().trim().replace("$", "").replace(",", "")) * (getInStockCount() - 1);
        double totalLocal = Double.parseDouble(total.getText().trim().replace("$", "").replace(",", ""));
        return itemPriceLocal == totalLocal;
    }

}
