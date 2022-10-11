import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.diplom.pom.AccountPageObject;
import ru.yandex.praktikum.diplom.pom.HomePageObject;
import ru.yandex.praktikum.diplom.pom.LoginPageObject;
import ru.yandex.praktikum.diplom.pom.RegisterPageObject;

@DisplayName("Тесты перехода из личного кабинета в конструктор в Yandex")
public class TestGoToConstructorYandex extends BaseTest {
    private WebDriver driver;
    private HomePageObject objHomePage;
    private AccountPageObject objAccountPage;

    @Before
    public void setUp() {
        driver = super.setBrowser("yandex");
        objHomePage = new HomePageObject(driver);
        objAccountPage = new AccountPageObject(driver);
        LoginPageObject objLoginPage = new LoginPageObject(driver);
        RegisterPageObject objRegisterPage = new RegisterPageObject(driver);
        super.setUpGoToConstructor(driver, objHomePage, objAccountPage, objLoginPage, objRegisterPage);
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
        super.tearDown(driver);
    }
}
