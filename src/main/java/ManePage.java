import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import java.util.List;
import java.util.Random;

public class ManePage {

    private WebDriver driver;
    private Object SearchPage;
    Random random = new Random();

    public ManePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "home")
    private WebElement homeButton;

    @FindBy(id = "primary-menu-rules")
    private WebElement rulesButton;

    @FindBy(css = "[href='\\/listing\\/']")
    private WebElement listingButton;

    @FindBy(css = "[href='\\/banlist\\/']")
    private WebElement banlistButton;

    @FindBy(css = "[href='\\/line_vip\\.php']")
    private WebElement lineVipButton;

    @FindBy(css = "[href='\\/faq\\.php']")
    private WebElement faqButton;

    @FindBy(css = "[href='https\\:\\/\\/fullserver\\.ru\\/support']")
    private WebElement supportButton;

    @FindBy(css = "[href='\\/pages\\/stats\\.htm']")
    private WebElement statsButton;

    @FindBy(css = ".form-search.simple-search-form > input[name='search_text']")
    private WebElement searchField;

    @FindBy(css = ".btn-primary")
    private WebElement searchButton;

    @FindBy(css = ".button")
    private WebElement loginButton;

    @FindBy(css = "[title='Регистрация']")
    private WebElement registrationButton;

    @FindBy(css = ".full_address")
    private List<WebElement> ip_addressServer;

    @FindBy(css = ".name")
    private List<WebElement> getAllServerNames;

    // metods
    public void clickOnRulesButton () {
        rulesButton.click();
    }

    public void clickOnLoginButton () {
        loginButton.click();

    }

    public void clickOnListingButton () {
        listingButton.click();
    }

    public  void clickOnBanlistButton () {
        banlistButton.click();
    }

    public void clickOnLineVipButton () {
        lineVipButton.click();
    }

    public void clickOnFaqButton () {
        faqButton.click();
    }

    public void clickOnStatsButton () {
        statsButton.click();
    }

    public void clickOnSupportButton () {
        supportButton.click();
    }

    public String getRandomIpAddress () {
//        List<WebElement> getAllIpAddress = driver.findElements(By.cssSelector(".full_address"));
        String randomIp =   ip_addressServer.get(random.nextInt(random.nextInt(ip_addressServer.size()))).getText();
        searchField.sendKeys(randomIp);
        searchButton.click();
        return randomIp;
    }
    public String getRandomServerNames () {

        String serverName =  getAllServerNames.get(random.nextInt(getAllServerNames.size())).getText();
        return serverName;
    }
}
