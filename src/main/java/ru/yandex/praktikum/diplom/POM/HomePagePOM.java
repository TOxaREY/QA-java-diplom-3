package ru.yandex.praktikum.diplom.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePOM {
    private final WebDriver driver;
    private final By signInButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By accountLink = By.xpath("//a[@href='/account']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By h1Burger = By.xpath("//h1[text()='Соберите бургер']");

    private final By h2Bun = By.xpath("//h2[text()='Булки']");
    private final By h2Sauce = By.xpath("//h2[text()='Соусы']");
    private final By h2Filling = By.xpath("//h2[text()='Начинки']");
    private final By signOutButton = By.xpath("//button[text()='Выход']");
    private final By spanBun = By.xpath("//span[text()='Булки']");
    private final By spanSauce = By.xpath("//span[text()='Соусы']");
    private final By spanFilling = By.xpath("//span[text()='Начинки']");

    public HomePagePOM(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadHomePage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(accountLink));
    }

    public void clickAccountLink() {
        driver.findElement(accountLink).click();
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickSignOutButton() {
        driver.findElement(signOutButton).click();
    }

    public void clickSpanBun() {
        driver.findElement(spanBun).click();
    }

    public void clickSpanSauce() {
        driver.findElement(spanSauce).click();
    }

    public void clickSpanFilling() {
        driver.findElement(spanFilling).click();
    }

    public void checkSuccessLogin() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    public void checkSuccessGoToConstructor() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(h1Burger));
    }

    public int checkSuccessGoToBun() {
        return driver.findElement(h2Bun).getLocation().y;
    }

    public int checkSuccessGoToSauce() {
        return driver.findElement(h2Sauce).getLocation().y;
    }

    public int checkSuccessGoToFilling() {
        return driver.findElement(h2Filling).getLocation().y;
    }
}
