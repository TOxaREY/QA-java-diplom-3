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

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.diplom.data.URLAddress.STELLARBURGERS_URL;

@DisplayName("Тесты раздела \"Конструктор\" в Chrome")
public class TestConstructorChrome {
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
        objAccountPage.clickConstructorLink();
        objHomePage.waitForLoadHomePage();
    }

    @Test
    @DisplayName("Тест перехода к разделу \"Булки\" в Chrome")
    public void testGoToBunChrome() throws InterruptedException {
        objHomePage.clickSpanFilling();
        objHomePage.clickSpanBun();
        Thread.sleep(1000);
        assertEquals(243,objHomePage.checkSuccessGoToBun());
    }

    @Test
    @DisplayName("Тест перехода к разделу \"Соусы\" в Chrome")
    public void testGoToSauceChrome() throws InterruptedException {
        objHomePage.clickSpanSauce();
        Thread.sleep(1000);
        assertEquals(243,objHomePage.checkSuccessGoToSauce());
    }

    @Test
    @DisplayName("Тест перехода к разделу \"Начинки\" в Chrome")
    public void testGoToFillingChrome() throws InterruptedException {
        objHomePage.clickSpanFilling();
        Thread.sleep(1000);
        assertEquals(243,objHomePage.checkSuccessGoToFilling());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
