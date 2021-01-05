import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class InvoicesPage {
    private WebDriver driver;
    Random random = new Random();

//    private WebDriverWait wait = new WebDriverWait(driver,10);

    public InvoicesPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    //elements
    @FindBy(css = "[href] .uk-button-mini")
    private WebElement replenishButton;

    @FindBy(css = "select[name='invoices_length']")
    private WebElement invoicesLength;

    @FindBy(css = "input[type='search']")
    private WebElement searchButton;

    @FindBy(css = "li#invoices_next > a")
    private WebElement nextPageButton;

    @FindBy(css = "#invoices_previous [href]")
    private WebElement previousPageButton;

    @FindBy(css = "tr:nth-of-type(1)  .uk-button.uk-button-mini")
    private WebElement moreDetailsButton;

    @FindBy(css = ".uk-badge.uk-badge-warning")
    private WebElement status;

    //елементы из окна moreDetails

//    @FindBy(css = "span#invoice_number")
//    private WebElement spanInvoiseNumber;


    @FindBy(css = "span#invoice_status > .uk-badge.uk-badge-warning")
    private WebElement spanInvoicesStatus;

    @FindBy(css = ".sorting_1")
    private List<WebElement> getAllInvoicesNumber;

    //metods

    public void checkInvoices() throws InterruptedException{
        List<WebElement> invoicesLength = driver.findElement(By.name("invoices_length")).findElements(By.tagName("option"));
        sleep(3000);
        invoicesLength.get(3).click();
        String randomInvoicesNumber = getAllInvoicesNumber.get(random.nextInt(random.nextInt(getAllInvoicesNumber.size()))).getText();
        searchButton.sendKeys(randomInvoicesNumber);
        String statusText = status.getText();
        moreDetailsButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement spanInvoiseNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#invoice_number")));
        String invoicesNumber = spanInvoiseNumber.getText();
        sleep(2000);
        Assert.assertTrue(invoicesNumber.contains(randomInvoicesNumber));
        String getInvoicesStatus = spanInvoicesStatus.getText();
        Assert.assertTrue(getInvoicesStatus.contains(statusText));

    }
}


