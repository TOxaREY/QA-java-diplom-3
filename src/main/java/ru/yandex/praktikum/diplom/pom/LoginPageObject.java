package ru.yandex.praktikum.diplom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
    private final WebDriver driver;
    private final By registertLink = By.xpath("//a[@href='/register']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By homeLink = By.xpath("//a[@href='/']");
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By passwordRecoveryLink = By.xpath("//a[@href='/forgot-password']");
    private final By h2Login = By.xpath("//h2[text()='Вход']");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    private void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    private void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterLink() {
        driver.findElement(registertLink).click();
    }

    public void clickPasswordRecoveryLink() {
        driver.findElement(passwordRecoveryLink).click();
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickHomeLink() {
        driver.findElement(homeLink).click();
    }

    public void setUserAndClickLoginButton(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLoginButton();
    }

    public void checkSuccessSignOut() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(h2Login));
    }
}
