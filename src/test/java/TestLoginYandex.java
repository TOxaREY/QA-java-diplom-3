import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.diplom.pom.ForgotPasswordPageObject;
import ru.yandex.praktikum.diplom.pom.HomePageObject;
import ru.yandex.praktikum.diplom.pom.LoginPageObject;
import ru.yandex.praktikum.diplom.pom.RegisterPageObject;
import ru.yandex.praktikum.diplom.data.User;


@DisplayName("Тесты входа на сайте в Yandex")
public class TestLoginYandex extends BaseTest {
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
        driver = super.setBrowser("yandex");
        objHomePage = new HomePageObject(driver);
        objLoginPage = new LoginPageObject(driver);
        objRegisterPage = new RegisterPageObject(driver);
        objForgotPasswordPage = new ForgotPasswordPageObject(driver);
        super.setUpLogin(driver, objHomePage, objLoginPage, objRegisterPage, objForgotPasswordPage);
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
        super.tearDown(driver);
    }
}
