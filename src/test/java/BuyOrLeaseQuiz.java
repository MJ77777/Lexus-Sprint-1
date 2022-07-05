import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuyOrLeaseQuiz extends BaseClass {

  @Test
  public void checkBuyOrLeaseQuiz(){
    driver.get("https://www.lexus.com");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    UtilityE.explicitWaitUntilElementVisible(driver, 20, By.xpath("//a[contains(@href, 'financing_options/buy_or_lease')]"));
    WebElement buyOrLeaseQuiz = driver.findElement(By.xpath("//a[contains(@href, 'financing_options/buy_or_lease')]"));
    UtilityE.jsScrollTo(driver, buyOrLeaseQuiz);
    UtilityE.explicitWaitUntilElementClickable(driver,20, By.xpath("//a[contains(@href, 'financing_options/buy_or_lease')]"));
    buyOrLeaseQuiz = driver.findElement(By.xpath("//a[contains(@href, 'financing_options/buy_or_lease')]")); // due to scroll event, the dom element gets deattached from the page, therefore assigning it again helps with this issue.
    String currentWindowHandle = driver.getWindowHandle();
    buyOrLeaseQuiz.click();

    UtilityE.changeWindow(driver, driver.getWindowHandles(), currentWindowHandle, false);

    UtilityE.explicitWaitUntilElementVisible(driver, 20, By.xpath("//div[@id='q1']//following-sibling::h4"));
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertEquals(currentURL, "https://www.lexusfinancial.com/us/en/financing_options/buy_or_lease.html");
    Assert.assertEquals(currentTitle, "Buy or Lease Quiz | Lexus Financial");

    WebElement questionOne = driver.findElement(By.xpath("//div[@id='q1']//following-sibling::h4"));
    Assert.assertEquals(questionOne.getText(), "QUESTION 1 OF 7");
  }
}
