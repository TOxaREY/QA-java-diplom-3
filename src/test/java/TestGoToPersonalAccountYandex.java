import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.diplom.pom.AccountPageObject;
import ru.yandex.praktikum.diplom.pom.HomePageObject;
import ru.yandex.praktikum.diplom.pom.LoginPageObject;
import ru.yandex.praktikum.diplom.pom.RegisterPageObject;

@DisplayName("Тест перехода в личный кабинет в Yandex")
public class TestGoToPersonalAccountYandex extends BaseTest {
    private WebDriver driver;
    private HomePageObject objHomePage;
    private AccountPageObject objAccountPage;

    @Before
    public void setUp() {
        driver = super.setBrowser("yandex");
        objHomePage = new HomePageObject(driver);
        objAccountPage = new AccountPageObject(driver);
        LoginPageObject objAccountPage = new LoginPageObject(driver);
        RegisterPageObject objRegisterPage = new RegisterPageObject(driver);
        super.setUpGoToPersonalAccount(driver, objHomePage, objAccountPage, objRegisterPage);
    }

    @Test
    @DisplayName("Тест перехода по клику на \"Личный кабинет\" в Yandex")
    public void testGoToPersonalAccountYandex() {
        objHomePage.waitForLoadHomePage();
        objHomePage.clickAccountLink();
        objAccountPage.waitForLoadAccountPage();
        objAccountPage.checkSuccessGoToPersonalAccount();
    }

    @After
    public void tearDown() {
        super.tearDown(driver);
    }
}
