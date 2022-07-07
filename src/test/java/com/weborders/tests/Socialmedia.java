package com.weborders.tests;

import com.weborders.pages.Socialmediaoptions;
import com.weborders.utilites.ConfigReader;
import com.weborders.utilites.SeleniumUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.weborders.utilites.SeleniumUtils.switchToWindowByUrl;
import static com.weborders.utilites.SeleniumUtils.switchToWindowContainUrl;

public class Socialmedia extends BaseClass {

    @Test( groups = "smoke")
    public void faceBook123() {
        String faceURL = "https://www.facebook.com/lexus";
        driver.get(ConfigReader.getProperty("url"));
        Socialmediaoptions socialMedia = new Socialmediaoptions();
        SeleniumUtils.jsClick(socialMedia.facebook);
        switchToWindowByUrl(faceURL);
        Assert.assertEquals(driver.getCurrentUrl(), faceURL);

    }

    @Test( groups = "smoke")
    public void twitter123() {
        String twitUrl = "https://twitter.com/lexus";
        driver.get(ConfigReader.getProperty("url"));
        Socialmediaoptions socialMedia = new Socialmediaoptions();
        SeleniumUtils.jsClick(socialMedia.twitter);
        switchToWindowByUrl(twitUrl);
        Assert.assertEquals(driver.getCurrentUrl(), twitUrl);

    }

    @Test( groups = "smoke")
    public void youtube123() {
        String youUrl = "https://www.youtube.com/Lexus";
        driver.get(ConfigReader.getProperty("url"));
        Socialmediaoptions socialMedia = new Socialmediaoptions();
        SeleniumUtils.jsClick(socialMedia.youtube);
        switchToWindowByUrl(youUrl);
        Assert.assertEquals(driver.getCurrentUrl(), youUrl);

    }

    @Test( groups = "smoke")
    public void instgram123() {
        String instUrl = "instagram.com";
        driver.get(ConfigReader.getProperty("url"));
        Socialmediaoptions socialMedia = new Socialmediaoptions();
        SeleniumUtils.jsClick(socialMedia.instagram);
        switchToWindowContainUrl(instUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(instUrl));

    }

    @Test( groups = "smoke")
    public void pineterest123() {
        String pineUrl = "https://www.pinterest.com/lexususa/";
        driver.get(ConfigReader.getProperty("url"));
        Socialmediaoptions socialMedia = new Socialmediaoptions();
        SeleniumUtils.jsClick(socialMedia.pinterest);
        switchToWindowByUrl(pineUrl);
        Assert.assertEquals(driver.getCurrentUrl(), pineUrl);

    }

    @Test( groups = "smoke")
    public void tiktok123() {
        String tikUrl = "https://www.tiktok.com/@lexususa";
        driver.get(ConfigReader.getProperty("url"));
        Socialmediaoptions socialMedia = new Socialmediaoptions();
        SeleniumUtils.jsClick(socialMedia.tiktok);
        switchToWindowByUrl(tikUrl);
        Assert.assertEquals(driver.getCurrentUrl(), tikUrl);

    }


}







