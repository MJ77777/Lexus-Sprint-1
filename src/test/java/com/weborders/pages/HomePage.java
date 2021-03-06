package com.weborders.pages;

import com.weborders.utilites.Driver;
import com.weborders.utilites.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);


    }

    @FindBy(xpath = "(//a[@href='/motorsports'][contains(text(), 'LEARN MORE')])[1]")
    public WebElement motorSportsElement;

    @FindBy(xpath = "//div[@id='content-grid']/h3[contains(text(), 'LEXUS OWNERSHIP')]/following-sibling::div/div")
    public List<WebElement> lexusOwnershipDivs;

    @FindBy(xpath = "//div[@id='content-grid']/div//h3[contains(text(), 'OWNER RESOURCES AND BENEFITS')]/following-sibling::div/a")
    public WebElement ownerResourcesLearnMoreButton;

    @FindBy(xpath = "//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='SHOP PARTS']")
    public WebElement shopParts;
    @FindBy(xpath = "//a[.=contains(text(), 'ROADSIDE ASSISTANCE')]")
    public WebElement roadsideAssistance;
    @FindBy(xpath = "//div[@data-testid='GlobalFooterCategoryLinks']//a[@aria-label='FIND A DEALER']")
    public WebElement findADealer;

    @FindBy(xpath="//a[@href='/about']")
    public WebElement aboutUsElement;

    @FindBy(xpath="//a[contains(@href, 'financing_options/buy_or_lease')]")
    public WebElement buyOrLeaseQuizElement;


    @FindBy(xpath = "//a[@href='https://www.facebook.com/lexus']")//Facebook
    public WebElement facebook;

    @FindBy(xpath = "//a[@href='https://twitter.com/lexus']")//twitter
    public WebElement twitter;

    @FindBy(xpath = "//a[@href='https://www.youtube.com/Lexus']")//youtube
    public WebElement youtube;

    @FindBy(xpath = "//a[@href='http://instagram.com/lexususa']")//instagram
    public WebElement instagram;

    @FindBy(xpath = "//a[@href='https://www.pinterest.com/lexususa']")//pinterest
    public WebElement pinterest;

    @FindBy(xpath = "//a[@href='https://www.tiktok.com/@lexususa']")//tiktok
    public WebElement tiktok;

    @FindBy(xpath ="//a[@href='/models/ES']")//EXPLORE
    public WebElement explore;

    @FindBy(xpath ="(//a[@data-testid='LexusButton'])[5]")//Build
    public WebElement build;

    @FindBy(xpath = "//input[@name=\"zipcode\"]") // enterZipCode - Sabina
    public WebElement enterZipCode;

    @FindBy(xpath = ("//a[@href=\"/build-your-lexus/#!/\"]")) // buildLexus - Sabina
    public WebElement buildLexus;

    @FindBy(xpath = ("//div[@id='quick-links']/div/a[@href='/dealers']")) //dealers - Sabina
    public WebElement dealers;

    @FindBy(xpath = ("//*[@id=\"quick-links\"]/div/a[3]")) //offers - Sabina
    public WebElement offers;

    @FindBy(xpath = "//a[@href='/models/LC-convertible?link[model_overlay_lcc_inspiration_series][SHOW_PAGE]=true']")
    public WebElement LCConvertable; // - Sabina

    @FindBy(xpath = "//a[@href='models/RCF']")
    public WebElement RCFFuji; // - Sabina

    @FindBy(xpath = "//a[@href='/newrx']")
    public WebElement newrx; // - Sabina

    @FindBy(xpath = "//a[@href='/future/rz']")
    public WebElement rz450; // - Sabina

    @FindBy(xpath = "//div[@id='content-grid']")
    public WebElement LEM; // - Sabina

    @FindBy(xpath = "//div//a[@href='/offers']")//view all offers option
    public WebElement viewAllOffers;

    @FindBy(xpath = "//a[.='LEXUS PERFORMANCE']")//view all offers option
    public WebElement performanceFooter;

    @FindBy(xpath = "//a[.='MOTORSPORTS']")//view all offers option
    public WebElement motorFooter;

    @FindBy(xpath = "//a[.='SAFETY TECHNOLOGY']")//view all offers option
    public WebElement safetyFooter;

    @FindBy(xpath = "//a[.='LEXUS HYBRID & ELECTRIC']")//view all offers option
    public WebElement hybridElectricFooter;

    @FindBy(xpath = "//a[.='LEXUS ELECTRIFIED']")//view all offers option
    public WebElement electrifiedFooter;








    @FindBy(xpath ="//a[@aria-label='CONNECTED TECHNOLOGY']")
            public WebElement connectButton;
    @FindBy(xpath ="//a[@aria-label='ROADSIDE ASSISTANCE']")
    public WebElement roadsideButton;

    @FindBy(xpath ="//a[@aria-label='BLUETOOTH']")
    public WebElement bluetoothButton;

    @FindBy(xpath ="//a[@aria-label='NAVIGATION']")
    public WebElement navigationButton;

    @FindBy(xpath ="//a[@aria-label='MAINTENANCE']")
    public WebElement maintenanceButton;
    @FindBy(xpath = "(//a[@href=\"https://www.thelexuscollection.com/\"])[3]")
    public WebElement exploreCollections; // Sabina

    public static void waitForMotorSportsElementVisibility(){
        SeleniumUtils.waitForVisibility(By.xpath("(//a[@href='/motorsports'][contains(text(), 'LEARN MORE')])[1]"), 5);
    }


}
