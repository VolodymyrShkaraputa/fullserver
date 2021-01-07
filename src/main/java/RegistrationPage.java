import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }


    //Elements
    @FindBy(id = "login")
    private WebElement loginField;

    @FindBy(css = "input#name")
    private WebElement userNameField;

    @FindBy(css = "input#password")
    private WebElement passwordField;

    @FindBy(css = "input#re_password")
    private WebElement rePasswordField;

    @FindBy(css = ".form-horizontal.form-validate.well .btn.btn-primary")
    private WebElement submitButton;

    @FindBy(css = "input#email")
    private WebElement emailField;

//    @FindBy(css = "div#notify > div > div")
//    private WebElement popupError;


    //metods

    public void setParametersForRegistarion (String login, String userName, String email, String password, String rePassword) {
        loginField.sendKeys(login);
        userNameField.sendKeys(userName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        rePasswordField.sendKeys(rePassword);
        submitButton.click();
    }

    public String getErrorPopup () {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement popupError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#notify > div > div")));
       return popupError.getText();

    }

}
