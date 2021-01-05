import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckSearchPage {
    private WebDriver driver;
//
//    @BeforeClass
//    public static void setupClass() {
//        ChromeDriverManager.chromedriver().setup();
//    }

    @Before
    public void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Wladimir\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fullserver.ru/search/");

    }

    @Test
    public void checkSearchWithServerName () {
        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        searchPage.setChooseGameFiled("cs16");
        searchPage.setCountryField("all");
        searchPage.setSearchField("hostname");
        searchPage.setTextField("OMG! OMG! OMG! Public Server");
        searchPage.clickOnSearchButton();
        String serverNameInSearchTable = searchPage.getServerNameInSearchTable();
        Assert.assertTrue(serverNameInSearchTable.contains("OMG! OMG! OMG! Public Server"));
    }

    @Test
    public void checkSearchWithServerIp () {
        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        searchPage.setChooseGameFiled("cs16");
        searchPage.setCountryField("all");
        searchPage.setSearchField("address");
        searchPage.setTextField("176.98.95.190:27028");
        searchPage.clickOnSearchButton();
        String serverIpInSearchTable = searchPage.getServerIpInSearchTable();
        Assert.assertTrue(serverIpInSearchTable.contains("176.98.95.190:27028"));
    }

    @Test
    public void checkSearchWrongParamets () {
        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        searchPage.setChooseGameFiled("cs16");
        searchPage.setCountryField("BO");
        searchPage.setSearchField("address");
        searchPage.setTextField("176.98.95.190:27028");
        searchPage.clickOnSearchButton();
        String emptySearcTable = searchPage.getEmptySearcTable();
        Assert.assertTrue(emptySearcTable.contains("Ваш запрос не дал результатов"));
    }

    @Test
    public void checkSearchWrongParamets2 () {
        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        searchPage.setChooseGameFiled("all");
        searchPage.setCountryField("AX");
        searchPage.setSearchField("map");
        searchPage.setTextField("176.98.95.190:27028");
        searchPage.clickOnSearchButton();
        String emptySearcTable = searchPage.getEmptySearcTable();
        Assert.assertTrue(emptySearcTable.contains("Ваш запрос не дал результатов"));
    }

    @Test
    public void checkSearchWrongParamets3 () {
        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        searchPage.setChooseGameFiled("cs16");
        searchPage.setCountryField("VA");
        searchPage.setSearchField("player");
        searchPage.setTextField("176.98.95.190:27028");
        searchPage.clickOnSearchButton();
        String emptySearcTable = searchPage.getEmptySearcTable();
        Assert.assertTrue(emptySearcTable.contains("Ваш запрос не дал результатов"));
    }

    @Test
    public void checkSearchWithRandomIp () {
        driver.get("https://fullserver.ru/");
        ManePage manePage = PageFactory.initElements(driver,ManePage.class);
        String  randomIpInManePage =  manePage.getRandomIpAddress();
        driver.get("https://fullserver.ru/search/");
        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        searchPage.setChooseGameFiled("cs16");
        searchPage.setCountryField("all");
        searchPage.setSearchField("all");
        searchPage.setTextField(randomIpInManePage);
        searchPage.clickOnSearchButton();
        String serverIpInSearchTable = searchPage.getServerIpInSearchTable();
        Assert.assertTrue(serverIpInSearchTable.contains(randomIpInManePage));
    }

    @Test
    public void checkSearchWithRandomServerName () {
        driver.get("https://fullserver.ru/");
        ManePage manePage = PageFactory.initElements(driver,ManePage.class);
        String  randomServerName =  manePage.getRandomServerNames();
        driver.get("https://fullserver.ru/search/");
        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        searchPage.setChooseGameFiled("cs16");
        searchPage.setCountryField("all");
        searchPage.setSearchField("all");
        searchPage.setTextField(randomServerName);
        searchPage.clickOnSearchButton();
        String serverNameInSearchTable = searchPage.getServerNameInSearchTable();
        Assert.assertTrue(serverNameInSearchTable.contains(randomServerName));
    }

    @After
    public void close () {
        driver.quit();
    }

}
