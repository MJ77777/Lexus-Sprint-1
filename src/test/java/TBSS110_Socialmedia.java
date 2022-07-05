import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TBSS110_Socialmedia extends BaseClass{



    @Test
        public void facebook123(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String FacebookUrl="https://www.facebook.com/lexus";
        driver.get("https://www.lexus.com/");
MJJ7Utility.jsClick(driver,driver.findElement(By.xpath("//a[@href='https://www.facebook.com/lexus']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);}
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            Assert.assertEquals(driver.getCurrentUrl(),FacebookUrl);

        }
    @Test
    public void twitter123(){
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String twitterUrl="https://twitter.com/lexus";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver,driver.findElement(By.xpath("//a[@href='https://twitter.com/lexus']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);}
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),twitterUrl);

    }
    @Test
    public void youtube123(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String youtubeUrl="https://www.youtube.com/Lexus";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver,driver.findElement(By.xpath("//a[@href='https://www.youtube.com/Lexus']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);}
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),youtubeUrl);

    }
    @Test
    public void instgram123(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String instgramUrl="https://www.instagram.com/lexususa/";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver,driver.findElement(By.xpath("//a[@href='http://instagram.com/lexususa']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);}
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),instgramUrl);

    }
    @Test
    public void pineterest123(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String pineterestUrl="https://www.pinterest.com/lexususa/";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver,driver.findElement(By.xpath("//a[@href='https://www.pinterest.com/lexususa']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);}
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),pineterestUrl);
//        Assert.assertTrue(driver.findElement(By.xpath("(//div[.='Lexus'])[3]")).isDisplayed());  // this another way to check by seeing if text is displayed

    }
    @Test
    public void tiktok123(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String tiktokUrl="https://www.tiktok.com/@lexususa";
        driver.get("https://www.lexus.com/");
        MJJ7Utility.jsClick(driver,driver.findElement(By.xpath("//a[@href='https://www.tiktok.com/@lexususa']")));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);}
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),tiktokUrl);

    }






}







