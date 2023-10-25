package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CitiesPage extends BasicPage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getNewItemButton() {
        return driver.findElement(By.className("v-btn--is-elevated"));
    }
    public void clickOnNewItemButton() {
        getNewItemButton().click();
    }
    public WebElement getPopUpMenuForAddOrEditCity() {
        return driver.findElement(By.className("v-card__title"));
    }
    public void waitUntilPopUpMessageForAddOrEditCityIsVisible() {
        wait
                .withMessage("Message should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMenuForAddOrEditCity()));
    }
    public WebElement getNameInputField() {
        return driver.findElement(By.id("name"));
    }
    public String getNameInputFieldValueForAttributeType() {
        return getNameInputField().getAttribute("type");
    }
    public void fillInNameInputField(String cityName) {
        getNameInputField().sendKeys(Keys.chord(Keys.CONTROL, "a"), cityName);
    }
    public WebElement getSaveButton() {
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnSaveButton() {
        getSaveButton().click();
    }
    public WebElement getSearchInputField() {
        return driver.findElement(By.id("search"));
    }
    public void fillInSearchInputField(String oldCityName) {
        getSearchInputField().clear();
        getSearchInputField().sendKeys(oldCityName);
    }
    public void waitUntilNumberOfRowsOfCitiesInSearchIs(int numberOfRows) {
        wait
                .withMessage("Number of rows should be" + numberOfRows + ".")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".v-data-table__wrapper tbody tr"), numberOfRows));
    }
    public List<WebElement> getEditButtonsFromAllRows() {
        return driver.findElements(By.cssSelector(".v-data-table__wrapper tbody tr td #edit"));
    }
    public WebElement getEditButtonFromRow(int rowNumber) {
        return getEditButtonsFromAllRows().get(rowNumber - 1);
    }
    public void clickOnEditButtonFromRow(int rowNumber) {
        getEditButtonFromRow(rowNumber).click();
    }
    public WebElement getCertainCellFromCertainRow(int rowNumber, int columnNumber) {
        return driver.findElement(By.cssSelector(".v-data-table__wrapper tbody tr:nth-child(" + rowNumber + ") td:nth-child(" + columnNumber + ")"));
    }
    public String getTextFromCertainCellFromCertainRow(int rowNumber, int columnNumber) {
        return getCertainCellFromCertainRow(rowNumber, columnNumber).getText();
    }
    public List<WebElement> getDeleteButtonsFromAllRows () {
        return driver.findElements(By.cssSelector(".v-data-table__wrapper tbody tr td #delete"));
    }
    public WebElement getDeleteButtonFromRow (int rowNumber) {
        return getDeleteButtonsFromAllRows().get(rowNumber - 1);
    }
    public void clickOnDeleteButtonFromRow (int rowNumber) {
        getDeleteButtonFromRow(rowNumber).click();
    }
    public WebElement getPopUpMenuForDeleteCity () {
        return driver.findElement(By.cssSelector("header.v-app-bar"));
    }
    public void waitUntilPopUpMessageForDeleteCityIsVisible () {
        wait
                .withMessage("Message for delete should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMenuForDeleteCity()));
    }
    public WebElement getDeleteButtonFromPopUpMenuForDeleteCity () {
        return driver.findElement(By.cssSelector(".v-dialog__content--active button.text--lighten3"));
    }
    public void clickOnDeleteButtonFromPopUpMenuForDeleteCity () {
        getDeleteButtonFromPopUpMenuForDeleteCity().click();
    }
}