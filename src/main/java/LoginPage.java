//import com.sun.tools.javac.util.Assert;
//import jdk.nashorn.internal.AssertsEnabled;
//import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
public class LoginPage {

    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "login")
    private WebElement loginField;

    @FindBy(css = "input#password")
    private WebElement passwordField;

    @FindBy(className = "inputbox")
    private WebElement remember;

    @FindBy(css = ".form-horizontal.form-validate.well .btn.btn-primary")
    private WebElement avtorizationButton;

    @FindBy(css = "div#notify > div > div")
    private WebElement erorPopupWrongAvtorization;

    @FindBy(css = "div#notify > div > div")
    private WebElement errorSetUserLogin;


    //metods

    public void setLoginField (String login) {
        loginField.sendKeys(login);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);

    }

    public void clickOnAvtorizationButton () {
        avtorizationButton.click();
    }

    public void checkWrongAvtorization (String login, String password) throws InterruptedException {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        avtorizationButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(erorPopupWrongAvtorization.isDisplayed());

    }


    public void setParametersForAuthorization (String login, String password) throws InterruptedException {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        avtorizationButton.click();
        Thread.sleep(3000);
    }

    public Boolean getTexterorPopupWrongAvtorization () {
        erorPopupWrongAvtorization.isDisplayed();
        return true;
    }

    public Boolean checkErrorSetUserLogin () {
        erorPopupWrongAvtorization.isDisplayed();
        return true;
    }

    public void authorization () {
        loginField.sendKeys("ZeddFox");
        passwordField.sendKeys("123555");
        avtorizationButton.click();
    }

}
