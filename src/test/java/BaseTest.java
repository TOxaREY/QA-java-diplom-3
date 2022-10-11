import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import ru.yandex.praktikum.diplom.data.User;
import ru.yandex.praktikum.diplom.pom.*;

import static ru.yandex.praktikum.diplom.data.URLAddress.STELLARBURGERS_URL;

public class BaseTest {

    public void tearDown(WebDriver driver) {
        driver.quit();
    }

    public WebDriver setBrowser(String browser) {
        if (browser.equals("yandex")) {
            System.setProperty("webdriver.opera.driver", "C:\\WebDriver\\bin\\operadriver.exe");
            OperaOptions options = new OperaOptions();
            options.setBinary("C:\\Users\\Anton\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            return new OperaDriver(options);
        } else {
            return new ChromeDriver();
        }
    }

    public void setUpConstructor(WebDriver driver, HomePageObject objHomePage, LoginPageObject objLoginPage, RegisterPageObject objRegisterPage) {
        registerAndLogin(driver, objHomePage, objLoginPage, objRegisterPage);
        objHomePage.waitForLoadHomePage();
        objHomePage.clickAccountLink();
        AccountPageObject objAccountPage = new AccountPageObject(driver);
        objAccountPage.waitForLoadAccountPage();
        objAccountPage.clickConstructorLink();
        objHomePage.waitForLoadHomePage();
    }

    public void setUpGoToConstructor(WebDriver driver, HomePageObject objHomePage, AccountPageObject objAccountPage, LoginPageObject objLoginPage, RegisterPageObject objRegisterPage) {
        registerAndLogin(driver, objHomePage, objLoginPage, objRegisterPage);
        objHomePage.waitForLoadHomePage();
        objHomePage.clickAccountLink();
        objAccountPage.waitForLoadAccountPage();
    }

    public void setUpGoToPersonalAccount(WebDriver driver, HomePageObject objHomePage, LoginPageObject objLoginPage, RegisterPageObject objRegisterPage) {
        registerAndLogin(driver, objHomePage, objLoginPage, objRegisterPage);
    }

    public void setUpLogin(WebDriver driver, HomePageObject objHomePage, LoginPageObject objLoginPage, RegisterPageObject objRegisterPage, ForgotPasswordPageObject objForgotPasswordPage) {
        setRegister(driver, objHomePage, objLoginPage, objRegisterPage);
        User.setUserData();
        objRegisterPage.setUserAndClickRegistrationButton(User.name, User.email, User.password);
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickHomeLink();
        objHomePage.waitForLoadHomePage();
    }

    public void setUpRegistration(WebDriver driver, HomePageObject objHomePage, LoginPageObject objLoginPage, RegisterPageObject objRegisterPage) {
        setRegister(driver, objHomePage, objLoginPage, objRegisterPage);
    }

    public void setUpSignOut(WebDriver driver, HomePageObject objHomePage, LoginPageObject objLoginPage, RegisterPageObject objRegisterPage) {
        registerAndLogin(driver, objHomePage, objLoginPage, objRegisterPage);
        objHomePage.waitForLoadHomePage();
        objHomePage.clickAccountLink();
        AccountPageObject objAccountPage = new AccountPageObject(driver);
        objAccountPage.waitForLoadAccountPage();
    }

    private void setRegister(WebDriver driver, HomePageObject objHomePage, LoginPageObject objLoginPage, RegisterPageObject objRegisterPage) {
        driver.get(STELLARBURGERS_URL);
        driver.manage().window().maximize();
        objHomePage.waitForLoadHomePage();
        objHomePage.clickAccountLink();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickRegisterLink();
        objRegisterPage.waitForLoadRegisterPage();
    }

    private void registerAndLogin(WebDriver driver, HomePageObject objHomePage, LoginPageObject objLoginPage, RegisterPageObject objRegisterPage) {
        setRegister(driver, objHomePage, objLoginPage, objRegisterPage);
        User.setUserData();
        objRegisterPage.setUserAndClickRegistrationButton(User.name, User.email, User.password);
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickHomeLink();
        objHomePage.waitForLoadHomePage();
        objHomePage.clickAccountLink();
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.setUserAndClickLoginButton(User.email, User.password);
    }

}
