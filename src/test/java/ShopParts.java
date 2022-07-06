import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShopParts extends BaseClass {

  @Test
  public void shopPartsCheck(){
    driver.get("https://www.lexus.com");
    String searchInputPlaceholder = "Search by Keywords, Part Numbers or Full VIN";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// for explicit wait
    UtilityE.explicitWaitUntilElementVisible(driver,20, By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='SHOP PARTS']"));
    WebElement aboutUsElement = driver.findElement(By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='SHOP PARTS']"));
    UtilityE.jsScrollTo(driver, aboutUsElement);
    UtilityE.explicitWaitUntilElementClickable(driver,20, By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='SHOP PARTS']"));
    aboutUsElement = driver.findElement(By.xpath("//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='SHOP PARTS']")); // due to scroll event, the dom element gets deattached from the page, therefore assigning it again helps with this issue.
    aboutUsElement.click();

    UtilityE.explicitWaitUntilElementVisible(driver,20, By.xpath("//input[@id='SearchInput']"));
    String currentURL = driver.getCurrentUrl();
    String currentTitle = driver.getTitle();
    Assert.assertTrue(currentURL.contains("https://parts.lexus.com"));
    Assert.assertEquals(currentTitle, "Shop Lexus Parts and Accessories Online");
    String searchInput = driver.findElement(By.xpath("//input[@id='SearchInput']")).getAttribute("placeholder");
    Assert.assertEquals(searchInput, searchInputPlaceholder);
  }
}
