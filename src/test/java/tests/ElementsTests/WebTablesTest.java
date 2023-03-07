package tests.ElementsTests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements.WebTablesPage;

public class WebTablesTest extends BaseTest {

    Logger logger = LoggerFactory.getLogger(WebTablesTest.class);

    @Test(priority = 1)
    public void test_CheckSearchBarWithValidData() {
        final String expectedFirstName = "Cierra";
        final String firstName = "Cierra";

        String actualFirstName = openBaseURL()
                .clickElementsMenu()
                .openWebTablesPage()
                .inputFirstNameIntoSearchField(firstName)
                .getTextFirstColumnRow();

        logger.info("Actual First Name = " + actualFirstName);

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
                .add7NewUsersWithEmail();

        logger.info("Emails presented = " + webTablesPage.getAmountOfEmailsInTheTable());

        Assert.assertFalse(getWebTablesPage().isAnyEmailEmpty());
        Assert.assertEquals(webTablesPage.getAmountOfEmailsInTheTable(),expectedUsersPresented);
    }

    @Test()
    public void testTablePresentOnly5Rows() {
        final int expectedRows5 = 5;
        final int expectedRows10 = 10;
        final int expectedRows20 = 20;
        final int expectedRows25 = 25;
        final int expectedRows50 = 50;
        final int expectedRows100 = 100;

        WebTablesPage webTablesPage = openBaseURL()
                .clickElementsMenu()
                .openWebTablesPage()
                .selectRows(String.valueOf(expectedRows5));

        logger.info("Rows in table = " + webTablesPage.getAmountOfEmailsInTheTable());

        Assert.assertEquals(webTablesPage.getAmountOfEmailsInTheTable(), expectedRows5);
        Assert.assertNotEquals(webTablesPage.getAmountOfEmailsInTheTable(), expectedRows10);
        Assert.assertNotEquals(webTablesPage.getAmountOfEmailsInTheTable(), expectedRows20);
        Assert.assertNotEquals(webTablesPage.getAmountOfEmailsInTheTable(), expectedRows25);
        Assert.assertNotEquals(webTablesPage.getAmountOfEmailsInTheTable(), expectedRows50);
        Assert.assertNotEquals(webTablesPage.getAmountOfEmailsInTheTable(), expectedRows100);
    }

    @Test()
    public void testPreviousButtonIsEnabled() {
        final int expectedRows5 = 5;
        final String expectedPage = "2";

        WebTablesPage webTablesPage = openBaseURL()
                .clickElementsMenu()
                .openWebTablesPage()
                .add7NewUsersWithEmail()
                .selectRows(String.valueOf(expectedRows5))
                .goToNextPage();

        logger.info("Current page = " + webTablesPage.getCurrentPageNumber());

        Assert.assertTrue(getWebTablesPage().isPreviousButtonEnabled());
        Assert.assertEquals(getWebTablesPage().getCurrentPageNumber(),expectedPage);
    }
}
