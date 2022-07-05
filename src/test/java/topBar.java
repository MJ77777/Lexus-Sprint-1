import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class topBar extends BaseClass {
    @Test(priority = 1)
    public void SEDAN() {
        driver.get("https://www.lexus.com");
        Actions actions = new Actions(driver);
        WebElement SEDAN = driver.findElement(By.xpath("//button[@data-testid='Typography'][1]"));
        actions.moveToElement(SEDAN).perform();
        System.out.println("Done Mouse hover on 'SEDAN' from TopBar");

        Select select1 = new Select(driver.findElement(By.id("//button[@data-testid='Typography'][1]")));
        WebElement firstAppear1 = select1.getFirstSelectedOption();
        Assert.assertEquals(firstAppear1.getText(), "SUV");
        List<WebElement> options = select1.getOptions();
        List<String> choises = new ArrayList<>();
        for (WebElement option : options) {
            choises.add(option.getText());
        }}}
//        WebElement hoverList = driver.findElement(By.xpath(""));
//        driver.switchTo().frame( hoverList);
//        List<WebElement> models = driver.findElement(By.xpath(""));
//        for (WebElement model : models) {
//            //String carModels=model.getText()
//            System.out.println(model.getText());
//            Assert.assertTrue(model.isDisplayed());




//    @Test(priority = 2)
//    public void SUV() {
//        driver.get("https://www.lexus.com");
//        Actions actions = new Actions(driver);
//        WebElement SUV = driver.findElement(By.xpath("//button[@data-testid='Typography'][2]"));
//        actions.moveToElement(SUV).perform();
//        System.out.println("Done Mouse hover on 'SUV' from TopBar");
//
//        List<WebElement> models = driver.findElements(By.xpath("//a[@href='/models/UX']"));
//
//        for (WebElement model : models) {
//            //String carModels = model.getText();
//           // System.out.println(carModels);
//            //Assert.assertEquals(model.isDisplayed());
//
//        }
//    }
//
//    @Test(priority = 3)
//    public void COUPE() {
//        driver.get("https://www.lexus.com");
//        Actions actions = new Actions(driver);
//        WebElement COUPE = driver.findElement(By.xpath("//button[@data-testid='Typography'][3]"));
//        actions.moveToElement(COUPE).perform();
//        System.out.println("Done Mouse hover on 'COUPE' from TopBar");
//
//        List<WebElement> models = driver.findElements(By.xpath("//a[@href='/models/RC']"));
//        for (WebElement model : models) {
//            String carModels = model.getText();
//            System.out.println(carModels);
//            Assert.assertTrue(model.isDisplayed());
//
//        }
//    }
//
//    @Test(priority = 4)
//    public void HYBRIDANDELECTRIC() {
//        driver.get("https://www.lexus.com");
//        Actions actions = new Actions(driver);
//        WebElement HYBRIDANDELECTRIC = driver.findElement(By.xpath("//button[@data-testid='Typography'][4]"));
//        actions.moveToElement(HYBRIDANDELECTRIC).perform();
//        System.out.println("Done Mouse hover on 'HYBRID & ELECTRIC' from TopBar");
//
//        List<WebElement> models = driver.findElements(By.xpath("//a[@href='/models/UX-hybrid']"));
//        for (WebElement model : models) {
//            String carModels = model.getText();
//            System.out.println(carModels);
//            Assert.assertTrue(model.isDisplayed());
//
//        }
//    }
//
//    @Test(priority = 5)
//    public void PERFPRMANCE() {
//        driver.get("https://www.lexus.com");
//        Actions actions = new Actions(driver);
//        WebElement PERFPRMANCE = driver.findElement(By.xpath("//button[@data-testid='Typography'][5]"));
//        actions.moveToElement(PERFPRMANCE).perform();
//        System.out.println("Done Mouse hover on 'PERFPRMANCE' from TopBar");
//
//        List<WebElement> models = driver.findElements(By.xpath("(//h2[@data-testid='Typography'])[1]"));
//        for (WebElement model : models) {
//            String carModels = model.getText();
//            System.out.println(carModels);
//            //Assert.assertTrue(model.isDisplayed());
//        }
//    }
//}
