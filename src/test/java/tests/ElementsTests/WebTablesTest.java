package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebTablesTest extends BaseTest {

    @Test
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
}
