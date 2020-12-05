import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoveryPage {

    private WebDriver driver;

    public RecoveryPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    //Elements

    @FindBy(className = "validate-username")
    private WebElement emailForm;

    @FindBy(css = ".form-horizontal.form-validate.well .btn.btn-primary")
    private WebElement submitButton;

    @FindBy(css = "div#notify > .uk-notify-message.uk-notify-message-success")
    private WebElement popupMessageSuccess;

    @FindBy(css = "div#notify > div > div")
    private WebElement popupSetEmail;

    @FindBy(css = "div#notify > div > div")
    private WebElement popupUserNotFound;


    //metods

    public void setEmailForm (String email) {
        emailForm.sendKeys(email);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public boolean checkPopupMessageSuccess () {
        popupMessageSuccess.isDisplayed();
        return true;
    }

    public boolean checkWithUserNotFound () {
        popupUserNotFound.isDisplayed();
        return true;
    }
    public boolean checkWithEmptyEmailField () {
        popupSetEmail.isDisplayed();
        return true;
    }

}
