import org.apache.commons.lang3.exception.ExceptionContext;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.invoke.CallSite;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CabinetPage {

    private WebDriver driver;


    public CabinetPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;

    }


    // Elements
    @FindBy(css = ".tm-article p")
    private  WebElement personalUserAccountText;

    @FindBy(css = ".uk-nav.uk-nav-parent-icon.uk-nav-side > li:nth-of-type(1) > a")
    private WebElement personalAccountButton;

    @FindBy(css = ".uk-nav.uk-nav-parent-icon.uk-nav-side > li:nth-of-type(2) > a")
    private WebElement servicesButton;

    @FindBy(css = ".uk-nav.uk-nav-parent-icon.uk-nav-side > li:nth-of-type(3) > a")
    private WebElement invoicesButton;

    @FindBy(css = ".uk-nav.uk-nav-parent-icon.uk-nav-side > li:nth-of-type(4) > a")
    private WebElement discountsButton;

    @FindBy(css = ".uk-nav.uk-nav-parent-icon.uk-nav-side > li:nth-of-type(5) > a")
    private WebElement partnerButton;

    @FindBy(css = ".uk-nav.uk-nav-parent-icon.uk-nav-side > li:nth-of-type(6) > a")
    private WebElement balanceButton;

    @FindBy(css = ".uk-nav.uk-nav-parent-icon.uk-nav-side > li:nth-of-type(7) > a")
    private WebElement logsButton;

    @FindBy(css = "li:nth-of-type(8) > a")
    private WebElement settingButton;

    @FindBy(css = ".uk-button.uk-button-mini.uk-button-primary")
    private WebElement addServerButton;

    @FindBy(css = "input#server_address")
    private WebElement serverAddressField;

    @FindBy(css = "input#site")
    private WebElement siteField;

    @FindBy(css = "input#contact")
    private WebElement contactField;

    @FindBy(id = "game")
    private WebElement gameField;

    @FindBy(css = ".uk-button.uk-button-large.uk-button-mini")
    private WebElement addButton;

    @FindBy(css = ".even")
    private WebElement myServer;

    @FindBy(css = ".uk-button.uk-button-danger.uk-margin-small-bottom.uk-width-1-1")
    private WebElement deleteButton;

    @FindBy(css = "div#notify")
    private WebElement popupMassege;

    @FindBy(css = ".uk-icon-cog")
    private WebElement settingServerButton;

    @FindBy(css = "input#website")
    private WebElement settingWebSiteField;

    @FindBy(css = ".uk-grid > div:nth-of-type(1) > a")
    private WebElement replenishButton;

    @FindBy(css = "[href='\\/listing\\/']")
    private WebElement listingButton;

    @FindBy(css = ".uk-icon-trash-o")
    private WebElement deleteIcon;

    @FindBy(id = "my_servers")
    private WebElement allServerInCabinet;


    //metods

    public boolean CheckPersonalUserAccountText () {
        personalUserAccountText.isDisplayed();
        return true;
    }

    public void checkAddNewServer() throws InterruptedException{
        addServerButton.click();
        serverAddressField.sendKeys("176.98.95.190:27028");
        siteField.sendKeys("https://fullserver.ru/");
        contactField.sendKeys("061 666 0 686");
        List<WebElement> getAllgameTypes = gameField.findElements(By.tagName("option"));
        getAllgameTypes.get(1).click();
        addButton.click();
        sleep(4000);
        String getServers = allServerInCabinet.getText();
        Assert.assertTrue(getServers.contains("176.98.95.190:27028"));
    }


    public void removeServer () throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       deleteIcon.click();
       deleteButton.isDisplayed();
       deleteButton.click();
       sleep(2000);
        WebElement popupMassege = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#notify")));
       popupMassege.isDisplayed();
       String massege = popupMassege.getText();
       Assert.assertTrue(massege.contains("Сервер успешно удален из Вашего списка"));
    }

    public void addExistingServer () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        addServerButton.click();
        serverAddressField.sendKeys("46.174.54.28:27015");
        siteField.sendKeys("https://fullserver.ru/");
        contactField.sendKeys("061 666 0 686");
        List<WebElement> getAllgameTypes = gameField.findElements(By.tagName("option"));
        getAllgameTypes.get(1).click();
        addButton.click();
        sleep(2000);
        WebElement popupMassege = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#notify")));
        popupMassege.isDisplayed();
        String massege = popupMassege.getText();
        Assert.assertTrue(massege.contains("Сервер уже присутсвует в базе"));

    }

    public void settingServer () {
        settingServerButton.click();
        settingWebSiteField.getText();
        contactField.getText();
    }

    public void clickOnBalanceButton () {
        replenishButton.click();
    }

    public void clickOnInvoicesButton () {
        invoicesButton.click();
    }

    public void clickOnDiscountButton () {
        discountsButton.click();
    }

    public void clickOnListingButton() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        listingButton.click();
    }
}
