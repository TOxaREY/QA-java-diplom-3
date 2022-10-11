import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.diplom.pom.*;

@DisplayName("Тест перехода в личный кабинет в Chrome")
public class TestGoToPersonalAccountChrome extends BaseTest {
    private WebDriver driver;
    private HomePageObject objHomePage;
    private AccountPageObject objAccountPage;

    @Before
    public void setUp() {
        driver = super.setBrowser("chrome");
        objHomePage = new HomePageObject(driver);
        objAccountPage = new AccountPageObject(driver);
        LoginPageObject objAccountPage = new LoginPageObject(driver);
        RegisterPageObject objRegisterPage = new RegisterPageObject(driver);
        super.setUpGoToPersonalAccount(driver, objHomePage, objAccountPage, objRegisterPage);
    }

    @Test
    @DisplayName("Тест перехода по клику на \"Личный кабинет\" в Chrome")
    public void testGoToPersonalAccountChrome() {
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
