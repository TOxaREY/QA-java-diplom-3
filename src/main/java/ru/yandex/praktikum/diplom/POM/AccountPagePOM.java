package ru.yandex.praktikum.diplom.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPagePOM {
    private final WebDriver driver;
    private final By saveButton = By.xpath("//button[text()='Сохранить']");
    private final By accountInfo = By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private final By constructorLink = By.xpath("(//a[@href='/'])[1]");
    private final By logoLink = By.xpath("(//a[@href='/'])[2]");
    public AccountPagePOM(WebDriver driver){
        this.driver = driver;
    }
    public void waitForLoadAccountPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(saveButton));
    }
    public void checkSuccessGoToPersonalAccount() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(accountInfo));
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }
    public void clickLogoLink() {
        driver.findElement(logoLink).click();
    }
}
