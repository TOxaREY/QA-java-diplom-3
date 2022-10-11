import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.diplom.pom.HomePageObject;
import ru.yandex.praktikum.diplom.pom.LoginPageObject;
import ru.yandex.praktikum.diplom.pom.RegisterPageObject;

@DisplayName("Тест выхода из аккаунта в Yandex")
public class TestSignOutYandex extends BaseTest {
    private WebDriver driver;
    private HomePageObject objHomePage;
    private LoginPageObject objLoginPage;

    @Before
    public void setUp() {
        driver = super.setBrowser("yandex");
        objHomePage = new HomePageObject(driver);
        objLoginPage = new LoginPageObject(driver);
        RegisterPageObject objRegisterPage = new RegisterPageObject(driver);
        super.setUpSignOut(driver, objHomePage, objLoginPage, objRegisterPage);
    }

    @Test
    @DisplayName("Тест выхода по кнопке \"Выйти\" в Yandex")
    public void testSignOutButtonSignOutYandex() {
        objHomePage.clickSignOutButton();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.checkSuccessSignOut();
    }

    @After
    public void tearDown() {
        super.tearDown(driver);
    }
}