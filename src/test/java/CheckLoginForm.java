import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CheckLoginForm {

    private WebDriver driver;


    @Before
    public  void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Volodymyr\\IdeaProjects\\Studing\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fullserver.ru/");

    }

    @Test
    public void checkWrongAuthorization () throws InterruptedException {

        ManePage manePage = PageFactory.initElements(driver,ManePage.class);
        manePage.clickOnLoginButton();
        LoginPage loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.setParametersForAuthorization("test","test");
        Assert.assertTrue(loginPage.getTexterorPopupWrongAvtorization());

    }

    @Test
    public void checkWithSuccessfulauthorization ()  throws InterruptedException{
        ManePage manePage = PageFactory.initElements(driver,ManePage.class);
        manePage.clickOnLoginButton();
        LoginPage loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.setParametersForAuthorization("ZeddFox","123555");
        CabinetPage cabinetPage = PageFactory.initElements(driver,CabinetPage.class);
        sleep(3000);
        Assert.assertTrue(cabinetPage.CheckPersonalUserAccountText());

    }

    @Test
    public void checkWithEmptyFields () throws  InterruptedException {
        ManePage manePage = PageFactory.initElements(driver,ManePage.class);
        manePage.clickOnLoginButton();
        LoginPage loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.setParametersForAuthorization("","");
        sleep(1000);
        Assert.assertTrue(loginPage.checkErrorSetUserLogin());
    }


    @After
    public void close () {
        driver.quit();
    }
}
