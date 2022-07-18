package com.weborders.tests;

import com.weborders.pages.HomePage;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static com.weborders.utilites.SeleniumUtils.switchToWindowByUrl;
import static com.weborders.utilites.SeleniumUtils.switchToWindowContainUrl;

public class SocialmediaTest extends BaseClass {

    @Test(groups = "smoke")
    public void faceBook123() throws InterruptedException {
        String faceURL = "https://www.facebook.com/lexus";
        driver.get(ConfigReader.getProperty("url"));
        HomePage socialMedia = new HomePage();
        SeleniumUtils.jsClick(socialMedia.facebook);
        SeleniumUtils.waitFor(3);
        switchToWindowContainUrl(faceURL);
        Assert.assertEquals(driver.getCurrentUrl(), faceURL);

    }

    @Test(groups = "smoke")
    public void twitter123() throws InterruptedException {
        String twitUrl = "https://twitter.com/lexus";
        driver.get(ConfigReader.getProperty("url"));
        HomePage socialMedia = new HomePage();
        SeleniumUtils.jsClick(socialMedia.twitter);
        SeleniumUtils.waitFor(3);
        switchToWindowContainUrl(twitUrl);
        Assert.assertEquals(driver.getCurrentUrl(), twitUrl);
//throw new SkipException("2");
    }

    @Test(groups = "smoke")
    public void youtube123() {
        String youUrl = "https://www.youtube.com/Lexus";
        driver.get(ConfigReader.getProperty("url"));
        HomePage socialMedia = new HomePage();
        SeleniumUtils.jsClick(socialMedia.youtube);
        SeleniumUtils.waitFor(3);
        switchToWindowContainUrl(youUrl);
        Assert.assertEquals(driver.getCurrentUrl(), youUrl);

    }

    @Test(groups = "smoke")
    public void instgram123() {
        String instUrl = "instagram.com";
        driver.get(ConfigReader.getProperty("url"));
        HomePage socialMedia = new HomePage();
        SeleniumUtils.jsClick(socialMedia.instagram);
        SeleniumUtils.waitFor(3);
        switchToWindowContainUrl(instUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(instUrl));

    }

    @Test(groups = "smoke")
    public void pineterest123() {
        String pineUrl = "https://www.pinterest.com/lexususa/";
        driver.get(ConfigReader.getProperty("url"));
        HomePage socialMedia = new HomePage();
        SeleniumUtils.jsClick(socialMedia.pinterest);
        SeleniumUtils.waitFor(3);
        switchToWindowContainUrl(pineUrl);
        Assert.assertEquals(driver.getCurrentUrl(), pineUrl);

    }

    @Test(groups = "smoke")
    public void tiktok123() {
        String tikUrl = "https://www.tiktok.com/@lexususa";
        driver.get(ConfigReader.getProperty("url"));
        HomePage socialMedia = new HomePage();
        SeleniumUtils.jsClick(socialMedia.tiktok);
        SeleniumUtils.waitFor(3);
        switchToWindowContainUrl(tikUrl);
        Assert.assertEquals(driver.getCurrentUrl(), tikUrl);

    }


}







