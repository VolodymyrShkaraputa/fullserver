import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver driver;

    public  SearchPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    //Elements

    @FindBy (css = "select[name='game']")
    private WebElement chooseGameFiled;

    @FindBy(css = "select[name='country']")
    private WebElement chooseCountryField;

    @FindBy(css = "[name='per_page']")
    private WebElement prePageField;

    @FindBy(css = "select[name='search_by']")
    private WebElement searchByField;

    @FindBy(css = "table input[name='search_text']")
    private WebElement searchTextField;

    @FindBy(css = "input[name='players_min']")
    private WebElement playersMinFild;

    @FindBy(css = "input[name='players_max']")
    private WebElement playersMaxField;

    @FindBy(css = "label:nth-of-type(1) > input[name='players_status']")
    private WebElement checkboxHavePlaces;

    @FindBy(css = "label:nth-of-type(2) > input[name='players_status']")
    private WebElement checkboxDoNotHavePlaces;

    @FindBy(css = ".uk-form-controls.uk-width-1-1 > .uk-button.uk-button-large.uk-width-1-2")
    private WebElement searchButton;
    
}
