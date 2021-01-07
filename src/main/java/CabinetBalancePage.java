import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

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

    public void checkWmrPayment () {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputBalanceField.sendKeys("100");
        webmoneyWmrButton.click();
        goToPayButton.isDisplayed();
        goToPayButton.click();



    }

    public void checkUnipayPayment (){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputBalanceField.sendKeys("100");
        unipayButton.click();
        goToPayButton.isDisplayed();
        goToPayButton.click();

    }
}
