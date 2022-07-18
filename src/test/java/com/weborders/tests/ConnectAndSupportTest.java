package com.weborders.tests;
import com.weborders.pages.HomePage;
import com.weborders.pages.ConnectedTechnologyPage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;


public class ConnectAndSupportTest extends BaseClass{

    @Test(priority = 1)
    public void connected() throws InterruptedException {
     driver.get(ConfigReader.getProperty("url"));
    ((JavascriptExecutor) driver).executeScript("scroll(0, 1500);");

       HomePage connect = new HomePage();
       SeleniumUtils.jsClick( connect.connectButton);

        Set<String> windowHandles =driver.getWindowHandles();
        for (String windowHandle:windowHandles ) {
        driver.switchTo().window(windowHandle);
        List<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        Thread.sleep(3000);

            ConnectedTechnologyPage model= new ConnectedTechnologyPage();
            SeleniumUtils.jsClick(model.modelDropDown);
            SeleniumUtils.jsClick(model.carModel);

            SeleniumUtils.jsClick(model.yearDropDown);
            Select select3 = new Select(model.yearDropDown);
            select3.getFirstSelectedOption();
            SeleniumUtils.jsClick(model.getStartedButton);

            Thread.sleep(3000);
            String PageSource= driver.getPageSource();
            String expectedText= "GX 460";
            Assert.assertTrue(PageSource.contains(expectedText));

   }}

    @Test(priority = 2)
    public void roadsideAssistance() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1500);");

        HomePage roadside = new HomePage();
        SeleniumUtils.jsClick(roadside.roadsideButton);


        String url="https://support.lexus.com/s/article/What-is-Lexus-Roads";
        SeleniumUtils.switchToWindowContainUrl(url);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://support.lexus.com/s/article/What-is-Lexus-Roads"));

        Thread.sleep(3000);

        String PageSource= driver.getPageSource();
        String expectedText= "What is Lexus Roadside Assistance?";
        Assert.assertTrue(PageSource.contains(expectedText));

    }
    @Test(priority = 3)
    public void bluetooth() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");

        HomePage bluetooth = new HomePage();
        SeleniumUtils.jsClick(bluetooth.bluetoothButton);


            String url="https://support.lexus.com/s/article/How-do-I-pair-my-Blue";
            SeleniumUtils.switchToWindowContainUrl(url);
            Assert.assertTrue(driver.getCurrentUrl().contains("https://support.lexus.com/s/article/How-do-I-pair-my-Blue"));
            Thread.sleep(3000);

        String PageSource= driver.getPageSource();
        String expectedText= "How do I pair my Bluetooth® device with my vehicle?";
        Assert.assertTrue(PageSource.contains(expectedText));

    }
    @Test(priority = 4)
    public void navigation() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");
        HomePage navigate = new HomePage();
        SeleniumUtils.jsClick(navigate.navigationButton);

        Set<String> windowHandles =driver.getWindowHandles();
        for (String windowHandle:windowHandles ) {
         driver.switchTo().window(windowHandle);
            List<String> newTab = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(newTab.get(1));

         String PageSource= driver.getPageSource();
         String expectedText= "How does the navigation system work?";
ConnectedTechnologyPage connected=new ConnectedTechnologyPage();
         Assert.assertEquals(connected.navigationGetText.getText(),expectedText.toUpperCase());

            }}

    @Test(priority = 5)
    public void maintenance() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");

        HomePage maintain = new HomePage();
        SeleniumUtils.jsClick(maintain.maintenanceButton);


        String url="https://support.lexus.com/s/article/Whats-the-best-way";
        SeleniumUtils.switchToWindowContainUrl(url);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://support.lexus.com/s/article/Whats-the-best-way"));
        Thread.sleep(3000);

        String PageSource= driver.getPageSource();
        String expectedText= "What's the best way to take care of my Lexus?";
        Assert.assertTrue(PageSource.contains(expectedText));


}}
