package ru.yandex.praktikum.diplom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPageObject {
    private final WebDriver driver;
    private final By nameField = By.xpath("(//input[@name='name'])[1]");
    private final By emailField = By.xpath("(//input[@name='name'])[2]");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By errorPasswordMessage = By.xpath("//p[text()='Некорректный пароль']");
    private final By loginLink = By.xpath("//a[@href='/login']");

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    private void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    private void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(registrationButton));
    }

    public void setUserAndClickRegistrationButton(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickRegistrationButton();
    }

    public void checkErrorPasswordMessage() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(errorPasswordMessage));
    }
}
