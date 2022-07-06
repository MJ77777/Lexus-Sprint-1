import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class UtilityE {
  public static void jsScrollTo(WebDriver driver, WebElement element){
    int y = element.getLocation().getY();
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, "+ y +")");
  }

  public static void explicitWaitUntilElementVisible(WebDriver driver, int seconds, By by){
    new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public static void explicitWaitUntilElementClickableWebElement(WebDriver driver, int seconds, WebElement element){
    new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void sendKeys(WebElement element, String keys){
    element.sendKeys(keys);
  }

  public static void explicitWaitUntilElementClickable(WebDriver driver, int seconds, By by){
    new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(by));
  }

  public static void changeWindow(WebDriver driver, Set<String> currentWindowHandles, String changeToWindow, boolean changeToGivenWindow){
    for(String windowHandle : currentWindowHandles){
      if(changeToGivenWindow && windowHandle.equals(changeToWindow)){
        driver.switchTo().window(windowHandle);
        break;
      }
      else if(!changeToGivenWindow && !windowHandle.equals(changeToWindow)){
        driver.switchTo().window(windowHandle);
        break;
      }
    }
  }
}
