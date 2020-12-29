import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(css = ".even .full_address")
    private WebElement firstIpAddress;

    @FindBy(css = "[href] span")
    private WebElement serverNameInSearchTable;

    @FindBy(css = ".even .full_address")
    private WebElement serverIpInSearchTable;

    @FindBy(id= "empty")
    private WebElement emptySearchTable;


    public String getIpAddress () {
        String getIp = firstIpAddress.getText();
        return getIp;

    }

    public String setChooseGameFiled (String gameName) {
        Select chooseGame = new Select (chooseGameFiled);
        chooseGame.selectByValue(gameName);
        return gameName;
    }

    public String setCountryField (String countryName) {
        Select chooseCountry = new Select(chooseCountryField);
        chooseCountry.selectByValue(countryName);
        return countryName;
    }

    public String setSearchField (String searchByName) {
        Select chooseSearchBy = new Select(searchByField);
        chooseSearchBy.selectByValue(searchByName);
        return searchByName;
    }

    public String setTextField (String setText) {
        searchTextField.sendKeys(setText);
        return  setText;
    }

    public void clickOnSearchButton () {
        searchButton.click();
    }

    public  String getServerIpInSearchTable () {
        return   serverIpInSearchTable.getText();
    }

    public String getServerNameInSearchTable () {
        return  serverNameInSearchTable.getText();
    }
    public String getEmptySearcTable () {
        return emptySearchTable.getText();
    }
}