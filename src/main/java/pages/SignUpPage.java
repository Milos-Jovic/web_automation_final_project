package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasicPage {
    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameInputField() {
        return driver.findElement(By.id("name"));
    }

    public String getNameInputFieldValueForAttributeType() {
        return getNameInputField().getAttribute("type");
    }

    public WebElement getEmailInputField() {
        return driver.findElement(By.id("email"));
    }

    public String getEmailInputFieldValueForAttributeType() {
        return getEmailInputField().getAttribute("type");
    }

    public WebElement getPasswordInputField() {
        return driver.findElement(By.id("password"));
    }

    public String getPasswordInputFieldValueForAttributeType() {
        return getPasswordInputField().getAttribute("type");
    }

    public WebElement getConfirmPasswordInputField() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public String getConfirmPasswordInputFieldValueForAttributeType() {
        return getConfirmPasswordInputField().getAttribute("type");
    }
    public void fillInNameInputField (String name) {
        getNameInputField().clear();
        getNameInputField().sendKeys(name);
    }
    public void fillInEmailInputField (String email) {
        getEmailInputField().clear();
        getEmailInputField().sendKeys(email);
    }
    public void fillInPasswordInputField (String password) {
        getPasswordInputField().clear();
        getPasswordInputField().sendKeys(password);
    }
    public void fillInConfirmPasswordInputField (String confirmPassword) {
        getConfirmPasswordInputField().clear();
        getConfirmPasswordInputField().sendKeys(confirmPassword);
    }
    public WebElement getSignUpButton () {
        return driver.findElement(By.className("v-btn--is-elevated"));
    }
    public void clickOnSignUpButton () {
        getSignUpButton().click();
    }
}