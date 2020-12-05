import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ListingPage {

    private WebDriver driver;
    public  ListingPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;


    }

    public void getRandomServer () {
        List<WebElement> fff = driver.findElements(By.cssSelector(".even [width='20%']"));
        Random random = new Random();
        String  ffr = fff.get(random.nextInt(random.nextInt(fff.size()))).getText();

    }


}
