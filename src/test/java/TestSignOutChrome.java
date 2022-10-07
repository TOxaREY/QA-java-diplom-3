import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.diplom.POM.AccountPagePOM;
import ru.yandex.praktikum.diplom.POM.HomePagePOM;
import ru.yandex.praktikum.diplom.POM.LoginPagePOM;
import ru.yandex.praktikum.diplom.POM.RegisterPagePOM;
import ru.yandex.praktikum.diplom.data.User;

import static ru.yandex.praktikum.diplom.data.URLAddress.STELLARBURGERS_URL;

@DisplayName("Тест выхода из аккаунта в Chrome")
public class TestSignOutChrome {
    private WebDriver driver;
    private HomePagePOM objHomePage;
    private LoginPagePOM objLoginPage;
    private RegisterPagePOM objRegisterPage;
    private AccountPagePOM objAccountPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(STELLARBURGERS_URL);
        driver.manage().window().maximize();
        objHomePage = new HomePagePOM(driver);
        objLoginPage = new LoginPagePOM(driver);
        objRegisterPage = new RegisterPagePOM(driver);
        objAccountPage = new AccountPagePOM(driver);
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
        objHomePage.clickAccountLink();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.setUserAndClickLoginButton(User.email, User.password);
        objHomePage.waitForLoadHomePage();
        objHomePage.clickAccountLink();
        objAccountPage.waitForLoadAccountPage();
    }

    @Test
    @DisplayName("Тест выхода по кнопке \"Выйти\" в Chrome")
    public void testSignOutButtonSignOutChrome() {
        objHomePage.clickSignOutButton();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.checkSuccessSignOut();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
