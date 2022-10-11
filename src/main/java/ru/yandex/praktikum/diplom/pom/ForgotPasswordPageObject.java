package ru.yandex.praktikum.diplom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPageObject {
    private final WebDriver driver;
    private final By loginLink = By.xpath("//a[@href='/login']");

    public ForgotPasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadForgotPasswordPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginLink));
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
