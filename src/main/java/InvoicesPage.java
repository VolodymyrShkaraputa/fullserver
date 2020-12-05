import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class InvoicesPage {
    private WebDriver driver;

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

    @FindBy(css = "span#invoice_number")
    private WebElement spanInvoiseNumber;

    @FindBy(css = "span#invoice_status > .uk-badge.uk-badge-warning")
    private WebElement spanInvoicesStatus;



    //metods

    public void checkInvoices() throws InterruptedException{
        List<WebElement> invoicesLength = driver.findElement(By.name("invoices_length")).findElements(By.tagName("option"));
        sleep(3000);
        invoicesLength.get(3).click();
        List<WebElement> getAllInvoicesNumber = driver.findElements(By.cssSelector(".sorting_1"));
        Random random = new Random();
        String randomInvoicesNumber = getAllInvoicesNumber.get(random.nextInt(random.nextInt(getAllInvoicesNumber.size()))).getText();
        searchButton.sendKeys(randomInvoicesNumber);
        String statusText = status.getText();
        moreDetailsButton.click();
        sleep(2000);
        String invoicesNumber = spanInvoiseNumber.getText();
        Assert.assertTrue(invoicesNumber.contains(randomInvoicesNumber));
        String getInvoicesStatus = spanInvoicesStatus.getText();
        Assert.assertTrue(getInvoicesStatus.contains(statusText));

    }
}


