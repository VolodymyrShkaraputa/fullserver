import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckAddAndRemoveServer {

    private WebDriver driver;

    @Before
    public void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Volodymyr\\IdeaProjects\\Studing\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fullserver.ru/account/auth/");
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.authorization();
    }

    @Test
    public void checkAddNewServer () throws InterruptedException {
        CabinetPage cabinetPage = PageFactory.initElements(driver,CabinetPage.class);
        cabinetPage.checkAddNewServer();

    }

    @Test
    public void checkRemoveServer () throws  InterruptedException{
        CabinetPage cabinetPage = PageFactory.initElements(driver,CabinetPage.class);
        cabinetPage.removeServer();
    }

    @Test
    public void checkAddExistingServer () throws InterruptedException {
        CabinetPage cabinetPage = PageFactory.initElements(driver,CabinetPage.class);
        cabinetPage.addExistingServer();
    }

    @After
    public void close () {
        driver.quit();
    }
}
