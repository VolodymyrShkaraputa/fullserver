import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CheckManePage {
    private WebDriver driver;

    @Before
    public void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Wladimir\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fullserver.ru/");

    }

    @Test
    public void checkSearchField () {
        ManePage manePage = PageFactory.initElements(driver,ManePage.class);
        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        String  randomIpInManePage =  manePage.getRandomIpAddres();
        String getIpAddressInSearchPage = searchPage.getIpAddress();
        Assert.assertTrue(randomIpInManePage.contains(getIpAddressInSearchPage));

    }

    @Test
    public  void checkRedirects () {

        ManePage manePage = PageFactory.initElements(driver,ManePage.class);
        manePage.clickOnRulesButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("pages/rules.htm"));

        manePage.clickOnListingButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("listing"));

        manePage.clickOnBanlistButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("banlist"));

        manePage.clickOnFaqButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("faq.php"));

        manePage.clickOnLineVipButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("line_vip.php"));

        manePage.clickOnStatsButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("pages/stats.htm"));

        manePage.clickOnSupportButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("account/auth/"));

    }

    @After
    public void close () {
        driver.quit();
    }
}
