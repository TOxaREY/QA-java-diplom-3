import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.diplom.POM.ForgotPasswordPagePOM;
import ru.yandex.praktikum.diplom.POM.HomePagePOM;
import ru.yandex.praktikum.diplom.POM.LoginPagePOM;
import ru.yandex.praktikum.diplom.POM.RegisterPagePOM;
import ru.yandex.praktikum.diplom.data.User;

import static ru.yandex.praktikum.diplom.data.URLAddress.STELLARBURGERS_URL;

@DisplayName("Тесты входа на сайте в Chrome")
public class TestLoginChrome {
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
        driver = new ChromeDriver();
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
    @DisplayName("Тест входа по кнопке \"Войти в аккаунт\" на главной сайта в Chrome")
    public void testLoginBySignInChrome() {
        objHomePage.clickSignInButton();
        checkSuccessLogin();
    }

    @Test
    @DisplayName("Тест входа по кнопке \"Личный кабинет\" на главной сайта в Chrome")
    public void testLoginByAccountChrome() {
        objHomePage.clickAccountLink();
        checkSuccessLogin();
    }

    @Test
    @DisplayName("Тест входа по кнопке в форме регистрации в Chrome")
    public void testLoginByRegistrationChrome() {
        objHomePage.clickAccountLink();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickRegisterLink();
        objRegisterPage.waitForLoadRegisterPage();
        objRegisterPage.clickLoginLink();
        checkSuccessLogin();
    }

    @Test
    @DisplayName("Тест входа по кнопке в форме восстановления пароля в Chrome")
    public void testLoginByPasswordRecoveryChrome() {
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
