package com.weborders.tests;

import com.weborders.pages.ExploreESPage;
import com.weborders.pages.HomePage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.weborders.utilites.SeleniumUtils.switchToWindowByUrl;

public class LaraTest2 extends BaseClass  {

    @Test(priority = 1)
    public void Style() {
        driver.get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");
        HomePage homepage= new HomePage();
        SeleniumUtils.jsClick(homepage.explore);
        ExploreESPage es =new ExploreESPage();
        SeleniumUtils.jsClick(es.styleButton);

        String PageSource= driver.getPageSource();
        String expectedText= "STYLES";
        Assert.assertTrue(PageSource.contains(expectedText));

    }

    @Test(priority = 2)
    public void Design() {
        driver.get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");
        HomePage homepage = new HomePage();
        SeleniumUtils.jsClick(homepage.explore);
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");
        ExploreESPage design = new ExploreESPage();
        SeleniumUtils.jsClick(design.designButton);

        String PageSource = driver.getPageSource();
        String expectedText = "DESIGN";
        Assert.assertTrue(PageSource.contains(expectedText));
    }

    @Test(priority = 3)
    public void Gallery() {
        driver.get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");
        HomePage homepage = new HomePage();
        SeleniumUtils.jsClick(homepage.explore);
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");
        ExploreESPage gallery = new ExploreESPage();
        SeleniumUtils.jsClick(gallery.galleryButton);

        String PageSource = driver.getPageSource();
        String expectedText = "GALLERY";
        Assert.assertTrue(PageSource.contains(expectedText));

    }

    @Test(priority = 4)
    public void Technology() {
        driver.get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");
        HomePage homepage= new HomePage();
        SeleniumUtils.jsClick(homepage.explore);
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");
        ExploreESPage technology =new ExploreESPage();
        SeleniumUtils.jsClick(technology.technologyButton);

        String PageSource= driver.getPageSource();
        String expectedText= "TECHNOLOGY";
        Assert.assertTrue(PageSource.contains(expectedText));

    }

    @Test(priority = 5)
    public void Build() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1000);");
        HomePage homepage= new HomePage();
        SeleniumUtils.jsClick(homepage.build);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("22182"+ Keys.ENTER);

        WebDriverWait S=new WebDriverWait(driver, Duration.ofSeconds(5));
        S.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//span[@class='list-title'])[1]"))));

         switchToWindowByUrl( "https://www.lexus.com/build-your-lexus/#!/zip/22182/series/ES/year/2022/trim");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[@class='list-title'])[1]")));

        ExploreESPage es =new ExploreESPage();
        SeleniumUtils.jsClick(es.colorButton);

        SeleniumUtils.jsClick(es.interiorButton);

        SeleniumUtils.jsClick(es.interiorColor);

        SeleniumUtils.jsClick(es.PackagesButton);

        SeleniumUtils.jsClick(es.choisButton);

        SeleniumUtils.jsClick(es.accessoriesButton);

        SeleniumUtils.jsClick(es.chois2Button);

        SeleniumUtils.jsClick(es.summary);
        Thread.sleep(3000);

        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle= "Build Your Own Lexus | Lexus Configurator";
        Assert.assertEquals(actualTitle,expectedTitle);

   }}