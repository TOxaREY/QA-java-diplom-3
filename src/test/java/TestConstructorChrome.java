import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.diplom.pom.HomePageObject;
import ru.yandex.praktikum.diplom.pom.LoginPageObject;
import ru.yandex.praktikum.diplom.pom.RegisterPageObject;

import static org.junit.Assert.assertEquals;

@DisplayName("Тесты раздела \"Конструктор\" в Chrome")
public class TestConstructorChrome extends BaseTest {
    private WebDriver driver;
    private HomePageObject objHomePage;

    @Before
    public void setUp() {
        driver = super.setBrowser("chrome");
        objHomePage = new HomePageObject(driver);
        LoginPageObject objLoginPage = new LoginPageObject(driver);
        RegisterPageObject objRegisterPage = new RegisterPageObject(driver);
        super.setUpConstructor(driver, objHomePage, objLoginPage, objRegisterPage);
    }

    @Test
    @DisplayName("Тест перехода к разделу \"Булки\" в Chrome")
    public void testGoToBunChrome() throws InterruptedException {
        objHomePage.clickSpanFilling();
        objHomePage.clickSpanBun();
        Thread.sleep(1000);
        assertEquals(243, objHomePage.checkSuccessGoToBun());
    }

    @Test
    @DisplayName("Тест перехода к разделу \"Соусы\" в Chrome")
    public void testGoToSauceChrome() throws InterruptedException {
        objHomePage.clickSpanSauce();
        Thread.sleep(1000);
        assertEquals(243, objHomePage.checkSuccessGoToSauce());
    }

    @Test
    @DisplayName("Тест перехода к разделу \"Начинки\" в Chrome")
    public void testGoToFillingChrome() throws InterruptedException {
        objHomePage.clickSpanFilling();
        Thread.sleep(1000);
        assertEquals(243, objHomePage.checkSuccessGoToFilling());
    }

    @After
    public void tearDown() {
        super.tearDown(driver);
    }
}
