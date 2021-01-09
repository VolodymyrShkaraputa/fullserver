import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckPayment {
    private WebDriver driver;

    @Before
    public void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Wladimir\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fullserver.ru/account/auth/");
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.authorization();

    }

    @Test
    public void checkWmrPayment () throws InterruptedException{
        CabinetPage cabinetPage = PageFactory.initElements(driver,CabinetPage.class);
        cabinetPage.clickOnBalanceButton();
        CabinetBalancePage cabinetBalancePage = PageFactory.initElements(driver,CabinetBalancePage.class);
        cabinetBalancePage.checkWmrPayment();

    }

    @Test
    public void checkUnipayPayment () throws InterruptedException{
        CabinetPage cabinetPage = PageFactory.initElements(driver,CabinetPage.class);
        cabinetPage.clickOnBalanceButton();
        CabinetBalancePage cabinetBalancePage = PageFactory.initElements(driver,CabinetBalancePage.class);
        cabinetBalancePage.checkUnipayPayment();
    }


    @After
    public void close () {
        driver.quit();
    }
}
