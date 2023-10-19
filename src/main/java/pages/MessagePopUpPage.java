package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getPopUpMessageForInvalidLogin () {
        return driver.findElement(By.cssSelector(".v-snack__content ul li"));
    }

    public void waitUntilPopUpMessageForInvalidLoginIsVisible () {
        wait
                .withMessage("Message for invalid login should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMessageForInvalidLogin()));
    }
    public String getTextFromPopUpMessageForInvalidLogin () {
        return getPopUpMessageForInvalidLogin().getText();
    }
    public WebElement getPopUpMessageForAccountVerify () {
        return driver.findElement(By.className("v-card__title"));
    }
    public void waitUntilPopUpMessageForAccountVerifyIsVisible () {
        wait
                .withMessage("Message for account verify should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMessageForAccountVerify()));
    }
    public String getTextFromPopUpMessageForAccountVerify () {
        return getPopUpMessageForAccountVerify().getText();
    }
    public WebElement getCloseButton () {
        return driver.findElement(By.cssSelector(".v-card__actions button"));
    }
    public void clickOnCloseButton () {
        getCloseButton().click();
    }
    public WebElement getPopUpMessageForSuccessfulActions() {
        return driver.findElement(By.cssSelector(".success .v-snack__content"));
    }
    public void waitUntilPopUpMessageForSuccessfulAddOrEditCityIsVisible () {
        wait
                .withMessage("Message should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMessageForSuccessfulActions()));
    }
    public boolean getTextFromPopUpMessageForSuccessfulAddOrEditCity () {
        return getPopUpMessageForSuccessfulActions().getText().contains("Saved successfully");
    }
    public void waitUntilPopUpMessageForSuccessfulDeleteCityIsVisible () {
        wait
                .withMessage("Message for successful add/edit city should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMessageForSuccessfulActions()));
    }
    public boolean getTextFromPopUpMessageForSuccessfulDeleteCity () {
        return getPopUpMessageForSuccessfulActions().getText().contains("Deleted successfully");
    }

}