package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities() {

        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        navPage.waitUntilCurrentUrlContainsLogin();
        loginPage.fillInEmailInputField(email);
        loginPage.fillInPasswordInputField(password);
        loginPage.clickOnLoginButton();
        navPage.clickOnAdminButton();
        navPage.waitUntilAdminListIsVisible();
        navPage.clickOnAdminCitiesFromAdminLIst();
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/admin/cities",
                "Current url should be " + baseUrl + "/admin/cities");

    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void ChecksInputTypesForCreateOrEditNewCity() {

        navPage.clickOnAdminButton();
        navPage.waitUntilAdminListIsVisible();
        navPage.clickOnAdminCitiesFromAdminLIst();
        navPage.waitUntilCurrentUrlContainsAdminCities();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitUntilPopUpMessageForAddOrEditCityIsVisible();
        Assert.assertEquals(citiesPage.getNameInputFieldValueForAttributeType(), "text",
                "Name input field should have value 'text'");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void CreateNewCity() {

        String cityName = "New City";

        navPage.clickOnAdminButton();
        navPage.waitUntilAdminListIsVisible();
        navPage.clickOnAdminCitiesFromAdminLIst();
        navPage.waitUntilCurrentUrlContainsAdminCities();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitUntilPopUpMessageForAddOrEditCityIsVisible();
        citiesPage.fillInNameInputField(cityName);
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulAddOrEditCityIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForSuccessfulAddOrEditCity(),
                "Message should contain text 'Saved successfully'.");

    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void EditCity() {

        String oldCityName = "Old city";
        String newCityName = "City Edited";

        navPage.clickOnAdminButton();
        navPage.waitUntilAdminListIsVisible();
        navPage.clickOnAdminCitiesFromAdminLIst();
        navPage.waitUntilCurrentUrlContainsAdminCities();
        citiesPage.fillInSearchInputField(oldCityName);
        citiesPage.waitUntilNumberOfRowsOfCitiesInSearchIs(1);
        citiesPage.clickOnEditButtonFromRow(1);
        citiesPage.waitUntilPopUpMessageForAddOrEditCityIsVisible();
        citiesPage.fillInNameInputField(newCityName);
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulAddOrEditCityIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForSuccessfulAddOrEditCity(),
                "Message should contain text 'Saved successfully'.");

    }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void SearchCity() {

        String newCityName = "City Edited";
        navPage.clickOnAdminButton();
        navPage.waitUntilAdminListIsVisible();
        navPage.clickOnAdminCitiesFromAdminLIst();
        navPage.waitUntilCurrentUrlContainsAdminCities();
        citiesPage.fillInSearchInputField(newCityName);
        citiesPage.waitUntilNumberOfRowsOfCitiesInSearchIs(1);
        Assert.assertEquals(citiesPage.getTextFromCertainCellFromCertainRow(1, 2), newCityName,
                "This row should contain " + newCityName);

    }
    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void DeleteCity() {

        String newCityName = "City Edited";
        navPage.clickOnAdminButton();
        navPage.waitUntilAdminListIsVisible();
        navPage.clickOnAdminCitiesFromAdminLIst();
        navPage.waitUntilCurrentUrlContainsAdminCities();
        citiesPage.fillInSearchInputField(newCityName);
        citiesPage.waitUntilNumberOfRowsOfCitiesInSearchIs(1);
        Assert.assertEquals(citiesPage.getTextFromCertainCellFromCertainRow(1, 2), newCityName,
                "Name cell from first row should contain " + newCityName);
        citiesPage.clickOnDeleteButtonFromRow(1);
        citiesPage.waitUntilPopUpMessageForDeleteCityIsVisible();
        citiesPage.clickOnDeleteButtonFromPopUpMenuForDeleteCity();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulDeleteCityIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForSuccessfulDeleteCity(),
                "Message should contain text 'Deleted successfully'.");

    }
}