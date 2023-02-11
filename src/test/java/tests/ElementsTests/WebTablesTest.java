package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.Elements.WebTablesPage;

import java.util.Arrays;
import java.util.List;


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
                .inputEmailIntoRegistrationForm(email)
                .inputAgeIntoRegistrationForm()
                .inputSalaryIntoRegistrationForm()
                .inputDepartmentIntoRegistrationForm()
                .clickOnSubmit();

        Assert.assertTrue(webTablesPage.isEmailPresentInColumn(expectedEmail));
    }
}
