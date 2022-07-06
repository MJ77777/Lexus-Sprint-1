import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RoadsideAssistance extends BaseClass{

  @Test
  public void checkRoadsideAssistance() {
    driver.get("https://www.lexus.com");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    UtilityE.explicitWaitUntilElementVisible(driver,20, By.xpath("//a[.=contains(text(), 'ROADSIDE ASSISTANCE')]"));
    WebElement roadsideAssistance = driver.findElement(By.xpath("//a[.=contains(text(), 'ROADSIDE ASSISTANCE')]"));
    UtilityE.jsScrollTo(driver, roadsideAssistance);
    UtilityE.explicitWaitUntilElementClickable(driver,20, By.xpath("//a[.=contains(text(), 'ROADSIDE ASSISTANCE')]"));
    roadsideAssistance = driver.findElement(By.xpath("//a[.=contains(text(), 'ROADSIDE ASSISTANCE')]")); // due to scroll event, the dom element gets deattached from the page, therefore assigning it again helps with this issue.
    String currentWindowHandle = driver.getWindowHandle();
    roadsideAssistance.click();

    UtilityE.changeWindow(driver, driver.getWindowHandles(), currentWindowHandle, false);

    UtilityE.explicitWaitUntilElementVisible(driver,20, By.xpath("//h1[contains(text(), 'Lexus Roadside Assistance')]"));
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertTrue(currentURL.contains("What-is-Lexus-Roadsid"));
    Assert.assertEquals(currentTitle, "What is Lexus Roadside Assistance?");
    String pageContent = driver.getPageSource();
    Assert.assertTrue(pageContent.contains("What is Lexus Roadside Assistance?"));
  }
}
