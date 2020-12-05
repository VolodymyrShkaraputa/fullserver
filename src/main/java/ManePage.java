import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ManePage {

    private WebDriver driver;

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


    // metods

    public void clickOnLoginButton () {
        loginButton.click();

    }

    public void getRandomIpAddres () {
        List<WebElement> getAllIpAddress = driver.findElements(By.cssSelector(".full_address"));
        Random random = new Random();
        String randomIp =   getAllIpAddress.get(random.nextInt(random.nextInt(getAllIpAddress.size()))).getText();
        searchField.sendKeys(randomIp);
        searchButton.click();

    }
}
