import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.diplom.pom.HomePageObject;
import ru.yandex.praktikum.diplom.pom.LoginPageObject;
import ru.yandex.praktikum.diplom.pom.RegisterPageObject;
import ru.yandex.praktikum.diplom.data.User;


@DisplayName("Тесты регистрации на сайте в Chrome")
public class TestRegistrationChrome extends BaseTest {
    private WebDriver driver;
    private LoginPageObject objLoginPage;
    private RegisterPageObject objRegisterPage;

    @Before
    public void setUp() {
        driver = super.setBrowser("chrome");
        HomePageObject objHomePage = new HomePageObject(driver);
        objLoginPage = new LoginPageObject(driver);
        objRegisterPage = new RegisterPageObject(driver);
        super.setUpRegistration(driver, objHomePage, objLoginPage, objRegisterPage);
    }

    @Test
    @DisplayName("Тест успешной регистрации на сайте в Chrome")
    public void testSuccessfulRegistrationChrome() {
        User.setUserData();
        objRegisterPage.setUserAndClickRegistrationButton(User.name, User.email, User.password);
        objLoginPage.waitForLoadLoginPage();
    }

    @Test
    @DisplayName("Тест некорректного пароля при регистрации на сайте в Chrome")
    public void testWrongPasswordRegistrationChrome() {
        User.setUserDataWrongPassword();
        objRegisterPage.setUserAndClickRegistrationButton(User.name, User.email, User.password);
        objRegisterPage.checkErrorPasswordMessage();
    }

    @After
    public void tearDown() {
        super.tearDown(driver);
    }
}
