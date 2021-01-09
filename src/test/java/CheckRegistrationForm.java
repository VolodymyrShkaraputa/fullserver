import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CheckRegistrationForm {

    private WebDriver driver;

    @Before
    public void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Wladimir\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fullserver.ru/account/reg/");

    }

    @Ignore
    public void checkSucessRegistration () {
        RegistrationPage registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.setParametersForRegistarion("ggggg","ggggg","ggggggg@gmail.com","123697","123697");
        String getPopupMessage = registrationPage.getErrorPopup();
        Assert.assertTrue(getPopupMessage.contains("Вы успешно зарегистрировались"));
    }

    @Test
    public void checkRegistrationWithoutLogin () throws InterruptedException{
        RegistrationPage registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.setParametersForRegistarion("","ggggg","ggggggg@gmail.com","123697","123697");
        sleep(1000);
        String getPopupMessage = registrationPage.getErrorPopup();
        Assert.assertTrue(getPopupMessage.contains("Заполните поле 'Логин'"));
    }

    @Test
    public void checkRegistrationWithoutUserNameField () throws InterruptedException{
        RegistrationPage registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.setParametersForRegistarion("ggggg","","ggggggg@gmail.com","123697","123697");
        sleep(1000);
        String getPopupMessage = registrationPage.getErrorPopup();
        Assert.assertTrue(getPopupMessage.contains("Заполните поле 'Имя'"));
    }

    @Test
    public void checkRegistrationWithoutPasswordField () throws InterruptedException{
        RegistrationPage registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.setParametersForRegistarion("gggg","ggggg","ggggggg@gmail.com","","123697");
        sleep(1000);
        String getPopupMessage = registrationPage.getErrorPopup();
        Assert.assertTrue(getPopupMessage.contains("Заполните поле 'Пароль'"));
    }

    @Test
    public void checkRegistrationWithoutRePasswordField () throws InterruptedException{
        RegistrationPage registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.setParametersForRegistarion("gggg","ggggg","ggggggg@gmail.com","123697","");
        sleep(1000);
        String getPopupMessage = registrationPage.getErrorPopup();
        Assert.assertTrue(getPopupMessage.contains("Заполните поле 'Повторите пароль'"));
    }

    @Test
    public void checkRegistrationWithoutEmaildField () throws InterruptedException{
        RegistrationPage registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.setParametersForRegistarion("gggg","ggggg","","123697","123697");
        sleep(1000);
        String getPopupMessage = registrationPage.getErrorPopup();
        Assert.assertTrue(getPopupMessage.contains("Заполните поле 'Email'"));
    }

    @Test
    public void checkRegistrationWithouAllField () throws InterruptedException{
        RegistrationPage registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.setParametersForRegistarion("","","","","");
        sleep(1000);
        String getPopupMessage = registrationPage.getErrorPopup();
        Assert.assertTrue(getPopupMessage.contains("Заполните поле 'Логин'"));
    }


    @After
    public void close () {
        driver.quit();
    }
}
