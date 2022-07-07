package com.weborders.tests;

import com.weborders.utilites.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)    public void setupClass() {
        WebDriverManager.chromedriver().setup();

    }


    @BeforeMethod (alwaysRun = true)

    public void setupMethod() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        Driver.quitDriver();

    }

}


