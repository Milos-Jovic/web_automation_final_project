package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignUpTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VisitsTheSignUpPage() {

        navPage.clickOnSignUpButton();
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/signup",
                "Current url should be " + baseUrl + "/signup");

    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void ChecksInputTypes() {

        navPage.clickOnSignUpButton();
        navPage.waitUntilCurrentUrlContainsSignUp();
        Assert.assertEquals(signUpPage.getNameInputFieldValueForAttributeType(), "text",
                "Name input field should have value 'text' for its type");
        Assert.assertEquals(signUpPage.getEmailInputFieldValueForAttributeType(), "email",
                "Email input field should have value 'email' for its type");
        Assert.assertEquals(signUpPage.getPasswordInputFieldValueForAttributeType(), "password",
                "Password input field should have value 'password' for its type");
        Assert.assertEquals(signUpPage.getConfirmPasswordInputFieldValueForAttributeType(), "password",
                "Confirm password input field should have value 'password' for its type");

    }

//    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
//    public void DisplaysErrorWhenUserAlreadyExists() {
//
//        String name = "User";
//        String email = "admin@admin.com";
//        String password = "12345";
//        String confirmPassword = "12345";
//
//        navPage.clickOnSignUpButton();
//        navPage.waitUntilCurrentUrlContainsSignUp();
//        signUpPage.fillInNameInputField(name);
//        signUpPage.fillInEmailInputField(email);
//        signUpPage.fillInPasswordInputField(password);
//        signUpPage.fillInConfirmPasswordInputField(confirmPassword);
//        signUpPage.clickOnSignUpButton();
//        messagePopUpPage.waitUntilPopUpMessageForInvalidLoginIsVisible();
//        Assert.assertEquals(messagePopUpPage.getTextFromPopUpMessageForInvalidLogin(), "E-mail already exists",
//                "Error message should be 'E-mail already exists'.");
//        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/signup",
//                "Current url should be " + baseUrl + "/signup");
//
//    }
//    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
//    public void SuccessfulSignup () {
//
//        String name = "Milos Jovic";
//        String email = "milos@gmail.com";
//        String password = "12345";
//        String confirmPassword = "12345";
//
//        navPage.clickOnSignUpButton();
//        navPage.waitUntilCurrentUrlContainsSignUp();
//        signUpPage.fillInNameInputField(name);
//        signUpPage.fillInEmailInputField(email);
//        signUpPage.fillInPasswordInputField(password);
//        signUpPage.fillInConfirmPasswordInputField(confirmPassword);
//        signUpPage.clickOnSignUpButton();
//        navPage.waitUntilCurrentUrlContainsHome();
//        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/home",
//                "Current url should be " + baseUrl + "/home");
//        messagePopUpPage.waitUntilPopUpMessageForAccountVerifyIsVisible();
//        Assert.assertEquals(messagePopUpPage.getTextFromPopUpMessageForAccountVerify(), "IMPORTANT: Verify your account",
//                "Error message should be 'IMPORTANT: Verify your account'.");
//        messagePopUpPage.clickOnCloseButton();
//        navPage.clickOnLogoutButton();
//
//    }
//}