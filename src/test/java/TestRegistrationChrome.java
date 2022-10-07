import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.diplom.POM.HomePagePOM;
import ru.yandex.praktikum.diplom.POM.LoginPagePOM;
import ru.yandex.praktikum.diplom.POM.RegisterPagePOM;
import ru.yandex.praktikum.diplom.data.User;

import static ru.yandex.praktikum.diplom.data.URLAddress.STELLARBURGERS_URL;

@DisplayName("Тесты регистрации на сайте в Chrome")
public class TestRegistrationChrome {
    private WebDriver driver;
    private HomePagePOM objHomePage;
    private LoginPagePOM objLoginPage;
    private RegisterPagePOM objRegisterPage;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(STELLARBURGERS_URL);
        driver.manage().window().maximize();
        objHomePage = new HomePagePOM(driver);
        objLoginPage = new LoginPagePOM(driver);
        objRegisterPage = new RegisterPagePOM(driver);
        objHomePage.waitForLoadHomePage();
        objHomePage.clickAccountLink();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickRegisterLink();
        objRegisterPage.waitForLoadRegisterPage();
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
        driver.quit();
    }
}
