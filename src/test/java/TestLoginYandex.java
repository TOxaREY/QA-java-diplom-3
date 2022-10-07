import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import ru.yandex.praktikum.diplom.POM.ForgotPasswordPagePOM;
import ru.yandex.praktikum.diplom.POM.HomePagePOM;
import ru.yandex.praktikum.diplom.POM.LoginPagePOM;
import ru.yandex.praktikum.diplom.POM.RegisterPagePOM;
import ru.yandex.praktikum.diplom.data.User;

import static ru.yandex.praktikum.diplom.data.URLAddress.STELLARBURGERS_URL;

@DisplayName("Тесты входа на сайте в Yandex")
public class TestLoginYandex {
    private WebDriver driver;
    private HomePagePOM objHomePage;
    private LoginPagePOM objLoginPage;
    private RegisterPagePOM objRegisterPage;
    private ForgotPasswordPagePOM objForgotPasswordPage;
    private void checkSuccessLogin() {
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.setUserAndClickLoginButton(User.email, User.password);
        objHomePage.checkSuccessLogin();
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.opera.driver", "C:\\WebDriver\\bin\\operadriver.exe");
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\Anton\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new OperaDriver(options);
        driver.get(STELLARBURGERS_URL);
        driver.manage().window().maximize();
        objHomePage = new HomePagePOM(driver);
        objLoginPage = new LoginPagePOM(driver);
        objRegisterPage = new RegisterPagePOM(driver);
        objForgotPasswordPage = new ForgotPasswordPagePOM(driver);
        objHomePage.waitForLoadHomePage();
        objHomePage.clickAccountLink();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickRegisterLink();
        objRegisterPage.waitForLoadRegisterPage();
        User.setUserData();
        objRegisterPage.setUserAndClickRegistrationButton(User.name, User.email, User.password);
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickHomeLink();
        objHomePage.waitForLoadHomePage();
    }

    @Test
    @DisplayName("Тест входа по кнопке \"Войти в аккаунт\" на главной сайта в Yandex")
    public void testLoginBySignInYandex() {
        objHomePage.clickSignInButton();
        checkSuccessLogin();
    }

    @Test
    @DisplayName("Тест входа по кнопке \"Личный кабинет\" на главной сайта в Yandex")
    public void testLoginByAccountYandex() {
        objHomePage.clickAccountLink();
        checkSuccessLogin();
    }

    @Test
    @DisplayName("Тест входа по кнопке в форме регистрации в Yandex")
    public void testLoginByRegistrationYandex() {
        objHomePage.clickAccountLink();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickRegisterLink();
        objRegisterPage.waitForLoadRegisterPage();
        objRegisterPage.clickLoginLink();
        checkSuccessLogin();
    }

    @Test
    @DisplayName("Тест входа по кнопке в форме восстановления пароля в Yandex")
    public void testLoginByPasswordRecoveryYandex() {
        objHomePage.clickAccountLink();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickPasswordRecoveryLink();
        objForgotPasswordPage.waitForLoadForgotPasswordPage();
        objForgotPasswordPage.clickLoginLink();
        checkSuccessLogin();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
