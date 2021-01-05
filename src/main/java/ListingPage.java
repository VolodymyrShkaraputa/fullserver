import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ListingPage {

    private WebDriver driver;
    public  ListingPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    @FindBy(css = ".even [width='20%']")
    private List<WebElement>  getAllServers;

    public void getRandomServer () {
        Random random = new Random();
        String  randomServer = getAllServers.get(random.nextInt(random.nextInt(getAllServers.size()))).getText();

    }


}
