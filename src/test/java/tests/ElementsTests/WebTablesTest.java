package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.Elements.WebTablesPage;

public class WebTablesTest extends BaseTest {

    @Test(priority = 1)
    public void test_CheckSearchBarWithValidData() {
        final String expectedFirstName = "Cierra";
        final String firstName = "Cierra";

        String actualFirstName = openBaseURL()
                .clickElementsMenu()
                .openWebTablesPage()
                .inputFirstNameIntoSearchField(firstName)
                .getTextFirstColumnRow();

        Assert.assertEquals(actualFirstName,expectedFirstName);
    }

    @Test()
    public void test_CheckAddingNewItemToTables() {
        final String email = "webolejuko@mailinator.com";
        final String expectedEmail = "webolejuko@mailinator.com";

        WebTablesPage webTablesPage = openBaseURL()
                .clickElementsMenu()
                .openWebTablesPage()
                .clickOnAdd()
                .inputFirstNameIntoRegistrationForm()
                .inputLastNameIntoRegistrationForm()
                .updateUserEmail(email)
                .inputAgeIntoRegistrationForm()
                .inputSalaryIntoRegistrationForm()
                .inputDepartmentIntoRegistrationForm()
                .clickSubmitButton();

        Assert.assertTrue(webTablesPage.isEmailPresentInColumn(expectedEmail));
    }

    @Test()
    public void test_CheckEditEmail() {
        final String email = "webolejuko@mailinator.com";
        final String newEmail = "tahasoh@mailinator.com";

        WebTablesPage webTablesPage = openBaseURL()
                .clickElementsMenu()
                .openWebTablesPage()
                .addNewUserWithEmail(email)
                .searchUserByEmail(email)
                .clickEditButton()
                .updateUserEmail(newEmail)
                .clickSubmitButton()
                .searchUserByEmail(newEmail);

        Assert.assertTrue(webTablesPage.isEmailPresentInColumn(newEmail));
    }

    @Test()
    public void test_DeleteUser() {
        final String email = "webolejuko@mailinator.com";
        final String newEmail = "tahasoh@mailinator.com";

        WebTablesPage webTablesPage = openBaseURL()
                .clickElementsMenu()
                .openWebTablesPage()
                .addNewUserWithEmail(email)
                .searchUserByEmail(email)
                .clickEditButton()
                .updateUserEmail(newEmail)
                .clickSubmitButton()
                .searchUserByEmail(newEmail)
                .clickDeleteButton();

        Assert.assertFalse(webTablesPage.isTableContainsText(newEmail));
    }

    @Test()
    public void test_CheckAddingPlus7NewUsers() {
        final int expectedUsersPresented = 10;

        WebTablesPage webTablesPage = openBaseURL()
                .clickElementsMenu()
                .openWebTablesPage()
                .addNew7UsersWithEmail();

        Reporter.log("Result = " + webTablesPage.getAmountOfEmailsInTheTable(), true);

        Assert.assertFalse(getWebTablesPage().isAnyEmailEmpty());
        Assert.assertEquals(webTablesPage.getAmountOfEmailsInTheTable(),expectedUsersPresented);
    }
}
