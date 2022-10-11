import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.diplom.pom.*;
import ru.yandex.praktikum.diplom.data.User;


@DisplayName("Тесты входа на сайте в Chrome")
public class TestLoginChrome extends BaseTest {
    private WebDriver driver;
    private HomePageObject objHomePage;
    private LoginPageObject objLoginPage;
    private RegisterPageObject objRegisterPage;
    private ForgotPasswordPageObject objForgotPasswordPage;

    private void checkSuccessLogin() {
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.setUserAndClickLoginButton(User.email, User.password);
        objHomePage.checkSuccessLogin();
    }

    @Before
    public void setUp() {
        driver = super.setBrowser("chrome");
        objHomePage = new HomePageObject(driver);
        objLoginPage = new LoginPageObject(driver);
        objRegisterPage = new RegisterPageObject(driver);
        objForgotPasswordPage = new ForgotPasswordPageObject(driver);
        super.setUpLogin(driver, objHomePage, objLoginPage, objRegisterPage, objForgotPasswordPage);
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
        super.tearDown(driver);
    }
}
