import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class CheckRecoveryForm {

    private WebDriver driver;

    @Before
    public void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Wladimir\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fullserver.ru/account/recovery/");

    }

    @Test
    public void checkSuccsesRecovery() {
        RecoveryPage recoveryPage = PageFactory.initElements(driver,RecoveryPage.class);
        recoveryPage.setEmailForm("test");
        recoveryPage.clickOnSubmitButton();
        Assert.assertTrue(recoveryPage.checkPopupMessageSuccess());
    }

    @Test
    public  void checkWithNotFoundUser () {
        RecoveryPage recoveryPage = PageFactory.initElements(driver,RecoveryPage.class);
        recoveryPage.setEmailForm("sdfsdfsd");
        recoveryPage.clickOnSubmitButton();
        Assert.assertTrue(recoveryPage.checkWithUserNotFound());
    }

    @Test
    public void checkWithEmptyField () {
        RecoveryPage recoveryPage = PageFactory.initElements(driver,RecoveryPage.class);
        recoveryPage.setEmailForm("");
        recoveryPage.clickOnSubmitButton();
        Assert.assertTrue(recoveryPage.checkWithEmptyEmailField());
    }

    @After
    public void close () {
        driver.quit();
    }

}
