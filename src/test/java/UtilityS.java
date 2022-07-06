import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilityS {

    public static void jsScrollTo(WebDriver driver, WebElement element){
        int y = element.getLocation().getY();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+y+")");
    }
    public static void explicitWaitUntilElementClickable(WebDriver driver, int seconds, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
    }
    static void jsClick(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
