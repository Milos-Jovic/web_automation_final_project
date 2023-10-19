package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VisitsTheLoginPage() {

        navPage.clickOnLanguageMenuButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnEnglishLanguageInMenuList();
        navPage.clickOnLoginButton();
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");

    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void ChecksInputTypes() {

        navPage.clickOnLoginButton();
        navPage.waitUntilCurrentUrlContainsLogin();
        Assert.assertEquals(loginPage.getEmailInputFieldValueForAttributeType(), "email",
                "Email input field should have value 'email' for its type");
        Assert.assertEquals(loginPage.getPasswordInputFieldValueForAttributeType(), "password",
                "Password input field should have value 'password' for its type");

    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void DisplaysErrorWhenUserDoesNotExist() {

        String email = "invalid@gmal.com";
        String password = "password123";

        navPage.clickOnLoginButton();
        loginPage.fillInEmailInputField(email);
        loginPage.fillInPasswordInputField(password);
        loginPage.clickOnLoginButton();
        messagePopUpPage.waitUntilPopUpMessageForInvalidLoginIsVisible();
        Assert.assertEquals(messagePopUpPage.getTextFromPopUpMessageForInvalidLogin(), "User does not exists",
                "Error message should be 'User does not exists'.");
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");

    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void DisplaysErrorWhenPasswordIsWrong() {

        String email = "admin@admin.com";
        String password = "password123";

        navPage.clickOnLoginButton();
        loginPage.fillInEmailInputField(email);
        loginPage.fillInPasswordInputField(password);
        loginPage.clickOnLoginButton();
        messagePopUpPage.waitUntilPopUpMessageForInvalidLoginIsVisible();
        Assert.assertEquals(messagePopUpPage.getTextFromPopUpMessageForInvalidLogin(), "Wrong password",
                "Error message should be 'Wrong password'.");
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");

    }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void SuccessfulLogin() {

        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        navPage.waitUntilCurrentUrlContainsLogin();
        loginPage.fillInEmailInputField(email);
        loginPage.fillInPasswordInputField(password);
        loginPage.clickOnLoginButton();
        navPage.waitUntilCurrentUrlContainsHome();

    }
    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void Logout() {

        navPage.waitUntilLogoutButtonIsVisible();
        navPage.clickOnLogoutButton();

    }
}