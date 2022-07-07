package com.weborders.tests;

import com.weborders.utilites.MJJ7Utility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Socialmedia extends BaseClass {

    @Test(priority = 1)
    public void faceBook123() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String facebookUrl = "https://www.facebook.com/lexus";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver, driver.findElement(By.xpath("//a[@href='https://www.facebook.com/lexus']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertEquals(driver.getCurrentUrl(), facebookUrl);

    }

    @Test(priority = 2,groups = "smoke")
    public void twitter123() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String twitterUrl = "https://twitter.com/lexus";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver, driver.findElement(By.xpath("//a[@href='https://twitter.com/lexus']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertEquals(driver.getCurrentUrl(), twitterUrl);

    }

    @Test(priority = 3,groups = "smoke")
    public void youtube123() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String youtubeUrl = "https://www.youtube.com/Lexus";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver, driver.findElement(By.xpath("//a[@href='https://www.youtube.com/Lexus']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertEquals(driver.getCurrentUrl(), youtubeUrl);

    }

    @Test(priority = 4,groups = "smoke")
    public void instgram123() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String instgramUrl = "https://www.instagram.com";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver, driver.findElement(By.xpath("//a[@href='http://instagram.com/lexususa']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains(instgramUrl));

    }

    @Test(priority = 5,groups = "smoke")
    public void pineterest123() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String pineterestUrl = "https://www.pinterest.com/lexususa/";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver, driver.findElement(By.xpath("//a[@href='https://www.pinterest.com/lexususa']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertEquals(driver.getCurrentUrl(), pineterestUrl);
//        Assert.assertTrue(driver.findElement(By.xpath("(//div[.='Lexus'])[3]")).isDisplayed());  // this another way to check by seeing if text is displayed

    }

    @Test(priority = 6,groups = "smoke")
    public void tiktok123() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String tiktokUrl = "https://www.tiktok.com/@lexususa";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver, driver.findElement(By.xpath("//a[@href='https://www.tiktok.com/@lexususa']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertEquals(driver.getCurrentUrl(), tiktokUrl);

    }


}







