import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class topBar extends BaseClass {
    @Test(priority = 1)
    public void SEDAN() {
        String[] carModels={"IS",  "IS 500", "ES","ES HYBRID",  "LS",   "LS HYBRID"};
        driver.get("https://www.lexus.com");
        Actions actions = new Actions(driver);
        WebElement first = driver.findElement(By.xpath("//button[@data-testid='Typography'][1]"));
        actions.moveToElement(first).perform();

       // System.out.println("Done Mouse hover on 'SEDAN' from TopBar");
        System.out.println(first.getText());

        Actions actions2 = new Actions(driver);
        WebElement first1 = driver.findElement(By.xpath("//h2[@data-testid='Typography']"));
        actions2.moveToElement(first1).perform();

        List<WebElement> models = driver.findElements(By.xpath("//h2[@data-testid='Typography']"));
        for(int i=0;i<models.size();i++){
            Assert.assertEquals(models.get(i).getText(),carModels[i]);
        }}

        @Test(priority = 2)
        public void SUV () {
            String[] carModels={"UX","UX HYBRID" ,"NX" ,"NX HYBRID" ,"NX PLUG-IN HYBRID ELECTRIC VEHICLE","RX","RX HYBRID","GX","LX"};

            driver.get("https://www.lexus.com");
            Actions actions = new Actions(driver);
            WebElement second = driver.findElement(By.xpath("//button[@data-testid='Typography'][2]"));
            actions.moveToElement(second).perform();
            System.out.println("Done Mouse hover on 'SUV' from TopBar");
            System.out.println(second.getText());

            Actions actions2 = new Actions(driver);
            WebElement second1 = driver.findElement(By.xpath("//h2[@data-testid='Typography']"));
            actions2.moveToElement(second1).perform();

            List<WebElement> models = driver.findElements(By.xpath("//h2[@data-testid='Typography']"));
            for(int i=0;i<models.size();i++){
            Assert.assertEquals(models.get(i).getText(),carModels[i]);




           }}
        @Test(priority = 3)
        public void COUPE () {
            String[] carModels={"RC","RC F", "LC","LC HYBRID","LC CONVERTIBLE"};
            driver.get("https://www.lexus.com");
            Actions actions = new Actions(driver);
            WebElement third = driver.findElement(By.xpath("//button[@data-testid='Typography'][3]"));
            actions.moveToElement(third).perform();
            System.out.println("Done Mouse hover on 'COUPE' from TopBar");
            System.out.println(third.getText());

            Actions actions2 = new Actions(driver);
            WebElement third1 = driver.findElement(By.xpath("//h2[@data-testid='Typography']"));
            actions2.moveToElement(third1).perform();

            List<WebElement> models = driver.findElements(By.xpath("//h2[@data-testid='Typography']"));
            for(int i=0;i<models.size();i++){
                Assert.assertEquals(models.get(i).getText(),carModels[i]);

            }}

        @Test(priority = 4)
        public void HYBRIDANDELECTRIC () {
            String[] carModels={"UX HYBRID", "NX HYBRID", "NX PLUG-IN HYBRID ELECTRIC VEHICLE","RX HYBRID","ES HYBRID", "LS HYBRID","LC HYBRID"};
            driver.get("https://www.lexus.com");
            Actions actions = new Actions(driver);
            WebElement fourth = driver.findElement(By.xpath("//button[@data-testid='Typography'][4]"));
            actions.moveToElement(fourth).perform();
            System.out.println("Done Mouse hover on 'HYBRID & ELECTRIC' from TopBar");
            System.out.println(fourth.getText());

            Actions actions2 = new Actions(driver);
            WebElement fourth1 = driver.findElement(By.xpath("//h2[@data-testid='Typography']"));
            actions2.moveToElement(fourth1).perform();

            List<WebElement> models = driver.findElements(By.xpath("//h2[@data-testid='Typography']"));
            for(int i=0;i<models.size();i++){
                Assert.assertEquals(models.get(i).getText(),carModels[i]);


            }
        }

        @Test(priority = 5)
        public void PERFPRMANCE () {
            String[] carModels={"IS 500","RC F", "LC","LC HYBRID","LC CONVERTIBLE","PERFORMANCE"};
            driver.get("https://www.lexus.com");
            Actions actions = new Actions(driver);
            WebElement fifth = driver.findElement(By.xpath("//button[@data-testid='Typography'][5]"));
            actions.moveToElement(fifth).perform();
            System.out.println("Done Mouse hover on 'PERFPRMANCE' from TopBar");
            System.out.println(fifth.getText());

            Actions actions2 = new Actions(driver);
            WebElement fifth1 = driver.findElement(By.xpath("//h2[@data-testid='Typography']"));
            actions2.moveToElement(fifth1).perform();

            List<WebElement> models = driver.findElements(By.xpath("//h2[@data-testid='Typography']"));
            for(int i=0;i<models.size();i++){
                Assert.assertEquals(models.get(i).getText(),carModels[i]);

            }
        }
    @Test(priority = 6)
    public void FUTURE () {
        String[] carModels={"2023 RX",  "RZ 450e", "LEXUS ELECTRIFIED"};
        driver.get("https://www.lexus.com");
        Actions actions = new Actions(driver);
        WebElement sixth = driver.findElement(By.xpath("//button[@data-testid='Typography'][6]"));
        actions.moveToElement(sixth).perform();
        System.out.println("Done Mouse hover on 'FUTURE' from TopBar");
        System.out.println(sixth.getText());

        Actions actions2 = new Actions(driver);
        WebElement sixth1 = driver.findElement(By.xpath("//h2[@data-testid='Typography']"));
        actions2.moveToElement(sixth1).perform();

        List<WebElement> models = driver.findElements(By.xpath("//h2[@data-testid='Typography']"));
        for(int i=0;i<models.size();i++){
            Assert.assertEquals(models.get(i).getText(),carModels[i]);

        }}}
