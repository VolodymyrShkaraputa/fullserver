import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class DiscountPage {

    private WebDriver driver;

    public  DiscountPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    //elements

    @FindBy(css = "input[name='promo']")
    private WebElement promoField;

    @FindBy(css = "div#divId2  .btn.btn-primary")
    private WebElement useButton;

    public void checknotValidDiscount() throws  InterruptedException{

        promoField.sendKeys("dfff");
        useButton.click();
        String fff = driver.findElement(By.cssSelector(".home")).getText();
        sleep(2000);


    }

}
