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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Volodymyr\\IdeaProjects\\Studing\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fullserver.ru/");
//        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
//        loginPage.authorization();
    }

    @Test
    public void test () {
//        List<WebElement> fff = driver.findElements(By.cssSelector(".full_address"));
//        Random random = new Random();
//        fff.get(random.nextInt(random.nextInt(fff.size()))).getText();
      ManePage manePage = PageFactory.initElements(driver,ManePage.class);
        manePage.getRandomIpAddres();
    }
}
