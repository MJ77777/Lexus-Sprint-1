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

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();

    }


    @BeforeMethod (alwaysRun = true)

    public void setupMethod() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}


