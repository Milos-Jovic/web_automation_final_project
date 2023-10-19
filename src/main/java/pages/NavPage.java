package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage {

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLanguageMenuButton() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public void clickOnLanguageMenuButton() {
        getLanguageMenuButton().click();
    }

    public WebElement getLanguageList() {
        return driver.findElement(By.cssSelector(".menuable__content__active > div"));
    }

    public void waitUntilLanguageListIsVisible() {
        wait
                .withMessage("List should be visible.")
                .until(ExpectedConditions.visibilityOf(getLanguageList()));
    }

    public WebElement getEnglishLanguageInMenuList() {
        return driver.findElement(By.cssSelector("span.f-gb"));
    }

    public void clickOnEnglishLanguageInMenuList() {
        getEnglishLanguageInMenuList().click();
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("[href='/login'].btnLogin"));
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitUntilCurrentUrlContainsLogin() {
        wait
                .withMessage("Current url should contain '/login'.")
                .until(ExpectedConditions.urlContains("/login"));
    }

    public void waitUntilCurrentUrlContainsHome() {
        wait
                .withMessage("Current url should contain '/home'.")
                .until(ExpectedConditions.urlContains("/home"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.className("btnLogout"));
    }

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }

    public void waitUntilLogoutButtonIsVisible() {
        wait
                .withMessage("Button should be visible.")
                .until(ExpectedConditions.visibilityOf(getLogoutButton()));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.cssSelector("[href='/signup'].btnLogin"));
    }

    public void clickOnSignUpButton() {
        getSignUpButton().click();
    }

    public void waitUntilCurrentUrlContainsSignUp() {
        wait
                .withMessage("Current url should contain '/signup'.")
                .until(ExpectedConditions.urlContains("/signup"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.className("btnAdmin"));
    }

    public void clickOnAdminButton() {
        getAdminButton().click();
    }

    public WebElement getAdminList() {
        return driver.findElement(By.className("menuable__content__active"));
    }

    public void waitUntilAdminListIsVisible() {
        wait
                .withMessage("Admin list should be visible.")
                .until(ExpectedConditions.visibilityOf(getAdminList()));
    }

    public WebElement getAdminCitiesFromAdminList() {
        return driver.findElement(By.className("btnAdminCities"));
    }

    public void clickOnAdminCitiesFromAdminLIst() {
        getAdminCitiesFromAdminList().click();
    }

    public void waitUntilCurrentUrlContainsAdminCities() {
        wait
                .withMessage("Current url should contain '/admin/cities'.")
                .until(ExpectedConditions.urlContains("/admin/cities"));
    }
    public WebElement getSpanishLanguageInMenuList () {
        return driver.findElement(By.cssSelector("span.f-es"));
    }
    public void clickOnSpanishLanguageInMenuList () {
        getSpanishLanguageInMenuList().click();
    }
    public WebElement getHeader () {
        return driver.findElement(By.cssSelector("h1.display-2"));
    }
    public String getHeaderText () {
        return getHeader().getText();
    }
    public WebElement getChineseLanguageInMenuList () {
        return driver.findElement(By.cssSelector("span.f-cn"));
    }
    public void clickOnChineseLanguageInMenuList () {
        getChineseLanguageInMenuList().click();
    }
    public WebElement getFrenchLanguageInMenuList () {
        return driver.findElement(By.cssSelector("span.f-fr"));
    }
    public void clickOnFrenchLanguageInMenuList () {
        getFrenchLanguageInMenuList().click();
    }
    public WebElement getUkraineLanguageInMenuList () {
        return driver.findElement(By.cssSelector("span.f-ua"));
    }
    public void clickOnUkraineLanguageInMenuList () {
        getUkraineLanguageInMenuList().click();
    }

}