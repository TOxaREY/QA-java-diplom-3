import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import ru.yandex.praktikum.diplom.POM.AccountPagePOM;
import ru.yandex.praktikum.diplom.POM.HomePagePOM;
import ru.yandex.praktikum.diplom.POM.LoginPagePOM;
import ru.yandex.praktikum.diplom.POM.RegisterPagePOM;
import ru.yandex.praktikum.diplom.data.User;

import static ru.yandex.praktikum.diplom.data.URLAddress.STELLARBURGERS_URL;

@DisplayName("Тесты перехода из личного кабинета в конструктор в Yandex")
public class TestGoToConstructorYandex {
    private WebDriver driver;
    private HomePagePOM objHomePage;
    private LoginPagePOM objLoginPage;
    private RegisterPagePOM objRegisterPage;
    private AccountPagePOM objAccountPage;

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
    @DisplayName("Тест перехода по клику на \"Конструктор\" в Yandex")
    public void testGoToConstructorClickConstructorYandex() {
        objAccountPage.clickConstructorLink();
        objHomePage.waitForLoadHomePage();
        objHomePage.checkSuccessGoToConstructor();
    }

    @Test
    @DisplayName("Тест перехода по клику на логотип в Yandex")
    public void testGoToConstructorClickLogoYandex() {
        objAccountPage.clickLogoLink();
        objHomePage.waitForLoadHomePage();
        objHomePage.checkSuccessGoToConstructor();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
