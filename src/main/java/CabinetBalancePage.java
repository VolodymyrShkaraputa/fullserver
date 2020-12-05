import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class CabinetBalancePage {

    private WebDriver driver;

    public CabinetBalancePage (WebDriver driver)  {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    //elements

    @FindBy(css = ".tm-article.uk-article > div:nth-of-type(1)")
    private WebElement balance;

    @FindBy(css = "input#input_balance")
    private WebElement inputBalanceField;

    @FindBy(css = "#webmoney_wmr_p")
    private WebElement webmoneyWmrButton;

    @FindBy(css = "#unitpay_p")
    private WebElement unipayButton;

    @FindBy(css = "button#go_to_pay")
    private WebElement goToPayButton;

    //metods

    public void checkWmrPayment ()throws InterruptedException {
        inputBalanceField.sendKeys("100");
        webmoneyWmrButton.click();
        goToPayButton.isDisplayed();
        goToPayButton.click();
        sleep(2000);
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("merchant.webmoney.ru"));
    }

    public void checkUnipayPayment () throws InterruptedException {
        inputBalanceField.sendKeys("100");
        unipayButton.click();
        goToPayButton.isDisplayed();
        goToPayButton.click();
        sleep(2000);
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("unitpay.ru"));
    }
}
